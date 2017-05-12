package com.lw.serivce;/**
 * Created by Administrator on 2017/5/8.
 */

import com.lw.bean.LwOptRole;
import com.lw.dao.LwOptRoleDAO;
import com.lw.dao.LwOptRoleResourceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李龙雨
 * @version 0.1
 * @date: 2017/5/8 21:12
 */
@Service
public class RoleSerivce {
    @Autowired
    private LwOptRoleDAO lwOptRoleDAO;
    @Autowired
    private LwOptRoleResourceDAO lwOptRoleResourceDAO;
    public List findAll() throws Exception {
        return lwOptRoleDAO.findAll();
    }
    public List findByProperty(Integer id) throws Exception {
        LwOptRole byId = lwOptRoleDAO.findById(id);
        return lwOptRoleResourceDAO.findByProperty("lwOptRole",byId);
    }
    public List roleResourcefindAll() throws Exception{
        return lwOptRoleResourceDAO.findAll();
    }
}
