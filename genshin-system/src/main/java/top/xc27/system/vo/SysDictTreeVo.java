package top.xc27.system.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SysDictTreeVo {

    @ApiModelProperty(value = "字典主键")
    private Long id;
    @ApiModelProperty(value = "字典名称")
    private String label;
    @ApiModelProperty(value = "子节点")
    private List<SysDictTreeVo> children;
}
