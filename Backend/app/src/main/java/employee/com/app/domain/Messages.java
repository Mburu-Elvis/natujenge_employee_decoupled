package employee.com.app.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_message")
public class Messages {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;

    private String messageTo;
    private String messageFrom;
    private String messageBody;
    private String deliveryStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageTo() {
        return messageTo;
    }

    public void setMessageTo(String messageTo) {
        this.messageTo = messageTo;
    }

    public String getMessageFrom() {
        return messageFrom;
    }

    public void setMessageFrom(String messageFrom) {
        this.messageFrom = messageFrom;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "id=" + id +
                ", messageTo='" + messageTo + '\'' +
                ", messageFrom='" + messageFrom + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                '}';
    }
}
