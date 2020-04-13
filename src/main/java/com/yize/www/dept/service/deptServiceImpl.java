package com.yize.www.dept.service;

import com.yize.www.dept.mapper.DeptModelMapper;
import com.yize.www.dept.pojo.DeptModel;
import com.yize.www.dept.pojo.DeptModelExample;
import com.yize.www.dept.pojo.DeptModelExample.Criteria;
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
    //获取总数
    @Override
    public Integer getCount(DeptQueryModel gqm) {
        DeptModelExample example = new DeptModelExample();
        Criteria criteria = example.createCriteria();
        return dmp.countByExample(example);
    }

    @Override
    public List<DeptModel> getAll(DeptQueryModel dqm, PageModel pageModel) {
        DeptModelExample example = new DeptModelExample();
        example.setStart(pageModel.getStart());
        example.setLimit(pageModel.getPageCount());
        Criteria criteria = example.createCriteria();
        doQuery(dqm,criteria);
        List<DeptModel> deptModels = dmp.selectByExample(example);
        return deptModels;
    }
    //增加查询条件
    private void doQuery(DeptQueryModel dqm,Criteria createCriteria) {
        if(dqm.getName() != null && dqm.getName().trim().length() > 0){
            createCriteria.andNameLike("%" + dqm.getName().trim()+"%");
        }
        if(dqm.getTel() != null && dqm.getTel().trim().length() > 0){
            createCriteria.andTelLike("%" + dqm.getTel().trim()+"%");
        }

    }


    @Override
    public DeptModel getId(Integer id) {
        DeptModel deptModel = dmp.selectByPrimaryKey(id);
        return deptModel;
    }

    @Override
    public void save(DeptModel deptModel) {
        dmp.insertSelective(deptModel);
    }

    @Override
    public void update(DeptModel deptModel) {
        dmp.updateByPrimaryKeySelective(deptModel);
    }

    @Override
    public void del(Integer id) {
        dmp.deleteByPrimaryKey(id);
    }

}
