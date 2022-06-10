package ru.netology.manager.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    Product book1 = new Book(1, "Война и мир", 300, "Толстой");
    Product phone1 = new Smartphone(2, "s65", 15000, "Siemens");
    Product phone2 = new Smartphone(3, "c75", 17500, "Siemens");
    Product phone3 = new Smartphone(4, "x10", 33400, "Nokia");
    Product book2 = new Book(5, "Вий", 450, "Гоголь");
    Product book3 = new Book(6, "Дюна", 740, "Френк Герберт");

    @Test
    public void removeById() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book2);
        manager.add(book3);
        manager.removeById(3);
        manager.findAll();

        Product[] actual = manager.findAll();
        Product[] expected = {book1, phone1, phone3, book2, book3};
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void emptyTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(phone1);
        manager.removeById(2);
        manager.findAll();



        Product[] actual = manager.findAll();
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByAuthorName() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book2);
        manager.add(book3);
        Product[] actual = manager.searchBy("сто");
        Product[] expected = { book1 };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findMatchesByRemove() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book2);
        manager.add(book3);
        manager.removeById(2);

        Product[] actual = manager.searchBy("Si");
        Product[] expected = { phone2 };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByTwoMatches() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book1);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book2);
        manager.add(book3);
        manager.removeById(2);
        manager.findAll();

        Product[] actual = manager.searchBy("В");
        Product[] expected = {book1, book2};
        Assertions.assertArrayEquals(expected, actual);
    }
}
