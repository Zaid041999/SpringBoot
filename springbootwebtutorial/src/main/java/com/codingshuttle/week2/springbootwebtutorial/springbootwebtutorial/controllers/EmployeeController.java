package com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.controllers;

import com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
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

   /* //We should service layer in between we directly don't use repository in controller
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }*/
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /*@GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long id){
        return employeeRepository.findById(id).orElse(null);
    }//here repository returning the Entity but when we use service layer the we will use dto(For which we have to map the data)
    // a proper mvc format*/


    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false,name = "inputAge") Integer age,
                                                @RequestParam(required = false) String sortingBy){
        return employeeService.getAllEmployees();
    }

  /*  @PostMapping
    public String createNewEmployee(){
        return "Hi from Post";
    }*/
  @PostMapping
  public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){

      return employeeService.createNewEmployee(inputEmployee);
  }


    @PutMapping
    public String updateEmployeeById(){

      return "Hi from Put";
    }
}
