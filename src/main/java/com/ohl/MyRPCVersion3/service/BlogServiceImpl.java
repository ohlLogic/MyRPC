package com.ohl.MyRPCVersion3.service;

import com.ohl.MyRPCVersion3.common.Blog;

public class BlogServiceImpl implements BlogService{
    @Override
    public Blog getBlogById(Integer id) {
        Blog blog = Blog.builder().id(id).title("我的博客").userId(22).build();
        System.out.println("客户端查询" + id + "博客");
        return blog;
    }
}
