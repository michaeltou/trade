drop database tzb;
create database tzb;
use tzb;
alter database tzb  character set utf8;

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
  `flow_status` int(11) DEFAULT NULL COMMENT '����״̬',
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
  PRIMARY KEY (`suborder_id`)
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
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��������';

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL COMMENT '�û�ID',
  `user_name` varchar(4048) DEFAULT NULL COMMENT '�û�����',
  `user_password` varchar(4048) DEFAULT NULL COMMENT '�û�����',
  `user_level` int(11) DEFAULT NULL COMMENT '�û��㼶',
  `user_tag` varchar(4048) DEFAULT NULL COMMENT '�û���ǩ',
  `user_role` int(11) DEFAULT NULL COMMENT '�û���ɫ',
  `gmt_create` datetime DEFAULT NULL COMMENT 'ע��ʱ��',
  `gmt_modified` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���';


CREATE TABLE `liveroomoffer` (
  `id` bigint(20) NOT NULL COMMENT '��ϵ��ID',
  `room_id` bigint(20) DEFAULT NULL COMMENT '����ID',
  `offer_id` bigint(20) DEFAULT NULL COMMENT '��ƷID',
  `status` bigint(20) DEFAULT NULL COMMENT '������Ʒ״̬',
  `gmt_create` datetime DEFAULT NULL COMMENT '����ʱ��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2340 COMMENT='ֱ��������Ʒ��ϵ��';


INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_level`, `user_tag`, `user_role`, `gmt_create`, `gmt_modified`) VALUES 
  (1, '����', '123456', 1, '������', 1, '2016-07-06 16:00:00', '2016-07-07 16:00:00'),
  (2, '����', '123456', 2, '������', 2, '2016-08-06 16:10:10', '2016-08-06 16:16:21'),
  (3, '����', '123456', 3, '������', 3, '2016-08-06', '2016-08-06 01:01:01');


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



INSERT INTO `liveroom` (`room_id`, `user_id`, `city`, `name`, `portrait`, `online_users_count`, `url`, `title`, `cover`, `gmt_create`, `flow_status`) VALUES 
  (1, 1, '����', '����', '01.jpg', 1000, 'tzb.com', '��������', 'c01.jpg', '2016-08-01 00:10:10', 1),
  (2, 2, '�Ϻ�', '����', '02.jpg', 999, 'tzb.com', '���ķ���', 'ls01.jpg', '2016-08-06 03:03:03', 1),
  (3, 3, '����', '����', '03.jpg', 777, 'tzb.com', '���巿��', 'ww01.jpg', '2016-08-03 02:03:03', 0);



INSERT INTO `offer` (`offer_id`, `offer_status`, `sku_id`, `offer_name`, `offer_detail`, `offer_seller_id`, `offer_org_price`, `offer_pro_price`, `offer_qty`, `offer_tag`, `offer_attributes`, `gmt_create`, `gmt_modified`) VALUES 
  (1, 1, 1, '�·�1', '��ӡ��Ʒ1', 1, 100, 77, 100, '������Ʒ', '��Ʒ��չ����1', '2016-08-01 01:01:01', '2016-08-03 01:01:01'),
  (2, 1, 2, '�·�2', '��ӡ��Ʒ2', 1, 200, 177, 200, '������Ʒ2', '��Ʒ��չ����2', '2016-08-01 03:03:03', '2016-08-03'),
  (3, 1, 3, '�·�3', '��ӡ��Ʒ3', 2, 188, 116, 150, '������Ʒ3', '��Ʒ��չ����3', '2016-08-03 01:01:01', '2016-08-03 10:10:01'),
  (4, 1, 4, 'Ь��1', '������Ʒ1', 2, 300, 99, 300, '����Ь��', '��Ʒ��չ����4', '2016-08-03 00:50:50', '2016-08-04 01:03:01'),
  (5, 0, 5, 'ñ��', 'ʱ��ñ��', 3, 50, 33, 99, '��Ʒ', '��Ʒ', '2016-08-01 03:03:03', '2016-08-03'),
  (6, 0, 6, '����', '����', 4, 55, 22, 323, 'ʱ������', 'ʱ��', '2016-08-01 01:01:01', '2016-08-01 03:03:03'),
  (7, 1, 7, '����1', '��Ʒ����', 5, 128, 77, 999, '����', '��������', '2016-08-01 03:03:03', '2016-08-06 05:05:05');




