package top.xc27.common.entity;

import lombok.Getter;

@Getter
public enum BasicEnum {

    STATE_OK("0","正常"),
    STATE_NO("1", "停用" ),

    DEL_OK("0", "正常"),
    DEL_NO("1", "删除"),

    ;

    private final String code;
    private final String message;

    public String code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    BasicEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
