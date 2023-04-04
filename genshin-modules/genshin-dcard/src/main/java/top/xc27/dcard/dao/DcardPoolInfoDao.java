package top.xc27.dcard.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.xc27.dcard.vo.DcardPoolInfoVo;

/**
 * 抽到的卡池信息
 * 
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-03 10:55:44
 */
@Mapper
public interface DcardPoolInfoDao extends BaseMapper<DcardPoolInfoVo> {
	
}
