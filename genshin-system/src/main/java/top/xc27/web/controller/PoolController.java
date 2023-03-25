package top.xc27.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import top.xc27.web.domain.PoolEntity;
import top.xc27.web.service.PoolService;
import top.xc27.common.core.result.ResultList;

/**
 * 原神用户对应卡池
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-02-20 22:39:32
 */
@RestController
@RequestMapping("/top/xc27/web/pool")
@Api(value = "web_原神用户对应卡池", tags = {"web_原神用户对应卡池"})
public class PoolController {

    @Autowired
    private PoolService poolService;

    /**
     * pageInfo 分页查询
     */
    @PostMapping("/queryPage")
    @ApiOperation(value = "web_原神用户对应卡池表分页接口")
    public ResultList<PoolEntity> queryPage(@RequestBody PoolEntity pool){
        return ResultList.success(poolService.queryPage(pool));
    }
}
