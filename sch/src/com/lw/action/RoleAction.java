package com.lw.action;/**
 * Created by Administrator on 2017/5/8.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lw.bean.LwOptResource;
import com.lw.serivce.ResourcesSerivce;
import com.lw.serivce.RoleSerivce;
import com.opensymphony.xwork2.ActionContext;
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
public class RoleAction {
    private HttpServletResponse response = ServletActionContext.getResponse();
    private HttpServletRequest request = ServletActionContext.getRequest();
    @Autowired
    private RoleSerivce roleSerivce;
    @Autowired
    private ResourcesSerivce resourcesSerivce;

    public String findAll() throws Exception {
        List list = roleSerivce.findAll();
        Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd HH:mm:ss").create();
        String s = gson.toJson(list);
        List<LwOptResource> listres = resourcesSerivce.findAll();
        for (int i = 0; i < listres.size(); i++) {
            LwOptResource listre = listres.get(i);
            if (listre.getResourceParent() == 0) {
                listres.remove(i);
            }
        }
        ActionContext.getContext().getSession().put("listres",listres);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(s);
        return null;
    }
    public String selectRessourcesByRole() throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        List list = roleSerivce.findByProperty(Integer.valueOf(id));
        request.setAttribute("list",list);
        response.getWriter().write("1");
        return null;
    }

}
