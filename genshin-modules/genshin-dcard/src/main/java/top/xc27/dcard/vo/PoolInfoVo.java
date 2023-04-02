package top.xc27.dcard;

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
 * @date 2023-04-02 16:59:00
 */
@Data
@TableName("pool_info")
@EqualsAndHashCode(callSuper = true)
public class PoolInfoVo extends BasicQueryForPage implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Long sid;
    /**
     * uid
     */
    @ApiModelProperty(value = "uid")
    private String uid;
    /**
     * uid
     */
    @ApiModelProperty(value = "name")
    private String name;
    /**
     * 所抽池
     */
    @ApiModelProperty(value = "pool")
    private String pool;
    /**
     * 星级
     */
    @ApiModelProperty(value = "星级")
    private Integer dStar;
    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private Integer dType;
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

}
