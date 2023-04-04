package top.xc27.dcard.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.xc27.dcard.vo.DcardPoolInfoVo;
import top.xc27.dcard.vo.PoolData;

import java.util.List;

/**
 * 抽到的卡池信息
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-03 10:55:44
 */
public interface DcardPoolInfoService extends IService<DcardPoolInfoVo> {

    IPage<DcardPoolInfoVo> queryPage(DcardPoolInfoVo dcardPoolInfo);

    boolean saveDcardPoolInfoVo(PoolData poolData, String pool);
}

