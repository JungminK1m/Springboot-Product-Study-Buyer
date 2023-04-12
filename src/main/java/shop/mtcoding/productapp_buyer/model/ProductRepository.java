package shop.mtcoding.productapp_buyer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductRepository {
    public Product findById(Integer productId);

    public List<Product> findAll();

    public int insert(Product product);

    public int update(Product product);

    public int deleteById(Integer productId);

    public Product findByProductName(String productName);
}
