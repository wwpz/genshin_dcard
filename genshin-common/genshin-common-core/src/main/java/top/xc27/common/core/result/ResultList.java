package top.xc27.common.core.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class ResultList<T> {

    private Integer code;
    private String message;
    private Long total = 0L;
    private Collection<T> object;

    private ResultList(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    private ResultList(IPage<T> page, ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.object = page.getRecords();
        this.total = page.getTotal();
    }

    private ResultList(Collection<T> object, ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.object = object;
    }

    public static <T> ResultList<T> success(IPage<T> page) {
        return new ResultList<>(page, ResultCode.SUCCESS);
    }

    public static <T> ResultList<T> success(Collection<T> object) {
        return new ResultList<>(object, ResultCode.SUCCESS);
    }

    public static <T> ResultList<T> fail() {
        return new ResultList<>(ResultCode.ERROR);
    }
}
