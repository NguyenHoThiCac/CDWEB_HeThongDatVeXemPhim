package com.example.repositories;

import com.example.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "SELECT c FROM Cart c WHERE c.user.username=:username")
    Cart getCartByUsername(@Param("username") String username);

    @Query("SELECT SUM(ci.count) FROM CartItem ci WHERE ci.cart.id = :cartId")
    int sumCountByCartId(@Param("cartId") int cartId);

    @Query(value = "SELECT c FROM Cart c WHERE c.user.username=:username")
    Cart findByUsername(@Param("username") String username);
}

