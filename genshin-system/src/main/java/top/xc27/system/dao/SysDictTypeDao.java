package top.xc27.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.xc27.system.vo.SysDictTypeVo;

/**
 * 字典类型表
 * 
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-03 11:26:00
 */
@Mapper
public interface SysDictTypeDao extends BaseMapper<SysDictTypeVo> {
	
}
