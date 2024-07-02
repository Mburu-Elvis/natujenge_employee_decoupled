package employee.com.app.web.rest;

import employee.com.app.domain.Employee;
import employee.com.app.service.EmployeeService;
import employee.com.app.service.dto.EmployeeRequestDTO;
import employee.com.app.service.dto.EmployeeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://127.0.0.1/8081")
public class WebController {
    @Autowired
    EmployeeService employeeService = new EmployeeService();

    @PostMapping(path="/employees")
    public EmployeeResponseDTO createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        System.out.println("Received: " + employeeRequestDTO);
        return employeeService.createEmployee(employeeRequestDTO);
    }

    @GetMapping(path="/employees")
    public ResponseEntity<Iterable<Employee>> getAllEmployees() {
        Iterable<Employee> employees = employeeService.getAllEmployees();

        return ResponseEntity.ok(employees);
    }

    @PutMapping(path="/employees")
    public EmployeeResponseDTO updateEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        System.out.println("Received Update DTO: " + employeeRequestDTO);
        return employeeService.updateEmployee(employeeRequestDTO);
    }

    @DeleteMapping(path="/employees")
    public EmployeeRequestDTO deleteEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        System.out.println("Deleting employee with email: " + employeeRequestDTO.getEmail());
        employeeService.deleteEmployee(employeeRequestDTO);
        return employeeRequestDTO;
    }
}
