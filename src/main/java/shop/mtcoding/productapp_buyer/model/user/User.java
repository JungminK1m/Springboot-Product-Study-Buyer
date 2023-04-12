package shop.mtcoding.productapp_buyer.model.user;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Integer usersId;
    private String username;
    private String password;
    private String role;
    private Timestamp createdAt;
}
