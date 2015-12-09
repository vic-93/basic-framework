# Host: 192.168.0.15  (Version: 5.1.71)
# Date: 2014-11-27 20:48:32
# Generator: MySQL-Front 5.3  (Build 4.13)

/*!40101 SET NAMES utf8 */;

#
# Source for table "mum_device"
#

DROP TABLE IF EXISTS `mum_device`;
CREATE TABLE `mum_device` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `device_type` varchar(100) DEFAULT NULL COMMENT '设备类型',
  `device_code` varchar(100) DEFAULT NULL COMMENT '设备标识',
  `bluetooth_mac` varchar(100) DEFAULT NULL COMMENT '蓝牙地址',
  `device_name` varchar(100) DEFAULT NULL COMMENT '设备名称',
  `imei` varchar(20) DEFAULT NULL COMMENT 'IMEI',
  `model_name` varchar(255) DEFAULT NULL COMMENT '型号',
  `os_version` varchar(100) DEFAULT NULL COMMENT '系统版本',
  `product_name` varchar(100) DEFAULT NULL COMMENT '设备厂商',
  `sim_carrier_network` varchar(100) DEFAULT NULL COMMENT 'sim卡地址',
  `wifi_mac` varchar(100) DEFAULT NULL COMMENT 'wifi地址',
  `phone_number` varchar(50) DEFAULT NULL COMMENT '电话号码',
  `device_capacity` varchar(50) DEFAULT NULL COMMENT '设备内存',
  `is_delete` int(1) DEFAULT '0' COMMENT '0：未删除 1：已删除',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "mum_device"
#

INSERT INTO `mum_device` VALUES ('03ca0009b17a434fa2509e5eec80797d','123','124','125','126','127','128','129','130','131','132','133','134',1,'16316a453413485fa511443ab547c36b'),('1234','999','999','999','9','9','9','9','9','99','9','9','9',0,'16316a453413485fa511443ab547c36b'),('6f2d6829295b41b9ba6a86163bb3fc71','888','888','888','888','888','888','888','888','888','888','888','888',0,'16316a453413485fa511443ab547c36b');

#
# Source for table "mum_invoice"
#

