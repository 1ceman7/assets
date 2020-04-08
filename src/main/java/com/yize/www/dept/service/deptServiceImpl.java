package com.yize.www.dept.service;

import com.yize.www.dept.mapper.DeptModelMapper;
import com.yize.www.dept.pojo.DeptModel;
import com.yize.www.dept.pojo.DeptModelExample;
import com.yize.www.dept.pojo.DeptQueryModel;
import com.yize.www.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class deptServiceImpl implements deptService {
    @Autowired
    private DeptModelMapper dmp;
    /*@Autowired
    private DeptModelExample example;*/
    @Override
    public Integer getCount(DeptQueryModel gqm) {
        DeptModelExample example = new DeptModelExample();
        DeptModelExample.Criteria criteria = example.createCriteria();


        return dmp.countByExample(example);
    }

    @Override
    public List<DeptModel> getAll(DeptQueryModel gqm, PageModel pageModel) {
        DeptModelExample example = new DeptModelExample();
        example.setStart(pageModel.getStart());
        example.setLimit(pageModel.getPageCount());
        DeptModelExample.Criteria criteria = example.createCriteria();

        List<DeptModel> deptModels = dmp.selectByExample(example);
        return deptModels;
    }

}
