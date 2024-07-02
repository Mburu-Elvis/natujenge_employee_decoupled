package employee.com.app.service.dto;

public class MessageRequestDTO {
    private String number;
    private String message;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageRequestDTO{" +
                "number='" + number + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}