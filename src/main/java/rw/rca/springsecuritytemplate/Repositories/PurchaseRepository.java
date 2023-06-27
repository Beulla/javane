package rw.rca.springsecuritytemplate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.rca.springsecuritytemplate.Models.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    // Add any custom query methods if needed
}
