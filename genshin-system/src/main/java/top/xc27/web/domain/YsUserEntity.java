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
 * 原神用户表
 * 
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-02-20 22:21:16
 */
@Data
@TableName("ys_user")
@EqualsAndHashCode(callSuper=true)
public class YsUserEntity extends BasicQueryForPage implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 原神UID
	 */
	@TableId(type = IdType.AUTO)
	@ApiModelProperty(value = "原神UID")
		private Integer uid;
	/**
	 * 帐号状态（0正常 1停用）
	 */
	@ApiModelProperty(value = "帐号状态（0正常 1停用）")
		private String status;
	/**
	 * 删除标志（0代表存在 2代表删除）
	 */
	@ApiModelProperty(value = "删除标志（0代表存在 2代表删除）")
		private String delFlag;
	/**
	 * 最后查询IP
	 */
	@ApiModelProperty(value = "最后查询IP")
		private String loginIp;
	/**
	 * 最后查询时间
	 */
	@ApiModelProperty(value = "最后查询时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private LocalDateTime loginDate;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@TableField(fill = FieldFill.INSERT)
private LocalDateTime createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		@TableField(fill = FieldFill.INSERT_UPDATE)
private LocalDateTime updateTime;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
		private String remark;

}
