package com.lw.serivce;/**
 * Created by Administrator on 2017/3/13.
 */

import com.lw.bean.LwOptLogin;
import com.lw.dao.LwOptLoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李龙雨
 * @version 0.1
 * @date: 2017/3/13 22:24
 */
@Service
public class LoginSerivce {
    @Autowired
    private LwOptLoginDAO lwOptLoginDAO;
    //账号登录
    public boolean Login(String name, String paw) {
        return lwOptLoginDAO.login(name, paw);
    }
    //查询全部数据
    public List findAll() {
        List list = lwOptLoginDAO.findAll();
        return list;
    }
    //修改登录信息
    public void updateLogin(LwOptLogin lwOptLogin){
        lwOptLoginDAO.attachDirty(lwOptLogin);
    }
    //根据ID查找登录信息
    public LwOptLogin findById(Integer id){
        return lwOptLoginDAO.findById(id);
    }
    //查找用户名是否重复
    public List findByLoginName(String loginName){
        return lwOptLoginDAO.findByProperty("loginName", loginName);
    }

    public void saveLoginAndPersonnel(LwOptLogin lwOptLogin){
        lwOptLoginDAO.save(lwOptLogin);
    }

}
