package com.ohl.MyRPCVersion4.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class RPCResponse implements Serializable {
    private int code;
    private String message;

    //其他序列化方式需要知道data的type
    private Class<?> dataType;
    private Object data;

    public static RPCResponse success(Object data)
    {
        return RPCResponse.builder().code(200).data(data).dataType(data.getClass()).build();
    }

    public static RPCResponse fail()
    {
        return RPCResponse.builder().code(500).message("服务器错误").build();
    }
}
