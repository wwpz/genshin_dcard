package top.xc27.dcard.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.xc27.common.core.result.Result;
import top.xc27.dcard.service.DcardService;

import javax.servlet.http.HttpServletRequest;

/**
 * 抽卡记录分析
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-02 15:29:30
 */
@RestController
@RequestMapping("/dcard")
@Api(value = "dcard_抽卡记录分析", tags = {"dcard_抽卡记录分析"})
public class DcardController {

    @Autowired
    private DcardService dcardService;
    @Autowired
    private HttpServletRequest servletRequest;

    /**
     * 根据uid 获取抽卡记录
     */
    @GetMapping("/queryDcard/{uid}")
    @ApiOperation(value = "根据uid 获取抽卡记录")
    public Result queryDcard(@PathVariable Integer uid){
        return Result.success();
    }

    /**
     * 分析抽卡记录
     */
    @GetMapping("/analyseData")
    @ApiOperation(value = "分析抽卡记录")
    public Result<String> analyseData(@RequestParam("url") String url){
        return Result.success(dcardService.analyseData(url, servletRequest));
    }
}
