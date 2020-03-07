package edu.ynmd.tools;

/**
 * @Author:lb
 * @date:2020/3/4 8:42
 * @description:返回值封装
 */
public class Result {
    private boolean success;
    private int code;
    private String msg;
    private Object data;

    public static Result success(Object data) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(200);
        result.setData(data);
        return result;
    }

    public static Result success() {
        return success((Object)null);
    }

    public static Result fail(int code, String message) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(message);
        return result;
    }

    public static Result fail(String message) {
        return fail(500, message);
    }

    public static Result fail() {
        return fail((String)null);
    }

    public Result() {
    }

    public boolean isSuccess() {
        return this.success;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setSuccess(final boolean success) {
        this.success = success;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public void setData(final Object data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.isSuccess() != other.isSuccess()) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                label40: {
                    Object this$msg = this.getMsg();
                    Object other$msg = other.getMsg();
                    if (this$msg == null) {
                        if (other$msg == null) {
                            break label40;
                        }
                    } else if (this$msg.equals(other$msg)) {
                        break label40;
                    }

                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Result;
    }

    public int hashCode() {
        int result =  59 + (this.isSuccess() ? 79 : 97);
        result = result * 59 + this.getCode();
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "Result(success=" + this.isSuccess() + ", code=" + this.getCode() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
    }
}

