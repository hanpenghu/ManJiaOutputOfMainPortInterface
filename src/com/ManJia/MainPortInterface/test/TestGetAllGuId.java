package com.ManJia.MainPortInterface.test;

import com.ManJia.MainPortInterface.service.GetAllGuidOfHishopProducts;
import com.ManJia.MainPortInterface.service.GetSomeProducts;
import com.ManJia.MainPortInterface.utils.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/6/12.
 */
@Component
public class TestGetAllGuId {
    @Autowired
    GetAllGuidOfHishopProducts getAllGuidOfHishopProducts;

    @Autowired
    GetSomeProducts getSomeProducts;

    public void f(){
        String allGuIdOfJSONString = getAllGuidOfHishopProducts.getAllGuIdOfJSONString();
        System.out.println(allGuIdOfJSONString);

    }

    public String g(){
        return getSomeProducts.getSomeProducts("[\"\",\"230DBCE6-C250-4C45-9C04-E12853A285D5\"]");
    }


    public static void main(String[]args){
         String []configs={"classpath*:applicationContext.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configs);
        System.out.println(ctx+"---------------------");
        TestGetAllGuId testGetAllGuId = SpringUtil.getBean(TestGetAllGuId.class);
        testGetAllGuId.f();
//       System.out.println( testGetAllGuId.g());
    }
}
