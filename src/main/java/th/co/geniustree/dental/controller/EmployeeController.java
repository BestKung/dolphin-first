/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import th.co.geniustree.dental.model.Employee;
import th.co.geniustree.dental.model.SearchData;
import th.co.geniustree.dental.repo.EmployeeRepo;
import th.co.geniustree.dental.service.EmployeeSearchService;

/**
 *
 * @author Best
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;
    private EmployeeSearchService employeeSearchService;
    private Integer employeeDetail;

    @RequestMapping(value = "/startpage", method = RequestMethod.GET)
    public Employee getCurrentLogin() {
        Employee employee = (Employee) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return employeeRepo.findByEmail(employee.getEmail());
    }

    @RequestMapping(value = "/saveemployee", method = RequestMethod.POST)
    public void saveEmployee(@Validated @RequestBody Employee employee) {
        employeeRepo.save(employee);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public Page<Employee> getEmployee(Pageable pageable) {
        return employeeRepo.findAll(pageable);
    }

    @RequestMapping(value = "/deleteemployee", method = RequestMethod.POST)
    public void deleteEmployee(@RequestBody Integer employeeID) {
        employeeRepo.delete(employeeID);
        employeeDetail = null;
    }

    @RequestMapping(value = "/employeedetail", method = RequestMethod.POST)
    public Employee EmployeeDetail(@RequestBody Employee employee) {
        if (employee.getId() != null) {
            employeeDetail = employee.getId();
        }
        return employeeRepo.findOne(employeeDetail);
    }

    @RequestMapping(value = "/employees/count", method = RequestMethod.GET)
    public Long countEmployees() {
        return employeeRepo.count();
    }

    @RequestMapping(value = "/employeesearch", method = RequestMethod.POST)
    public Page<Employee> searchEmployee(@RequestBody SearchData searchData, Pageable pageable) {
        String keyword = searchData.getKeyword();
        String searchBy = searchData.getSearchBy();
        System.out.println("----------------------------------------------------------->" + keyword);
        System.out.println("----------------------------------------------------------->" + searchBy);
        Page<Employee> searchEmp = null;
        if (searchBy.equals("Name")) {
            System.out.println("-----------------------------------------------------------> Name");
            searchEmp = employeeSearchService.searchByName(keyword, pageable);
        }
        if (searchBy.equals("Email")) {
            System.out.println("-----------------------------------------------------------> Email");
            searchEmp = employeeSearchService.searchByEmail(keyword, pageable);
        }
        if (searchBy.equals("Mobile")) {
            System.out.println("-----------------------------------------------------------> Mobile");
            searchEmp = employeeSearchService.searchByMobile(keyword, pageable);
        }
        return searchEmp;
    }

}
