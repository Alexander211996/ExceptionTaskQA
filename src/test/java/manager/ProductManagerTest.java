package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductManager manager = new ProductManager();

    private final Book bookFirst = new Book(1, "Сияние", 100, "Кинг");
    private final Book bookSecond = new Book(2, "Война и мир", 1000, "Толстой");
    private final Book bookThird = new Book(3, "Иллиндан", 350, "Голден");
    private final Book bookForth = new Book(4, "Сказки", 3000, "Барто");
    private final Book bookFifth = new Book(5, "Преступление и наказание", 100, "Достоевский");
    private final Book bookSixth = new Book(6, "Война миров", 1000, "Кинг");
    private final Smartphone smartphoneFirst = new Smartphone(7, "P50", 25000, "Huawei");
    private final Smartphone smartphoneSecond = new Smartphone(8, "13pro", 40000, "Apple");
    private final Smartphone smartphoneThird = new Smartphone(9, "P30Pro", 35000, "Huawei");
    private final Smartphone smartphoneForth = new Smartphone(10, "14 pro max", 20000, "Apple");
    private final Smartphone smartphoneFifth = new Smartphone(11, "Mi10", 25000, "Xiaomi");
    private final Smartphone smartphoneSixth = new Smartphone(12, "P5300", 15000, "Oppo");

@BeforeEach
public void setUp() {
manager.add(bookFirst);
manager.add(bookSecond);
manager.add(bookThird);
manager.add(bookForth);
manager.add(bookFifth);
manager.add(bookSixth);
manager.add(smartphoneFirst);
manager.add(smartphoneSecond);
manager.add(smartphoneThird);
manager.add(smartphoneForth);
manager.add(smartphoneFifth);
manager.add(smartphoneSixth);
}

    @Test
    void shouldSearchByBookName() {
        Product[] expected = new Product[]{bookFirst};
        Product[] actual = manager.searchBy("Сияние");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookAuthor() {
        Product[] expected = new Product[]{bookFirst, bookSixth};
        Product[] actual = manager.searchBy("Кинг");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNameForPhone() {
        Product[] expected = new Product[]{smartphoneFirst};
        Product[] actual = manager.searchBy("P50");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByProducerForPhone() {
        Product[] expected = new Product[]{smartphoneFirst, smartphoneThird};
        Product[] actual = manager.searchBy("Huawei");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldReturnNull() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Самсунг");
        assertArrayEquals(expected, actual);
    }
}