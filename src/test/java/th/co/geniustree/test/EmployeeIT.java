/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.co.geniustree.dental.App;
import th.co.geniustree.dental.model.Bank;
import th.co.geniustree.dental.model.Contact;
import th.co.geniustree.dental.model.Department;
import th.co.geniustree.dental.model.Employee;
import th.co.geniustree.dental.model.Authority;
import th.co.geniustree.dental.repo.BankRepo;
import th.co.geniustree.dental.repo.ContactRepo;
import th.co.geniustree.dental.repo.DepartmentRepo;
import th.co.geniustree.dental.repo.EmployeeRepo;
import th.co.geniustree.dental.repo.AuthorityRepo;

/**
 *
 * @author Best
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeIT {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private BankRepo bankRepo;
    @Autowired
    private ContactRepo contactRepo;
    @Autowired
    private AuthorityRepo roleRepo;

    private Employee employee;
    private Contact contact;
    private Bank bank;
    private Department department;
    private Authority role1;
    private Authority role2;
    private Authority role3;

    @Before
    public void insertEmployee() {
        department = new Department();
        department.setName("Programmer");
        departmentRepo.save(department);

        contact = new Contact();
        contact.setName("a");
        contact.setRelation("mom");
        contact.setTel("12345");
        contactRepo.save(contact);

        bank = new Bank();
        bank.setBankName("SCB");
        bank.setAccountName("Best");
        bank.setAccountNumber("12345678909999");
        bankRepo.save(bank);

        role1 = new Authority();
        role2 = new Authority();
        role3 = new Authority();
        role1.setRole("Insert");
        role2.setRole("Update");
        role3.setRole("Delete");
        roleRepo.saveAndFlush(role1);
        roleRepo.saveAndFlush(role2);
        roleRepo.saveAndFlush(role3);

        employee = new Employee();
        employee.setEmail("best@best.com");
        employee.setPassword("123456");
        employee.setPid("7565435579");
        employee.setNameTh("jhghft");
        employee.setBlood("AB");
        employee.setNation("THAI");
        employee.setRace("THAI");
        employee.setCurrentAddress("Thai");
        employee.setMobile("877534267");
        employee.setStartWork(new Date(1993, 9, 16));
        employee.setWorkStatus("nomal");

        employee.setDepartment(department);
        employee.setContact(contact);
        employee.setBank(bank);
        employee.setRoles(selectRole());

        employeeRepo.saveAndFlush(employee);
    }

    @Test
    public void findEmployeeShoudReturnOne() {
        List<Employee> findAll = employeeRepo.findAll();
        Assertions.assertThat(findAll.size()).isEqualTo(1);
    }

    public List<Authority> selectRole() {
        List<Authority> roles = roleRepo.findAll();
        List<Authority> roleManaged = new ArrayList<Authority>();
        for (int i = 0; i < roles.size(); i++) {
            roleManaged.add(roles.get(i));
        }
        return roleManaged;
    }

}
