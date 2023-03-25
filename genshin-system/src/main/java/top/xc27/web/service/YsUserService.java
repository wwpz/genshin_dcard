package top.xc27.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.xc27.web.domain.YsUserEntity;

import java.util.List;

/**
 * 原神用户表
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-02-20 22:21:16
 */
public interface YsUserService extends IService<YsUserEntity> {

    void ysUserDelete(List<Integer> ids);

    IPage<YsUserEntity> queryPage(YsUserEntity ysUser);
}

