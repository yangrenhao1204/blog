package top.yangrenhao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import top.yangrenhao.po.User;

@Service
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}
