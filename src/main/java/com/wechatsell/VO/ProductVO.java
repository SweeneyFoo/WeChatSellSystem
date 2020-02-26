package com.wechatsell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品（包含类目）
 */
@Data
public class ProductVO {

    @JsonProperty("name")//返回前端变为name
    private String categoryName;
    @JsonProperty("type")//返回前端变为type
    private Integer categoryType;
    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;


}
