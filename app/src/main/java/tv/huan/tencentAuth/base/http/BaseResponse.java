package tv.huan.tencentAuth.base.http;


import java.io.Serializable;
import java.util.Map;

public class BaseResponse<T extends Object>implements Serializable {
    protected int code;
    protected T data;
    protected T datas;
    protected String msg;
    protected int num;
    protected Map<String,Object> otherResult;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getResobj()  {
        return data;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public void setResobj(T resobj) {
        this.data = resobj;
    }

    public String getInfo() {
        return msg;
    }

    public void setInfo(String info) {
        this.msg = info;
    }

    public boolean isSuccess(){
        return  code== SubscriberCallBack.SUCCESS;
    }

    public Map<String, Object> getOtherResult() {
        return otherResult;
    }

    public void setOtherResult(Map<String, Object> otherResult) {
        this.otherResult = otherResult;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", resobj=" + data +
                ", info='" + msg + '\'' +
                '}';
    }
}
