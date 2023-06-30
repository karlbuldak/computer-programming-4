package pl.kbuldak.sales;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesController {
    @GetMapping("/api/offer")
    public Offer getCurrentOffer(){
        return null;
    }

    @PostMapping("/api/add-to-cart{productId}")
    public void addToCart(@PathVariable String productId){
        Sales.addToCart(getCurrentCustomer(), productId);
    }

    private String getCurrentCustomer() {
        return null;
    }
}