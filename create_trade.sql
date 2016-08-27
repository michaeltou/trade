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
  `logistics_model_id` bigint(20) DEFAULT NULL COMMENT '����ģ��ID',
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
  `logistics_id` varchar(20) DEFAULT NULL COMMENT '��������',
  `preferential_fees` bigint(20) DEFAULT NULL COMMENT '�Żݷ���',
  `offer_org_price` bigint(20) DEFAULT NULL COMMENT 'ԭʼ�۸�',
  `actual_paid_price` bigint(20) DEFAULT NULL COMMENT 'ʵ�����',
  `logistics_cost` bigint(20) DEFAULT NULL COMMENT '�����˷�',
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
  `order_total_paid_money` varchar(20) DEFAULT NULL COMMENT '����ʵ���ܶ�',
  `order_refund_id` bigint(20) DEFAULT NULL COMMENT '�˿�ID',
  `logistics_cost` bigint(20) DEFAULT NULL COMMENT '�����˷�',
  `logistics_promotion_fee` int(11) DEFAULT NULL COMMENT '�����Żݷ���',
  `promotion_fees` bigint(20) DEFAULT NULL COMMENT '��Ʒ�Żݷ���',
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


CREATE TABLE `offer_pictures` (
  `pic_id` bigint(20) DEFAULT NULL COMMENT 'ID',
  `offer_id` bigint(20) DEFAULT NULL COMMENT '��ƷID',
  `gmt_create` datetime DEFAULT NULL COMMENT '����ʱ��',
  `gmt_modified` datetime DEFAULT NULL COMMENT '�޸�ʱ��',
  `pic_url` varchar(20) DEFAULT NULL COMMENT 'ͼƬ·��',
  `pic_status` int(11) DEFAULT NULL COMMENT 'ͼƬ״̬',
  `pic_desc` varchar(20) DEFAULT NULL COMMENT 'ͼƬ����',
  `pic_type` int(11) DEFAULT NULL COMMENT 'ͼƬ���ࣺ1-������ͼ 2-���渽ͼ 3-����ͼƬ'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ƷͼƬ��';

CREATE TABLE `user_address` (
  `user_addr_id` bigint(20) NOT NULL COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '�û�ID',
  `detail_addr` varchar(2048) DEFAULT NULL COMMENT '��ϸ��ַ1',
  `default_addr` varchar(2048) DEFAULT NULL COMMENT 'Ĭ�ϵ�ַ',
  `province` varchar(20) DEFAULT NULL COMMENT 'ʡ��',
  `city` varchar(20) DEFAULT NULL COMMENT '����',
  `name` varchar(20) DEFAULT NULL COMMENT '����',
  `phone` varchar(20) DEFAULT NULL COMMENT '�̶��绰',
  `cell_phone` varchar(20) DEFAULT NULL COMMENT '�ֻ�����',
  `type` int(11) DEFAULT NULL COMMENT '����',
  PRIMARY KEY (`user_addr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ϸ��ַ��';

