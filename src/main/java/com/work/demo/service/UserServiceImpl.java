package com.work.demo.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.work.demo.bean.User;
import com.work.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getLoginUser(String userName, String password) throws Exception {
        return userMapper.getLoginUser(userName,password);
    }

    @Override
    public boolean useradd(User user) {
        if (userMapper.useradd(user)>0){
            return true;
        }else {
           return false;
        }

    }

    @Override
    public boolean deluser(Integer id) {
        int iRes = 0;
        try {
            iRes = userMapper.deluser(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(iRes>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateuser(User user) {
        if (userMapper.updateuser(user)>0){
            return true;
        }else {
            return false;
        }


    }

    @Override
    public PageInfo<User> UserFen(String userName,int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> lists = userMapper.selectUserFenYe(userName);
        PageInfo<User> pageInfo = new PageInfo<User>(lists);
        return pageInfo;
    }

    @Override
    public User getProduct(Integer id) {
        return userMapper.getProduct(id);
    }


}
