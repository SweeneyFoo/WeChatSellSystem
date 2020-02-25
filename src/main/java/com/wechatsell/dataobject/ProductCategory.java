package com.wechatsell.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 类目
 */
@Entity
@DynamicUpdate//动态更新
@Data//自动生成get，set方法(lombok.Data)
public class ProductCategory {
    /**
     * 类目id
     */
    @Id
    @GeneratedValue(strategy =javax.persistence.GenerationType.IDENTITY)
    private Integer categoryId;
    /**
     * 类目名字
     */
    private String categoryName;
    /**
     * 类目编号
     */
    private Integer categoryType;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {
    }

    private class GenerationType {
    }
}
