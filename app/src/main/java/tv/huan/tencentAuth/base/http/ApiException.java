package tv.huan.tencentAuth.base.http;


public class ApiException extends RuntimeException {
    private int code;
    //用于展示的异常信息
    private String msg;

    public ApiException(int code, String info) {
        super(info);
        this.code = code;
        this.msg = info;

    }

    public ApiException(BaseResponse baseResponse) {
        this(baseResponse.getCode(), baseResponse.getInfo());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return msg;
    }

    public void setInfo(String info) {
        this.msg = info;
    }
}
