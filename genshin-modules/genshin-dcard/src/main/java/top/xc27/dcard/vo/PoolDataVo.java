package top.xc27.dcard.vo;

import lombok.Data;

import java.util.List;

@Data
public class PoolDataVo {

    private String page;
    private String size;
    private String total;
    private List<PoolData> list;
}
