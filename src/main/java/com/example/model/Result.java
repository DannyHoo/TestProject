package com.example.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;

    private int code;
    private String message;
    private T data;

    public Result() {
    }

    public static Result success() {
        return new Result().setCode(200).setMessage("success");
    }

    public static <T> Result success(T data) {
        return new Result().setCode(200).setMessage("success").setData(data);
    }

    public static Result error() {
        return new Result().setCode(500).setMessage("error");
    }

    public static <T> Result error(int code, String message) {
        return new Result().setCode(code).setMessage(message);
    }
}