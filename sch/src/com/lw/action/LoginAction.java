package com.lw.action;

import com.lw.serivce.LoginSerivce;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;

public class LoginAction {
    private String name;
    private String password;
    private HttpServletResponse response = ServletActionContext.getResponse();
    @Autowired
    private LoginSerivce loginSerivce;

    public String tijiao() throws Throwable {
        Thread.sleep(2000);
        response.setContentType("text/html;charset=UTF-8");
        if (null != name || null != password) {
            if (loginSerivce.Login(name, password)) {
                response.getWriter().write("1");
                return "success";
            }else{
                response.getWriter().write("0");
            }
        }
        Thread.sleep(5000);
        return "failure";
    }

    public void antijiao() throws Throwable {
        response.setContentType("text/html;charset=UTF-8");
        if (null != name || null != password) {
            if (loginSerivce.Login(name, password)) {
                response.getWriter().write("1");
            }else{
                response.getWriter().write("0");
            }
        }
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
