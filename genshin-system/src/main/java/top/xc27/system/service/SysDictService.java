package top.xc27.system.service;

import top.xc27.system.vo.SysDictTreeVo;

import java.util.List;

/**
 * 字典
 *
 * @author Pcling
 * @email lingcglib@163.com
 * @date 2023-04-07 11:26:00
 */
public interface SysDictService {

    List<SysDictTreeVo> queryTree();
}
