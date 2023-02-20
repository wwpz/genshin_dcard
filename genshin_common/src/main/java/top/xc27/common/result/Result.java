package top.xc27.common.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class Result<T> {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T object;
    private String message;
    private String code;

    public Result() {
    }

    private Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    private Result(ResultCode resultCode,String message) {
        this.code = resultCode.getCode();
        this.message = message;
    }

    private Result(String code,String message) {
        this.code = code;
        this.message = message;
    }

    private Result(T object, ResultCode resultCode) {
        this.object = object;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public static <T> Result<T> success() {
        return new Result<>(ResultCode.SUCCESS);
    }

    public static <T> Result<T> success(@Nullable T object) {
        return new Result<>(object, ResultCode.SUCCESS);
    }

    public static <T> Result<T> fail() {
        return new Result<>(ResultCode.ERROR);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(ResultCode.ERROR,message);
    }

    public static <T> Result<T> fail(ResultCode resultCode,String message) {
        return new Result<>(resultCode,message);
    }

    public static <T> Result<T> fail(String code,String message) {
        return new Result<>(code,message);
    }

}
