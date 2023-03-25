package top.xc27.web.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import top.xc27.web.domain.PoolEntity;
import top.xc27.web.mapper.PoolDao;
import top.xc27.web.service.PoolService;

@Service("poolService")
public class PoolServiceImpl extends ServiceImpl<PoolDao, PoolEntity> implements PoolService {

    @Override
    public IPage<PoolEntity> queryPage(PoolEntity pool) {
        LambdaQueryWrapper<PoolEntity> wrapper = queryWrapper(pool);
        return baseMapper.selectPage(pool.getPage(Page::new),wrapper);
    }

    private LambdaQueryWrapper<PoolEntity> queryWrapper(PoolEntity pool) {
        LambdaQueryWrapper<PoolEntity> query = Wrappers.lambdaQuery();

        return query;
    }

}