package com.ManJia.MainPortInterface.test;

import com.ManJia.MainPortInterface.dao.mapperJava.HishopCategoriesMapper;
import com.ManJia.MainPortInterface.dto.HishopCategories;
import com.ManJia.MainPortInterface.dto.HishopCategoriesExample;
import com.ManJia.MainPortInterface.dto.HishopCategoriesWithBLOBs;
import com.ManJia.MainPortInterface.service.GetAllCategories;
import com.ManJia.MainPortInterface.utils.MD5Utils;
import com.ManJia.MainPortInterface.utils.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/8.
 */


@Component
public class TCategories {
    @Autowired
    GetAllCategories getAllCategories;

    public void f(){
        System.out.println(getAllCategories.getAllCategoriesAsJSONArray());
    }

    public static void main(String[]args){

        /*String []configs={"classpath*:applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
        System.out.println(ctx+"---------------------");
        TCategories tCategories = SpringUtil.getBean(TCategories.class);
        tCategories.f();*/

//       String requestMethod="getAllCategory";
//        String requestMethod="getAllGuidOfHishopProducts";//getAllGuidOfHishopProducts
        String requestMethod="getSomeProducts";
        String formatDate=new SimpleDateFormat("yyyy_MM_dd").format(new Date());
        System.out.println(formatDate);
        //60ccf292c03c09ac115c2ac383a1d180
            System.out.println(MD5Utils.generatePassword(requestMethod+formatDate+"key1"+"secret1"));

    }
}
