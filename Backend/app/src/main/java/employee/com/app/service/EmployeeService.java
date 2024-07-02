package employee.com.app.service;

import employee.com.app.domain.Employee;
import employee.com.app.repository.EmployeeRepository;
import employee.com.app.service.dto.EmployeeRequestDTO;
import employee.com.app.service.dto.EmployeeResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new Employee();
        employee.setName(employeeRequestDTO.getName());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setPhoneNumber(employeeRequestDTO.getPhoneNumber());
        employee.setPassword(employeeRequestDTO.getPassword());

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        responseDTO.setName(savedEmployee.getName());
        responseDTO.setEmail(savedEmployee.getEmail());
        responseDTO.setPhoneNumber(savedEmployee.getPhoneNumber());
        responseDTO.setPassword(savedEmployee.getPassword());

        return responseDTO;
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }


    @Transactional
    public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = employeeRepository.findByEmail(employeeRequestDTO.getEmail());
        if (employee == null) {
            throw new RuntimeException("Employee not found with email: " + employeeRequestDTO.getEmail());
        }
        employee.setName(employeeRequestDTO.getName());
        employee.setPhoneNumber(employeeRequestDTO.getPhoneNumber());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setPassword(employeeRequestDTO.getPassword());

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        responseDTO.setName(savedEmployee.getName());
        responseDTO.setPhoneNumber(savedEmployee.getPhoneNumber());
        responseDTO.setEmail(savedEmployee.getEmail());
        responseDTO.setPassword(savedEmployee.getPassword());

        return responseDTO;
    }

    public void deleteEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = employeeRepository.findByEmail(employeeRequestDTO.getEmail());
        if (employee == null) {
            throw new RuntimeException("Employee not found with email: " + employeeRequestDTO.getEmail());
        }

        employeeRepository.delete(employee);
    }
}
