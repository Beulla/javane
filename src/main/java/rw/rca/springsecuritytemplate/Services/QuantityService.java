package rw.rca.springsecuritytemplate.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.rca.springsecuritytemplate.Models.Quantity;
import rw.rca.springsecuritytemplate.Repositories.QuantityRepository;

import java.util.List;

@Service
public class QuantityService {
    private final QuantityRepository quantityRepository;

    @Autowired
    public QuantityService(QuantityRepository quantityRepository) {
        this.quantityRepository = quantityRepository;
    }

    public Quantity saveQuantity(Quantity quantity) {
        return quantityRepository.save(quantity);
    }

    public List<Quantity> getAllQuantities() {
        return quantityRepository.findAll();
    }

    public Quantity getQuantityById(Long id) {
        return quantityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Quantity not found with id: " + id));
    }

    public void deleteQuantity(Long id) {
        quantityRepository.deleteById(id);
    }
}

