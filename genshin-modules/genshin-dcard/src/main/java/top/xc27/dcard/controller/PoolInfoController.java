package top.xc27.dcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import top.xc27.common.core.result.Result;
import top.xc27.common.core.result.ResultList;
import top.xc27.dcard.PoolInfoVo;
import top.xc27.dcard.service.PoolInfoService;

import java.util.List;

/**
 * 抽到的卡池信息表
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-02 16:59:00
 */
@RestController
@RequestMapping("/dcard/poolinfo")
@Api(value = "dcard_抽到的卡池信息表", tags = {"dcard_抽到的卡池信息表"})
public class PoolInfoController {

    @Autowired
    private PoolInfoService poolInfoService;

    /**
     * pageInfo 分页查询
     */
    @PostMapping("/queryPage")
    @ApiOperation(value = "dcard_抽到的卡池信息表分页接口")
    public ResultList<PoolInfoVo> queryPage(@RequestBody PoolInfoVo poolInfo){
        return ResultList.success(poolInfoService.queryPage(poolInfo));
    }
}
