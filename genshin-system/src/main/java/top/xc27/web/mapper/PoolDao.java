package top.xc27.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.xc27.web.domain.PoolEntity;

/**
 * 原神用户对应卡池表
 * 
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-02-20 22:39:32
 */
@Mapper
public interface PoolDao extends BaseMapper<PoolEntity> {
	
}
