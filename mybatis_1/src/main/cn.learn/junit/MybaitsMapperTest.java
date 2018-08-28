package junit;

import java.io.InputStream;
import mapper.UserMapper;
import mybaits.po.User;
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
}
