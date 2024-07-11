package com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.controllers;

import com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
  /*  @GetMapping(path = "/getsecretmessage")
    public String getMySecretMessage(){
        return "Secret Message:@1!!!32#$5%4";
    }*/

    //We should service layer in between we directly don't use repository in controller
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false,name = "inputAge") Integer age,
                                                @RequestParam(required = false) String sortingBy){
        return employeeRepository.findAll();
    }

  /*  @PostMapping
    public String createNewEmployee(){
        return "Hi from Post";
    }*/
  @PostMapping
  public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){

      return employeeRepository.save(inputEmployee);
  }


    @PutMapping
    public String updateEmployeeById(){
        return "Hi from Put";
    }
}
