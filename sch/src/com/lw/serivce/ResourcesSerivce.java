package com.lw.serivce;/**
 * Created by Administrator on 2017/5/8.
 */

import com.lw.dao.LwOptResourceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李龙雨
 * @version 0.1
 * @date: 2017/5/8 21:12
 */
@Service
public class ResourcesSerivce {
    @Autowired
    private LwOptResourceDAO lwOptResourceDAO;
    public List findAll() throws Exception {
        return lwOptResourceDAO.findAll();
    }
    public List findAllbyxx(Integer id) throws Exception {
        return lwOptResourceDAO.findByProperty("resourceParent",id);
    }
}
