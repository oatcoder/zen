package zen;

public enum StatusResponseEnum {
    SUCCESS("Success"), ERROR("Error");

    final private String status;

    StatusResponseEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}