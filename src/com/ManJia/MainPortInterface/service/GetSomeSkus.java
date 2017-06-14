package com.ManJia.MainPortInterface.service;

import com.ManJia.MainPortInterface.dao.mapperJava.HishopSkusMapper;
import com.ManJia.MainPortInterface.dto.HishopSkus;
import com.ManJia.MainPortInterface.dto.HishopSkusExample;
import com.ManJia.MainPortInterface.utils.NotEmpty;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/14.
 */
@Component
public class GetSomeSkus {

    @Autowired
    HishopSkusMapper hishopSkusMapper;

    public  String  getSomeSkus(String guidsStrJsonArray){
        List<String> guidsStrs = JSON.parseArray(guidsStrJsonArray, String.class);
        if(!(NotEmpty.notEmpty(guidsStrs))){
            return "when mothers get Products in list by suns guidsStrJsonArray ,her have a Exception  (class GetSomeSkus)";
        }

        HishopSkusExample hishopSkusExample=new HishopSkusExample();
        hishopSkusExample.createCriteria().andGuidIn(guidsStrs);
        List<HishopSkus> hishopSkuses = hishopSkusMapper.selectByExample(hishopSkusExample);
        if(!(NotEmpty.notEmpty(hishopSkuses))){
            return "Exception from mother where hishopSkuses is empty!";
        }
        String s = JSON.toJSONString(hishopSkuses);
        return s;

    }

}
