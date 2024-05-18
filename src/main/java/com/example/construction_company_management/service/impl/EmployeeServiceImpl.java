package com.example.construction_company_management.service.impl;

import com.example.construction_company_management.dto.EmployeeAfterCreationDto;
import com.example.construction_company_management.dto.EmployeeAfterUpdateDto;
import com.example.construction_company_management.dto.EmployeeCreateDto;
import com.example.construction_company_management.dto.EmployeeUpdateDto;
import com.example.construction_company_management.entity.Department;
import com.example.construction_company_management.entity.Employee;
import com.example.construction_company_management.entity.Role;
import com.example.construction_company_management.entity.User;
import com.example.construction_company_management.exсeption.*;
import com.example.construction_company_management.mapper.EmployeeMapper;
import com.example.construction_company_management.repository.DepartmentRepository;
import com.example.construction_company_management.repository.EmployeeRepository;
import com.example.construction_company_management.repository.RoleRepository;
import com.example.construction_company_management.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentRepository departmentRepository;
    private final RoleRepository roleRepository;





    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public Employee getEmployeeById(UUID id) {
        Employee employee = employeeRepository.getEmployeeById(id);
        if (employee == null) {
            throw new EmployeeIsNotFound(ErrorMessage.EMPLOYEE_NOT_EXIST);

        }
        return employee;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteEmployeeById(UUID id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeIsNotFound(ErrorMessage.EMPLOYEE_IS_NOT_FOUND);
        }
        employeeRepository.deleteById(id);
    }


    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public EmployeeAfterUpdateDto updateEmployee(UUID id, EmployeeUpdateDto employeeUpdateDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            throw new EmployeeIsNotFound(ErrorMessage.EMPLOYEE_IS_NOT_FOUND);
        }

        Employee employee = optionalEmployee.get();


        employeeMapper.toUpdate(employeeUpdateDto, employee);

        String newRoleName = employeeUpdateDto.getRoleName();

        if (newRoleName != null && !newRoleName.equals(employee.getRole().getRoleName())) {
            Role role = roleRepository.findByRoleName(newRoleName);
            if (role == null) {
                role = new Role();
                role.setRoleName(newRoleName);
                role = roleRepository.save(role);
            }
            employee.setRole(role);
        }

        Employee updatedEmployee = employeeRepository.save(employee);

        return employeeMapper.afterUpdateDto(updatedEmployee);
    }


    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public EmployeeAfterCreationDto createEmployee(EmployeeCreateDto employeeCreationDto) {

        Role role = roleRepository.findByRoleName(employeeCreationDto.getRoleName());
        if (role == null) {
            role = new Role();
            role.setRoleName(employeeCreationDto.getRoleName());
            role = roleRepository.save(role);
        }

        String depName = employeeCreationDto.getDepName();
        Department department = departmentRepository.findByDepName(depName);
        if (department == null) {
            throw new DepartmentNotFoundException(ErrorMessage.DEPARTMENT_IS_NOT_FOUND);
        }

        Employee entity = employeeMapper.toEntity(employeeCreationDto);


        entity.setDepartment(department);
        entity.setRole(role);

        Employee employeeAfterCreation = employeeRepository.save(entity);
        return employeeMapper.toDto(employeeAfterCreation);
    }
}
