package rw.rca.springsecuritytemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rw.rca.springsecuritytemplate.Models.Quantity;
import rw.rca.springsecuritytemplate.Services.QuantityService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/quantities")
public class QuantityController {
    private final QuantityService quantityService;

    @Autowired
    public QuantityController(QuantityService quantityService) {
        this.quantityService = quantityService;
    }

    @PostMapping("/add")
    public Quantity addQuantity(@RequestBody Quantity quantity) {
        return quantityService.saveQuantity(quantity);
    }

    @GetMapping
    public List<Quantity> getAllQuantities() {
        return quantityService.getAllQuantities();
    }

    @GetMapping("/{id}")
    public Quantity getQuantityById(@PathVariable Long id) {
        return quantityService.getQuantityById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteQuantity(@PathVariable Long id) {
        quantityService.deleteQuantity(id);
    }
}

