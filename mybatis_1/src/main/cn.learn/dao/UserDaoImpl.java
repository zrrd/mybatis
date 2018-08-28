package dao;

import mybaits.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao {

  private SqlSessionFactory sqlSessionFactory;

  public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  //通过用户id查询一个用户
  @Override
  public User selectUserById(Integer id) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    User user = sqlSession.selectOne("test.findUserById", id);
    return user;
  }
}
