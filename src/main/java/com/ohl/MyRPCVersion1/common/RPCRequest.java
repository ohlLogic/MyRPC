package com.ohl.MyRPCVersion1.common;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 相较于Version0，Request只发送了一个Id参数，但是服务端不会只有一个方法，因此传递参数服务不知道调用什么方法；
 * RPC请求：client发送应该调用的Service接口名，方法名，参数，参数类型
 * 服务端根据这些信息通过反射调用相应的方法
 * 使用java自带的序列化方式（实现Serializable）
 */
@Data
@Builder
public class RPCRequest implements Serializable {
    //服务类名，客户端知道接口名，服务端中用接口指向实现类
    private String interfaceName;
    //方法名
    private String methodName;
    //参数列表
    private Object[] params;
    //参数类型
    private Class<?>[] paramTypes;
}
