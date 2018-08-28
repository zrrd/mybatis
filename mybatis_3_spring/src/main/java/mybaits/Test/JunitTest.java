package mybaits.Test;

import mybaits.mapper.UserMapper;
import mybaits.po.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitTest {

  @Test
  public void testMapper() {
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    /*ac.getBean(UserMapper.class)*/
    UserMapper mapper = (UserMapper) ac.getBean("MapperFactoryBean");
    User user = mapper.findUserById(10);
    System.out.println(user);
  }

  @Test
  public void testMapperScannerConfigurer() {
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserMapper mapper = (UserMapper) ac.getBean(UserMapper.class);
    User user = mapper.findUserById(10);
    System.out.println(user);
  }

}
