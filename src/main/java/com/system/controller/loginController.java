package com.system.controller;

import com.system.pojo.Suser;
import com.system.pojo.SuserExample;
import com.system.service.SuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes({"username", "Sno", "Tno"})
public class loginController {

    @Autowired
    private SuserService suserService;

    // 登录表单处理
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, Model model) {
        System.out.println("用户登录："+ username + password);
        // 封装成一个 Suser 类
        Suser suser = new Suser(username, password, null);
        // 创造条件
        SuserExample example = new SuserExample();
        example.createCriteria().andUsernameEqualTo(username);
        Suser suser1 = suserService.GetUser(example);

        // 判断用户记录是否存在
        String correctPassWord = suser1.getPassword();
        if (correctPassWord.equals(password)) {
            System.out.println("登陆成功");
            // 判断用户类型
            int type = Integer.parseInt(suser1.getType());
            if (type == 0) {
                model.addAttribute("username", username);
                return "admin";
            }
            else if (type == 1) {
                model.addAttribute("Sno", username);
                return "student";
            }
            else {
                model.addAttribute("Tno", username);
                return "teacher";
            }
        }
        // 用户不存在或者密码输入错误
        if (suser1.getUsername() == null) {
            return "failed";
        }
        return "failed";
    }
}
