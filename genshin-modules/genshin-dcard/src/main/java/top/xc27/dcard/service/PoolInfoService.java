package top.xc27.dcard.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.xc27.dcard.PoolInfoVo;
import top.xc27.dcard.vo.PoolData;

import java.util.List;

/**
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-02 16:59:00
 */
public interface PoolInfoService extends IService<PoolInfoVo> {

    IPage<PoolInfoVo> queryPage(PoolInfoVo poolInfo);

    boolean savePoolInfoVo(PoolData poolData,String pool);
}

