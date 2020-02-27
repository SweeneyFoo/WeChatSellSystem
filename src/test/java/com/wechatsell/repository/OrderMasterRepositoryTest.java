package com.wechatsell.repository;

import com.wechatsell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;
    @Test
    public void findByBuyerOpenid() {
        PageRequest page = PageRequest.of(0, 3);
        Page<OrderMaster> result = repository.findByBuyerOpenid(OPENID, page);
//        System.out.println(result.getTotalElements());
        Assert.assertNotEquals(0,result.getTotalElements());
    }
    private final String OPENID = "112110";
    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("haha");
        orderMaster.setBuyerPhone("12345678901");
        orderMaster.setBuyerAddress("mooc");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerAmount(new BigDecimal(2.5));
        OrderMaster res = repository.save(orderMaster);
        Assert.assertNotNull(res);
    }
}