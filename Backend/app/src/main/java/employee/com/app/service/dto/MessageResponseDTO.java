package employee.com.app.service.dto;

public class MessageResponseDTO {
    private String messageDelivery;
    private  String status;
    private  String msgId;
    private  String desc;
    private  String statusCode;

    public String getMessageDelivery() {
        return messageDelivery;
    }

    public void setMessageDelivery(String messageDelivery) {
        this.messageDelivery = messageDelivery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "MessageResponseDTO{" +
                "messageDelivery='" + messageDelivery + '\'' +
                ", status='" + status + '\'' +
                ", msgId='" + msgId + '\'' +
                ", desc='" + desc + '\'' +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}