package com.dv.controller.data.resp;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Builder
@Data
@Accessors(chain = true)
public class Response<T> {
    private ResponseStatus status;
    private String message;
    private T data;
}