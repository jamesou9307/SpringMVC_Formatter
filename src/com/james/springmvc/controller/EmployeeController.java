package com.james.springmvc.controller;

import com.james.springmvc.entity.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

    private static final Log logger= LogFactory.getLog(EmployeeController.class);

    @RequestMapping(value = "/emp_input")
    public String input(Model model){

        model.addAttribute("employee",new Employee());
        return "EmployeeForm";
    }

    @RequestMapping(value = "/employee_save")
    public String save(Model model, @ModelAttribute Employee employee, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            FieldError fieldError=bindingResult.getFieldError();
            logger.info("Code:"+fieldError.getCode()+",field:"+fieldError.getField());
            return "EmployeeForm";
        }

        model.addAttribute("employee",employee);
        return "EmployeeDetails";
    }

}
