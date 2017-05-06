package com.lw.serivce;/**
 * Created by Administrator on 2017/3/10.
 */

import com.lw.interfaces.HelloSch;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @author 李龙雨
 * @version 0.1
 * @date: 2017/3/10 11:14
 */
@Component("helloWorldImpl")
@WebService(endpointInterface="com.lw.interfaces.HelloSch")
public class HelloSchImpl implements HelloSch {
    @Override
    public String sayHi(String text) {
        return text+" 成功！";
    }
}
