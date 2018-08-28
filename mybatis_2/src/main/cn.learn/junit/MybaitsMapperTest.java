package junit;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import mapper.OrderMapper;
import mapper.UserMapper;
import mybaits.po.Orders;
import mybaits.po.User;
import mybaits.vo.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MybaitsMapperTest {

  @Test
  public void testMapper() throws Exception {
    //创建sqlSessionFactory
    String resource = "sqlMapConfig.xml";
    InputStream in = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    //sqlSessin帮我生成一个实现类
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    User user = userMapper.findUserById(10);
    System.out.println(user);
  }

  @Test
  public void testMapperQueryVO() throws Exception {
    //创建sqlSessionFactory
    String resource = "sqlMapConfig.xml";
    InputStream in = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    //sqlSessin帮我生成一个实现类
    QueryVo vo = new QueryVo();
    User user = new User();
    user.setUsername("五");
    vo.setUser(user);
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    List<User> users = userMapper.findUserByQueryVo(vo);
    for (User user1 : users) {
      System.out.println(user1);
    }
    Integer i = userMapper.countUser();
    System.out.println(i);
  }

  @Test
  public void testMapperQueryOrders() throws Exception {
    //创建sqlSessionFactory
    String resource = "sqlMapConfig.xml";
    InputStream in = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
    List<Orders> orders = orderMapper.getOrders();
    orders.forEach(order -> System.out.println(order.toString()));
  }

  @Test
  public void selectUserBySexAndUsername() throws Exception {
    //创建sqlSessionFactory
    String resource = "sqlMapConfig.xml";
    InputStream in = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    User user = new User();
    user.setUsername("张小明");
    user.setSex("1");
    List<User> users = userMapper.selectUserBySexAndUsername(user);
    users.forEach(user1 -> System.out.println(user));
  }

  @Test
  public void selectUserByIdsTest() throws Exception {
    //创建sqlSessionFactory
    String resource = "sqlMapConfig.xml";
    InputStream in = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    List<Integer> ids = new ArrayList<>(3);
    ids.add(10);
    ids.add(16);
    ids.add(22);
    List<User> users = userMapper.selectUserByIds(ids);
    users.forEach(user -> System.out.println(user));
  }

  @Test
  public void selectOrdersCustomerTest() throws Exception {
    //创建sqlSessionFactory
    String resource = "sqlMapConfig.xml";
    InputStream in = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
    List<Orders> orders = orderMapper.selectOrdersCustomer();
  }

  @Test
  public void getOrdersListTest() throws Exception {
    //创建sqlSessionFactory
    String resource = "sqlMapConfig.xml";
    InputStream in = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    SqlSession sqlSession = sqlSessionFactory.openSession();

    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    List<User> users = userMapper.getOrdersList();
  }
}
