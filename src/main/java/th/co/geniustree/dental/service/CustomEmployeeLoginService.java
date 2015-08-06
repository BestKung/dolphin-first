/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import th.co.geniustree.dental.model.Employee;
import th.co.geniustree.dental.repo.EmployeeRepo;

/**
 *
 * @author best
 */
@Service
public class CustomEmployeeLoginService  implements UserDetailsService{

    @Autowired
    private EmployeeRepo employeeRepo;
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        
        Employee employee = employeeRepo.findByEmail(string);
        
        return employee;
        
    }
    
}
