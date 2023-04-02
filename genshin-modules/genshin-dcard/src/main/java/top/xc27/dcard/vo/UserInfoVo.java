package top.xc27.dcard.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;
import top.xc27.common.core.basic.BasicQueryForPage;

/**
 * 
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-02 18:42:15
 */
@Data
@TableName("user_info")
@EqualsAndHashCode(callSuper=true)
public class UserInfoVo extends BasicQueryForPage implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * uid
	 */
	@TableId(type = IdType.AUTO)
	@ApiModelProperty(value = "uid")
		private String uid;
	/**
	 * 帐号状态(0正常 1停用)
	 */
	@ApiModelProperty(value = "帐号状态(0正常 1停用)")
		private String status;
	/**
	 * 删除标志(0代表存在 1代表删除)
	 */
	@ApiModelProperty(value = "删除标志(0代表存在 1代表删除)")
		private String delFlag;
	/**
	 * 最后查询IP
	 */
	@ApiModelProperty(value = "最后查询IP")
		private String lastIp;
	/**
	 * 最后查询时间
	 */
	@ApiModelProperty(value = "最后查询时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
		private LocalDateTime lastTime;
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

}
