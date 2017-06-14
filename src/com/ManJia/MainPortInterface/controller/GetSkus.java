package com.ManJia.MainPortInterface.controller;

import com.ManJia.MainPortInterface.service.GetSomeSkus;
import com.ManJia.MainPortInterface.utils.NotEmpty;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/14.
 */
@RestController
@RequestMapping("skus")
public class GetSkus {

    @Autowired
    GetSomeSkus getSomeSkus;

    @RequestMapping(value ="getSomeSkus",method = RequestMethod.POST,produces = {"text/html;charset=UTF-8"})
    public String getSomeSkusC(@Param("jsonArrayOfGuids") String jsonArrayOfGuids){

        String someSkus = getSomeSkus.getSomeSkus(jsonArrayOfGuids);
        if(NotEmpty.notEmpty(someSkus)){
            return someSkus;
        }

        return "GetSkus.getSomeSkusC() has get nothing from database";
    }
}
