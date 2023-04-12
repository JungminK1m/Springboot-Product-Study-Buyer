package shop.mtcoding.productapp_buyer.model.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository {

    public Product findById(Integer productId);

    public List<Product> findAll();

    public Product findByProductName(String productName);

    public void insert(Product product);

    public void update(Product product);

    public void deleteById(Integer productId);

    // public void productQtyUpdate(OrdersProductDto ordersProductDto);
}
