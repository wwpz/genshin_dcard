package top.xc27.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xc27.common.core.result.Result;
import top.xc27.common.core.result.ResultList;
import top.xc27.system.service.SysDictService;
import top.xc27.system.vo.SysDictTreeVo;
import top.xc27.system.vo.SysDictTypeVo;

import java.util.List;

/**
 * 字典接口
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-07 11:26:00
 */
@RestController
@RequestMapping("/sys/dict")
@Api(value = "sys_字典接口", tags = {"sys_字典接口"})
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;

    /**
     * 字典树查询
     */
    @GetMapping("/tree")
    @ApiOperation(value = "sys_字典树查询接口")
    public Result<List<SysDictTreeVo>> queryTree(){
        return Result.success(sysDictService.queryTree());
    }
}
