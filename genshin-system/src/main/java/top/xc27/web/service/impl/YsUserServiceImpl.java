package top.xc27.web.service.impl;

import cn.hutool.core.lang.Assert;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import top.xc27.web.domain.YsUserEntity;
import top.xc27.web.mapper.YsUserDao;
import top.xc27.web.service.YsUserService;

import java.util.List;

@Service("ysUserService")
public class YsUserServiceImpl extends ServiceImpl<YsUserDao, YsUserEntity> implements YsUserService {

    @Override
    public void ysUserDelete(List<Integer> ids) {
        Assert.notEmpty(ids, "id参数不能为空!");
        ids.forEach(id -> {
            YsUserEntity ysUser = new YsUserEntity();
            ysUser.setUid(id);
            ysUser.setDelFlag("1");
            Assert.isTrue(SqlHelper.retBool(baseMapper.updateById(ysUser)),"删除菜单失败!");
        });
    }

    @Override
    public IPage<YsUserEntity> queryPage(YsUserEntity ysUser) {
        LambdaQueryWrapper<YsUserEntity> wrapper = queryWrapper(ysUser);
        return baseMapper.selectPage(ysUser.getPage(Page::new),wrapper);
    }

    private LambdaQueryWrapper<YsUserEntity> queryWrapper(YsUserEntity ysUser) {
        LambdaQueryWrapper<YsUserEntity> query = Wrappers.lambdaQuery();

        return query;
    }

}