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
import top.xc27.dcard.dao.UserInfoDao;
import top.xc27.dcard.service.UserInfoService;
import top.xc27.dcard.vo.UserInfoVo;
import top.xc27.util.IpUtil;


import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfoVo> implements UserInfoService {

    @Override
    public void userInfoDelete(List<String> ids) {
        Assert.notEmpty(ids, "id参数不能为空!");
        ids.forEach(id -> {
            UserInfoVo userInfo = new UserInfoVo();
            userInfo.setUid(id);
            userInfo.setDelFlag("1");
            Assert.isTrue(SqlHelper.retBool(baseMapper.updateById(userInfo)),"删除菜单失败!");
        });
    }

    @Override
    public IPage<UserInfoVo> queryPage(UserInfoVo userInfo) {
        LambdaQueryWrapper<UserInfoVo> wrapper = queryWrapper(userInfo);
        return baseMapper.selectPage(userInfo.getPage(Page::new),wrapper);
    }

    @Override
    public boolean saveUserInfoVo(String uid, HttpServletRequest request) {
        boolean result = false;
        if(ObjUtil.isNull(baseMapper.selectById(uid))){
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.setUid(uid);
            userInfoVo.setStatus("0");
            userInfoVo.setDelFlag("0");
            userInfoVo.setLastIp(IpUtil.getIpAddr(request));
            userInfoVo.setLastTime(LocalDateTime.now());
            userInfoVo.setCreateTime(LocalDateTime.now());
            userInfoVo.setUpdateTime(LocalDateTime.now());
            result = SqlHelper.retBool(baseMapper.insert(userInfoVo));
        }else {
            result = true;
        }
        return result;
    }

    private LambdaQueryWrapper<UserInfoVo> queryWrapper(UserInfoVo userInfo) {
        LambdaQueryWrapper<UserInfoVo> query = Wrappers.lambdaQuery();

        return query;
    }

}