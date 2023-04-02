package top.xc27.dcard.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import top.xc27.dcard.PoolInfoVo;
import top.xc27.dcard.service.DcardService;
import top.xc27.dcard.service.PoolInfoService;
import top.xc27.dcard.service.UserInfoService;
import top.xc27.dcard.vo.PoolData;
import top.xc27.dcard.vo.PoolDataVo;
import top.xc27.util.ConvertUrlUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("dcardService")
public class DcardServiceImpl implements DcardService {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private PoolInfoService poolInfoService;

    @Override
    public String analyseData(String url, HttpServletRequest servletRequest) {
        Long lastId = 0L;
        String uid = "";
        String[] pool = {"200", "100", "301", "302"};
        if (StrUtil.isNotBlank(url)) {
            for (int i = 0; i < pool.length; i++) {
                boolean flag = true;
                while (flag) {
                    String urlInfo = ConvertUrlUtil.parset(url, pool[i], lastId);
                    List<PoolData> poolDatas = call(urlInfo);
                    if (ObjUtil.isNotNull(poolDatas)) {
                        if (poolDatas.size() != 0) {
                            for (PoolData poolData : poolDatas) {
                                lastId = poolData.getId();
                                uid = poolData.getUid();
                                if (!poolInfoService.savePoolInfoVo(poolData,pool[i])) {
                                    throw new RuntimeException();
                                }
                            }
                        }else {
                            flag = false;
                            lastId = 0L;
                        }
                    }
                }
            }
            if(!userInfoService.saveUserInfoVo(uid,servletRequest)){
                throw new RuntimeException();
            }
        }
        return "解析成功！";
    }

    private List<PoolData> call(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        PoolDataVo poolDataVo = new PoolDataVo();
        HttpGet request = new HttpGet(url);
        try {
            response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 5.获取响应内容
                HttpEntity httpEntity = response.getEntity();
                String json = EntityUtils.toString(httpEntity, "utf-8");
                HashMap map = JSONUtil.toBean(json, HashMap.class);
                Map data = (Map) map.get("data");
                poolDataVo = JSONUtil.toBean(JSONUtil.toJsonStr(data), PoolDataVo.class);
            } else {
                // 如果返回状态不是200，比如404（页面不存在）等，根据情况做处理
                System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6.关闭
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
        return poolDataVo.getList();
    }

}
