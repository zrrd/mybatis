package dao;

import mybaits.po.User;

public interface UserDao {

  User selectUserById(Integer id);
}
