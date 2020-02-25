package com.wechatsell.service;

import com.wechatsell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductInfo findOne(String productId);
    List<ProductInfo> findUpAll();//查询在架商品
    Page<ProductInfo> findAll(Pageable pageable);//查询所有商品
    ProductInfo save(ProductInfo productInfo);
    //加库存
    //减库存

}
