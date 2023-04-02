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

import top.xc27.dcard.dao.PoolInfoDao;
import top.xc27.dcard.PoolInfoVo;
import top.xc27.dcard.service.PoolInfoService;
import top.xc27.dcard.vo.PoolData;

import java.time.LocalDateTime;
import java.util.List;

@Service("poolInfoService")
public class PoolInfoServiceImpl extends ServiceImpl<PoolInfoDao, PoolInfoVo> implements PoolInfoService {


    @Override
    public boolean savePoolInfoVo(PoolData poolData,String pool) {
        boolean result = false;
        if(ObjUtil.isNull(baseMapper.selectById(poolData.getId()))){
            PoolInfoVo poolInfoVo = new PoolInfoVo();
            poolInfoVo.setSid(poolData.getId());
            poolInfoVo.setUid(poolData.getUid());
            poolInfoVo.setDStar(Integer.valueOf(poolData.getRank_type()));
            poolInfoVo.setName(poolData.getName());
            poolInfoVo.setPool(pool);
            switch (poolData.getItem_type()){
                case "角色":
                    poolInfoVo.setDType(301);
                    break;
                case "武器" :
                    poolInfoVo.setDType(302);
                    break;
            }
            poolInfoVo.setDTime(poolData.getTime());
            poolInfoVo.setCreateTime(LocalDateTime.now());
            result =  SqlHelper.retBool(baseMapper.insert(poolInfoVo));
        }else {
            result = true;
        }
        return result;
    }

    @Override
    public IPage<PoolInfoVo> queryPage(PoolInfoVo poolInfo) {
        LambdaQueryWrapper<PoolInfoVo> wrapper = queryWrapper(poolInfo);
        return baseMapper.selectPage(poolInfo.getPage(Page::new),wrapper);
    }

    private LambdaQueryWrapper<PoolInfoVo> queryWrapper(PoolInfoVo poolInfo) {
        LambdaQueryWrapper<PoolInfoVo> query = Wrappers.lambdaQuery();

        return query;
    }

}