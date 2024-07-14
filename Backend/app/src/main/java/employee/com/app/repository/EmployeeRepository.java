package employee.com.app.repository;

import employee.com.app.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
//    Employee findByEmail(String email);
//}


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmail(String email);
}

