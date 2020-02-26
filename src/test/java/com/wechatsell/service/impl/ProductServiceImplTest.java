package com.wechatsell.service.impl;


import com.wechatsell.dataobject.ProductInfo;
import com.wechatsell.enums.ProductStatusEnum;
import com.wechatsell.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductService productService;

    @Test
    public void findOne() {
        ProductInfo one = productService.findOne("123456");
        Assert.assertEquals("123456",one.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> upAll = productService.findUpAll();
        Assert.assertNotEquals(0,upAll);
    }

    @Test
    public void findAll() throws Exception{
        PageRequest pageRequest =PageRequest.of(0, 2);
        Page<ProductInfo> productInfoPage = productService.findAll(pageRequest);
//        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,pageRequest.getPageSize());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("223456");
        productInfo.setProductName("蛋炒饭");
        productInfo.setProductPrice(new BigDecimal(2.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("超级好吃！！");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setCategoryType(2);
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        ProductInfo save = productService.save(productInfo);
        Assert.assertNotNull(save);
    }
}