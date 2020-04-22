package clothesRental;

public class PaymentCanceled extends AbstractEvent {

    private Long id;
    private String orderId;
    private String custoemrNm;
    private String address;
    private String productId;
    private Double qty;
    private String productStatus;

    public PaymentCanceled(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public String getCustoemrNm() {
        return custoemrNm;
    }

    public void setCustoemrNm(String custoemrNm) {
        this.custoemrNm = custoemrNm;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }
    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
}
