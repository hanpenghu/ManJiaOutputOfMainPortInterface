package com.ManJia.MainPortInterface.service;

import com.ManJia.MainPortInterface.dao.mapperJava.HishopCategoriesMapper;
import com.ManJia.MainPortInterface.dto.HishopCategories;
import com.ManJia.MainPortInterface.dto.HishopCategoriesExample;
import com.ManJia.MainPortInterface.dto.HishopCategoriesWithBLOBs;
import com.ManJia.MainPortInterface.utils.NotEmpty;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/8.
 */
@Service
public class GetAllCategories {
    @Autowired
    HishopCategoriesMapper hishopCategoriesMapper;
    public String  getAllCategoriesAsJSONArray(){
        try {
            HishopCategoriesExample he=new HishopCategoriesExample();
            he.createCriteria().andCategoryidIsNotNull();
            List<HishopCategories> hcwbs
                    = hishopCategoriesMapper.selectByExample(he);
            if(NotEmpty.notEmpty(hcwbs)){
                return ((JSONArray)JSON.toJSON(hcwbs)).toString();
            }else{
                return "has_a_exception_in_Service_of_com.ManJia.MainPortInterface.service.GetAllCategories.getAllCategoriesAsJSONArray()001";
            }
        } catch (Exception e) {}
        return "has_a_exception_in_Service_of_com.ManJia.MainPortInterface.service.GetAllCategories.getAllCategoriesAsJSONArray()002";
    }
}
