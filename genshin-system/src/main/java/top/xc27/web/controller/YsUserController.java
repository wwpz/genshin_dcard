package top.xc27.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import top.xc27.web.domain.YsUserEntity;
import top.xc27.web.service.YsUserService;
import top.xc27.common.core.result.Result;
import top.xc27.common.core.result.ResultList;

import java.util.List;

/**
 * 原神用户表
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-02-20 22:21:16
 */
@RestController
@RequestMapping("/top/xc27/web/ysuser")
@Api(value = "web_原神用户表", tags = {"web_原神用户表"})
public class YsUserController {

    @Autowired
    private YsUserService ysUserService;

    /**
     * 新增 web_原神用户表
     */
    @PostMapping("/add")
    @ApiOperation(value = "web_原神用户表新增接口")
    public Result<String> ysUserAdd(@RequestBody YsUserEntity ysUser){
		ysUserService.save(ysUser);
        return Result.success();
    }

    /**
     * 修改 web_原神用户表
     */
    @PutMapping("/update")
    @ApiOperation(value = "web_原神用户表修改接口")
    public Result<String> ysUserUpdate(@RequestBody YsUserEntity ysUser){
        Assert.hasText(String.valueOf(ysUser.getUid()), "需要修改的id必传!");
		ysUserService.updateById(ysUser);
        return Result.success();
    }

    /**
     * 删除 web_原神用户表
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "web_原神用户表删除接口")
    public Result<String> ysUserDelete(@RequestBody List<Integer> ids){
		ysUserService.ysUserDelete(ids);
        return Result.success();
    }

    /**
     * pageInfo 分页查询
     */
    @PostMapping("/queryPage")
    @ApiOperation(value = "web_原神用户表分页接口")
    public ResultList<YsUserEntity> queryPage(@RequestBody YsUserEntity ysUser){
        return ResultList.success(ysUserService.queryPage(ysUser));
    }
}
