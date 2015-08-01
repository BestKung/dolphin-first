/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.dental.model.Employee;
import th.co.geniustree.dental.repo.EmployeeRepo;

/**
 *
 * @author Best
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @RequestMapping(value = "/saveemployee", method = RequestMethod.POST)
    public void saveEmployee(@Validated @RequestBody Employee employee) {
       employeeRepo.save(employee);
    }

    @RequestMapping(value = "/employees" , method = RequestMethod.GET)
    public Page<Employee> getEmployee(Pageable pageable){
    return employeeRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "totalemployee" , method = RequestMethod.GET)
    public Long totalEmployee(){
    return employeeRepo.count();
    }
    
}
