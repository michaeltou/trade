--修改数据库的编码形式
--mysql>user mydb;
--mysql>alter database mydb  character set utf8;

CREATE TABLE `chatmessage` (
  `message_id` bigint(20) NOT NULL COMMENT '消息ID',
  `room_id` int(11) DEFAULT NULL COMMENT '房间ID',
  `sender_id` bigint(20) DEFAULT NULL COMMENT '发送ID\r\n',
  `receiver_id` bigint(20) DEFAULT NULL COMMENT '接收人ID',
  `message` varchar(4048) DEFAULT NULL COMMENT '消息',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='聊天表';

CREATE TABLE `inventory` (
  `sku_id` bigint(20) NOT NULL COMMENT 'Stock Keeping Unit（库存量单位）ID',
  `item_qty` bigint(20) DEFAULT NULL COMMENT '数量',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存表';

CREATE TABLE `liveroom` (
  `room_id` int(11) NOT NULL COMMENT '房间号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `city` varchar(200) DEFAULT NULL COMMENT '所在城市',
  `name` varchar(200) DEFAULT NULL COMMENT '主播姓名',
  `portrait` varchar(20) DEFAULT NULL COMMENT '头像',
  `online_users_count` int(11) DEFAULT NULL COMMENT '在线用户数',
  `url` varchar(200) DEFAULT NULL COMMENT '直播流链接',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `cover` varchar(200) DEFAULT NULL COMMENT '封面',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='直播房间表';

CREATE TABLE `offer` (
  `offer_id` bigint(20) NOT NULL COMMENT '商品ID',
  `offer_status` int(11) DEFAULT NULL COMMENT '商品状态：1、商品上架；2、商品下架',
  `sku_id` bigint(20) NOT NULL COMMENT 'Stock Keeping Unit（库存量单位）ID',
  `offer_name` varchar(4048) DEFAULT NULL COMMENT '商品名称',
  `offer_detail` longtext COMMENT '商品详情',
  `offer_seller_id` bigint(20) DEFAULT NULL COMMENT '商品卖家ID',
  `offer_org_price` bigint(20) DEFAULT NULL COMMENT '商品原始价格',
  `offer_pro_price` bigint(20) DEFAULT NULL COMMENT '商品优惠价格',
  `offer_qty` bigint(20) DEFAULT NULL COMMENT '商品数量',
  `offer_tag` text COMMENT '商品标签',
  `offer_attributes` text COMMENT '商品扩展属性',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';

CREATE TABLE `subtradeorder` (
  `suborder_id` bigint(20) NOT NULL COMMENT '子订单ID',
  `order_id` bigint(20) NOT NULL COMMENT '主订单ID',
  `buyer_id` bigint(20) DEFAULT NULL COMMENT '买家ID',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '卖家ID',
  `offer_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `sku_id` bigint(20) DEFAULT NULL COMMENT 'Stock Keeping Unit（库存量单位）ID',
  `flow_status` varchar(20) DEFAULT NULL COMMENT '流程状态：1、交易中；2、交易成功；3、交易关闭',
  `pay_status` varchar(20) DEFAULT NULL COMMENT '支付状态：1、已支付；2、未支付',
  `logistics_status` varchar(20) DEFAULT NULL COMMENT '物流状态：1、未发货 2、已发货、3、已签收',
  `suborder_qty` bigint(20) DEFAULT NULL COMMENT '子订单数',
  `suborder_money` varchar(20) DEFAULT NULL COMMENT '子订单金额',
  `suborder_paid_money` varchar(20) DEFAULT NULL COMMENT '子订单已支付金额',
  `suborder_refund_id` bigint(20) DEFAULT NULL COMMENT '子订单退款ID',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`suborder_id`),
  UNIQUE KEY `suborder_id` (`suborder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='子订单表';

CREATE TABLE `tradeorder` (
  `order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `buyer_id` bigint(20) DEFAULT NULL COMMENT '买家ID',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '卖家ID',
  `flow_status` varchar(20) DEFAULT NULL COMMENT '流程状态：1、交易中；2、交易成功；3、交易关闭',
  `pay_status` varchar(20) DEFAULT NULL COMMENT '支付状态：1、已支付；2、未支付',
  `logistics_status` varchar(20) DEFAULT NULL COMMENT '物流状态：1、未发货 2、已发货、3、已签收',
  `order_total_qty` bigint(20) DEFAULT NULL COMMENT '订单数量',
  `order_total_money` varchar(20) DEFAULT NULL COMMENT '订单总额',
  `order_total_paid_money` varchar(20) DEFAULT NULL COMMENT '订单已支付总额',
  `order_refund_id` bigint(20) DEFAULT NULL COMMENT '退款ID',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主订单表';

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(4048) DEFAULT NULL,
  `user_password` varchar(4048) DEFAULT NULL,
  `user_level` int(11) DEFAULT NULL,
  `user_tag` varchar(4048) DEFAULT NULL,
  `user_role` int(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `liveroomoffer` (
  `id` bigint(20) NOT NULL COMMENT '关系表ID',
  `room_id` bigint(20) DEFAULT NULL COMMENT '房间ID',
  `offer_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `status` bigint(20) DEFAULT NULL COMMENT '房间商品状态',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2340 COMMENT='直播房间商品关系表';

---插入数据

/* Data for the `user` table  (Records 1 - 3) */

INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_level`, `user_tag`, `user_role`, `gmt_create`, `gmt_modified`) VALUES 
  (1, '张三', '123456', 1, '白名单', 1, '2016-07-06 16:00:00', '2016-07-07 16:00:00'),
  (2, '李四', '123456', 2, '白名单', 2, '2016-08-06 16:10:10', '2016-08-06 16:16:21'),
  (3, '王五', '123456', 3, '白名单', 3, '2016-08-06', '2016-08-06 01:01:01');




/* Data for the `liveroomoffer` table  (Records 1 - 14) */

INSERT INTO `liveroomoffer` (`room_id`, `offer_id`, `status`, `gmt_create`, `id`) VALUES 
  (1, 1, 1, '2016-08-01 01:01:00', 1),
  (1, 2, 1, '2016-08-01 01:02:00', 2),
  (1, 3, 1, '2016-08-01 01:03:00', 3),
  (1, 4, 1, '2016-08-01 01:04:00', 4),
  (1, 5, 1, '2016-08-01 01:05:01', 5),
  (2, 1, 1, '2016-08-01 02:02:00', 6),
  (2, 2, 1, '2016-08-01 02:03:01', 7),
  (2, 3, 1, '2016-08-01 02:04:00', 8),
  (2, 4, 1, '2016-08-01 01:01:01', 9),
  (2, 5, 1, '2016-08-01 01:02:01', 10),
  (1, 6, 0, '2016-08-01 01:01:00', 11),
  (1, 7, 0, '2016-08-01 01:01:03', 12),
  (2, 6, 0, '2016-08-01 02:02:02', 13),
  (2, 7, 0, '2016-08-01 03:03:00', 14);


