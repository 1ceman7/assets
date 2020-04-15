package com.yize.www.emp.mapper;

import com.yize.www.emp.pojo.EmpModel;
import com.yize.www.emp.pojo.EmpModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpModelMapper {
    int countByExample(EmpModelExample example);

    int deleteByExample(EmpModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmpModel record);

    int insertSelective(EmpModel record);

    List<EmpModel> selectByExample(EmpModelExample example);

    EmpModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmpModel record, @Param("example") EmpModelExample example);

    int updateByExample(@Param("record") EmpModel record, @Param("example") EmpModelExample example);

    int updateByPrimaryKeySelective(EmpModel record);

    int updateByPrimaryKey(EmpModel record);
}