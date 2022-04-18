package gnut.service;

import gnut.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{

    private static final Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"iPhone13 Pro",30000,"New",20));
        products.put(2,new Product(2,"iPhone13 Pro Max",35000,"New",20));
        products.put(3,new Product(3,"iPhone12 Pro",25000,"New",35));
        products.put(4,new Product(4,"iPhone12 Pro Max",28000,"New",12));
        products.put(5,new Product(5,"SamSung S21 Ultra 5G",21000,"Like New",3));
        products.put(6,new Product(6,"Galaxy Tab S8",16,"99%",4));
        products.put(7,new Product(7,"Xiaomi 11",18000,"New",24));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {

        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {

        products.put(id, product);
    }

    @Override
    public void remove(int id) {

        products.remove(id);
    }
}
