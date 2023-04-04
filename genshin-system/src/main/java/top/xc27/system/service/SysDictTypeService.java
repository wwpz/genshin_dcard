package top.xc27.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.xc27.system.vo.SysDictTypeVo;

import java.util.List;

/**
 * 字典类型表
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-03 11:26:00
 */
public interface SysDictTypeService extends IService<SysDictTypeVo> {

    void sysDictTypeDelete(List<Long> ids);

    IPage<SysDictTypeVo> queryPage(SysDictTypeVo sysDictType);
}

