package com.yize.www.dept.mapper;

import com.yize.www.dept.pojo.DeptModel;
import com.yize.www.dept.pojo.DeptModelExample;
import java.util.List;

import com.yize.www.emp.pojo.EmpModel;
import com.yize.www.emp.pojo.EmpModelExample;
import org.apache.ibatis.annotations.Param;

public interface DeptModelMapper {
    int countByExample(DeptModelExample example);

    int deleteByExample(DeptModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeptModel record);

    int insertSelective(DeptModel record);

    List<DeptModel> selectByExample(DeptModelExample example);

    DeptModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeptModel record, @Param("example") DeptModelExample example);

    int updateByExample(@Param("record") DeptModel record, @Param("example") DeptModelExample example);

    int updateByPrimaryKeySelective(DeptModel record);

    int updateByPrimaryKey(DeptModel record);

}