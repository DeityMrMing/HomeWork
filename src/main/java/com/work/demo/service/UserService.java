package com.work.demo.service;

import com.github.pagehelper.PageInfo;
import com.work.demo.bean.User;
import org.apache.ibatis.annotations.Param;


public interface UserService {
    public User getLoginUser(String userName,String password)throws Exception;
    public  boolean useradd(User user);
    public  boolean deluser( Integer id);
    public  boolean updateuser(User user);
    PageInfo<User> UserFen(String userName,int pageNum, int pageSize);
    public User getProduct(Integer id);
}
