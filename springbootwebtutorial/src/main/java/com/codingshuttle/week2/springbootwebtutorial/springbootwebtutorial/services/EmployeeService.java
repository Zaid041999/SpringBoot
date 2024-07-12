package com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.services;

import com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.week2.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id){
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        //Mapping/converting Entity to DTO
        return modelMapper.map(employeeEntity,EmployeeDTO.class);

    }

    public List<EmployeeDTO> getAllEmployees(){
       List<EmployeeEntity> employeeEntities =employeeRepository.findAll();
        //Mapping/converting list of Entity to list of DTO
       return employeeEntities
               .stream()
               .map(employeeEntity->modelMapper.map(employeeEntity,EmployeeDTO.class))
               .collect(Collectors.toList());

    }
    public EmployeeDTO createNewEmployee( EmployeeDTO inputEmployee){

        //to convert(mapping) the inputEmployee to EmployeeEntity
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee,EmployeeEntity.class);
        //Saved Entity
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        //Mapping/converting Entity to DTO
        return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
    }

}
