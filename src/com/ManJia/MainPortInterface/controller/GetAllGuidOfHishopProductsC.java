package com.ManJia.MainPortInterface.controller;

import com.ManJia.MainPortInterface.service.GetAllGuidOfHishopProducts;
import com.ManJia.MainPortInterface.service.GetSomeProducts;
import com.ManJia.MainPortInterface.utils.NotEmpty;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/12.
 */
@RestController
@RequestMapping("product")
public class GetAllGuidOfHishopProductsC {
    @Autowired
    GetAllGuidOfHishopProducts getAllGuidOfHishopProducts;
    @Autowired
    GetSomeProducts getSomeProducts;
    @RequestMapping(value ="getAllGuidOfHishopProducts",method = RequestMethod.POST,produces = {"text/html;charset=UTF-8"})
    public String getAllGuidOfHishopProductsC(){
        String allGuIdOfJSONString = getAllGuidOfHishopProducts.getAllGuIdOfJSONString();
        if(NotEmpty.notEmpty(allGuIdOfJSONString)){
            return allGuIdOfJSONString;
        }
        return "GetAllGuidOfHishopProducts.getAllGuIdOfJSONString() has get nothing from database";
    }

    @RequestMapping(value ="getSomeProducts",method = RequestMethod.POST,produces = {"text/html;charset=UTF-8"})
    public String getSomeProductsOfJsonArrayStrC(@Param("jsonArrayOfGuids") String jsonArrayOfGuids){
        String someProducts = getSomeProducts.getSomeProducts(jsonArrayOfGuids);
        if(NotEmpty.notEmpty(someProducts)){
            return someProducts;
        }
        return "GetAllGuidOfHishopProducts.getSomeProductsOfJsonArrayStrC() has get nothing from database";
    }
    
    
    
}
