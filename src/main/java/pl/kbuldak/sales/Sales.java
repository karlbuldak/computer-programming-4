package pl.kbuldak.sales;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Optional;

public class Sales {
    private static CartStorage cartStorage;
    private static ProductDetailsProvider productDetailsProvider;

    public static void addToCart(String customerId, String productId) {
        Cart customerCart = loadCartForCustomer(customerId)
                .orElse(Cart.empty());

        ProductDetails product = loadProductDetails(productId)
                .orElseThrow(() -> new NoSuchProductException());

        customerCart.add(product);
    }

    private static Optional<ProductDetails> loadProductDetails(String productId) {
        return productDetailsProvider.load(productId);
    }

    private static Optional<Cart> loadCartForCustomer(String customerId) {
        return cartStorage.load(customerId);
    }
}
