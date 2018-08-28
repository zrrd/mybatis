package junit;


import java.io.InputStream;
import java.util.Date;
import java.util.List;
import mybaits.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MybaitsTest1 {

  @Test
  public void testMybaits() throws Exception {
    //创建sqlSessionFactory
    String resource = "sqlMapConfig.xml";
    InputStream in = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    User user = sqlSession.selectOne("test.findUserById", 10);
    System.out.println(user);

    List<User> users = sqlSession.selectList("test.findUserByUsername", "五");
    for (User user1 : users) {
      System.out.println(user1);
    }
  }

  @Test
  public void testInsertUser() throws Exception {
    //创建sqlSessionFactory
    String resource = "sqlMapConfig.xml";
    InputStream in = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    //执行sql语句
    User user = new User();
    user.setSex("男");
    user.setUsername("刘备");
    user.setAddress("成都");
    user.setBirthday(new Date());
    sqlSession.insert("test.insertUser", user);
    sqlSession.commit();

    System.out.println(user.getId());
  }

  @Test
  public void testUpdateUserById() throws Exception {
    //创建sqlSessionFactory
    String resource = "sqlMapConfig.xml";
    InputStream in = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    //执行sql语句
    User user = new User();
    user.setId(29);
    user.setSex("男");
    user.setUsername("曹操");
    user.setAddress("山东");
    user.setBirthday(new Date());
    sqlSession.update("test.updateUserById", user);
    sqlSession.commit();
  }

  @Test
  public void testDeleteUserById() throws Exception {
    //创建sqlSessionFactory
    String resource = "sqlMapConfig.xml";
    InputStream in = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    int id = 29;
    sqlSession.delete("test.deleteUserById", id);
    sqlSession.commit();

  }
}
