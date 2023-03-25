package top.xc27.web.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.xc27.web.service.ApiDcardService;
import top.xc27.common.core.result.Result;

/**
 * 原神用户抽卡记录分析接口
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-02-20 22:50:32
 */
@RestController
@RequestMapping("api")
@Api(value = "web_原神用户抽卡记录分析", tags = {"web_原神用户抽卡记录分析"})
public class ApiDcardController {

    @Autowired
    private ApiDcardService apiDcardService;

    /**
     *
     */
    @GetMapping("/dcard")
    @ApiOperation(value = "web_抽卡记录分析")
    public Result<String> dcard(@RequestParam("url") String url){
//        return Result.success(apiDcardService.dcard(url));
        return Result.success();
    }
}
