package top.xc27.dcard.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.xc27.dcard.vo.DcardUserInfoVo;

/**
 * uid用户信息
 * 
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-03 10:55:44
 */
@Mapper
public interface DcardUserInfoDao extends BaseMapper<DcardUserInfoVo> {
	
}
