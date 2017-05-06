package com.lw.interfaces;/**
 * Created by Administrator on 2017/3/10.
 */

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author 李龙雨
 * @version 0.1
 * @date: 2017/3/10 11:08
 */
@WebService
public interface HelloSch {
    String sayHi(@WebParam(name="text")String text);
}
