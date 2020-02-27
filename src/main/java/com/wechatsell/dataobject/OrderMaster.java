package com.wechatsell.dataobject;

import com.wechatsell.enums.OrderStatusEnum;
import com.wechatsell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
    private  String orderId;

    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;

    private BigDecimal buyerAmount;

    //订单状态，默认新订单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态，默认等待支付
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    private Date createTime;
    private Date updateTime;

//    @Transient
//    private List<OrderDetail> orderDetailList;
}
