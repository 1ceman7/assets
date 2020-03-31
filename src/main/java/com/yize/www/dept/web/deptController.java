package com.yize.www.dept.web;

import com.yize.www.dept.service.deptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class deptController {
    @Autowired
    private deptService deptService;
}
