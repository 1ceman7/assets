package com.yize.www.dept.web;

import com.yize.www.dept.pojo.DeptModel;
import com.yize.www.dept.pojo.DeptQueryModel;
import com.yize.www.dept.service.deptService;
import com.yize.www.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("dept")
public class deptController {
    @Autowired
    private deptService deptService;
    @RequestMapping("list")
    @ResponseBody
    public PageModel list(DeptQueryModel gqm, PageModel pageModel){
        Integer count = deptService.getCount(gqm);
        pageModel.setPageCount(count);
        List<DeptModel> deptList = deptService.getAll(gqm, pageModel);
        pageModel.setRows(deptList);
        return pageModel;
    };

    @RequestMapping("update")
    @ResponseBody
    public String update(DeptModel deptModel,Integer id){

        if (deptModel.getId()!=null){
            System.out.println(deptModel.getId());
        }else {
            System.out.println("id=null");
        }
        return "data";
    }
}
