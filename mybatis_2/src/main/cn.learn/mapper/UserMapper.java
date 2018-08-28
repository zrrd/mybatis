package mapper;

import java.util.List;
import mybaits.po.User;
import mybaits.vo.QueryVo;

public interface UserMapper {

  /**
   * 遵循4个原则 接口方法名 == UserMapper.xml 中 id名 返回值类型与 Mapper.xml中的返回值一致 方法入参一致 与 Mapper.xml中一致 命名空间绑定此接口
   */
  User findUserById(Integer id);

  List<User> findUserByQueryVo(QueryVo vo);

  /**
   * 查询数据条数
   */
  Integer countUser();

  /**
   * 根据性别和名称查询用户
   */
  List<User> selectUserBySexAndUsername(User user);

  /**
   * 根据多个id查询用户
   */
  List<User> selectUserByIds(List<Integer> ids);

  /**
   * 一对多关联查询
   */
  List<User> getOrdersList();

}
