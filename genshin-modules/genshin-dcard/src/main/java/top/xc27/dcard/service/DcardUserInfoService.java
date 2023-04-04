package top.xc27.dcard.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.xc27.dcard.vo.DcardUserInfoVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * uid用户信息
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-03 10:55:44
 */
public interface DcardUserInfoService extends IService<DcardUserInfoVo> {

    void userInfoDelete(List<String> ids);

    IPage<DcardUserInfoVo> queryPage(DcardUserInfoVo userInfo);

    boolean saveDcardUserInfoVo(String uid, HttpServletRequest request);
}

