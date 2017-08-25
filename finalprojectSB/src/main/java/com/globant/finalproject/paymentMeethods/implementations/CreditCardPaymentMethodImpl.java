package com.globant.finalproject.paymentMeethods.implementations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.globant.finalproject.model.*;
import com.globant.finalproject.repositories.*;
import com.globant.finalproject.paymentMeethods.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.util.List;

@Component
public class CreditCardPaymentMethodImpl implements PaymentMethodService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PStockRepository pStockRepository;

    // Fields
    private static final double DISCOUNT = 0.1;


    @Override
    public Payment payCart(String paymentMethod, Long cartId, double amount) {

        Cart cart = cartRepository.findOne(cartId);
        List<Shop> shops = shopRepository.findByCartId(cartId);
        double total = cart.getTotal();
        double discount = 0;
        discount = calculateDiscount(cart);
        amount = total - discount;

        DecimalFormat df = new DecimalFormat("00.00");
        // Execute payment
        cart.setCartPaid(true);
        Payment payment = new Payment(cart,paymentMethod,amount);
        paymentRepository.save(payment);
        cartRepository.save(cart);
        // Updating final stock.
        for (Shop shop: shops) {
            Product product = productRepository.findProductsByShopId(shop.getId());
            int stock = (product.getStock().getStockQuantity() - shop.getShopQuantity());
                PStock pStock = pStockRepository.findPStockByProductId(product.getId());
                pStock.setStockQuantity(stock);
                pStockRepository.save(pStock);
        }
        return payment;
    }

    @Override
    public double calculateDiscount(Cart cart) {
        return cart.getTotal() * DISCOUNT;
    }
}
