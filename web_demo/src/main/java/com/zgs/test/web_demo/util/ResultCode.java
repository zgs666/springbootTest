package com.zgs.test.web_demo.util;

public enum ResultCode {
    Success(200,"交易成功"),
    Fail(500,"交易失败");

    private Integer Code;
    private String Msg;

    ResultCode(Integer code, String msg) {
        Code = code;
        Msg = msg;
    }

    public Integer getCode() {
        return Code;
    }

    public void setCode(Integer code) {
        Code = code;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
}
