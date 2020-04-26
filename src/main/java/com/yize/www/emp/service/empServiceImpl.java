package com.yize.www.emp.service;

import com.yize.www.emp.mapper.EmpModelMapper;
import com.yize.www.emp.pojo.EmpModel;
import com.yize.www.emp.pojo.EmpModelExample;
import com.yize.www.emp.pojo.EmpModelExample.Criteria;
import com.yize.www.emp.pojo.EmpQueryModel;
import com.yize.www.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class empServiceImpl implements empService{
    @Autowired
    private EmpModelMapper empModelMapper;

    @Override
    public Integer getCount(EmpQueryModel eqm) {
        EmpModelExample example = new EmpModelExample();
        return empModelMapper.countByExample(example);
    }

    @Override
    public List<EmpModel> getAll(EmpQueryModel eqm, PageModel pageModel) {
        EmpModelExample example = new EmpModelExample();
        example.setStart(pageModel.getStart());
        example.setLimit(pageModel.getPageCount());
        Criteria criteria = example.createCriteria();
        /*去重*/
        //example.setDistinct(true);
        //查询数据
        System.out.println("得到部门id="+eqm.getDeptid());
        System.out.println("得到name="+eqm.getName());
        System.out.println("得到电话="+eqm.getTel());
        System.out.println("得到性别="+eqm.getGender());
        List<EmpModel> empAndDept = empModelMapper.getEmpAndDept(eqm);
        /*for (int i=0 ; i<empAndDept.size();i++){
            //离职时间为空视图赋值”在职“，不为空赋值日期
            if (empAndDept.get(i).getOuttime()==null){
                empAndDept.get(i).setOutTimeView("在职");
            }else{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String time = sdf.format(empAndDept.get(i).getOuttime());
                empAndDept.get(i).setOutTimeView(time);
            }
        }*/
        empAndDept.forEach(emp -> System.out.println(emp));
        //empAndDept.forEach(System.out::println);

        return empAndDept;
    }

    @Override
    public void del(Integer id) {
        empModelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer getDeptCount(Integer id) {
        return empModelMapper.getDeptCount(id);
    }
}
