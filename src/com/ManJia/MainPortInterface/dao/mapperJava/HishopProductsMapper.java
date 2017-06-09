package com.ManJia.MainPortInterface.dao.mapperJava;

import com.ManJia.MainPortInterface.dto.HishopProducts;
import com.ManJia.MainPortInterface.dto.HishopProductsExample;
import com.ManJia.MainPortInterface.dto.HishopProductsWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HishopProductsMapper {
    long countByExample(HishopProductsExample example);

    int deleteByExample(HishopProductsExample example);

    int deleteByPrimaryKey(Integer productid);

    int insert(HishopProductsWithBLOBs record);

    int insertSelective(HishopProductsWithBLOBs record);

    List<HishopProductsWithBLOBs> selectByExampleWithBLOBs(HishopProductsExample example);

    List<HishopProducts> selectByExample(HishopProductsExample example);

    HishopProductsWithBLOBs selectByPrimaryKey(Integer productid);

    int updateByExampleSelective(@Param("record") HishopProductsWithBLOBs record, @Param("example") HishopProductsExample example);

    int updateByExampleWithBLOBs(@Param("record") HishopProductsWithBLOBs record, @Param("example") HishopProductsExample example);

    int updateByExample(@Param("record") HishopProducts record, @Param("example") HishopProductsExample example);

    int updateByPrimaryKeySelective(HishopProductsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(HishopProductsWithBLOBs record);

    int updateByPrimaryKey(HishopProducts record);
}