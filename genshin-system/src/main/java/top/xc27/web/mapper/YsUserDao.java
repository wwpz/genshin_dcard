package top.xc27.web.mapper;

import top.xc27.web.domain.YsUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 原神用户表
 * 
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-02-20 22:21:16
 */
@Mapper
public interface YsUserDao extends BaseMapper<YsUserEntity> {
	
}
