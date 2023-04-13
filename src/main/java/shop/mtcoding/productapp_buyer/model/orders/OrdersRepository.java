package shop.mtcoding.productapp_buyer.model.orders;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import shop.mtcoding.productapp_buyer.dto.orders.OrdersDto;

@Mapper
public interface OrdersRepository {

    public void insert(OrdersDto ordersDto, Integer userId);

    public Orders findById(Integer ordersId);

    public List<Orders> findAll(Integer usersId);

    public void orderUpdatebyProductQty(Orders orders);

    public void delete(Integer ordersId);
}
