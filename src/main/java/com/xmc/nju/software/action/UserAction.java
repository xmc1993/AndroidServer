package com.xmc.nju.software.action;

import com.xmc.nju.software.entity.User;
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
    private User user;

    @Autowired
    private UserService userService;

    public void login(){
        String formData = getFormData();
        System.out.println(formData);
        System.out.println("over");
    }

}
