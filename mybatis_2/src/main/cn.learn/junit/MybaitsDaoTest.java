package junit;

import dao.UserDao;
import dao.UserDaoImpl;
import java.io.InputStream;
import mybaits.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class MybaitsDaoTest {

  public SqlSessionFactory sqlSessionFactory;

  @Before
  public void before() throws Exception {
    //创建sqlSessionFactory
    String resource = "sqlMapConfig.xml";
    InputStream in = Resources.getResourceAsStream(resource);
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
  }

  @Test
  public void testDao() throws Exception {
    System.out.println(sqlSessionFactory);
    UserDao userDao = new UserDaoImpl(sqlSessionFactory);
    User user = userDao.selectUserById(10);
    System.out.println(user);
  }
}
