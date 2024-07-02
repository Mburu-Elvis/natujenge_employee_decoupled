package employee.com.app.web.rest;

import employee.com.app.service.MessageService;
import employee.com.app.service.dto.MessageRequestDTO;
import employee.com.app.service.dto.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
