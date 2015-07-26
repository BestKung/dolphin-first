/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    @RequestMapping(value = "/saveemployee" , method = RequestMethod.POST)
    public void saveEmployee(@RequestBody Employee employee){
    employeeRepo.save(employee);
    }
}
