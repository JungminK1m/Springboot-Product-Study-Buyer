package shop.mtcoding.productapp_buyer.model.orders;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Orders {

    private Integer ordersId;
    private String ordersName;
    private Integer ordersPrice;
    private Integer ordersCount; // 주문수량
    private Integer productId;
    private Integer usersId;
    private Timestamp createdAt;
}
