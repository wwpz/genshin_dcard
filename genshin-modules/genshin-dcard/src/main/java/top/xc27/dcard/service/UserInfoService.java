package top.xc27.dcard.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.xc27.dcard.vo.UserInfoVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * dcard_userinfo信息
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-02 18:42:15
 */
public interface UserInfoService extends IService<UserInfoVo> {

    void userInfoDelete(List<String> ids);

    IPage<UserInfoVo> queryPage(UserInfoVo userInfo);

    boolean saveUserInfoVo(String uid, HttpServletRequest request);
}

