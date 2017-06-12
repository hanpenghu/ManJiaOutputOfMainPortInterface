package com.ManJia.MainPortInterface.service;

import com.ManJia.MainPortInterface.dao.mapperJava.HishopProductsMapper;
import com.ManJia.MainPortInterface.dto.HishopProducts;
import com.ManJia.MainPortInterface.dto.HishopProductsExample;
import com.ManJia.MainPortInterface.utils.NotEmpty;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/9.
 */

@Service
public class GetAllGuidOfHishopProducts {
    @Autowired
    HishopProductsMapper hishopProductsMapper;

    public String getAllGuIdOfJSONString(){
        List<String> guIds = hishopProductsMapper.getAllGuId();
        if(NotEmpty.notEmpty(guIds)){
            JSONArray ja = (JSONArray) JSON.toJSON(guIds);
            return ja.toString();
        }
        return "GetAllGuidOfHishopProducts.getAllGuIdOfJSONString() has get nothing from database";
    }

}

