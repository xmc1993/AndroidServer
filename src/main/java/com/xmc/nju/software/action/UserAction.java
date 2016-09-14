package com.xmc.nju.software.action;

import com.xmc.nju.software.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by xmc1993 on 16/9/14.
 */
@Setter
public class UserAction extends BaseAction {
    private String userName;
    private String password;

    @Autowired
    private UserService userService;

    public void login(){
        System.out.println("over");
    }

}
