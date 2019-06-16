package com.tangyechun.controller;

import com.tangyechun.bean.RespBean;
import com.tangyechun.common.StateCode;
import com.tangyechun.model.User;
import com.tangyechun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 * @since 2019/6/16 18:03
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    @ResponseBody
    public RespBean addUser(User user) {
        int code = userService.addUser(user);
        if (code == StateCode.SUCCESS.value()) {
            return RespBean.ok("注册成功!");
        }
        else{
            return RespBean.error("注册失败！" + StateCode.valueOf(code).getReasonChPhrase());
        }
    }

}
