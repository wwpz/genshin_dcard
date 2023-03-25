package top.xc27.web.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.xc27.common.core.basic.BasicQueryForPage;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 原神用户对应卡池表
 * 
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-02-20 22:39:32
 */
@Data
@TableName("ys_pool")
@EqualsAndHashCode(callSuper=true)
public class PoolEntity extends BasicQueryForPage implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	@ApiModelProperty(value = "主键id")
		private Integer sid;
	/**
	 * 原神UID
	 */
	@ApiModelProperty(value = "原神UID")
		private Integer uid;
	/**
	 * 星级
	 */
	@ApiModelProperty(value = "星级")
		private Integer starLevel;
	/**
	 * 抽到的时间
	 */
	@ApiModelProperty(value = "抽到的时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private LocalDateTime dTime;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@TableField(fill = FieldFill.INSERT)
private LocalDateTime createTime;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
		private Integer dTypeCode;

}