DROP TABLE IF EXISTS `mum_invoice`;
CREATE TABLE `mum_invoice` (
  `record_id` varchar(32) NOT NULL DEFAULT '',
  `user_id` varchar(32) DEFAULT NULL,
  `invoice_code` varchar(30) DEFAULT NULL COMMENT '发票代码',
  `invoice_num` varchar(30) DEFAULT NULL COMMENT '发票号码',
  `invoice_password` varchar(50) DEFAULT NULL COMMENT '发票密码',
  `invoice_name` varchar(60) DEFAULT NULL COMMENT '发票名称',
  `tax_num` varchar(30) DEFAULT NULL COMMENT '税号',
  `machine_code` varchar(50) DEFAULT NULL COMMENT '机器编号',
  `recipients_dept` varchar(50) DEFAULT NULL COMMENT '领用单位',
  `collection_dept` varchar(50) DEFAULT NULL COMMENT '收款单位',
  `pay_dept` varchar(50) DEFAULT NULL COMMENT '付款单位',
  `buy_ticket_dept` varchar(50) DEFAULT NULL COMMENT '购票单位',
  `make_out_time` varchar(19) DEFAULT NULL COMMENT '开具时间',
  `make_out_money` varchar(30) DEFAULT NULL COMMENT '开具金额',
  `identify_result` int(1) DEFAULT NULL COMMENT '1：真2：假',
  `identify_time` varchar(19) DEFAULT NULL,
  `is_delete` int(1) DEFAULT '0' COMMENT '1：未删除 2：已删除',
  `par_value` varchar(50) DEFAULT NULL,
  `query_result` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "mum_invoice"
#

INSERT INTO `mum_invoice` VALUES ('2955622ba0f54fb5b4c68789827a6fcd','huxueyan','211001460030','00607245','89562846',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,2,'2014-11-25 20:37:48',0,NULL,'此发票与北京市地方税务局后台数据信息不符!'),('3ea8f2aced82429d82e0ec25821ca023','huxueyan','211001473410','19560666','25361290','北京市政交通一卡通有限公司充值专用发票（50元）',NULL,NULL,'北京市政交通一卡通有限公司',NULL,NULL,NULL,NULL,NULL,1,'2014-11-26 17:01:44',0,'50.00','此发票不是第一次查询！ \n '),('4750433a539c406b818980a3a17adf9c','huxueyan','111001481001','12859352','',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,2,'2014-11-25 20:35:08',0,NULL,'北京市国家税务局通用机打发票,代码、号码、密码及税控后台校验比对结果：fj假。请及时与税务机关联系，感谢您的支持。'),('5b464da7a420443e8dec6090dfb0c234','huxueyan','211001460030','00607244','89562848',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,2,'2014-11-25 20:38:06',0,NULL,'此发票与北京市地方税务局后台数据信息不符!'),('666dd0cfa3bc45948cb7331c2c6eb0a1','huxueyan','111001481001','12859358','06537225',NULL,NULL,NULL,NULL,NULL,NULL,'北京市天安出租汽车有限责任公司',NULL,NULL,1,'2014-11-27 19:14:22',0,NULL,'北京市国家税务局通用机打发票,代码、号码、密码及税控后台校验比对结果:tz真。该查询为第31次正确查询。'),('77c013927dd941e7baa351c3bf844c54','huxueyan','111001481001','12859358','06537225',NULL,NULL,NULL,NULL,NULL,NULL,'北京市天安出租汽车有限责任公司',NULL,NULL,1,'2014-11-25 20:03:29',0,NULL,'北京市国家税务局通用机打发票,代码、号码、密码及税控后台校验比对结果:tz真。该查询为第24次正确查询。'),('9e966188f944487bb094117cc2cd4e10','huxueyan','111001481001','12859358','06537225',NULL,NULL,NULL,NULL,NULL,NULL,'北京市天安出租汽车有限责任公司',NULL,NULL,1,'2014-11-27 20:23:00',0,NULL,'北京市国家税务局通用机打发票,代码、号码、密码及税控后台校验比对结果:tz真。该查询为第32次正确查询。'),('bef0c0dc4cd14e56b6c5e7ed94e3d74a','huxueyan','211001460031','00607244','89562846',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,2,'2014-11-26 16:26:33',0,NULL,'此发票与北京市地方税务局后台数据信息不符!'),('c173edf5501f45c0bb31297dbae8a5ff','huxueyan','211001460030','00607244','89562846','北京市地方税务局通用机打发票(有奖卷式)','11010469166610X','013210053373','北京乐记西湘餐饮有限责任公司广安门小豆分公司','北京乐记西湘餐饮有限责任公司广安门小豆分公司','北京酷博灵科信息技术有限公司',NULL,'2014-10-27','242.00',1,'2014-11-27 20:22:03',0,NULL,'此发票不是第一次查询！ \n '),('c26188c3c6224c6fa5086b2a41ada2d3','huxueyan','211001460030','00607244','89562846','北京市地方税务局通用机打发票(有奖卷式)','11010469166610X','013210053373','北京乐记西湘餐饮有限责任公司广安门小豆分公司','北京乐记西湘餐饮有限责任公司广安门小豆分公司','北京酷博灵科信息技术有限公司',NULL,'2014-10-27','242.00',1,'2014-11-26 16:43:38',0,NULL,'此发票不是第一次查询！ \n '),('cb1905b0163245e3b368711ff98f869f','huxueyan','111001481003','12859358','',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,2,'2014-11-26 16:35:21',0,NULL,'北京市国家税务局通用机打发票,代码、号码、密码及税控后台校验比对结果：fj假。请及时与税务机关联系，感谢您的支持。'),('d664794d036e4e97a8fd3225d492c13f','huxueyan','211001460031','00607244','89562846',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,2,'2014-11-25 18:38:26',0,NULL,NULL),('e284e116079646ebbf5245e3a5fdc67a','huxueyan','211001460031','00607244','89562846',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,2,'2014-11-25 20:36:47',0,NULL,'此发票与北京市地方税务局后台数据信息不符!'),('e29e1c6591ea413bae6a8e125e84cc4c','huxueyan','111001481003','12859358','',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,2,'2014-11-25 18:50:34',0,NULL,'北京市国家税务局通用机打发票,代码、号码、密码及税控后台校验比对结果：fj假。请及时与税务机关联系，感谢您的支持。'),('e6690b8b77904893bc455075b4ac72e3','huxueyan','211001460030','00607244','89562846','北京市地方税务局通用机打发票(有奖卷式)','11010469166610X','013210053373','北京乐记西湘餐饮有限责任公司广安门小豆分公司','北京乐记西湘餐饮有限责任公司广安门小豆分公司','北京酷博灵科信息技术有限公司',NULL,'2014-10-27','242.00',1,'2014-11-25 18:46:00',0,NULL,'此发票不是第一次查询！ \n '),('fe3bb22162504166adf55aaf5ae1763f','huxueyan','111001481001','12859358','06537225',NULL,NULL,NULL,NULL,NULL,NULL,'北京市天安出租汽车有限责任公司',NULL,NULL,1,'2014-11-26 16:29:08',0,NULL,'北京市国家税务局通用机打发票,代码、号码、密码及税控后台校验比对结果:tz真。该查询为第28次正确查询。');

#
# Source for table "mum_invoice_item"
#

DROP TABLE IF EXISTS `mum_invoice_item`;
CREATE TABLE `mum_invoice_item` (
  `invoice_item_id` varchar(32) NOT NULL DEFAULT '',
  `record_id` varchar(32) DEFAULT '' COMMENT '发票的记录id',
  `item_name` varchar(50) DEFAULT NULL COMMENT '项目名',
  `item_price` varchar(30) DEFAULT NULL COMMENT '项目单价',
  `item_count` varchar(50) DEFAULT NULL COMMENT '项目数量',
  `total_cost` varchar(255) DEFAULT NULL COMMENT '总额',
  PRIMARY KEY (`invoice_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

#
# Data for table "mum_invoice_item"
#

INSERT INTO `mum_invoice_item` VALUES ('0d22544debcd4d99a1e5af13eb7d6754','4c87dbb8cb0b44bdb3c0ddc06dd5b61a','餐费','242.00','1','242.00'),('36c98c2403df4c04aac3c1e31a0be809','c26188c3c6224c6fa5086b2a41ada2d3','餐费','242.00','1','242.00'),('454337e3a1df472e981b467eb9554345','67cbaf2b608c46c0b66b83eceff37512','餐费','242.00','1','242.00'),('6abeb2ce956e4267938d1f51fe15e46d','6d9fdb1ed2f94647a5f792a1535eeb15','餐费','242.00','1','242.00'),('72dc89b3982b42718ddf4d4460ebc53a','730f95cdcffc4503bbeca61fa9ba7cbf','餐费','242.00','1','242.00'),('7e1704b623d34903afc2ab73f7d15af6','22dceb57d69f4f18b0f2fc0d2ae4c30e','餐费','242.00','1','242.00'),('85f93f656b3c494784d9143ac41b9507','c173edf5501f45c0bb31297dbae8a5ff','餐费','242.00','1','242.00'),('94d8e05721674333921ba92a2fc8a3d1','87fcbb7aec794884af537c54779377bc','餐费','242.00','1','242.00'),('c5a993263da141179c53f9ab2ba02ccf','86ea997090e54cd482c0f8fd57fe5da2','餐费','242.00','1','242.00'),('dec3a0636fe84e9d8a69321a347baa4a','e6690b8b77904893bc455075b4ac72e3','餐费','242.00','1','242.00'),('f6623dc360f24ee28278be090deb03cf','b2fa775685d24053aa7f4f4f895b8669','餐费','242.00','1','242.00'),('fa941c752b6c408fb81157174d664d7e','df57c50607754285b241b452fc890409','餐费','242.00','1','242.00');

#
# Source for table "mum_org"
#

DROP TABLE IF EXISTS `mum_org`;
CREATE TABLE `mum_org` (
  `org_id` varchar(32) NOT NULL DEFAULT '',
  `cfg_index` varchar(32) DEFAULT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `org_code` varchar(20) DEFAULT NULL,
  `org_sort` varchar(30) DEFAULT NULL,
  `org_name` varchar(50) DEFAULT NULL,
  `comment_info` varchar(300) DEFAULT NULL,
  `org_sts` varchar(2) DEFAULT NULL,
  `org_location` varchar(50) DEFAULT NULL,
  `org_addr` varchar(100) DEFAULT NULL,
  `office_phone` varchar(15) DEFAULT NULL,
  `liaison` varchar(35) DEFAULT NULL,
  `org_type` varchar(2) DEFAULT NULL,
  `ext_pro` varchar(1000) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_date` varchar(20) DEFAULT NULL,
  `modify_user_id` varchar(32) DEFAULT NULL,
  `modify_date` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "mum_org"
#

INSERT INTO `mum_org` VALUES ('01f769200a5448d4a579fb94c21d8f58',NULL,'3b6c7029852f472d9b6cbcccd4997725','dept_zh','/coo/dept_zh','综合部','',NULL,'','','','','2',NULL,'iris','2014-10-15 14:16:07','iris','2014-10-15 14:16:07'),('0af63144b5054d28bc86374eed98dcb8',NULL,'8eb220d65a474430a01c083a0255f0f4','0001','/coo/003/004/0001','政府事业部','',NULL,'','','','','2',NULL,'1','2014-09-28 10:13:28','1','2014-09-28 10:13:28'),('1f9347e56bb34d1a83bcdcec61133db9',NULL,NULL,'CH05',NULL,'测试机构','','1',NULL,NULL,NULL,'杨明','1',NULL,NULL,'2014-10-10 16:14:23',NULL,'2014-10-10 16:14:23'),('2a10f93830d448bcabf5cc594a5618c4',NULL,NULL,'CH041',NULL,'测试机构1','','1',NULL,'北京市海淀区',NULL,'杨明','1',NULL,NULL,'2014-10-13 16:18:24',NULL,'2014-10-13 16:18:24'),('3b6c7029852f472d9b6cbcccd4997725',NULL,'-1','orgcode1','/coo','cooperlink','18888888888','1','010-888888-4','base_mdm','base_mdm','zhangsan','1',NULL,NULL,'2014-08-26 11:00:13',NULL,NULL),('3b7809b4accc49f69ba51c56885ae9c4',NULL,'-1','CH06',NULL,'测试机构','','1',NULL,'北京市海淀区',NULL,'杨明','1',NULL,'iris','2014-10-16 17:50:22','iris','2014-10-16 17:50:22');

#
# Source for table "mum_rs_org_user"
#

DROP TABLE IF EXISTS `mum_rs_org_user`;
CREATE TABLE `mum_rs_org_user` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `user_id` varchar(32) DEFAULT NULL,
  `org_id` varchar(32) DEFAULT NULL,
  `org_type` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "mum_rs_org_user"
#


#
# Source for table "mum_user"
#

DROP TABLE IF EXISTS `mum_user`;
CREATE TABLE `mum_user` (
  `user_id` varchar(32) NOT NULL DEFAULT '',
  `cfg_index` varchar(10) DEFAULT NULL,
  `user_code` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `ename` varchar(20) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL,
  `modify_psw_time` varchar(20) DEFAULT NULL,
  `mobile_phone` varchar(20) DEFAULT NULL,
  `office_phone` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `identity_no` varchar(20) DEFAULT NULL,
  `user_pic` varchar(50) DEFAULT NULL,
  `entry_time` varchar(20) DEFAULT NULL,
  `user_title` varchar(20) DEFAULT NULL,
  `user_post` varchar(20) DEFAULT NULL,
  `user_country` varchar(20) DEFAULT NULL,
  `user_nation` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `comment_info` varchar(300) DEFAULT NULL,
  `user_sts` varchar(2) DEFAULT NULL,
  `ext_pro` varchar(1000) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `create_date` varchar(20) DEFAULT NULL,
  `modify_user_id` varchar(32) DEFAULT NULL,
  `modify_date` varchar(20) DEFAULT NULL,
  `is_delete` char(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "mum_user"
#

INSERT INTO `mum_user` VALUES ('0121d5dc37424bc39c0f5f1ee40749fb',NULL,'beijingtest1','孙阳30',NULL,'e10adc3949ba59abbe56e057f20f883e','2014-10-09 11:02:06','','','1',NULL,NULL,NULL,'','','','','','','1',NULL,NULL,'2014-09-28 11:31:27',NULL,'2014-09-28 11:31:27','0'),('078caee2022f4d44a686132aec8414c8',NULL,'beijingtest2','孙阳23',NULL,'e10adc3949ba59abbe56e057f20f883e',NULL,'','','1',NULL,NULL,NULL,'','','','','','','2',NULL,NULL,'2014-09-28 11:31:27',NULL,'2014-09-28 11:31:27','0'),('0c9fd81cebab49e59e6966b3a06acc74',NULL,'beijingtest3','孙阳41',NULL,'e10adc3949ba59abbe56e057f20f883e',NULL,'','','1',NULL,NULL,NULL,'','','','','','','1',NULL,NULL,'2014-09-28 11:31:27',NULL,'2014-09-28 11:31:27','0'),('0df2fa66fa4c4c55ad76a55612110ed9',NULL,'beijingtest4','孙阳33',NULL,'e10adc3949ba59abbe56e057f20f883e','2014-10-09 11:01:11','','','1',NULL,NULL,NULL,'','','','','','','1',NULL,NULL,'2014-09-28 11:31:27',NULL,'2014-09-28 11:31:27','0'),('12e534c5f604459b85ee0aa6ad86833c',NULL,'beijingtest5','孙阳62',NULL,'e10adc3949ba59abbe56e057f20f883e',NULL,'','','1',NULL,NULL,NULL,'','','','','','','1',NULL,NULL,'2014-09-28 11:31:27',NULL,'2014-09-28 11:31:27','0'),('13b371721fc446979f8b7fd14db01769',NULL,'beijingtest6','孙阳49',NULL,'e10adc3949ba59abbe56e057f20f883e',NULL,'','','1',NULL,NULL,NULL,'','','','','','','1',NULL,NULL,'2014-09-28 11:31:27',NULL,'2014-09-28 11:31:27','0'),('148ba804830d4f3b84f79dcad214e1ae',NULL,'beijingtest7','CasperNO','Casper','e10adc3949ba59abbe56e057f20f883e',NULL,'876688','18778899','',NULL,NULL,NULL,'','','','','chongyuan.yang@gmail.com','','1',NULL,'iris','2014-11-12 14:32:25','iris','2014-11-12 14:32:25','0'),('153c34ced36b46589ab374070a1cd46c',NULL,'beijingtest8','刘','ss','e10adc3949ba59abbe56e057f20f883e','2014-10-29 14:44:02','','','0',NULL,NULL,'','','','','','','','1',NULL,'emily','2014-10-29 14:44:02','emily','2014-10-29 14:44:01','0'),('16316a453413485fa511443ab547c36b',NULL,'beijingtest9','CasperNO','Casper','e10adc3949ba59abbe56e057f20f883e',NULL,'876688','18778899','',NULL,NULL,NULL,'','','','','chongyuan.yang@gmail.com','','1',NULL,'iris','2014-11-12 14:41:31','iris','2014-11-12 14:41:31','0'),('181646cad59b40cc9b8a7a72f5ceab83',NULL,'beijingtest10','Casperman15','Casper','e10adc3949ba59abbe56e057f20f883e',NULL,'876688','18778899','1',NULL,NULL,NULL,'','','','','','','1',NULL,'iris','2014-11-12 14:33:50','iris','2014-11-12 14:33:50','0'),('18d3f2c170094a608b32a5b1c2fe5712',NULL,'beijingtest11','孙阳60',NULL,'e10adc3949ba59abbe56e057f20f883e',NULL,'','','1',NULL,NULL,NULL,'','','','','','','2',NULL,NULL,'2014-09-28 11:31:27',NULL,'2014-09-28 11:31:27','0');
