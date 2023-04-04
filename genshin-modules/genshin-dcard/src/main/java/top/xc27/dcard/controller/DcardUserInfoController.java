package top.xc27.dcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import top.xc27.common.core.result.Result;
import top.xc27.common.core.result.ResultList;
import top.xc27.dcard.service.DcardUserInfoService;
import top.xc27.dcard.vo.DcardUserInfoVo;

import java.util.List;

/**
 * uid用户信息
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-03 10:55:44
 */
@RestController
@RequestMapping("/dcard/dcarduserinfo")
@Api(value = "dcard_uid用户信息", tags = {"dcard_uid用户信息"})
public class DcardUserInfoController {

    @Autowired
    private DcardUserInfoService userInfoService;

    /**
     * 修改 dcard_userinfo信息
     */
    @PutMapping("/update")
    @ApiOperation(value = "dcard_userinfo信息修改接口")
    public Result<String> userInfoUpdate(@RequestBody DcardUserInfoVo userInfo){
        Assert.hasText(String.valueOf(userInfo.getUid()), "需要修改的id必传!");
        userInfoService.updateById(userInfo);
        return Result.success();
    }

    /**
     * 删除 dcard_userinfo信息
     */
    @DeleteMapping("/delete")
    @ApiOperation(value = "dcard_userinfo信息删除接口")
    public Result<String> userInfoDelete(@RequestBody List<String> ids){
        userInfoService.userInfoDelete(ids);
        return Result.success();
    }

    /**
     * pageInfo 分页查询
     */
    @PostMapping("/queryPage")
    @ApiOperation(value = "dcard_userinfo信息分页接口")
    public ResultList<DcardUserInfoVo> queryPage(@RequestBody DcardUserInfoVo userInfo){
        return ResultList.success(userInfoService.queryPage(userInfo));
    }
}
