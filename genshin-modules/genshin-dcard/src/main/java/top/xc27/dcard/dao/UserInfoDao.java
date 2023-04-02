package top.xc27.dcard.dao;

import top.xc27.dcard.vo.UserInfoVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * uid信息
 * 
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-02 18:42:15
 */
@Mapper
public interface UserInfoDao extends BaseMapper<UserInfoVo> {
	
}
