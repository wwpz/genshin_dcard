package top.xc27.dcard.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PoolData {

    private String uid;
    private String gacha_type;
    private String item_id;
    private String count;
    private LocalDateTime time;
    private String name;
    private String lang;
    private String item_type;
    private String rank_type;
    private Long id;
}
