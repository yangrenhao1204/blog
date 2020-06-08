package top.yangrenhao.service;

import top.yangrenhao.po.User;

public interface UserService {
    User checkUser(String username, String password);
}
