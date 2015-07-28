/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.dental.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartRequest;
import th.co.geniustree.dental.model.EmployeeImage;
import th.co.geniustree.dental.repo.EmployeeImageRepo;


/**
 *
 * @author Best
 */
@RestController
public class EmployeeImageController {
    
   @Autowired
   private EmployeeImageRepo uploadFileRepo;
    
   
   
   @RequestMapping(value = "/savefile" , method = RequestMethod.POST)
   @ResponseBody
    public void saveFile(MultipartRequest file) throws IOException{
        EmployeeImage uploadFile = new EmployeeImage();
        uploadFile.setName(file.getFile("file").getOriginalFilename());
        uploadFile.setMimeType(file.getFile("file").getContentType());
        uploadFile.setContent(file.getFile("file").getBytes());
        uploadFileRepo.save(uploadFile);
    }
    
//    @RequestMapping(value = "/getfile/{id}" , method = RequestMethod.GET)
//    public ResponseEntity<InputStreamResource> getFile(@PathVariable("id")UploadFile uploadFile){
//       ResponseEntity<InputStreamResource> body = ResponseEntity.ok()
//               .contentLength(uploadFile.getContent().length)
//               .contentType(MediaType.parseMediaType(uploadFile.getMimeType()))
//               .header("Content-Disposition","attachment; filename=\""+uploadFile.getName()+"\"")
//               .body(new InputStreamResource(new ByteArrayInputStream(uploadFile.getContent())));
//        
//        return body;
//    }
    
    @RequestMapping(value = "/getfile/{id}" , method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getFile(@PathVariable("id")EmployeeImage uploadFile){
       ResponseEntity<InputStreamResource> body = ResponseEntity.ok()
               .contentLength(uploadFile.getContent().length)
               .contentType(MediaType.parseMediaType(uploadFile.getMimeType()))
               .header("Content-Disposition","attachment; filename=\""+uploadFile.getName()+"\"")
               .body(new InputStreamResource(new ByteArrayInputStream(uploadFile.getContent())));
        System.out.println("---------------------------------------------------------------------");
        System.out.println("length : "+ResponseEntity.ok().contentLength(uploadFile.getContent().length));
        System.out.println("Type : "+ResponseEntity.ok().contentType(MediaType.parseMediaType(uploadFile.getMimeType())));
        System.out.println("header : "+ResponseEntity.ok().header("Content-Disposition","attachment; filename=\""+uploadFile.getName()+"\""));
        System.out.println("body : "+ResponseEntity.ok().body(new InputStreamResource(new ByteArrayInputStream(uploadFile.getContent()))));
        System.out.println("---------------------------------------------------------------------");

        return body;
    }
}
