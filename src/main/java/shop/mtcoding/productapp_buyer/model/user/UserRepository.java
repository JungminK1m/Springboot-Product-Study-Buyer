package shop.mtcoding.productapp_buyer.model.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    public void insert(User users);

    public User findById(Integer usersId);

    public User findByUsername(String username);

    public List<User> findAll();

    public void update(User user);

    public void delete(Integer usersId);
}
