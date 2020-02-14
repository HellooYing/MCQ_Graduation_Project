package com.bishe.cloud.common;

/**
 * @description:
 * @author: mayingying03
 * @date: 2020/2/14
 * @time: 11:31 下午
 */
public class ResultBase<T> {
    Boolean success;
    String errorMsg;
    Integer errorCode;
    T value;

    public Boolean isSuccess() {
        return success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ResultBase() {
    }

    public ResultBase(Boolean success, String errorMsg, Integer errorCode, T value) {
        this.success = success;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
        this.value = value;
    }

    public ResultBase(Boolean success, T value) {
        this.success = success;
        this.value = value;
    }

    public ResultBase(Boolean success, String errorMsg, Integer errorCode) {
        this.success = success;
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public ResultBase(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResultBase{" +
                "success=" + success +
                ", errorMsg='" + errorMsg + '\'' +
                ", errorCode=" + errorCode +
                ", value=" + value +
                '}';
    }
}
