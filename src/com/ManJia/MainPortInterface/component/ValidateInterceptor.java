package com.ManJia.MainPortInterface.component;

import com.ManJia.MainPortInterface.utils.MD5Utils;
import com.ManJia.MainPortInterface.utils.NotEmpty;
import com.ManJia.MainPortInterface.utils.ReadTxt;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.logging.log4j.LogManager;//
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/9.
 */
public class ValidateInterceptor implements HandlerInterceptor {
    protected Logger log= LogManager.getLogger(this.getClass().getName());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o)  {
        log.info("===========HandlerInterceptor preHandle");
        String key = request.getParameter("key");
        if(!NotEmpty.notEmpty(key)){
            return false;
        }
        String validate=request.getParameter("validate");
        if(!NotEmpty.notEmpty(validate)){
            return false;
        }
        String url = request.getRequestURI();
        if(!NotEmpty.notEmpty(url)){
            return false;
        }
        String requestMethod = url.substring(url.lastIndexOf("/") + 1);
        String formatDate = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
        String path = this.getClass().getResource("/").getPath();
        String json = ReadTxt.readAllTxt(path + "subPortToken.json");
        if(NotEmpty.notEmpty(json)){
            JSONArray ja = JSON.parseArray(json);
            for(Object ob:ja){
                JSONObject jo=(JSONObject)ob;
                if(NotEmpty.notEmpty(key)){//用户提供的key存在,此时再验证用户的md5
                    String secret = (String)jo.get(key);
                    if(NotEmpty.notEmpty(secret)){
                       String validate1= MD5Utils.generatePassword(requestMethod+formatDate+key+secret);
                       if(NotEmpty.notEmpty(validate1)){
                           if(NotEmpty.notEmpty(validate)){
                               if(validate1.equals(validate)){
                                   return true;
                               }
                           }else{log.error("subPort give her mother's wrong md5!!!");}
                       }else{
                           log.error("subPort give her mother's wrong md5!!!");
                       }
                    }else{
                        log.info("subPortToken.json has key have no secret! please check this txt!!");
                        return false;
                    }

                }else{
                    log.info("custom give the wrong key or  custom's key  not exsit!!");
                    return false;
                }
            }
        }else{
            log.error("Interceptor read json Validate text failed!!!");
            return false;
        }

        return false;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("===========HandlerInterceptor postHandle");

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("===========HandlerInterceptor afterCompletion");

    }
}
