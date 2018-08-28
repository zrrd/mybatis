package mapper;

import mybaits.po.User;

public interface UserMapper {

  /**
   * 遵循4个原则 接口方法名 == User.xml 中 id名 返回值类型与 Mapper.xml中的返回值一致 方法入参一致 与 Mapper.xml中一致 命名空间绑定此接口
   */
  User findUserById(Integer id);

}
