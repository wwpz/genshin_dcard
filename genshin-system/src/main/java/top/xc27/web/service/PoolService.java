package top.xc27.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.xc27.web.domain.PoolEntity;

/**
 * 原神用户对应卡池表
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-02-20 22:39:32
 */
public interface PoolService extends IService<PoolEntity> {
    IPage<PoolEntity> queryPage(PoolEntity pool);
}

