package com.ManJia.MainPortInterface.test;

import com.ManJia.MainPortInterface.service.GetAllGuid;
import com.ManJia.MainPortInterface.utils.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */
@Component
public class TestGetAllGuId {
    @Autowired
    GetAllGuid getAllGuid;
    public void f(){
        List<String> allGuId = getAllGuid.getAllGuId();
        System.out.println(allGuId.size());
        System.out.println(allGuId);
    }
    public static void main(String[]args){
         String []configs={"classpath*:applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
        System.out.println(ctx+"---------------------");
        TestGetAllGuId testGetAllGuId = SpringUtil.getBean(TestGetAllGuId.class);
        testGetAllGuId.f();
    }
}
