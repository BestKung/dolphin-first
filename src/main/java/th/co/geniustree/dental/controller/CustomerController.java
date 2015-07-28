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
import th.co.geniustree.dental.model.Customer;
import th.co.geniustree.dental.model.MedicalHistory;
import th.co.geniustree.dental.repo.CustomerRepo;
import th.co.geniustree.dental.repo.MedicalHistoryRepo;



/**
 *
 * @author Jasin007
 */
@RestController
public class CustomerController {
  
    @Autowired
    private CustomerRepo customerRepo;
    
    @Autowired
    private MedicalHistoryRepo medicalHistoryRepo;
    
    @RequestMapping(value = "/customer")
    public Page<Customer> getCustomer(Pageable pageable){
        return customerRepo.findAll(pageable);
    }
    
    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public void saveCustomer(@Validated @RequestBody Customer customer){
        customerRepo.save(customer);
    }
    
    @RequestMapping(value = "/customerdelete", method = RequestMethod.POST)
    public void deleteCutomer(@RequestBody Customer customer){
        customerRepo.delete(customer.getId());
    }
    
    @RequestMapping(value = "/medicalhistory")
    public Page<MedicalHistory> getMedicalHistory(Pageable pageable){
        return  medicalHistoryRepo.findAll(pageable);
    }
}
