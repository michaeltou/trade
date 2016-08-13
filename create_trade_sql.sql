--�޸����ݿ�ı�����ʽ
--mysql>user mydb;
--mysql>alter database mydb  character set utf8;

CREATE TABLE `chatmessage` (
  `message_id` bigint(20) NOT NULL COMMENT '��ϢID',
  `room_id` int(11) DEFAULT NULL COMMENT '����ID',
  `sender_id` bigint(20) DEFAULT NULL COMMENT '����ID\r\n',
  `receiver_id` bigint(20) DEFAULT NULL COMMENT '������ID',
  `message` varchar(4048) DEFAULT NULL COMMENT '��Ϣ',
  `status` int(11) DEFAULT NULL COMMENT '״̬',
  `gmt_create` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�����';

CREATE TABLE `inventory` (
  `sku_id` bigint(20) NOT NULL COMMENT 'Stock Keeping Unit���������λ��ID',
  `item_qty` bigint(20) DEFAULT NULL COMMENT '����',
  `gmt_create` datetime DEFAULT NULL COMMENT '����ʱ��',
  `gmt_modified` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  PRIMARY KEY (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='����';

CREATE TABLE `liveroom` (
  `room_id` int(11) NOT NULL COMMENT '�����',
  `user_id` bigint(20) DEFAULT NULL COMMENT '�û�id',
  `city` varchar(200) DEFAULT NULL COMMENT '���ڳ���',
  `name` varchar(200) DEFAULT NULL COMMENT '��������',
  `portrait` varchar(20) DEFAULT NULL COMMENT 'ͷ��',
  `online_users_count` int(11) DEFAULT NULL COMMENT '�����û���',
  `url` varchar(200) DEFAULT NULL COMMENT 'ֱ��������',
  `title` varchar(200) DEFAULT NULL COMMENT '����',
  `cover` varchar(200) DEFAULT NULL COMMENT '����',
  `gmt_create` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ֱ�������';

CREATE TABLE `offer` (
  `offer_id` bigint(20) NOT NULL COMMENT '��ƷID',
  `offer_status` int(11) DEFAULT NULL COMMENT '��Ʒ״̬��1����Ʒ�ϼܣ�2����Ʒ�¼�',
  `sku_id` bigint(20) NOT NULL COMMENT 'Stock Keeping Unit���������λ��ID',
  `offer_name` varchar(4048) DEFAULT NULL COMMENT '��Ʒ����',
  `offer_detail` longtext COMMENT '��Ʒ����',
  `offer_seller_id` bigint(20) DEFAULT NULL COMMENT '��Ʒ����ID',
  `offer_org_price` bigint(20) DEFAULT NULL COMMENT '��Ʒԭʼ�۸�',
  `offer_pro_price` bigint(20) DEFAULT NULL COMMENT '��Ʒ�Żݼ۸�',
  `offer_qty` bigint(20) DEFAULT NULL COMMENT '��Ʒ����',
  `offer_tag` text COMMENT '��Ʒ��ǩ',
  `offer_attributes` text COMMENT '��Ʒ��չ����',
  `gmt_create` datetime DEFAULT NULL COMMENT '����ʱ��',
  `gmt_modified` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  PRIMARY KEY (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��Ʒ��';

CREATE TABLE `subtradeorder` (
  `suborder_id` bigint(20) NOT NULL COMMENT '�Ӷ���ID',
  `order_id` bigint(20) NOT NULL COMMENT '������ID',
  `buyer_id` bigint(20) DEFAULT NULL COMMENT '���ID',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '����ID',
  `offer_id` bigint(20) DEFAULT NULL COMMENT '��ƷID',
  `sku_id` bigint(20) DEFAULT NULL COMMENT 'Stock Keeping Unit���������λ��ID',
  `flow_status` varchar(20) DEFAULT NULL COMMENT '����״̬��1�������У�2�����׳ɹ���3�����׹ر�',
  `pay_status` varchar(20) DEFAULT NULL COMMENT '֧��״̬��1����֧����2��δ֧��',
  `logistics_status` varchar(20) DEFAULT NULL COMMENT '����״̬��1��δ���� 2���ѷ�����3����ǩ��',
  `suborder_qty` bigint(20) DEFAULT NULL COMMENT '�Ӷ�����',
  `suborder_money` varchar(20) DEFAULT NULL COMMENT '�Ӷ������',
  `suborder_paid_money` varchar(20) DEFAULT NULL COMMENT '�Ӷ�����֧�����',
  `suborder_refund_id` bigint(20) DEFAULT NULL COMMENT '�Ӷ����˿�ID',
  `gmt_create` datetime DEFAULT NULL COMMENT '����ʱ��',
  `gmt_modified` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  PRIMARY KEY (`suborder_id`),
  UNIQUE KEY `suborder_id` (`suborder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�Ӷ�����';

CREATE TABLE `tradeorder` (
  `order_id` bigint(20) NOT NULL COMMENT '����ID',
  `buyer_id` bigint(20) DEFAULT NULL COMMENT '���ID',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '����ID',
  `flow_status` varchar(20) DEFAULT NULL COMMENT '����״̬��1�������У�2�����׳ɹ���3�����׹ر�',
  `pay_status` varchar(20) DEFAULT NULL COMMENT '֧��״̬��1����֧����2��δ֧��',
  `logistics_status` varchar(20) DEFAULT NULL COMMENT '����״̬��1��δ���� 2���ѷ�����3����ǩ��',
  `order_total_qty` bigint(20) DEFAULT NULL COMMENT '��������',
  `order_total_money` varchar(20) DEFAULT NULL COMMENT '�����ܶ�',
  `order_total_paid_money` varchar(20) DEFAULT NULL COMMENT '������֧���ܶ�',
  `order_refund_id` bigint(20) DEFAULT NULL COMMENT '�˿�ID',
  `gmt_create` datetime DEFAULT NULL COMMENT '����ʱ��',
  `gmt_modified` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��������';

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
  `id` bigint(20) NOT NULL COMMENT '��ϵ��ID',
  `room_id` bigint(20) DEFAULT NULL COMMENT '����ID',
  `offer_id` bigint(20) DEFAULT NULL COMMENT '��ƷID',
  `status` bigint(20) DEFAULT NULL COMMENT '������Ʒ״̬',
  `gmt_create` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2340 COMMENT='ֱ��������Ʒ��ϵ��';

---��������

/* Data for the `user` table  (Records 1 - 3) */

INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_level`, `user_tag`, `user_role`, `gmt_create`, `gmt_modified`) VALUES 
  (1, '����', '123456', 1, '������', 1, '2016-07-06 16:00:00', '2016-07-07 16:00:00'),
  (2, '����', '123456', 2, '������', 2, '2016-08-06 16:10:10', '2016-08-06 16:16:21'),
  (3, '����', '123456', 3, '������', 3, '2016-08-06', '2016-08-06 01:01:01');




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


