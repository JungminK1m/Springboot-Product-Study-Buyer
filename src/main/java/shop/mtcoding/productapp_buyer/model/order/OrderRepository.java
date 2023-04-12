package shop.mtcoding.productapp_buyer.model.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderRepository {

    public void insert(Order orders);

    public Order findById(Integer ordersId);

    public List<Order> findAll(Integer usersId);

    public void orderUpdatebyProductQty(Order orders);

    public void delete(Integer ordersId);
}
