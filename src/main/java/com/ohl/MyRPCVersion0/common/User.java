package com.ohl.MyRPCVersion0.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//lombok  Builder设
@Builder
//lombok 全属性Setter, Getter方法
@Data
//lombok 无参构造器
@NoArgsConstructor
//lombok 全属性构造器
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String userName;
    private Boolean sex;
}
