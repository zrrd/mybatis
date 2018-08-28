package mybaits.vo;

import java.io.Serializable;
import mybaits.po.User;

public class QueryVo implements Serializable {


  private User user;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
