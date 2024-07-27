package employee.com.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import employee.com.app.domain.Messages;
import employee.com.app.repository.MessageRepository;
import employee.com.app.service.dto.MessageRequestDTO;
import employee.com.app.service.dto.MessageResponseDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpHeaders;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Transactional
    public MessageResponseDTO queryApi(MessageRequestDTO messageRequestDTO) {
        String phoneNumber = messageRequestDTO.getNumber();
        String message = messageRequestDTO.getMessage();
        String url = "https://api2.tiaraconnect.io/api/messaging/sendsms";

        WebClient webClient = WebClient.create(url);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("to", phoneNumber);
        requestBody.put("from", "TIARACONECT");
        requestBody.put("message", message);
        requestBody.put("refId", "09wiwu088e");

        // Perform the POST request and handle the response
        MessageResponseDTO messageResponseDTO = webClient.post()
                .headers(httpHeaders -> httpHeaders.addAll(headers))
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(res -> {
                    // Process the response and return a MessageResponseDTO
                    MessageResponseDTO responseDTO = new MessageResponseDTO();
                    ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        JsonNode jsonNode = objectMapper.readTree(res);
                        responseDTO.setStatus(jsonNode.get("status").asText());
                        responseDTO.setMsgId(jsonNode.get("msgId").asText());
                        responseDTO.setDesc(jsonNode.get("desc").asText());
                        responseDTO.setStatusCode(jsonNode.get("statusCode").asText());
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return Mono.just(responseDTO);
                })
                .block(); // Block to wait for the response

        Messages msg = new Messages();
        msg.setMessageTo(messageRequestDTO.getNumber());
        msg.setMessageBody(messageRequestDTO.getMessage());
        msg.setMessageFrom("TIARACONECT");
        msg.setDeliveryStatus(messageResponseDTO.getStatus());

        Messages savedMsg = messageRepository.save(msg);

        System.out.println(messageResponseDTO.toString());

        return messageResponseDTO;
    }

    public Iterable<Messages> getMessages() {
        return messageRepository.findAll();
    }



}