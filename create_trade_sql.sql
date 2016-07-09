CREATE TABLE `inventory` (
  `sku_id` bigint(20) NOT NULL,
  `item_qty` bigint(20) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `offer` (
  `offer_id` bigint(20) NOT NULL,
  `offer_status` int(11) DEFAULT NULL,
  `sku_id` bigint(20) NOT NULL,
  `offer_name` varchar(4048) DEFAULT NULL,
  `offer_detail` longtext,
  `offer_seller_id` bigint(20) DEFAULT NULL,
  `offer_org_price` bigint(20) DEFAULT NULL,
  `offer_pro_price` bigint(20) DEFAULT NULL,
  `offer_qty` bigint(20) DEFAULT NULL,
  `offer_tag` text,
  `offer_attributes` text,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tradeorder` (
  `order_id` bigint(20) NOT NULL,
  `buyer_id` bigint(20) DEFAULT NULL,
  `seller_id` bigint(20) DEFAULT NULL,
  `flow_status` varchar(20) DEFAULT NULL,
  `pay_status` varchar(20) DEFAULT NULL,
  `logistics_status` varchar(20) DEFAULT NULL,
  `order_total_qty` bigint(20) DEFAULT NULL,
  `order_total_money` varchar(20) DEFAULT NULL,
  `order_total_paid_money` varchar(20) DEFAULT NULL,
  `order_refund_id` bigint(20) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `subtradeorder` (
  `suborder_id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `buyer_id` bigint(20) DEFAULT NULL,
  `seller_id` bigint(20) DEFAULT NULL,
  `offer_id` bigint(20) DEFAULT NULL,
  `sku_id` bigint(20) DEFAULT NULL,
  `flow_status` varchar(20) DEFAULT NULL,
  `pay_status` varchar(20) DEFAULT NULL,
  `logistics_status` varchar(20) DEFAULT NULL,
  `suborder_qty` bigint(20) DEFAULT NULL,
  `suborder_money` varchar(20) DEFAULT NULL,
  `suborder_paid_money` varchar(20) DEFAULT NULL,
  `suborder_refund_id` bigint(20) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`suborder_id`),
  UNIQUE KEY `suborder_id` (`suborder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
