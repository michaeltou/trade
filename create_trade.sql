drop database tzb;
create database tzb;
use tzb;
alter database tzb  character set utf8;

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
  `flow_status` int(11) DEFAULT NULL COMMENT '房间状态',
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
  `logistics_model_id` bigint(20) DEFAULT NULL COMMENT '物流模板ID',
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
  `logistics_id` varchar(20) DEFAULT NULL COMMENT '物流单号',
  `preferential_fees` bigint(20) DEFAULT NULL COMMENT '优惠费用',
  `offer_org_price` bigint(20) DEFAULT NULL COMMENT '原始价格',
  `actual_paid_price` bigint(20) DEFAULT NULL COMMENT '实付金额',
  `logistics_cost` bigint(20) DEFAULT NULL COMMENT '物流运费',
  `suborder_qty` bigint(20) DEFAULT NULL COMMENT '子订单数',
  `suborder_money` varchar(20) DEFAULT NULL COMMENT '子订单金额',
  `suborder_paid_money` varchar(20) DEFAULT NULL COMMENT '子订单已支付金额',
  `suborder_refund_id` bigint(20) DEFAULT NULL COMMENT '子订单退款ID',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`suborder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='子订单表';

CREATE TABLE `tradeorder` (
  `order_id` bigint(20) NOT NULL COMMENT '订单ID',
  `buyer_id` bigint(20) DEFAULT NULL COMMENT '买家ID',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '卖家ID',
  `flow_status` varchar(20) DEFAULT NULL COMMENT '流程状态：1、交易中；2、交易成功；3、交易关闭',
  `pay_status` varchar(20) DEFAULT NULL COMMENT '支付状态：1、已支付；2、未支付',
  `logistics_status` varchar(20) DEFAULT NULL COMMENT '物流状态：1、未发货 2、已发货、3、已签收',
  `order_total_qty` bigint(20) DEFAULT NULL COMMENT '订单数量',
  `order_total_paid_money` varchar(20) DEFAULT NULL COMMENT '订单实付总额',
  `order_refund_id` bigint(20) DEFAULT NULL COMMENT '退款ID',
  `logistics_cost` bigint(20) DEFAULT NULL COMMENT '物流运费',
  `logistics_promotion_fee` int(11) DEFAULT NULL COMMENT '物流优惠费用',
  `promotion_fees` bigint(20) DEFAULT NULL COMMENT '产品优惠费用',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主订单表';

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `user_name` varchar(4048) DEFAULT NULL COMMENT '用户姓名',
  `user_password` varchar(4048) DEFAULT NULL COMMENT '用户密码',
  `user_level` int(11) DEFAULT NULL COMMENT '用户层级',
  `user_tag` varchar(4048) DEFAULT NULL COMMENT '用户标签',
  `user_role` int(11) DEFAULT NULL COMMENT '用户角色',
  `gmt_create` datetime DEFAULT NULL COMMENT '注册时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


CREATE TABLE `liveroomoffer` (
  `id` bigint(20) NOT NULL COMMENT '关系表ID',
  `room_id` bigint(20) DEFAULT NULL COMMENT '房间ID',
  `offer_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `status` bigint(20) DEFAULT NULL COMMENT '房间商品状态',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2340 COMMENT='直播房间商品关系表';


CREATE TABLE `offer_pictures` (
  `pic_id` bigint(20) DEFAULT NULL COMMENT 'ID',
  `offer_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `pic_url` varchar(20) DEFAULT NULL COMMENT '图片路径',
  `pic_status` int(11) DEFAULT NULL COMMENT '图片状态',
  `pic_desc` varchar(20) DEFAULT NULL COMMENT '图片描述',
  `pic_type` int(11) DEFAULT NULL COMMENT '图片种类：1-封面主图 2-封面附图 3-详情图片'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品图片表';

CREATE TABLE `user_address` (
  `user_addr_id` bigint(20) NOT NULL COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `detail_addr` varchar(2048) DEFAULT NULL COMMENT '详细地址1',
  `default_addr` varchar(2048) DEFAULT NULL COMMENT '默认地址',
  `province` varchar(20) DEFAULT NULL COMMENT '省份',
  `city` varchar(20) DEFAULT NULL COMMENT '市区',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) DEFAULT NULL COMMENT '固定电话',
  `cell_phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `type` int(11) DEFAULT NULL COMMENT '种类',
  PRIMARY KEY (`user_addr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='详细地址表';

