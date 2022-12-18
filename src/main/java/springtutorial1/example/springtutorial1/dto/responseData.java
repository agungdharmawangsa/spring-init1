package springtutorial1.example.springtutorial1.dto;

import java.util.ArrayList;

public class responseData<T> {

    private boolean status;

    private ArrayList<String> error_messages = new ArrayList<String>();

    private T payload;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<String> getError_messages() {
        return error_messages;
    }

    public void setMessages(ArrayList<String> error_messages) {
        this.error_messages = error_messages;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
