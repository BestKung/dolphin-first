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

    @Before
    public void setup() {
        employee = new Employee();
        employee.setEmail("b@b");
        employee.setPassword("xxx");
        employee.setCurrentAddress("aaaaaa");
        employee.setNameTh("xxxxx");
        employee.setMobile("xxxxxx");
        employeeRepo.saveAndFlush(employee);
    }

    @Test
    public void findEmailShouldReturnOneRow() {
        Page<Employee> searchemp = employeeSearchService.searchByEmail("b", new PageRequest(0, 10));
        System.out.println("---------------------------------------------------------------------->" + searchemp);
        Assertions.assertThat(searchemp.getTotalElements()).isEqualTo(1);
    }
}
