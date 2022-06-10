package ru.netology.repository.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    Product book1 = new Book( 1, "Война и мир", 300, "Толстой");
    Product phone1 = new Smartphone(2, "s65", 15000, "Siemens" );
    Product phone2 = new Smartphone(3, "c75", 17500, "Siemens");
    Product phone3 = new Smartphone (4, "x10", 33400, "Nokia");
    Product book2 = new Book(5, "Вий", 450, "Гоголь");
    Product book3 = new Book(6, "Дюна", 740, "Френк Герберт");

    @Test
    public void addProduct() {
        ProductRepository repo = new ProductRepository();
        repo.add(book1);
        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone3);
        repo.add(book2);
        repo.add(book3);
        repo.findAll();

        Product[] actual = repo.findAll();
        Product[] expected = { book1, phone1, phone2, phone3, book2, book3 };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        ProductRepository repo = new ProductRepository();
        repo.add(book1);
        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone3);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(2);
        repo.findAll();

        Product[] actual = repo.findAll();
        Product[] expected = { book1, phone2, phone3, book2, book3 };
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllEmptyRepository() {
        ProductRepository repo = new ProductRepository();
        repo.findAll();

        Product[] actual = repo.findAll();
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

}
