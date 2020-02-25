-- 1.构建商品表 --
drop table if exists `product_info`;
CREATE TABLE `product_info`(
	`product_id` VARCHAR(32) NOT NULL,
	`product_name` VARCHAR(64) not NULL COMMENT '商品名称',
	`product_price` DECIMAL(8,2) NOT NULL COMMENT '单价',
	`product_stock` INT NOT NULL COMMENT '库存',
	`product_description` VARCHAR(64) COMMENT '描述',
	`product_icon` VARCHAR(512) COMMENT '小图',
	`product_status` tinyint(3) DEFAULT '0' COMMENT '商品状态,0正常1下架',
	`category_type` int not null comment '类目编号',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
	`update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key (`product_id`)
)comment '商品表' CHARSET=utf8;

-- 2.构建商品类目表 --
drop table if exists `product_category`;
CREATE TABLE `product_category`(
	`category_id` int not null auto_increment,
	`category_name` varchar(64) not null comment '类目名字',
	`category_type` int not null comment '类目编号',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
	`update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key (`category_id`),
	unique key `uqe_category_type`(`category_type`)
)comment '类目表' default CHARSET=utf8;

-- 3.订单表 --
drop table if exists `order_master`;
CREATE TABLE `order_master`(
	`order_id` varchar(32) not null,
	`buyer_name` varchar(32) not null comment '买家名字',
	`buyer_phone` varchar(32) not null comment '买家电话',
	`buyer_address` varchar(128) not null comment '买家地址',
	`buyer_openid` varchar(64) not null comment '买家微信openid',
	`buyer_amount` decimal(8,2) not null comment '订单总金额',
	`order_status` tinyint(3) not null default '0' comment '订单状态，默认0新下单',
	`pay_status` tinyint(3) not null default '0' comment '支付状态，默认0未支付',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
	`update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(`order_id`),
	key `idx_buyer_openid`(`buyer_openid`)
)comment '订单主表' default CHARSET=utf8;

-- 4.订单详情表 --
drop table if exists `order_detail`;
CREATE TABLE `order_detail`(
	`detail_id` varchar(32) not null,
	`order_id` varchar(32) not null,
	`product_id` varchar(32) not null,
	`product_name` varchar(64) not null comment '商品价格',
	`product_price` decimal(8,2) not null comment '商品价格',
	`product_quantity` int not null comment '商品数量',
	`product_icon` varchar(512) comment '商品小图',
	`create_time` timestamp not null default current_timestamp comment '创建时间',
	`update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(`detail_id`),
	key `idx_order_id` (`order_id`)
)comment '订单详情表' default CHARSET=utf8;

-- 5.卖家(登录后台使用, 卖家登录之后可能直接采用微信扫码登录，不使用账号密码) --
drop table if exists `seller_info`;
create table `seller_info` (
    `id` varchar(32) not null,
    `username` varchar(32) not null,
    `password` varchar(32) not null,
    `openid` varchar(64) not null comment '微信openid',
    `create_time` timestamp not null default current_timestamp comment '创建时间',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
    primary key (`id`)
) comment '卖家信息表' default CHARSET=utf8;
