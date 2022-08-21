package zen;

import com.google.gson.JsonElement;

public class StandardResponse {
    private StatusResponseEnum status;
    private String message;
    private JsonElement data;

    public StandardResponse(StatusResponseEnum status) {
        this.status = status;
    }

    public StandardResponse(StatusResponseEnum status, String message) {
        this.status = status;
        this.message = message;
    }

    public StandardResponse(StatusResponseEnum status, JsonElement data) {
        this.status = status;
        this.data = data;
    }

    public StatusResponseEnum getStatus() {
        return status;
    }

    public void setStatus(StatusResponseEnum status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }
}