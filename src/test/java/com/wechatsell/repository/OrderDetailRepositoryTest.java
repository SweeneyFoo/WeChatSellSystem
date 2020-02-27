package com.wechatsell.repository;

import com.wechatsell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void findByOrderId() {
        List<OrderDetail> id = repository.findByOrderId("1111111113");
        Assert.assertNotEquals(0,id.size());
    }

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1234567891");
        orderDetail.setOrderId("1111111113");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("111111122");
        orderDetail.setProductName("炸虾");
        orderDetail.setProductPrice(new BigDecimal(2.2));
        orderDetail.setProductQuantity(5);

        OrderDetail res = repository.save(orderDetail);
        Assert.assertNotNull(res);
    }
}