package com.yize.www.emp.web;
import com.yize.www.dept.service.deptService;
import com.yize.www.emp.pojo.EmpQueryModel;
import com.yize.www.emp.service.empService;
import com.yize.www.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        Integer total = empService.getCount(eqm);
        pageModel.setPageTotal(total);
        empService.getAll(eqm);
        return pageModel;
    };


}
