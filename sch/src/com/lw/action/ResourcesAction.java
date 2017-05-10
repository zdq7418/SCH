package com.lw.action;/**
 * Created by Administrator on 2017/5/8.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lw.serivce.ResourcesSerivce;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 李龙雨
 * @version 0.1
 * @date: 2017/5/8 21:11
 */
public class ResourcesAction {
    private HttpServletResponse response = ServletActionContext.getResponse();
    private HttpServletRequest request = ServletActionContext.getRequest();
    @Autowired
    private ResourcesSerivce resourcesSerivce;
    public String findAll() throws Exception {
        List list = resourcesSerivce.findAll();
        Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd HH:mm:ss").create();
        String s = gson.toJson(list);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(s);
        return null;
    }

}
