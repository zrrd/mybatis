package mybaits.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * 原始dao开发
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

  public void insertUser() {
    this.getSqlSession().insert("s");
  }
}
