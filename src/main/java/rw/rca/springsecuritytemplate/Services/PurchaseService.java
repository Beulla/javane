package rw.rca.springsecuritytemplate.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.rca.springsecuritytemplate.Models.Product;
import rw.rca.springsecuritytemplate.Models.Purchase;
import rw.rca.springsecuritytemplate.Models.User;
import rw.rca.springsecuritytemplate.Repositories.PurchaseRepository;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    // Implement methods for handling purchase-related operations
    public Purchase createPurchase(User user, Product product, int quantity) {
        Purchase purchase = new Purchase();
        purchase.setUser(user);
        purchase.setProduct(product);
        purchase.setQuantity(quantity);

        // Perform any additional logic or validation if needed

        return purchaseRepository.save(purchase);
    }

    // Add more methods as per your requirements
}

