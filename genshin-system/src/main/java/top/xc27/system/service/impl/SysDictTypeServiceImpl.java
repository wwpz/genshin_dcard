package top.xc27.system.service.impl;

import cn.hutool.core.lang.Assert;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import top.xc27.system.dao.SysDictTypeDao;
import top.xc27.system.service.SysDictTypeService;
import top.xc27.system.vo.SysDictTypeVo;

import java.util.List;

@Service("sysDictTypeService")
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeDao, SysDictTypeVo> implements SysDictTypeService {

    @Override
    public void sysDictTypeDelete(List<Long> ids) {
        Assert.notEmpty(ids, "id参数不能为空!");
        ids.forEach(id -> {
            SysDictTypeVo sysDictType = new SysDictTypeVo();
            sysDictType.setDictId(id);
            sysDictType.setStatus("1");
            Assert.isTrue(SqlHelper.retBool(baseMapper.updateById(sysDictType)),"删除菜单失败!");
        });
    }

    @Override
    public IPage<SysDictTypeVo> queryPage(SysDictTypeVo sysDictType) {
        LambdaQueryWrapper<SysDictTypeVo> wrapper = queryWrapper(sysDictType);
        return baseMapper.selectPage(sysDictType.getPage(Page::new),wrapper);
    }

    private LambdaQueryWrapper<SysDictTypeVo> queryWrapper(SysDictTypeVo sysDictType) {
        LambdaQueryWrapper<SysDictTypeVo> query = Wrappers.lambdaQuery();

        return query;
    }

}