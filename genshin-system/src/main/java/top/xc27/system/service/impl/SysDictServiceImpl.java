package top.xc27.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xc27.system.service.SysDictDataService;
import top.xc27.system.service.SysDictService;
import top.xc27.system.service.SysDictTypeService;
import top.xc27.system.vo.SysDictDataVo;
import top.xc27.system.vo.SysDictTreeVo;
import top.xc27.system.vo.SysDictTypeVo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service("sysDictService")
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictTypeService sysDictTypeService;
    @Autowired
    private SysDictDataService sysDictDataService;

    @Override
    public List<SysDictTreeVo> queryTree() {
        ArrayList<SysDictTreeVo> trees = new ArrayList<>();
        List<SysDictTypeVo> dictTypes = sysDictTypeService.list();
        dictTypes.forEach(el -> {
            SysDictTreeVo sysDictTreeVo = new SysDictTreeVo();
            List<SysDictDataVo> dictDatas = sysDictDataService.getByType(el.getDictType());
            if(null != dictDatas && 0 != dictDatas.size()){
                List<SysDictTreeVo> arrays = new ArrayList<>();
                dictDatas.forEach(dataVo ->{
                    SysDictTreeVo treeVo = new SysDictTreeVo();
                    treeVo.setId(dataVo.getDictCode());
                    treeVo.setLabel(dataVo.getDictLabel());
                    arrays.add(treeVo);
                });
                sysDictTreeVo.setChildren(arrays);
            }
            sysDictTreeVo.setId(el.getDictId());
            sysDictTreeVo.setLabel(el.getDictName());
            trees.add(sysDictTreeVo);
        });
        return trees;
    }
}
