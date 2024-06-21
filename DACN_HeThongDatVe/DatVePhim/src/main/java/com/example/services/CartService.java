package com.example.services;

import com.example.models.Cart;
import com.example.models.CartItem;
import com.example.models.Food;
import com.example.repositories.CartRepository;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartService {
    private final CartRepository cartRepository;

    private final UserRepository userRepository;

    @Autowired
    public CartService(CartRepository cartRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public void addToCart(Food food, String username) {
        // Lấy thông tin user từ username
        Cart cart = cartRepository.getCartByUsername(username);

        // Kiểm tra xem user có giỏ hàng chưa
        if (cart == null) {
            // Nếu user chưa có giỏ hàng, tạo mới một giỏ hàng
            cart = new Cart();
            cart.setUser(userRepository.findByUsername(username));
        }

        // Kiểm tra xem food đã tồn tại trong cart hay chưa
        CartItem existingCartItem = null;
        for (CartItem cartItem : cart.getCartItems()) {
            if (cartItem.getFood().equals(food)) {
                existingCartItem = cartItem;
                break;
            }
        }

        if (existingCartItem != null) {
            // Nếu food đã tồn tại trong cart, tăng count lên 1
            int newCount = existingCartItem.getCount() + 1;
            existingCartItem.setCount(newCount);
        } else {
            // Nếu food chưa tồn tại trong cart, tạo cart item mới
            CartItem cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setFood(food);
            cartItem.setCount(1); // Số lượng ban đầu là 1

            // Thêm cart item vào giỏ hàng
            cart.getCartItems().add(cartItem);
        }

        // Cập nhật giỏ hàng trong cơ sở dữ liệu
        cartRepository.save(cart);
    }


    public void removeFromCart(Food food, String username) {
        // Lấy thông tin user từ username
        Cart cart = cartRepository.getCartByUsername(username);

        // Kiểm tra xem user có giỏ hàng chưa
        if (cart == null) {
            // Nếu user chưa có giỏ hàng, tạo mới một giỏ hàng
            cart = new Cart();
            cart.setUser(userRepository.findByUsername(username));
        }

        // Kiểm tra xem food đã tồn tại trong cart hay chưa
        CartItem existingCartItem = null;
        for (CartItem cartItem : cart.getCartItems()) {
            if (cartItem.getFood().equals(food)) {
                existingCartItem = cartItem;
                break;
            }
        }

        if (existingCartItem != null) {
            // Nếu food đã tồn tại trong cart, giảm count xuống 1
            int newCount = existingCartItem.getCount() - 1;
            existingCartItem.setCount(newCount);

            if (existingCartItem.getCount() == 0) {
                // Xóa cart item khỏi giỏ hàng nếu số lượng bằng 0
                cart.getCartItems().remove(existingCartItem);
            }
        }

        // Cập nhật giỏ hàng trong cơ sở dữ liệu
        cartRepository.save(cart);
    }

    public int countItemsByCartId(int cartId) {
        return cartRepository.sumCountByCartId(cartId);
    }
    public Cart getCartByUsername(String username) {
        return cartRepository.findByUsername(username);
    }
    public Cart getCartById(Integer cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

}
