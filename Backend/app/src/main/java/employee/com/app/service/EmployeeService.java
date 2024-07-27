package employee.com.app.service;

import employee.com.app.domain.Employee;
import employee.com.app.repository.EmployeeRepository;
import employee.com.app.service.dto.EmployeeRequestDTO;
import employee.com.app.service.dto.EmployeeResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee emp = employeeRepository.findByEmail(employeeRequestDTO.getEmail());

        if (emp != null ) {
            throw new RuntimeException();
        }

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

    public EmployeeResponseDTO getEmployee(Integer employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (!employee.isPresent()) {
            System.out.println("The Employee does not Exist");
            throw new RuntimeException();
        }

        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();

        Employee emp = employee.get();
        responseDTO.setId(emp.getId());
        responseDTO.setName(emp.getName());
        responseDTO.setEmail(emp.getEmail());
        responseDTO.setPhoneNumber(emp.getPhoneNumber());
        responseDTO.setPassword(emp.getPassword());
        return responseDTO;
    }

    public Iterable<Employee> getAllEmployees() {
        Iterable<Employee> all = employeeRepository.findAll();
        return all;
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
        responseDTO.setId(savedEmployee.getId());
        responseDTO.setName(savedEmployee.getName());
        responseDTO.setPhoneNumber(savedEmployee.getPhoneNumber());
        responseDTO.setEmail(savedEmployee.getEmail());
        responseDTO.setPassword(savedEmployee.getPassword());

        return responseDTO;
    }

    public String deleteEmployee(Integer employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }

        Employee emp = employee.get();

        employeeRepository.delete(emp);

        return "Employee with id : " + employeeId.toString() + " deleted";
    }

    public Page<Employee> getEmployees(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return employeeRepository.findAll(pageable);
    }
}
