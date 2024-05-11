package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {
    Product product = new Product(1, "молоко", 30);
    Product product1 = new Product(2, "масло", 180);
    Product product2 = new Product(3, "хлеб", 50);
    Product product3 = new Product(4, "булка", 50);
    Product product4 = new Product(3, "картошка", 50);


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

    @Test
    public void addProduct() {
        ShopRepository shopRepository = new ShopRepository();

        shopRepository.add(product);
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);


        Product[] expected = {product, product1, product2, product3};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addProductWithRepetitiveId() {
        ShopRepository shopRepository = new ShopRepository();

        shopRepository.add(product);
        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);



        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shopRepository.add(product4);
        });
    }

}