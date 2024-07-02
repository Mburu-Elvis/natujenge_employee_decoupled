package employee.com.app.repository;

import employee.com.app.domain.Messages;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Messages, Integer> {
}
