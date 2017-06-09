package com.ManJia.MainPortInterface.dao.mapperJava;

import com.ManJia.MainPortInterface.dto.HishopCategories;
import com.ManJia.MainPortInterface.dto.HishopCategoriesExample;
import com.ManJia.MainPortInterface.dto.HishopCategoriesWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HishopCategoriesMapper {
    long countByExample(HishopCategoriesExample example);

    int deleteByExample(HishopCategoriesExample example);

    int deleteByPrimaryKey(Integer categoryid);

    int insert(HishopCategoriesWithBLOBs record);

    int insertSelective(HishopCategoriesWithBLOBs record);

    List<HishopCategoriesWithBLOBs> selectByExampleWithBLOBs(HishopCategoriesExample example);

    List<HishopCategories> selectByExample(HishopCategoriesExample example);

    HishopCategoriesWithBLOBs selectByPrimaryKey(Integer categoryid);

    int updateByExampleSelective(@Param("record") HishopCategoriesWithBLOBs record, @Param("example") HishopCategoriesExample example);

    int updateByExampleWithBLOBs(@Param("record") HishopCategoriesWithBLOBs record, @Param("example") HishopCategoriesExample example);

    int updateByExample(@Param("record") HishopCategories record, @Param("example") HishopCategoriesExample example);

    int updateByPrimaryKeySelective(HishopCategoriesWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(HishopCategoriesWithBLOBs record);

    int updateByPrimaryKey(HishopCategories record);
}