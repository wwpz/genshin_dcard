package top.xc27.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.function.BiFunction;

@Data
public class BasicQueryForPage {
    /**
     * 页数
     */
    @TableField(exist = false)
    @JsonIgnore
    private int page = 1;
    /**
     * 每页多少条
     */
    @TableField(exist = false)
    @JsonIgnore
    private int pageSize = 10;

    public <T> T getPage(BiFunction<Integer, Integer, T> constructor) {
        return constructor.apply(page, pageSize);
    }

}

