package rw.rca.springsecuritytemplate.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rw.rca.springsecuritytemplate.Models.Quantity;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, Long> {
    // You can add custom query methods here if needed
}
