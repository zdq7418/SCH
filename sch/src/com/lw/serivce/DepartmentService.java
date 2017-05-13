package com.lw.serivce;

import com.lw.bean.LwOptDepartment;
import com.lw.dao.LwOptDepartmentDAO;
import com.lw.dao.LwOptLoginDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ThundeRobot on 2017/5/13.
 */
public class DepartmentService {
    @Autowired
    private LwOptDepartmentDAO lwOptDepartmentDAO;
    @Autowired
    private LwOptLoginDAO lwOptLoginDAO;

    public List findAll(){
        return lwOptDepartmentDAO.findAll();
    }

    public void save(LwOptDepartment lwOptDepartment){
        lwOptDepartmentDAO.save(lwOptDepartment);
    }

    public void saveOrUpdate(LwOptDepartment lwOptDepartment){
        lwOptDepartmentDAO.attachDirty(lwOptDepartment);
    }
    public void delete(LwOptDepartment lwOptDepartment){
        lwOptDepartmentDAO.delete(lwOptDepartment);
    }

    public List findByHql(String hql){
        return lwOptLoginDAO.findByHql(hql);
    }

}