package com.wechatsell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class ProductInfo {
    @Id
    private  String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;//库存
    private String productDescription;//描述
    private String productIcon;//小图
    private Integer productStatus;//状态，0正常，1下架
    private Integer categoryType;//类目编号

}
