package top.xc27.system.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import top.xc27.common.core.basic.BasicQueryForPage;

/**
 * 字典类型表
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-03 11:26:00
 */
@Data
@TableName("sys_dict_type")
@EqualsAndHashCode(callSuper = true)
public class SysDictTypeVo extends BasicQueryForPage implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 字典主键
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "字典主键")
    private Long dictId;
    /**
     * 字典名称
     */
    @ApiModelProperty(value = "字典名称")
    private String dictName;
    /**
     * 字典类型
     */
    @ApiModelProperty(value = "字典类型")
    private String dictType;
    /**
     * 状态（0正常 1停用）
     */
    @ApiModelProperty(value = "状态（0正常 1停用）")
    private String status;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者")
    private String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者")
    private String updateBy;
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
