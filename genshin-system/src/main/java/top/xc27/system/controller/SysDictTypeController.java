package top.xc27.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import top.xc27.common.core.result.Result;
import top.xc27.common.core.result.ResultList;
import top.xc27.system.service.SysDictTypeService;
import top.xc27.system.vo.SysDictTypeVo;

import java.util.List;

/**
 * 字典类型表
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-03 11:26:00
 */
@RestController
@RequestMapping("/sys/dictType")
@Api(value = "sys_字典类型表", tags = {"sys_字典类型表"})
public class SysDictTypeController {

    @Autowired
    private SysDictTypeService sysDictTypeService;

    /**
     * 新增 sys_字典类型表
     */
    @PostMapping("/add")
    @ApiOperation(value = "sys_字典类型表新增接口")
    public Result<String> sysDictTypeAdd(@RequestBody SysDictTypeVo sysDictType){
		sysDictTypeService.save(sysDictType);
        return Result.success();
    }

    /**
     * 修改 sys_字典类型表
     */
    @PutMapping("/update")
    @ApiOperation(value = "sys_字典类型表修改接口")
    public Result<String> sysDictTypeUpdate(@RequestBody SysDictTypeVo sysDictType){
        Assert.hasText(String.valueOf(sysDictType.getDictId()), "需要修改的id必传!");
		sysDictTypeService.updateById(sysDictType);
        return Result.success();
    }

    /**
     * 删除 sys_字典类型表
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "sys_字典类型表删除接口")
    public Result<String> sysDictTypeDelete(@RequestBody List<Long> ids){
		sysDictTypeService.sysDictTypeDelete(ids);
        return Result.success();
    }

    /**
     * pageInfo 分页查询
     */
    @PostMapping("/page")
    @ApiOperation(value = "sys_字典类型表分页接口")
    public ResultList<SysDictTypeVo> queryPage(@RequestBody SysDictTypeVo sysDictType){
        return ResultList.success(sysDictTypeService.queryPage(sysDictType));
    }
}
