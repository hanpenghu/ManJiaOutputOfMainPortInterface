package com.ManJia.MainPortInterface.service;

import com.ManJia.MainPortInterface.dao.mapperJava.HishopProductsMapper;
import com.ManJia.MainPortInterface.dto.HishopProductsExample;
import com.ManJia.MainPortInterface.dto.HishopProductsWithBLOBs;
import com.ManJia.MainPortInterface.utils.NotEmpty;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by hanhan on 2017/6/9.
 *
 */
@Component
public class GetSomeProducts {
    @Autowired
    HishopProductsMapper hishopProductsMapper;
    /**
     *传入几个guid,就返回几个对应的商品
     * */
    public String getSomeProducts(String guidsStrJsonArray){
        List<String> guidsStrs = JSON.parseArray(guidsStrJsonArray, String.class);
        if(!(NotEmpty.notEmpty(guidsStrs))){
            return "when mothers get Products in list by suns guidsStrJsonArray ,her have a Exception";
        }
        HishopProductsExample hishopProductsExample=new HishopProductsExample();
        hishopProductsExample.createCriteria().andGuidIn(guidsStrs);
        List<HishopProductsWithBLOBs> hishopProductsWithBLOBs = hishopProductsMapper.selectByExampleWithBLOBs(hishopProductsExample);
        if(!(NotEmpty.notEmpty(hishopProductsWithBLOBs))){
            return "Exception from mother where hishopProductsWithBLOBs is empty!";
        }
        String s = JSON.toJSONString(hishopProductsWithBLOBs);
        return s;
    }
}
