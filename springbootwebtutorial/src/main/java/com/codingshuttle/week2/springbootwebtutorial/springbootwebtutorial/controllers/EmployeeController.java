package com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.controllers;

import com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
  /*  @GetMapping(path = "/getsecretmessage")
    public String getMySecretMessage(){
        return "Secret Message:@1!!!32#$5%4";
    }*/

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id){
        return new EmployeeDTO(id,"John","john@gmail.com",25, LocalDate.of(2024,7,11),true);
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false,name = "inputAge") Integer age,
                                  @RequestParam(required = false, name= "sortBy") String sortingBy){
        return "Hi age "+age+" "+sortingBy;
    }

  /*  @PostMapping
    public String createNewEmployee(){
        return "Hi from Post";
    }*/
  @PostMapping
  public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
      inputEmployee.setId(100L);
      return inputEmployee;
  }


    @PutMapping
    public String updateEmployeeById(){
        return "Hi from Put";
    }
}
