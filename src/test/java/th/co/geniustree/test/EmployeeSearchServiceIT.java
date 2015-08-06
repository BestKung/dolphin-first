/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.test;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.co.geniustree.dental.App;
import th.co.geniustree.dental.model.Employee;
import th.co.geniustree.dental.repo.EmployeeRepo;
import th.co.geniustree.dental.service.EmployeeSearchService;

/**
 *
 * @author best
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeSearchServiceIT {

    @Autowired
    private EmployeeSearchService employeeSearchService;
    @Autowired
    private EmployeeRepo employeeRepo;

    private Employee employee;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;
    private Employee employee4;

    @Before
    public void setup() {
        employee = new Employee();
        employee.setEmail("b@b");
        employee.setPassword("xxx");
        employee.setCurrentAddress("aaaaaa");
        employee.setNameTh("xxxxx");
        employee.setMobile("xxxxxx");
        employeeRepo.saveAndFlush(employee);
        
        employee1 = new Employee();
        employee1.setEmail("a@a");
        employee1.setPassword("aaa");
        employee1.setCurrentAddress("xxxx");
        employee1.setNameTh("aaa");
        employee1.setMobile("aaa");
        employeeRepo.saveAndFlush(employee1);
       
        employee2 = new Employee();
        employee2.setEmail("c@c");
        employee2.setPassword("bb");
        employee2.setCurrentAddress("bbbb");
        employee2.setNameTh("bbb");
        employee2.setMobile("bbbb");
        employeeRepo.saveAndFlush(employee2);
       
        employee3 = new Employee();
        employee3.setEmail("d@d");
        employee3.setPassword("ddd");
        employee3.setCurrentAddress("dddd");
        employee3.setNameTh("dddd");
        employee3.setMobile("dddd");
        employeeRepo.saveAndFlush(employee3);
        
        employee4 = new Employee();
        employee4.setEmail("e@e");
        employee4.setPassword("eee");
        employee4.setCurrentAddress("eeeee");
        employee4.setNameTh("eeeeee");
        employee4.setMobile("eeeeeee");
        employeeRepo.saveAndFlush(employee4);
    }

    @Test
    public void findEmailShouldReturnOneRow() {
        Page<Employee> searchemp = employeeSearchService.searchByEmail("b", new PageRequest(0, 10));
        System.out.println("---------------------------------------------------------------------->" + searchemp);
        Assertions.assertThat(searchemp.getTotalElements()).isEqualTo(1);
    }
    
     @Test
    public void findNameShouldReturnOneRow() {
        Page<Employee> searchemp = employeeSearchService.searchByName("d", new PageRequest(0, 10));
        System.out.println("---------------------------------------------------------------------->" + searchemp);
        Assertions.assertThat(searchemp.getTotalElements()).isEqualTo(1);
    }
    
     @Test
    public void findMobileShouldReturnOneRow() {
        Page<Employee> searchemp = employeeSearchService.searchByMobile("e", new PageRequest(0, 10));
        System.out.println("---------------------------------------------------------------------->" + searchemp);
        Assertions.assertThat(searchemp.getTotalElements()).isEqualTo(1);
    }
}
