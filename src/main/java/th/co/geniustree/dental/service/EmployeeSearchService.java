/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import th.co.geniustree.dental.model.Employee;
import th.co.geniustree.dental.repo.EmployeeRepo;
import th.co.geniustree.dental.spec.EmployeeSpec;

/**
 *
 * @author best
 */
@Service
public class EmployeeSearchService {
    
    @Autowired
    private EmployeeRepo employeeRepo;
   
    public Page<Employee> searchByName(String keyword,Pageable pageable){
    Specifications<Employee> specification =  Specifications.where(EmployeeSpec.nameLike("%"+keyword+"%"));
    return employeeRepo.findAll(specification, pageable);
    }
    
    public Page<Employee> searchByEmail(String keyword , Pageable pageable){
    Specifications<Employee> specification = Specifications.where(EmployeeSpec.emailLike("%"+keyword+"%"));
    return employeeRepo.findAll(specification, pageable);
    }
    
    public Page<Employee> searchByMobile(String keyword , Pageable pageable){
    Specifications<Employee> specification = Specifications.where(EmployeeSpec.mobileLike("%"+keyword+"%"));
    return employeeRepo.findAll(specification, pageable);
    }
    
    public Page<Employee> searchByEmailAndPassword(String email , String password , Pageable pageable){
    Specifications<Employee> specification = Specifications.where(EmployeeSpec.emailAndPasswordLike(email, password));
    return employeeRepo.findAll(specification, pageable);
    }
}
