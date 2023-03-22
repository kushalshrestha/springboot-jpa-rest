package id_authentication.domain;

public enum TransactionType {
    ALLOWED("Allowed"),DECLINED("Declined");
    private String value;

    private TransactionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
