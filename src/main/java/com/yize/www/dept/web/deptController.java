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
    /*   进入“部门管理”页面后展示所有信息   */
    public PageModel list(DeptQueryModel dqm, PageModel pageModel) {
        //获取总数
        Integer total = deptService.getCount(dqm);
        pageModel.setPageTotal(total);
        //获取数据
        List<DeptModel> deptList = deptService.getAll(dqm, pageModel);
        deptList.forEach(deptModel -> System.out.println(deptList));
        pageModel.setRows(deptList);
        return pageModel;
    }

    ;


    @RequestMapping("update_list")
    @ResponseBody
    /*    进入“新建/修改”页面后展示所选中的信息   */
    public DeptModel update_list(DeptModel deptModel, Integer id) {
        if (id != null) {
            deptModel = deptService.getId(id);
            System.out.println(deptModel.getName());
        } else {
            System.out.println("id=null");
        }
        ;

        return deptModel;
    }


    @RequestMapping("save")
    @ResponseBody
    public String save(DeptModel deptModel) {
        deptService.save(deptModel);
        return "saveOk";
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(DeptModel deptModel) {
        System.out.println(deptModel.getId());
        System.out.println(deptModel.getName());
        deptService.update(deptModel);
        return "updateOk";
    }

    @RequestMapping("del")
    @ResponseBody
    public String del(Integer id) {
        System.out.println(id);
        deptService.del(id);
        return "delOk";
    }
}
