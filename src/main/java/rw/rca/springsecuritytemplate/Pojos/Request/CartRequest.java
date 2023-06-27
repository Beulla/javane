package rw.rca.springsecuritytemplate.Pojos.Request;

public class CartRequest {
    private Long userId;
    private Long productId;
    private int quantity;

    public CartRequest(Long userId) {
        this.userId = userId;
    }

    public CartRequest(Long userId, Long productId, int quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    // Constructors, getters, and setters
}

