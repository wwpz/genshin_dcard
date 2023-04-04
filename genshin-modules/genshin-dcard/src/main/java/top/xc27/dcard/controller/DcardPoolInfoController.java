package top.xc27.dcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import top.xc27.common.core.result.ResultList;
import top.xc27.dcard.service.DcardPoolInfoService;
import top.xc27.dcard.vo.DcardPoolInfoVo;

/**
 * 抽到的卡池信息
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-03 10:55:44
 */
@RestController
@RequestMapping("/dcard/dcardpoolinfo")
@Api(value = "dcard_抽到的卡池信息", tags = {"dcard_抽到的卡池信息"})
public class DcardPoolInfoController {

    @Autowired
    private DcardPoolInfoService poolInfoService;

    /**
     * pageInfo 分页查询
     */
    @PostMapping("/queryPage")
    @ApiOperation(value = "dcard_抽到的卡池信息表分页接口")
    public ResultList<DcardPoolInfoVo> queryPage(@RequestBody DcardPoolInfoVo poolInfo){
        return ResultList.success(poolInfoService.queryPage(poolInfo));
    }
}
