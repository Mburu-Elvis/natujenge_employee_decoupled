package employee.com.app.web.rest;

import employee.com.app.domain.Messages;
import employee.com.app.service.MessageService;
import employee.com.app.service.dto.MessageRequestDTO;
import employee.com.app.service.dto.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    @Autowired
    MessageService messageService = new MessageService();

    @PostMapping("/messages")
    public MessageResponseDTO sendMessage(@RequestBody MessageRequestDTO messageRequestDTO) {
        System.out.println("Received: "+ messageRequestDTO);
        return messageService.queryApi(messageRequestDTO);
    }

    @GetMapping("/messages")
    public ResponseEntity<Iterable<Messages>> getMessages() {
        Iterable messages = messageService.getMessages();

        return ResponseEntity.ok(messages);
    }
}
