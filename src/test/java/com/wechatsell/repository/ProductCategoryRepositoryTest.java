package com.wechatsell.repository;

import com.wechatsell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public  void findOneTest(){
        ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory.toString());
    }
    @Test
    @Transactional
    public void saveTest(){
        ProductCategory result = repository.save(new ProductCategory("男生最爱", 4));
        Assert.assertNotNull(result);
    }
    @Test
    public void saveTest2(){
        ProductCategory productCategory = repository.findById(1).get();
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }
    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());

    }

}