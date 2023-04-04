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

import top.xc27.dcard.dao.DcardPoolInfoDao;
import top.xc27.dcard.service.DcardPoolInfoService;
import top.xc27.dcard.vo.DcardPoolInfoVo;
import top.xc27.dcard.vo.PoolData;

import java.time.LocalDateTime;
import java.util.List;

@Service("dcardPoolInfoService")
public class DcardPoolInfoServiceImpl extends ServiceImpl<DcardPoolInfoDao, DcardPoolInfoVo> implements DcardPoolInfoService {

    @Override
    public IPage<DcardPoolInfoVo> queryPage(DcardPoolInfoVo dcardPoolInfo) {
        LambdaQueryWrapper<DcardPoolInfoVo> wrapper = queryWrapper(dcardPoolInfo);
        return baseMapper.selectPage(dcardPoolInfo.getPage(Page::new),wrapper);
    }

    @Override
    public boolean saveDcardPoolInfoVo(PoolData poolData,String pool) {
        boolean result = false;
        if(ObjUtil.isNull(baseMapper.selectById(poolData.getId()))){
            DcardPoolInfoVo dcardPoolInfoVo = new DcardPoolInfoVo();
            dcardPoolInfoVo.setSid(poolData.getId());
            dcardPoolInfoVo.setUid(poolData.getUid());
            dcardPoolInfoVo.setDStar(Integer.valueOf(poolData.getRank_type()));
            dcardPoolInfoVo.setName(poolData.getName());
            dcardPoolInfoVo.setPool(pool);
            switch (poolData.getItem_type()){
                case "角色":
                    dcardPoolInfoVo.setDType(301);
                    break;
                case "武器" :
                    dcardPoolInfoVo.setDType(302);
                    break;
            }
            dcardPoolInfoVo.setDTime(poolData.getTime());
            dcardPoolInfoVo.setCreateTime(LocalDateTime.now());
            result =  SqlHelper.retBool(baseMapper.insert(dcardPoolInfoVo));
        }else {
            result = true;
        }
        return result;
    }

    private LambdaQueryWrapper<DcardPoolInfoVo> queryWrapper(DcardPoolInfoVo dcardPoolInfo) {
        LambdaQueryWrapper<DcardPoolInfoVo> query = Wrappers.lambdaQuery();

        return query;
    }

}