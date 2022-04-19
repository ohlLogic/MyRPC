package com.ohl.MyRPCVersion4.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Integer id;
    private Integer userId;
    private String title;
}
