package top.xc27.dcard.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjUtil;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import top.xc27.dcard.dao.DcardUserInfoDao;
import top.xc27.dcard.service.DcardUserInfoService;
import top.xc27.dcard.vo.DcardUserInfoVo;
import top.xc27.util.IpUtil;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Service("dcardUserInfoService")
public class DcardUserInfoServiceImpl extends ServiceImpl<DcardUserInfoDao, DcardUserInfoVo> implements DcardUserInfoService {


    @Override
    public void userInfoDelete(List<String> ids) {
        Assert.notEmpty(ids, "id参数不能为空!");
        ids.forEach(id -> {
            DcardUserInfoVo userInfo = new DcardUserInfoVo();
            userInfo.setUid(id);
            userInfo.setDelFlag("1");
            Assert.isTrue(SqlHelper.retBool(baseMapper.updateById(userInfo)),"删除菜单失败!");
        });
    }

    @Override
    public IPage<DcardUserInfoVo> queryPage(DcardUserInfoVo userInfo) {
        LambdaQueryWrapper<DcardUserInfoVo> wrapper = queryWrapper(userInfo);
        return baseMapper.selectPage(userInfo.getPage(Page::new),wrapper);
    }

    @Override
    public boolean saveDcardUserInfoVo(String uid, HttpServletRequest request) {
        boolean result = false;
        DcardUserInfoVo infoVo = baseMapper.selectById(uid);
        if(ObjUtil.isNull(infoVo)){
            DcardUserInfoVo dcardUserInfoVo = new DcardUserInfoVo();
            dcardUserInfoVo.setUid(uid);
            dcardUserInfoVo.setStatus("0");
            dcardUserInfoVo.setDelFlag("0");
            dcardUserInfoVo.setLastIp(IpUtil.getIpAddr(request));
            dcardUserInfoVo.setLastTime(LocalDateTime.now());
            dcardUserInfoVo.setCreateTime(LocalDateTime.now());
            dcardUserInfoVo.setUpdateTime(LocalDateTime.now());
            result = SqlHelper.retBool(baseMapper.insert(dcardUserInfoVo));
        }else {
            infoVo.setUpdateTime(LocalDateTime.now());
            infoVo.setLastTime(LocalDateTime.now());
            result = SqlHelper.retBool(baseMapper.updateById(infoVo));
        }
        return result;
    }

    private LambdaQueryWrapper<DcardUserInfoVo> queryWrapper(DcardUserInfoVo userInfo) {
        LambdaQueryWrapper<DcardUserInfoVo> query = Wrappers.lambdaQuery();

        return query;
    }

}