package com.lw.util;/**
 * Created by Administrator on 2017/3/10.
 */

import com.lw.interfaces.HelloSch;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * @author 李龙雨
 * @version 0.1
 * @date: 2017/3/10 11:05
 */
public class TextWebService {
    public static void main(String[] args) {
        JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
        svr.setServiceClass(HelloSch.class);
        svr.setAddress("http://localhost:8080/webservice/helloSch");
        HelloSch hw = (HelloSch) svr.create();
        System.out.println(hw.sayHi("世界"));
    }
}
