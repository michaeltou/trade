INSERT INTO `inventory` (`sku_id`, `item_qty`, `gmt_create`, `gmt_modified`) VALUES 
  (1, 100, '2016-08-27', '2016-08-27'),
  (2, 200, '2016-08-26', '2016-08-26'),
  (3, 300, '2016-08-25', '2016-08-25');


INSERT INTO `liveroom` (`room_id`, `user_id`, `city`, `name`, `portrait`, `online_users_count`, `url`, `title`, `cover`, `gmt_create`, `flow_status`) VALUES 
  (1, 1, '����', '����', '01.jpg', 1000, 'tzb.com', '��������', 'c01.jpg', '2016-08-01 00:10:10', 1),
  (2, 2, '�Ϻ�', '����', '02.jpg', 999, 'tzb.com', '���ķ���', 'ls01.jpg', '2016-08-06 03:03:03', 1),
  (3, 3, '����', '����', '03.jpg', 777, 'tzb.com', '���巿��', 'ww01.jpg', '2016-08-03 02:03:03', 0);


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


INSERT INTO `offer` (`offer_id`, `offer_status`, `sku_id`, `offer_name`, `offer_detail`, `offer_seller_id`, `offer_org_price`, `offer_pro_price`, `offer_qty`, `offer_tag`, `offer_attributes`, `gmt_create`, `gmt_modified`) VALUES 
  (1, 1, 1, '�·�1', '��ӡ��Ʒ1', 1, 100, 77, 100, '������Ʒ', '��Ʒ��չ����1', '2016-08-01 01:01:01', '2016-08-03 01:01:01'),
  (2, 1, 2, '�·�2', '��ӡ��Ʒ2', 1, 200, 177, 200, '������Ʒ2', '��Ʒ��չ����2', '2016-08-01 03:03:03', '2016-08-03'),
  (3, 1, 3, '�·�3', '��ӡ��Ʒ3', 2, 188, 116, 150, '������Ʒ3', '��Ʒ��չ����3', '2016-08-03 01:01:01', '2016-08-03 10:10:01'),
  (4, 1, 4, 'Ь��1', '������Ʒ1', 2, 300, 99, 300, '����Ь��', '��Ʒ��չ����4', '2016-08-03 00:50:50', '2016-08-04 01:03:01'),
  (5, 0, 5, 'ñ��', 'ʱ��ñ��', 3, 50, 33, 99, '��Ʒ', '��Ʒ', '2016-08-01 03:03:03', '2016-08-03'),
  (6, 0, 6, '����', '����', 4, 55, 22, 323, 'ʱ������', 'ʱ��', '2016-08-01 01:01:01', '2016-08-01 03:03:03'),
  (7, 1, 7, '����1', '��Ʒ����', 5, 128, 77, 999, '����', '��������', '2016-08-01 03:03:03', '2016-08-06 05:05:05');

INSERT INTO `offer_pictures` (`pic_id`, `offer_id`, `gmt_create`, `gmt_modified`, `pic_url`, `pic_status`, `pic_desc`, `pic_type`) VALUES 
  (1, 1, '2016-08-27', '2016-08-27', 'image\\offer\\p01.jpg', 1, '����ͼƬ1', 1),
  (2, 2, '2016-08-26', '2016-08-26', 'image\\offer\\p02.jpg', 1, '����ͼƬ2', 1),
  (3, 3, '2016-08-25', '2016-08-25', 'image\\home\\p01.jpg', 1, '����ͼƬ3', 1);



INSERT INTO `subtradeorder` (`suborder_id`, `order_id`, `buyer_id`, `seller_id`, `offer_id`, `sku_id`, `flow_status`, `pay_status`, `logistics_status`, `logistics_id`, `preferential_fees`, `offer_org_price`, `actual_paid_price`, `logistics_cost`, `suborder_qty`, `suborder_money`, `suborder_paid_money`, `suborder_refund_id`, `gmt_create`, `gmt_modified`) VALUES 
  (1, 2, 2, 2, 2, 2, '1', '1', '1', '1', 8, 1, 8, 8, 2, '700', '700', 1, '2016-08-25', '2016-08-25'),
  (2, 1, 1, 1, 1, 1, '1', '1', '1', '2', 8, 8, 8, 8, 8, '500', '600', 2, '2016-08-24', '2016-08-24'),
  (3, 3, 3, 3, 3, 3, '1', '1', '1', '3', 8, 8, 8, 8, 3, '800', '800', 3, '2016-08-26', '2016-08-26');

INSERT INTO `tradeorder` (`order_id`, `buyer_id`, `seller_id`, `flow_status`, `pay_status`, `logistics_status`, `order_total_qty`, `order_total_paid_money`, `order_refund_id`, `logistics_cost`, `logistics_promotion_fee`, `promotion_fees`, `gmt_create`, `gmt_modified`) VALUES 
  (1, 1, 1, '1', '1', '1', 2, '700', 1, 8, 8, 8, '2016-08-27', '2016-08-27 01:01:01'),
  (2, 2, 2, '1', '1', '1', 2, '600', 0, 16, 16, 16, '2016-08-26', '2016-08-27 02:02:02'),
  (3, 1, 3, '1', '1', '1', 3, '898', 0, 20, 20, 20, '2016-08-25', '2016-08-26 03:03:03');


INSERT INTO `user` (`user_id`, `user_name`, `user_password`, `user_level`, `user_tag`, `user_role`, `gmt_create`, `gmt_modified`) VALUES 
  (1, '����', '123456', 1, '������', 1, '2016-07-06 16:00:00', '2016-07-07 16:00:00'),
  (2, '����', '123456', 2, '������', 2, '2016-08-06 16:10:10', '2016-08-06 16:16:21'),
  (3, '����', '123456', 3, '������', 3, '2016-08-06', '2016-08-06 01:01:01');

INSERT INTO `user_address` (`user_addr_id`, `user_id`, `detail_addr`, `default_addr`, `province`, `city`, `name`, `phone`, `cell_phone`, `type`) VALUES 
  (1, 1, '�㽭ʡ������������', '�㽭ʡ������������', '�㽭ʡ', '������', '����', '057188999988', '13989898989', 1),
  (2, 2, '�㽭ʡ������������', '�㽭ʡ������������', '�㽭ʡ', '������', '����', '057188999987', '13989898987', 1),
  (3, 3, '�㽭ʡ�����н�����', '�㽭ʡ������������', '�㽭ʡ', '������', '����', '057188999986', '13989898986', 2);
