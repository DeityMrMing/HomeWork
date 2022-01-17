package com.work.demo.controller;

import com.github.pagehelper.PageInfo;
import com.work.demo.bean.User;
import com.work.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String index(){
        return "login";
    }
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model)throws Exception{
        User u=userService.getLoginUser(user.getUserName(),user.getPassword());
        if(u!=null){
            session.setAttribute("loginUser",user);
            //登录成功重定向到主页面，重定向防止重复提交
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }

    }
    @GetMapping("/main.html")
    public  String mains(Model model,HttpSession session){ Object loginUser = session.getAttribute("loginUser");
    if (loginUser !=null){
        return "main";
        }else {
        model.addAttribute("msg","先登入");
            return "login";
      }
    }
    @ResponseBody
    @GetMapping("/testPageHelper1")
    public PageInfo<User> testPageHelper1(@RequestParam(defaultValue ="1" )Integer currentPage,
                                          @RequestParam(defaultValue = "10")Integer pageSize,
                                          @RequestParam(value = "userName",required = false)String userName){
        PageInfo<User> queryResult = userService.UserFen(userName,currentPage,pageSize);
        return queryResult;
    }

    @GetMapping("/useradd")
    public  String useradd(){
        return "uadd";
    }
    @ResponseBody
    @PostMapping("/useraddsave")
    public Map saveUser(User user){
        boolean b = userService.useradd(user);
        Map<String,Object> map = new HashMap<>();
        map.put("flag",b);
        return map;
    }
    /**
     * 主页的欢迎页面显示
     * @return
     */
    @GetMapping("/welcome.html")
    public String welcome(){
        return "welcome";
    }

    @ResponseBody
    @GetMapping("/user/del")
    public Map delete(@RequestParam("id") Integer id) throws Exception {
        boolean b = userService.deluser(id);
        Map<String,Object> map = new HashMap<>();
        map.put("flag",b);
        return map;
    }

    @GetMapping("/li")
    public String toList(){
        return "ulist";
    }
    /**
     * 根据ID查出页面信息
     * @param id
     * @return
     */
    @ResponseBody
    @PostMapping("/getProductById")
    public User getUserByIds(@RequestParam("id") Integer id){
        User user = userService.getProduct(id);
        return user;
    }

    /**
     * 修改操作到数据库
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("/updateuser")
    public Map editProducts(User user){
        boolean b = userService.updateuser(user);
        Map<String,Object> map = new HashMap<>();
        map.put("flag",b);
        return map;
    }
    /**
     * 进入到编辑页面
     * @return
     */
    @GetMapping("/edit.html")
    public String edit(){
        return "uedit";
    }
}
