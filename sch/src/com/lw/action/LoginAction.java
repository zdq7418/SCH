package com.lw.action;

import com.lw.serivce.LoginSerivce;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginAction {
    private String name;
    private String password;
    @Autowired
    private LoginSerivce loginSerivce;

    public String tijiao() throws Throwable {
        Thread.sleep(2000);
        if (null != name || null != password) {
            if (loginSerivce.Login(name, password)) {
                return "success";
            }
        }
        Thread.sleep(5000);
        return "failure";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
