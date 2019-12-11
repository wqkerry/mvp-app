package tv.huan.tencentAuth.base.http;


public class UnKnowException extends RuntimeException {
    private int code;
    //用于展示的异常信息
    private String info;

    public UnKnowException(String info) {
        super(new Throwable(info));
        this.code = code;
        this.info = info;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
