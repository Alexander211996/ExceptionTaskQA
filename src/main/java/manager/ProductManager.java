package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import repository.ProductRepository;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProductManager {

    private ProductRepository repository = new ProductRepository();

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }

    }

    public Product[] getAll() {
        return repository.findAll();
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

}












