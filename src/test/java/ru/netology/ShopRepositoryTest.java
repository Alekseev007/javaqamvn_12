package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {
    Product product = new Product(1, "молоко", 30);
    Product product1 = new Product(2, "масло", 180);
    Product product2 = new Product(3, "хлеб", 50);


    @Test
    public void findByIdTest() {
        ShopRepository shopRepository = new ShopRepository();

        shopRepository.add(product);
        shopRepository.add(product1);
        shopRepository.add(product2);

        shopRepository.remove(1);


        Product[] expected = {product1, product2};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByIdTest2() {
        ShopRepository shopRepository = new ShopRepository();

        shopRepository.add(product);
        shopRepository.add(product1);
        shopRepository.add(product2);


        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(5);
        });

    }

}