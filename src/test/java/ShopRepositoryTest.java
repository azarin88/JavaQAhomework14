import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "Вещь 1", 100);
    Product product2 = new Product(2, "Вещь 2", 200);
    Product product3 = new Product(3, "Вещь 3", 300);
    Product product4 = new Product(4, "Вещь 4", 400);
    Product product5 = new Product(5, "Вещь 5", 500);
    Product product6 = new Product(6, "Вещь 6", 600);
    Product product7 = new Product(7, "Вещь 7", 700);
    ShopRepository repository = new ShopRepository();

    @BeforeEach
    void setUp() {
        repository.add(product1);
        repository.add(product2);
        repository.add(product3);
        repository.add(product4);
        repository.add(product5);
        repository.add(product6);
    }

    @Test
    void shouldAddProduct() {
        repository.add(product7);
        Product[]expected = new Product[]{product1, product2, product3, product4, product5, product6, product7};
        Product[]actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddProductDouble() {
        repository.add(product7);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.add(product7);
        });
    }

    @Test
    void shouldRemove() {
        repository.remove(6);
        Product[]expected = new Product[]{product1, product2, product3, product4, product5};
        Product[]actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveDouble() {
        repository.remove(6);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.remove(6);
        });
    }

}
