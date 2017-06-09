package com.ManJia.MainPortInterface.controller;
import com.ManJia.MainPortInterface.service.GetAllCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by Administrator on 2017/6/8.
 */
@RestController
@RequestMapping("category")
public class GetAllCategoriesC{
    @Autowired
    GetAllCategories getAllCategories;

    @RequestMapping(value ="getAllCategory",method = RequestMethod.POST,produces = {"text/html;charset=UTF-8"})
    public String getAllCategoryAsJSONArray(){
        return getAllCategories.getAllCategoriesAsJSONArray();
    }
}
