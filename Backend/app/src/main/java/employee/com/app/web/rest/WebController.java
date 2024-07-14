package employee.com.app.web.rest;

import employee.com.app.domain.Employee;
import employee.com.app.service.EmployeeService;
import employee.com.app.service.dto.EmployeeRequestDTO;
import employee.com.app.service.dto.EmployeeResponseDTO;
import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping(path = "/employees/{employeeId}")
    public EmployeeResponseDTO getEmployee(@PathVariable Integer employeeId) {
        System.out.println("Received Id: " + employeeId);

        return employeeService.getEmployee(employeeId);
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

    @DeleteMapping(path="/employees/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeId) {
        System.out.println("Deleting employee with id: " +  employeeId);
        String res = employeeService.deleteEmployee(employeeId);
        Map<String, Object> response = new HashMap<>();
        response.put("message", res);
        response.put("code", "200");
        return ResponseEntity.ok(response);
    }

    @GetMapping(path="/employees/pagination")
    public ResponseEntity<Page<Employee>> getEmployees(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "2") int pageSize) {
        Page<Employee> employees = employeeService.getEmployees(pageNo, pageSize);
        return  ResponseEntity.ok(employees);
    }
}
