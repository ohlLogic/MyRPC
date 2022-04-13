package com.ohl.MyRPCVersion3.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    //客户端和服务端公有的，模拟RPC中传输的信息
    private Integer id;
    private String userName;
    private boolean sex;
}