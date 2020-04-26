package com.yize.www.emp.web;
import com.yize.www.dept.service.deptService;
import com.yize.www.emp.pojo.EmpModel;
import com.yize.www.emp.pojo.EmpQueryModel;
import com.yize.www.emp.service.empService;
import com.yize.www.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("emp")
public class empController {
    @Autowired
    private empService empService;
    @Autowired
    private deptService deptService;
    @RequestMapping("list")
    @ResponseBody
    public PageModel list(PageModel pageModel, EmpQueryModel eqm){
        //获取总数
        Integer total = empService.getCount(eqm);
        pageModel.setPageTotal(total);
        //获取信息

        /*if (eqm.getDeptid()!=null){
            System.out.println("！！！！！！！！得到部门id");
            List<EmpModel> deptAntEmp = deptService.findDeptAntEmp(eqm.getDeptid());
            pageModel.setRows(deptAntEmp);
        }else{
        }*/
        List<EmpModel> empAndDept = empService.getAll(eqm, pageModel);
        pageModel.setRows(empAndDept);
        return pageModel;
    };


    @RequestMapping("del")
    @ResponseBody
    public String del(Integer id) {
        System.out.println(id);
        empService.del(id);
        return "delOk";
    }
}
