package com.lw.action;/**
 * Created by Administrator on 2017/4/27.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lw.bean.LwOptLogin;
import com.lw.bean.LwOptPersonnel;
import com.lw.serivce.LoginSerivce;
import com.lw.util.DateUtil;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 李龙雨
 * @version 0.1
 * @date: 2017/4/27 22:54
 */
public class PersonnelAction {
    @Autowired
    private LoginSerivce loginSerivce;
    private HttpServletResponse response = ServletActionContext.getResponse();
    private HttpServletRequest request = ServletActionContext.getRequest();

    public String findAll() throws Exception {
        List list = loginSerivce.findAll();
        Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd HH:mm:ss").create();
        String s = gson.toJson(list);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(s);
        return null;
    }

    public String overdue() throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        String loginId = request.getParameter("loginId");
        if (null == loginId || "".equals(loginId)) {
            response.getWriter().write("0");
            return null;
        }
        LwOptLogin optLogin = loginSerivce.findById(Integer.valueOf(loginId));
        optLogin.setIsUse("0");
        loginSerivce.updateLogin(optLogin);
        response.getWriter().write("1");
        return null;
    }

    public String savePersonnel() throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        String peopleName = request.getParameter("peopleName");
        String loginName = request.getParameter("loginName");
        String loginSex = request.getParameter("loginSex");
        String loginPassword = request.getParameter("loginPassword");
        String isTeacher = request.getParameter("isTeacher");
        List loginNameList = loginSerivce.findByLoginName(loginName);
        if(null != loginNameList && loginNameList.size()>0){
            response.getWriter().write("0");
            return null;
        }
        LwOptPersonnel lwOptPersonnel=new LwOptPersonnel();
        lwOptPersonnel.setPersonnelName(peopleName);
        lwOptPersonnel.setPersonnelSex(loginSex);
        lwOptPersonnel.setInductionDate(DateUtil.getTimestamp());
        lwOptPersonnel.setIsUse("1");
        lwOptPersonnel.setIsTeacher(Integer.valueOf(isTeacher));
        LwOptLogin lwOptLogin=new LwOptLogin();
        lwOptLogin.setLwOptPersonnel(lwOptPersonnel);
        lwOptLogin.setLoginName(loginName);
        lwOptLogin.setLoginPaw(loginPassword);
        lwOptLogin.setCreateDate(DateUtil.getTimestamp());
        lwOptLogin.setIsUse("1");
        loginSerivce.saveLoginAndPersonnel(lwOptLogin);
        response.getWriter().write("1");
        return null;
    }
    public String checkLoginName() throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        String loginName = request.getParameter("loginName");
        List loginNameList = loginSerivce.findByLoginName(loginName);
        if(loginNameList!=null && loginNameList.size()>0){
            response.getWriter().write("0");
            return null;
        }
        response.getWriter().write("1");
        return null;
    }
}
