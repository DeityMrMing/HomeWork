package com.work.demo.mapper;

import com.work.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    public User getLoginUser(@Param("userName") String userName,@Param("password") String password)throws Exception;
    public User getProduct(@Param("id")Integer id);

    public List<User> selectUserFenYe(@Param("userName") String userName);

    public  int useradd(User user);

    public  int updateuser(User user);

    public  int deluser(@Param("id") Integer id);

}
