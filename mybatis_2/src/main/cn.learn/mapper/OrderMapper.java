package mapper;

import java.util.List;
import mybaits.po.Orders;

public interface OrderMapper {

  List<Orders> getOrders();

  /**
   * 一对一关联查询
   */
  List<Orders> selectOrdersCustomer();
}
