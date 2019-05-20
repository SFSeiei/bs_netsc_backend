/*
Navicat MySQL Data Transfer

Source Server         : localhostmysql
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : db_bs_netsc

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2019-05-11 07:43:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_address
-- ----------------------------
DROP TABLE IF EXISTS `tb_address`;
CREATE TABLE `tb_address` (
  `addId` bigint(20) NOT NULL auto_increment COMMENT '地址ID',
  `addName` varchar(255) default NULL COMMENT '地址名称',
  `uId` varchar(255) default NULL COMMENT '用户ID',
  `linkmanName` varchar(50) default NULL COMMENT '联系人名字',
  `qqNumber` varchar(50) default NULL,
  `telphone` bigint(20) default NULL COMMENT '联系人电话',
  PRIMARY KEY  (`addId`),
  KEY `FK_usersToAdd` (`uId`),
  CONSTRAINT `FK_usersToAdd` FOREIGN KEY (`uId`) REFERENCES `tb_users` (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COMMENT='��ַ��';

-- ----------------------------
-- Records of tb_address
-- ----------------------------
INSERT INTO `tb_address` VALUES ('1', '天津市西青区宾水西道399号天津工业大学', 'fd43d710062240db833ef4fb6e80b290', '张学友', null, '15620225280');
INSERT INTO `tb_address` VALUES ('2', '天津市西青区宾水西道399号 ', 'fd43d710062240db833ef4fb6e80b290', '刘德华', null, '123321');
INSERT INTO `tb_address` VALUES ('3', '软件园五号楼', 'fd43d710062240db833ef4fb6e80b290', '郭富城', null, '12356516');
INSERT INTO `tb_address` VALUES ('4', null, '9194aff898854f1b8541ff01febdefe3', null, null, null);
INSERT INTO `tb_address` VALUES ('5', null, '9194aff898854f1b8541ff01febdefe3', null, null, null);
INSERT INTO `tb_address` VALUES ('6', null, 'fd43d710062240db833ef4fb6e80b290', null, null, null);
INSERT INTO `tb_address` VALUES ('7', null, 'fd43d710062240db833ef4fb6e80b290', null, null, null);
INSERT INTO `tb_address` VALUES ('8', null, 'fd43d710062240db833ef4fb6e80b290', null, null, null);
INSERT INTO `tb_address` VALUES ('9', null, 'fd43d710062240db833ef4fb6e80b290', null, null, null);
INSERT INTO `tb_address` VALUES ('10', null, 'fd43d710062240db833ef4fb6e80b290', null, null, null);
INSERT INTO `tb_address` VALUES ('11', null, 'fd43d710062240db833ef4fb6e80b290', null, null, null);
INSERT INTO `tb_address` VALUES ('12', null, 'fd43d710062240db833ef4fb6e80b290', null, null, null);
INSERT INTO `tb_address` VALUES ('13', null, 'fd43d710062240db833ef4fb6e80b290', null, null, null);
INSERT INTO `tb_address` VALUES ('14', null, 'fd43d710062240db833ef4fb6e80b290', null, null, null);
INSERT INTO `tb_address` VALUES ('15', '天津市西青区宾水西道399号', 'add3d5483cd74118b6d50107dcb434e9', '猪八戒', null, '15620225280');
INSERT INTO `tb_address` VALUES ('18', '天津市西青区宾水西道399号', '43967f402b564f519c65732c7341d0a4', '刘德华', null, '123321');
INSERT INTO `tb_address` VALUES ('26', '天津市西青区宾水西道399号', 'add3d5483cd74118b6d50107dcb434e9', '刘德华', null, '111456');
INSERT INTO `tb_address` VALUES ('30', '天津市西青区宾水西道399号', '74b12381d98a4a90940c4f47e9025969', '猪八戒', null, '123321');
INSERT INTO `tb_address` VALUES ('31', 'sdf', 'adfeedb812ed4fe7b29aa8e5a82e0941', 'sdf', null, '123');
INSERT INTO `tb_address` VALUES ('34', 'qweerer', 'adfeedb812ed4fe7b29aa8e5a82e0941', 'qweqweqwe', null, '456456');
INSERT INTO `tb_address` VALUES ('35', 'dsf', '448f6b6068b1483ba23ac20e8afd2ec2', 'sdf', null, '456');
INSERT INTO `tb_address` VALUES ('36', 'sdf', '5360937a0cac45578c9b2dfd9a16cfce', 'sdf', null, '123');

-- ----------------------------
-- Table structure for tb_bigcategories
-- ----------------------------
DROP TABLE IF EXISTS `tb_bigcategories`;
CREATE TABLE `tb_bigcategories` (
  `bCId` bigint(20) NOT NULL auto_increment COMMENT '商品类型ID',
  `bCName` varchar(50) default NULL COMMENT '商品类型名称',
  PRIMARY KEY  (`bCId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='��Ʒ�����';

-- ----------------------------
-- Records of tb_bigcategories
-- ----------------------------
INSERT INTO `tb_bigcategories` VALUES ('1', '鱼类');
INSERT INTO `tb_bigcategories` VALUES ('2', '青菜类');
INSERT INTO `tb_bigcategories` VALUES ('3', '干货类');
INSERT INTO `tb_bigcategories` VALUES ('4', '肉类');
INSERT INTO `tb_bigcategories` VALUES ('5', '水产类');
INSERT INTO `tb_bigcategories` VALUES ('6', '瓜类');
INSERT INTO `tb_bigcategories` VALUES ('7', '菌类');
INSERT INTO `tb_bigcategories` VALUES ('8', '烧烤类');

-- ----------------------------
-- Table structure for tb_deliver
-- ----------------------------
DROP TABLE IF EXISTS `tb_deliver`;
CREATE TABLE `tb_deliver` (
  `dId` bigint(20) NOT NULL auto_increment,
  `sId` bigint(20) default NULL,
  `dName` varchar(50) default NULL,
  `dPrice` bigint(20) default NULL,
  `dDescribe` varchar(50) default NULL,
  `dRemark` varchar(50) default NULL,
  `dState` varchar(50) default NULL,
  PRIMARY KEY  (`dId`),
  KEY `FK_shopToDeliver` (`sId`),
  CONSTRAINT `FK_shopToDeliver` FOREIGN KEY (`sId`) REFERENCES `tb_shops` (`sId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�ͻ���ʽ��';

-- ----------------------------
-- Records of tb_deliver
-- ----------------------------

-- ----------------------------
-- Table structure for tb_distributors
-- ----------------------------
DROP TABLE IF EXISTS `tb_distributors`;
CREATE TABLE `tb_distributors` (
  `dId` bigint(20) NOT NULL auto_increment COMMENT '派送人员ID',
  `sId` bigint(20) default NULL COMMENT '店铺ID',
  `dName` varchar(50) default NULL COMMENT '派送人员名字',
  `dState` varchar(50) default NULL COMMENT '派送人员状态',
  PRIMARY KEY  (`dId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_distributors
-- ----------------------------
INSERT INTO `tb_distributors` VALUES ('1', '2', '猪刚烈', '空闲');
INSERT INTO `tb_distributors` VALUES ('2', '2', '猪老三', '空闲');
INSERT INTO `tb_distributors` VALUES ('4', '1', '猪老四', '忙碌');
INSERT INTO `tb_distributors` VALUES ('6', '0', 'string', 'string');
INSERT INTO `tb_distributors` VALUES ('8', '12', '唐小三', '空闲');
INSERT INTO `tb_distributors` VALUES ('9', '1', '猪老五', '忙碌');
INSERT INTO `tb_distributors` VALUES ('10', '1', '猪老六', '空闲');

-- ----------------------------
-- Table structure for tb_orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_orderinfo`;
CREATE TABLE `tb_orderinfo` (
  `oIId` bigint(20) NOT NULL auto_increment COMMENT '订单信息ID',
  `orderId` bigint(20) default NULL COMMENT '订单ID',
  `pId` bigint(20) default NULL COMMENT '商品ID',
  `pName` varchar(50) default NULL COMMENT '商品名称',
  `pNumber` bigint(20) default NULL COMMENT '商品数量',
  `pPrice` double(20,2) default NULL COMMENT '商品价格',
  PRIMARY KEY  (`oIId`),
  KEY `FK_Reference_24` (`orderId`),
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`orderId`) REFERENCES `tb_orders` (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8 COMMENT='������ϸ��';

-- ----------------------------
-- Records of tb_orderinfo
-- ----------------------------
INSERT INTO `tb_orderinfo` VALUES ('106', '63', '1', '草鱼', '1', '7.55');
INSERT INTO `tb_orderinfo` VALUES ('107', '63', '2', '章鱼', '1', '9.98');
INSERT INTO `tb_orderinfo` VALUES ('108', '64', '5', '卷心菜', '1', '3.99');
INSERT INTO `tb_orderinfo` VALUES ('109', '64', '6', '草鱼', '1', '5.99');
INSERT INTO `tb_orderinfo` VALUES ('110', '64', '7', '波菜', '1', '3.99');
INSERT INTO `tb_orderinfo` VALUES ('111', '64', '8', '章鱼', '1', '6.99');
INSERT INTO `tb_orderinfo` VALUES ('112', '66', '13', '草鱼', '1', '5.99');
INSERT INTO `tb_orderinfo` VALUES ('113', '67', '14', '章鱼', '1', '6.99');
INSERT INTO `tb_orderinfo` VALUES ('114', '67', '15', '菠菜', '1', '3.59');
INSERT INTO `tb_orderinfo` VALUES ('115', '67', '14', '章鱼', '1', '6.99');
INSERT INTO `tb_orderinfo` VALUES ('116', '71', '13', '草鱼', '1', '5.99');
INSERT INTO `tb_orderinfo` VALUES ('117', '67', '15', '菠菜', '1', '3.59');
INSERT INTO `tb_orderinfo` VALUES ('118', '71', '12', '卷心菜', '1', '2.99');
INSERT INTO `tb_orderinfo` VALUES ('119', '73', '13', '草鱼', '1', '5.99');
INSERT INTO `tb_orderinfo` VALUES ('120', '74', '14', '章鱼', '1', '6.99');
INSERT INTO `tb_orderinfo` VALUES ('121', '71', '13', '草鱼', '1', '5.99');
INSERT INTO `tb_orderinfo` VALUES ('122', '71', '18', '鲭鱼', '1', '3.69');
INSERT INTO `tb_orderinfo` VALUES ('123', '76', '13', '草鱼', '1', '5.99');
INSERT INTO `tb_orderinfo` VALUES ('124', '76', '12', '卷心菜', '1', '2.99');

-- ----------------------------
-- Table structure for tb_orders
-- ----------------------------
DROP TABLE IF EXISTS `tb_orders`;
CREATE TABLE `tb_orders` (
  `orderId` bigint(20) NOT NULL auto_increment COMMENT '订单ID',
  `uId` varchar(255) default NULL COMMENT '用户ID',
  `proPrice` double(20,2) default NULL,
  `proPoint` bigint(20) default NULL,
  `mPrice` double(20,2) default NULL COMMENT '订单价钱',
  `createTime` varchar(50) default NULL COMMENT '创建时间',
  `getGWay` varchar(50) default NULL COMMENT '收货方式',
  `sendGTime` varchar(50) default NULL COMMENT '发货时间',
  `getGTime` varchar(50) default NULL COMMENT '收货时间',
  `payWay` varchar(50) default NULL COMMENT '付款方式',
  `payTime` varchar(50) default NULL COMMENT '付款时间',
  `oState` varchar(50) default NULL COMMENT '订单状态',
  `oComment` varchar(50) default NULL COMMENT '订单评价',
  `getAddress` varchar(255) default NULL COMMENT '收货地址',
  `linkmanName` varchar(50) default NULL COMMENT '联系人名字',
  `telphone` bigint(20) default NULL COMMENT '联系人电话',
  `sId` bigint(20) default NULL COMMENT '店铺ID',
  `dId` bigint(20) default NULL COMMENT '派送人员ID',
  `dName` varchar(50) default NULL COMMENT '派送人员名字',
  PRIMARY KEY  (`orderId`),
  KEY `FK_userToOrder` (`uId`),
  CONSTRAINT `FK_userToOrder` FOREIGN KEY (`uId`) REFERENCES `tb_users` (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='������Ϣ��';

-- ----------------------------
-- Records of tb_orders
-- ----------------------------
INSERT INTO `tb_orders` VALUES ('63', '43967f402b564f519c65732c7341d0a4', '0.00', null, '17.53', '2019-04-23 15:18:06', '配送', '2019-05-08 10:44:37', null, '在线付款', '2019-04-23 15:22:55', '已发货', null, '天津市西青区宾水西道399号', '刘德华', '123321', '1', '9', '猪老五');
INSERT INTO `tb_orders` VALUES ('64', '74b12381d98a4a90940c4f47e9025969', '0.00', null, '9.98', '2019-04-26 14:32:40', '配送', '2019-04-26 14:36:11', '2019-04-26 14:37:14', '在线付款', '2019-04-26 14:34:2', '已完成', 'sdfdsf', '天津市西青区宾水西道399号', '猪八戒', '123321', '1', '3', '猪大炮');
INSERT INTO `tb_orders` VALUES ('65', '74b12381d98a4a90940c4f47e9025969', '0.00', null, '10.98', '2019-04-26 14:32:40', '配送', null, null, null, null, '未付款', null, '天津市西青区宾水西道399号', '猪八戒', '123321', '2', null, null);
INSERT INTO `tb_orders` VALUES ('66', 'add3d5483cd74118b6d50107dcb434e9', '0.00', null, '8.98', '2019-04-29 00:06:40', '配送', null, null, '在线付款', '2019-04-29 0:16:10', '已付款', null, '天津市西青区宾水西道399号', '猪八戒', '15620225280', '1', '0', null);
INSERT INTO `tb_orders` VALUES ('67', 'add3d5483cd74118b6d50107dcb434e9', '0.00', null, '10.58', '2019-04-29 00:06:40', '配送', null, null, '在线付款', '2019-05-07 0:10:29', '已付款', null, '天津市西青区宾水西道399号', '猪八戒', '15620225280', '2', '0', null);
INSERT INTO `tb_orders` VALUES ('68', 'adfeedb812ed4fe7b29aa8e5a82e0941', '0.00', null, '2.99', '2019-04-29 11:43:48', '配送', null, null, '在线付款', '2019-04-29 11:52:26', '已付款', null, 'sdf', 'sdf', '123', '1', '0', null);
INSERT INTO `tb_orders` VALUES ('69', '448f6b6068b1483ba23ac20e8afd2ec2', '0.00', null, '5.99', '2019-04-30 10:51:45', '配送', '2019-04-30 10:54:51', '2019-04-30 10:55:19', '在线付款', '2019-04-30 10:53:30', '已完成', 'sdfsd', 'dsf', 'sdf', '456', '1', '3', '猪大炮');
INSERT INTO `tb_orders` VALUES ('70', 'add3d5483cd74118b6d50107dcb434e9', '0.00', null, '8.98', '2019-05-07 00:08:45', '配送', null, null, null, null, '未付款', null, '天津市西青区宾水西道399号', '猪八戒', '15620225280', '1', null, null);
INSERT INTO `tb_orders` VALUES ('71', 'add3d5483cd74118b6d50107dcb434e9', '0.00', null, '10.58', '2019-05-07 00:08:45', '配送', null, null, '在线付款', '2019-05-07 0:10:29', '已付款', null, '天津市西青区宾水西道399号', '猪八戒', '15620225280', '2', '0', null);
INSERT INTO `tb_orders` VALUES ('72', '5360937a0cac45578c9b2dfd9a16cfce', '0.00', null, '5.99', '2019-05-07 23:28:06', '配送', null, null, null, null, '未付款', null, 'sdf', 'sdf', '123', '1', null, null);
INSERT INTO `tb_orders` VALUES ('73', '5360937a0cac45578c9b2dfd9a16cfce', '0.00', null, '5.99', '2019-05-07 23:28:58', '配送', null, null, null, null, '未付款', null, 'sdf', 'sdf', '123', '1', null, null);
INSERT INTO `tb_orders` VALUES ('74', '5360937a0cac45578c9b2dfd9a16cfce', '0.00', null, '6.99', '2019-05-07 23:29:14', '配送', null, null, null, null, '未付款', null, 'sdf', 'sdf', '123', '2', null, null);
INSERT INTO `tb_orders` VALUES ('75', 'add3d5483cd74118b6d50107dcb434e9', '0.00', null, '9.68', '2019-05-08 10:27:09', '配送', null, null, null, null, '未付款', null, '天津市西青区宾水西道399号', '猪八戒', '15620225280', '1', null, null);
INSERT INTO `tb_orders` VALUES ('76', 'add3d5483cd74118b6d50107dcb434e9', '0.00', null, '8.98', '2019-05-08 10:28:11', '配送', '2019-05-08 10:46:11', '2019-05-08 10:48:32', '在线付款', '2019-05-08 10:30:25', '已完成', '真是一次完美的购物体验！', '天津市西青区宾水西道399号', '猪八戒', '15620225280', '1', '10', '猪老六');

-- ----------------------------
-- Table structure for tb_payway
-- ----------------------------
DROP TABLE IF EXISTS `tb_payway`;
CREATE TABLE `tb_payway` (
  `pWId` bigint(20) NOT NULL auto_increment,
  `pWName` varchar(50) default NULL,
  `pWAccount` bigint(20) default NULL,
  `sId` bigint(20) default NULL,
  `pWState` varchar(50) default NULL,
  PRIMARY KEY  (`pWId`),
  KEY `FK_shopToPayWay` (`sId`),
  CONSTRAINT `FK_shopToPayWay` FOREIGN KEY (`sId`) REFERENCES `tb_shops` (`sId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='֧����ʽ��';

-- ----------------------------
-- Records of tb_payway
-- ----------------------------

-- ----------------------------
-- Table structure for tb_productphotos
-- ----------------------------
DROP TABLE IF EXISTS `tb_productphotos`;
CREATE TABLE `tb_productphotos` (
  `pPId` bigint(20) NOT NULL auto_increment COMMENT '商品图片ID',
  `pPurl` varchar(255) default NULL COMMENT '商品图片',
  `pId` bigint(20) default NULL COMMENT '商品ID',
  PRIMARY KEY  (`pPId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_productphotos
-- ----------------------------
INSERT INTO `tb_productphotos` VALUES ('1', 'http://localhost:8080/netsc/img/productPhotos/1fbb4064-fe87-4f31-99fd-29cb7763be1b.jpg', '3');
INSERT INTO `tb_productphotos` VALUES ('4', 'http://localhost:8080/netsc/img/productPhotos/ffa7755d-a842-4958-8fe1-c0ff42a54d8c.jpg', '2');
INSERT INTO `tb_productphotos` VALUES ('5', 'http://localhost:8080/netsc/img/productPhotos/dc182bab-c2a0-4c92-ae38-c1163c9dbb22.jpg', '2');
INSERT INTO `tb_productphotos` VALUES ('6', 'http://localhost:8080/netsc/img/productPhotos/a3c2af17-5e50-4113-be15-6c8faad38b3d.jpg', '2');
INSERT INTO `tb_productphotos` VALUES ('7', 'http://localhost:8080/netsc/img/productPhotos/9332cb1b-b20d-4a0e-a19e-bcbdc15b038d.jpg', '20');
INSERT INTO `tb_productphotos` VALUES ('8', 'http://localhost:8080/netsc/img/productPhotos/89ed3a24-5e54-4f9f-b359-2cec2865c953.jpg', '20');
INSERT INTO `tb_productphotos` VALUES ('9', 'http://localhost:8080/netsc/img/productPhotos/cd786c3d-6e74-43ff-874b-656aa23544ac.jpg', '20');
INSERT INTO `tb_productphotos` VALUES ('10', 'http://localhost:8080/netsc/img/productPhotos/afdb6429-a1dc-4c40-89ff-94276c761bc7.jpg', '12');
INSERT INTO `tb_productphotos` VALUES ('13', 'http://localhost:8080/netsc/img/productPhotos/4cb7dc3a-05be-4946-96f6-511157ae2351.jpg', '12');

-- ----------------------------
-- Table structure for tb_products
-- ----------------------------
DROP TABLE IF EXISTS `tb_products`;
CREATE TABLE `tb_products` (
  `pId` bigint(20) NOT NULL auto_increment COMMENT '商品ID',
  `bCId` bigint(20) default NULL COMMENT '商品类型ID',
  `pName` varchar(50) default NULL COMMENT '商品名称',
  `bCName` varchar(20) default NULL COMMENT '商品类型名称',
  `sId` bigint(20) default NULL COMMENT '店铺ID',
  `pState` varchar(50) default NULL COMMENT '商品状态',
  `pReleaseTime` varchar(50) default NULL COMMENT '上架时间',
  `pPhoto` varchar(255) default NULL COMMENT '商品图片',
  `pPrice` double(20,2) default NULL COMMENT '商品价格',
  `pMemPrice` double(20,2) default NULL COMMENT '平台价格',
  `pDescribe` varchar(50) default NULL COMMENT '商品描述',
  `sellTime` varchar(50) default NULL,
  `overTime` varchar(50) default NULL,
  `sName` varchar(50) default NULL COMMENT '店铺名称',
  PRIMARY KEY  (`pId`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COMMENT='tb_products';

-- ----------------------------
-- Records of tb_products
-- ----------------------------
INSERT INTO `tb_products` VALUES ('12', '2', '卷心菜', '青菜类', '1', '在售', '2019-04-26 20:52:13', 'http://localhost:8080/netsc/img/productPhotos/794620aa-a5e0-430b-bd06-223cc596c744.jpg', '2.99', '2.59', '一般的卷心菜', null, null, '天津工业大学猪八戒蔬菜店');
INSERT INTO `tb_products` VALUES ('13', '1', '草鱼', '鱼类', '1', '在售', '2019-04-26 20:52:54', 'http://localhost:8080/netsc/img/productPhotos/64da2bac-f05d-4c81-a1b1-68039c5274cd.jpg', '5.99', '3.99', '一般的草鱼', null, null, '天津工业大学猪八戒蔬菜店');
INSERT INTO `tb_products` VALUES ('14', '1', '章鱼', '鱼类', '2', '在售', '2019-04-26 20:54:06', 'http://localhost:8080/netsc/img/productPhotos/d8bc9158-c2a5-45a9-b467-e93df1fd5378.jpg', '6.99', '6.59', '一般的章鱼', null, null, '猪八戒天津南开店');
INSERT INTO `tb_products` VALUES ('15', '2', '菠菜', '青菜类', '2', '在售', '2019-04-26 20:54:34', 'http://localhost:8080/netsc/img/productPhotos/9c33b741-81cf-40c2-ab7f-cd6735f461e7.jpg', '3.59', '2.99', '一般的菠菜', null, null, '猪八戒天津南开店');
INSERT INTO `tb_products` VALUES ('16', '1', '鲭鱼', '鱼类', '11', '在售', '2019-04-26 20:57:29', 'http://localhost:8080/netsc/img/productPhotos/d7fce71c-3edb-4cad-9c23-4d5c8cac8f1b.jpg', '3.99', '2.99', '一般的鲭鱼', null, null, '天津南开店');
INSERT INTO `tb_products` VALUES ('17', '2', '花菜', '青菜类', '11', '在售', '2019-04-26 20:57:55', 'http://localhost:8080/netsc/img/productPhotos/59e824c1-9c49-49eb-8183-eff611d20b24.jpg', '3.99', '3.49', '一般的花菜', null, null, '天津南开店');
INSERT INTO `tb_products` VALUES ('18', '1', '鲭鱼', '鱼类', '1', '在售', '2019-04-26 21:10:57', 'http://localhost:8080/netsc/img/productPhotos/bdf22823-cb46-4e82-b74c-6bec5ccfd876.jpg', '3.69', '2.99', '一般的鲭鱼', null, null, '天津工业大学猪八戒蔬菜店');
INSERT INTO `tb_products` VALUES ('19', '2', '菜花', '青菜类', '1', '在售', '2019-04-26 21:11:38', 'http://localhost:8080/netsc/img/productPhotos/5ed5744e-68c9-4ed2-b425-f666a5f415bc.jpg', '1.99', '0.99', '一般的菜花', null, null, '天津工业大学猪八戒蔬菜店');
INSERT INTO `tb_products` VALUES ('20', '1', '猪肉', '鱼类', '12', '在售', '2019-04-29 09:52:35', 'http://localhost:8080/netsc/img/productPhotos/bcf51f60-80f4-4427-8de9-fbd99a30d2b6.jpg', '5.99', '5.49', '一般的猪肉', null, null, '唐僧肉南开店');
INSERT INTO `tb_products` VALUES ('21', '1', '草鱼', '鱼类', '13', '在售', '2019-04-30 10:49:34', 'http://localhost:8080/netsc/img/productPhotos/ffd5483b-93d0-4507-ab29-030cfb73e645.jpg', '5.99', '5.49', 'dsf', null, null, 'ert');
INSERT INTO `tb_products` VALUES ('22', '1', '卷心菜', '鱼类', '13', '在售', '2019-04-30 10:50:04', 'http://localhost:8080/netsc/img/productPhotos/52fc97f2-f198-46b9-ada8-de517d09534f.jpg', '2.99', '3.99', 'sdfsd', null, null, 'ert');
INSERT INTO `tb_products` VALUES ('23', '1', '猪肉', '鱼类', '13', '在售', '2019-04-30 10:50:33', 'http://localhost:8080/netsc/img/productPhotos/7954e4c6-034c-488c-b266-b9fe9987aca4.jpg', '3.99', '3.49', 'sdf', null, null, 'ert');

-- ----------------------------
-- Table structure for tb_roles
-- ----------------------------
DROP TABLE IF EXISTS `tb_roles`;
CREATE TABLE `tb_roles` (
  `roleId` bigint(20) NOT NULL auto_increment COMMENT '角色ID',
  `roleName` varchar(50) default NULL COMMENT '角色名称',
  PRIMARY KEY  (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='��ɫ��';

-- ----------------------------
-- Records of tb_roles
-- ----------------------------
INSERT INTO `tb_roles` VALUES ('1', '管理员');
INSERT INTO `tb_roles` VALUES ('2', '一般用户');
INSERT INTO `tb_roles` VALUES ('3', '个人商家');

-- ----------------------------
-- Table structure for tb_shoppingpoints
-- ----------------------------
DROP TABLE IF EXISTS `tb_shoppingpoints`;
CREATE TABLE `tb_shoppingpoints` (
  `gPId` bigint(20) NOT NULL,
  `buyGoods` varchar(50) default NULL,
  `pointNumber` bigint(20) default NULL,
  `uIId` bigint(20) default NULL,
  PRIMARY KEY  (`gPId`),
  KEY `FK_Reference_22` (`uIId`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`uIId`) REFERENCES `tb_userinfo` (`uIId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������ֱ�';

-- ----------------------------
-- Records of tb_shoppingpoints
-- ----------------------------

-- ----------------------------
-- Table structure for tb_shops
-- ----------------------------
DROP TABLE IF EXISTS `tb_shops`;
CREATE TABLE `tb_shops` (
  `sId` bigint(20) NOT NULL auto_increment COMMENT '店铺ID',
  `sName` varchar(50) default NULL COMMENT '店铺名称',
  `sLogo` varchar(50) default NULL,
  `sTrademark` varchar(50) default NULL,
  `bScope` varchar(50) default NULL COMMENT '类型名称',
  `sAddress` varchar(255) default NULL COMMENT '店铺地址',
  `shopMan` varchar(50) default NULL COMMENT '店铺联系人',
  `shopManTel` bigint(20) default NULL COMMENT '联系人电话',
  `shopState` varchar(50) default NULL COMMENT '店铺状态',
  `sRegisteTime` varchar(50) default NULL COMMENT '添加时间',
  `sDescribe` varchar(50) default NULL COMMENT '店铺描述',
  `sPayDescribe` varchar(255) default NULL COMMENT '支付类型',
  `sPayNumber` varchar(50) default NULL COMMENT '支付密码',
  `deliveryDescribe` varchar(50) default NULL COMMENT '送货方式',
  `shopAuth` varchar(50) default NULL,
  `pointExDescribe` varchar(50) default NULL,
  `uId` varchar(255) default NULL COMMENT '用户ID',
  PRIMARY KEY  (`sId`),
  KEY `FK_Relationship_7` USING BTREE (`uId`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`uId`) REFERENCES `tb_users` (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='�̼ұ�';

-- ----------------------------
-- Records of tb_shops
-- ----------------------------
INSERT INTO `tb_shops` VALUES ('1', '天津工业大学猪八戒蔬菜店', null, null, '青菜，干货类，瓜类', '天津市西青区宾水西道399号 ', '猪八戒', '15620225280', '营业中', '2019-04-14 18:23:59', '本店主要经营青菜，干货类，瓜类', '个人钱包付款', '15620225280', '配送', null, null, 'add3d5483cd74118b6d50107dcb434e9');
INSERT INTO `tb_shops` VALUES ('2', '猪八戒天津南开店', null, null, '肉类', '天津和平区', '猪八戒', '15620225280', '营业中', '2019-04-14 21:15:35', '本店主要经营鱼类', '个人钱包付款', '15620225280', '配送', null, null, 'add3d5483cd74118b6d50107dcb434e9');
INSERT INTO `tb_shops` VALUES ('11', '天津南开店', null, null, '肉类', '南开区', '朱老三', '123123123', '营业中', '2019-04-25 18:36:34', '主要经营肉类', '个人钱包付款', null, '配送', null, null, 'add3d5483cd74118b6d50107dcb434e9');
INSERT INTO `tb_shops` VALUES ('12', '唐僧肉南开店', null, null, '肉类', '南开区', '孙悟空', '123456', '营业中', '2019-04-29 09:45:55', '主要经营肉类', '个人钱包付款', null, '配送', null, null, 'adfeedb812ed4fe7b29aa8e5a82e0941');
INSERT INTO `tb_shops` VALUES ('13', 'ert', null, null, 'ert', 'ert', 'ert', '12345', '营业中', '2019-04-30 10:48:34', 'ert', '个人钱包付款', null, '配送', null, null, '448f6b6068b1483ba23ac20e8afd2ec2');

-- ----------------------------
-- Table structure for tb_trolley
-- ----------------------------
DROP TABLE IF EXISTS `tb_trolley`;
CREATE TABLE `tb_trolley` (
  `tId` bigint(20) NOT NULL auto_increment COMMENT '购物车ID',
  `pId` bigint(20) default NULL COMMENT '商品ID',
  `uId` varchar(255) default NULL COMMENT '用户ID',
  `pNumber` bigint(20) default NULL COMMENT '商品数量',
  `pPrice` double(20,2) default NULL COMMENT '商品价格',
  `getPTime` varchar(50) default NULL COMMENT '加入购物车时间',
  `pName` varchar(50) default NULL COMMENT '商品名称',
  `sId` bigint(20) default NULL COMMENT '店铺ID',
  PRIMARY KEY  (`tId`),
  KEY `FK_userToTrolley` (`uId`),
  KEY `FK_shopToTrolley` USING BTREE (`sId`),
  CONSTRAINT `FK_shopToTrolley` FOREIGN KEY (`sId`) REFERENCES `tb_shops` (`sId`),
  CONSTRAINT `FK_userToTrolley` FOREIGN KEY (`uId`) REFERENCES `tb_users` (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='���ﳵ��';

-- ----------------------------
-- Records of tb_trolley
-- ----------------------------
INSERT INTO `tb_trolley` VALUES ('2', '2', '49e35232518248b59e84c443a8b1ae58', '1', '9.98', '2019-04-15 23:51:12', '章鱼', null);
INSERT INTO `tb_trolley` VALUES ('3', '1', '49e35232518248b59e84c443a8b1ae58', '1', '7.55', '2019-04-15 23:52:00', '草鱼', null);
INSERT INTO `tb_trolley` VALUES ('5', '3', '212c8b85f10a4f6eb70a5dbcaa538c78', '1', '3.49', '2019-04-16 09:49:20', '卷心菜', null);
INSERT INTO `tb_trolley` VALUES ('6', '13', null, '1', '5.99', '2019-04-27 20:24:29', '草鱼', '1');
INSERT INTO `tb_trolley` VALUES ('7', '13', null, '1', '5.99', '2019-04-27 20:24:54', '草鱼', '1');
INSERT INTO `tb_trolley` VALUES ('8', '12', null, '1', '2.99', '2019-04-28 17:13:03', '卷心菜', '1');
INSERT INTO `tb_trolley` VALUES ('16', '12', 'adfeedb812ed4fe7b29aa8e5a82e0941', '1', '2.99', '2019-04-29 11:45:34', '卷心菜', '1');

-- ----------------------------
-- Table structure for tb_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_userinfo`;
CREATE TABLE `tb_userinfo` (
  `uIId` bigint(20) NOT NULL auto_increment COMMENT '用户信息ID',
  `uId` varchar(255) default NULL COMMENT '用户ID',
  `ustate` varchar(50) default NULL COMMENT '用户状态',
  `uPassQuestion` varchar(50) default NULL,
  `uPassAnswer` varchar(50) default NULL,
  `email` varchar(50) default NULL COMMENT '电子邮件',
  `realname` varchar(50) default NULL COMMENT '真实姓名',
  `uTel` bigint(20) default NULL COMMENT '联系电话',
  `uIDcard` varchar(255) default NULL COMMENT '身份证号',
  `uSex` varchar(50) default NULL COMMENT '性别',
  `userImage` varchar(255) default NULL COMMENT '用户头像',
  `nickname` varchar(50) default NULL COMMENT '昵称',
  `sType` varchar(50) default NULL COMMENT '店铺类型',
  `address` varchar(255) default NULL COMMENT '居住地址',
  `roleId` bigint(20) default NULL COMMENT '角色ID',
  `uRole` varchar(50) default NULL COMMENT '用户角色',
  PRIMARY KEY  (`uIId`),
  KEY `FK_userToUserInfo2` (`uId`),
  KEY `FK_userToRoles2` USING BTREE (`roleId`),
  CONSTRAINT `FK_userToRoles1` FOREIGN KEY (`roleId`) REFERENCES `tb_roles` (`roleId`),
  CONSTRAINT `FK_userToUserInfo2` FOREIGN KEY (`uId`) REFERENCES `tb_users` (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='�û���Ϣ��';

-- ----------------------------
-- Records of tb_userinfo
-- ----------------------------
INSERT INTO `tb_userinfo` VALUES ('1', 'fd43d710062240db833ef4fb6e80b290', '已通过', null, null, '740969264@qq.com', '张学友', '15620225280', '450821199605314011', '男', null, '喵喵喵', '个人店铺', '天津市西青区宾水西道399号天津工业大学', '1', '个人商家');
INSERT INTO `tb_userinfo` VALUES ('6', '06684991383945bb9b4582a4f2a16392', '已通过', null, null, null, '一般用户', null, null, null, null, null, '个人店铺', null, '2', '个人商家');
INSERT INTO `tb_userinfo` VALUES ('9', '9194aff898854f1b8541ff01febdefe3', '未提交申请', null, null, null, '周星驰', null, null, null, null, null, null, null, '1', '管理员');
INSERT INTO `tb_userinfo` VALUES ('10', 'cc046a951c4b412eaab7c09f10ccd81d', '已通过', null, null, null, '周润发', null, null, null, null, null, '个人店铺', null, '2', '个人商家');
INSERT INTO `tb_userinfo` VALUES ('11', '966d21e5d802416eb80cd37002166718', '未通过', null, null, null, '郭富城', null, null, null, null, null, '个人店铺', null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('12', 'a4939442ca864c659f13391de715ab22', '待审核', null, null, null, '黎明', null, null, null, null, null, '个人店铺', null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('13', '60b6f768a79e43aba38e772a9f713abc', '待审核', null, null, null, '孙悟空', null, null, null, null, null, '个人店铺', null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('14', 'add3d5483cd74118b6d50107dcb434e9', '已通过', null, null, '740969264@qq.com', '猪八戒', '15620225280', '450821199605314011', '男', '/static/img/1.1494326.png', '猪猪猪', '个人店铺', '天津市西青区宾水西道399号天津工业大学', '3', '个人商家');
INSERT INTO `tb_userinfo` VALUES ('15', 'adfeedb812ed4fe7b29aa8e5a82e0941', '已通过', null, null, null, '唐僧', null, null, null, '/static/img/1.1494326.png', null, '个人店铺', null, '3', '个人商家');
INSERT INTO `tb_userinfo` VALUES ('16', '2fae65075d8641a9aaaf5dbd718daf0c', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('17', '0566ce6643814c61b308543ab0f4e581', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('18', '20911931ef3c461a8eac54bfcd337a9a', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('19', '49e35232518248b59e84c443a8b1ae58', '待审核', null, null, null, null, null, null, null, null, null, '个人店铺', null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('20', '212c8b85f10a4f6eb70a5dbcaa538c78', '已通过', null, null, null, null, null, null, null, null, null, null, null, '2', '个人商家');
INSERT INTO `tb_userinfo` VALUES ('21', '43967f402b564f519c65732c7341d0a4', '已通过', null, null, null, null, null, null, null, null, null, null, null, '2', '个人商家');
INSERT INTO `tb_userinfo` VALUES ('22', '74b12381d98a4a90940c4f47e9025969', '已通过', null, null, '234', '234', '234', '234', '234', 'http://localhost:8080/netsc/img/userPhotos/16acc2fd-cf1f-4891-9b55-5223b06f09ed.png', '234', null, '234', '2', '个人商家');
INSERT INTO `tb_userinfo` VALUES ('23', '7c46537bcec34defbd3e359acae1b660', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('24', '4c43f46e965b4862978ec7df2a2dd9a6', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('25', 'cbfd4bc13f894521be86fd6ad03b1e60', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('26', 'e4d96e312dfb4e71a04346c0219b8471', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('27', 'be3cfa5a7854427eb890e52319e31f4d', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('28', '35fe1dcc529140dea9754f1ac6da6381', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('29', '19f72c30b03745daa24b982f967bf248', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('30', 'a2cd36a6fcb44cd7bdaebbd672ebbbac', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('31', '31a4873943ba49e8963f6c51fe464839', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('32', '4486b1411b2f4880aa0ad686cffe1233', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('33', '665b872870124d32bb7c96156d3e51fa', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('34', 'f87d708994914eca815f576c5cc9e3f4', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('35', '8d03111eeaf04a52b9d775e77b75b4de', '未通过', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('36', '9357812623b54706b24dd56fc73cb4b7', '已通过', null, null, null, null, null, null, null, null, null, '个人店铺', null, '3', '个人商家');
INSERT INTO `tb_userinfo` VALUES ('37', 'ac120f96ca62456f96639a717ee26346', '未通过', null, null, 'sdf', 'sdf', '123', 'sdf', 'sdf', null, 'dsf', '个人店铺', 'sdf', '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('38', 'f3c8fbcaf756432da725464a15c0a89d', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('39', '448f6b6068b1483ba23ac20e8afd2ec2', '已通过', null, null, 'sdf', '456', '456', '456', 'sdf', 'http://localhost:8080/netsc/img/userPhotos/442c6dbc-efa8-4aa3-a3bd-7706632f447f.png', '234', '个人店铺', 'sdf', '3', '个人商家');
INSERT INTO `tb_userinfo` VALUES ('40', '873f96148e6d478aa9c507b8d7a7ac2b', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');
INSERT INTO `tb_userinfo` VALUES ('41', '5360937a0cac45578c9b2dfd9a16cfce', '未提交申请', null, null, null, null, null, null, null, null, null, null, null, '2', '一般用户');

-- ----------------------------
-- Table structure for tb_users
-- ----------------------------
DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users` (
  `uId` varchar(255) NOT NULL COMMENT '用户ID',
  `username` varchar(50) default NULL COMMENT '用户名',
  `password` varchar(50) default NULL COMMENT '用户密码',
  `registeTime` varchar(50) default NULL COMMENT '注册时间',
  `onLineState` varchar(50) default NULL,
  `lasttime` varchar(50) default NULL,
  PRIMARY KEY  (`uId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_users
-- ----------------------------
INSERT INTO `tb_users` VALUES ('01d0f6902e6f43fd9995d40e5d248cf6', 'liudehua', 'a83ed5df4e12879e459b6d8bf81b618a', '2019-04-04 23:20:36', null, null);
INSERT INTO `tb_users` VALUES ('0566ce6643814c61b308543ab0f4e581', 'bailongma', '7cff00e95f67dc93d6e1cb3afbdc00ae', '2019-04-15 22:02:59', null, null);
INSERT INTO `tb_users` VALUES ('06684991383945bb9b4582a4f2a16392', 'string456', 'a2c757f614bbe30eded66bad2a4b8b08', '2019-04-12 21:54:05', null, null);
INSERT INTO `tb_users` VALUES ('19f72c30b03745daa24b982f967bf248', 'qwer3', '302b4fbbb426096bb3b3ee660ce1f6c8', '2019-04-26 22:08:36', null, null);
INSERT INTO `tb_users` VALUES ('20911931ef3c461a8eac54bfcd337a9a', 'rulaifuozhu', 'b1e4cdb1b055310ea733de7dad3d7e83', '2019-04-15 22:09:00', null, null);
INSERT INTO `tb_users` VALUES ('212c8b85f10a4f6eb70a5dbcaa538c78', 'zhangxuping', 'be572f944416b1925800b5de73f55f1d', '2019-04-16 09:44:50', null, null);
INSERT INTO `tb_users` VALUES ('2fae65075d8641a9aaaf5dbd718daf0c', 'shaseng', '3b1c685125edf0a1c84e909128f7d2bb', '2019-04-15 22:00:01', null, null);
INSERT INTO `tb_users` VALUES ('31a4873943ba49e8963f6c51fe464839', 'qewr5', '4542f3c2e3fdf17660856a59aa97f556', '2019-04-26 22:25:27', null, null);
INSERT INTO `tb_users` VALUES ('35fe1dcc529140dea9754f1ac6da6381', 'qwer2', 'cc73c28a6052d012be295e81e2d8303c', '2019-04-26 22:06:32', null, null);
INSERT INTO `tb_users` VALUES ('36c9a63895f547f591809e855bb007a6', 'shipeng', '50ea140c2edf29509d9c8c06d66f25ce', '2019-04-09 16:30:05', null, null);
INSERT INTO `tb_users` VALUES ('3d26453a4f3d4097b98ae65a447fb05f', 'string', '60d73818ecee95d7ebb9d763877185b7', '2019-04-04 00:27:33', null, null);
INSERT INTO `tb_users` VALUES ('417e5eab55e94e6b9cf961fea4b7fb8a', '123', 'afa73fbe6a5f956f754f0ce31efac23b', '2019-04-04 00:28:58', null, null);
INSERT INTO `tb_users` VALUES ('43967f402b564f519c65732c7341d0a4', '123123', '67d6d15f04e6a752d25729119cb038f0', '2019-04-23 15:09:46', null, null);
INSERT INTO `tb_users` VALUES ('4486b1411b2f4880aa0ad686cffe1233', 'zhulaosan', '0412c657a9eaa816a470e549e6b06b1c', '2019-04-26 22:39:09', null, null);
INSERT INTO `tb_users` VALUES ('448f6b6068b1483ba23ac20e8afd2ec2', '456', '7e34e3b06a907adfbb25ba17ee6d6201', '2019-04-30 10:39:09', null, null);
INSERT INTO `tb_users` VALUES ('49e35232518248b59e84c443a8b1ae58', 'guanyin', '750313b0db0106e4914f4a585224a76d', '2019-04-15 22:10:56', null, null);
INSERT INTO `tb_users` VALUES ('4c43f46e965b4862978ec7df2a2dd9a6', 'dsf', 'd241d531408203aebe27d211d801d819', '2019-04-26 21:44:08', null, null);
INSERT INTO `tb_users` VALUES ('5360937a0cac45578c9b2dfd9a16cfce', 'songjian', '014fa8bb0c66022dad9dba46256cd35e', '2019-05-07 00:11:45', null, null);
INSERT INTO `tb_users` VALUES ('60b6f768a79e43aba38e772a9f713abc', 'sunwukong', '0f0da57abef3a3be952875c9724f2edf', '2019-04-13 00:39:15', null, null);
INSERT INTO `tb_users` VALUES ('665b872870124d32bb7c96156d3e51fa', 'zhulaosi', '5f8bddca1931fc554a33ba1e4cea2691', '2019-04-26 22:41:11', null, null);
INSERT INTO `tb_users` VALUES ('74b12381d98a4a90940c4f47e9025969', '456456', 'a61f92d0029ba83d6e7c60eb6eeb5bd0', '2019-04-26 14:22:55', null, null);
INSERT INTO `tb_users` VALUES ('7c46537bcec34defbd3e359acae1b660', 'zhanglaosan', '2089600013102eb86093a75b5fb83d48', '2019-04-26 21:36:19', null, null);
INSERT INTO `tb_users` VALUES ('873f96148e6d478aa9c507b8d7a7ac2b', '猪八戒', '488c0cce01da33a56a7a6b0f4d6b25f8', '2019-05-04 22:27:20', null, null);
INSERT INTO `tb_users` VALUES ('8d03111eeaf04a52b9d775e77b75b4de', 'baolongma', '371b6d92ec6c6ceab96da73fe6518c33', '2019-04-29 12:13:13', null, null);
INSERT INTO `tb_users` VALUES ('9194aff898854f1b8541ff01febdefe3', 'zhouxingchi', '3e8b395ad61910344dd4c3fb7f1b671d', '2019-04-12 22:07:31', null, null);
INSERT INTO `tb_users` VALUES ('9357812623b54706b24dd56fc73cb4b7', 'niumowang', 'f38f4d025a6f48a60af118e6232ed27d', '2019-04-29 12:35:36', null, null);
INSERT INTO `tb_users` VALUES ('966d21e5d802416eb80cd37002166718', 'guofucheng', 'e95b61ca69d1d7c72dc963ee8812c614', '2019-04-13 00:36:51', null, null);
INSERT INTO `tb_users` VALUES ('a2cd36a6fcb44cd7bdaebbd672ebbbac', 'qwer4', 'f11b999c8dc69ae53ed9df9c3594ed05', '2019-04-26 22:10:23', null, null);
INSERT INTO `tb_users` VALUES ('a4939442ca864c659f13391de715ab22', 'liming', '52174a175216b0da93056a8843b3ad07', '2019-04-13 00:38:06', null, null);
INSERT INTO `tb_users` VALUES ('ac120f96ca62456f96639a717ee26346', 'guangyu', '494df04569e57c2f0eaf35bed9049df4', '2019-04-29 16:45:30', null, null);
INSERT INTO `tb_users` VALUES ('add3d5483cd74118b6d50107dcb434e9', 'zhubajie', '5b3d35a7b4ffe03e9c0ee123a16b2631', '2019-04-13 00:40:59', null, null);
INSERT INTO `tb_users` VALUES ('adfeedb812ed4fe7b29aa8e5a82e0941', 'tangseng', '7f7f8f44a0eddc11f9bf6d70c2864939', '2019-04-13 00:41:13', null, null);
INSERT INTO `tb_users` VALUES ('be3cfa5a7854427eb890e52319e31f4d', 'qwer1', '2569607d366063abffa41305591fd1e5', '2019-04-26 22:06:26', null, null);
INSERT INTO `tb_users` VALUES ('cbfd4bc13f894521be86fd6ad03b1e60', 'zhanglaosan1', 'b39da85785e2e826983e8573a3be203b', '2019-04-26 21:50:04', null, null);
INSERT INTO `tb_users` VALUES ('cc046a951c4b412eaab7c09f10ccd81d', 'zhourunfa', 'f43debdaf8627e20d9210ae1199c4687', '2019-04-13 00:34:26', null, null);
INSERT INTO `tb_users` VALUES ('e4d96e312dfb4e71a04346c0219b8471', 'qwer', 'dce8b52c980ff4da47e4e466717466eb', '2019-04-26 22:05:34', null, null);
INSERT INTO `tb_users` VALUES ('f3c8fbcaf756432da725464a15c0a89d', 'zhulaowu', '5cc7af41b5a9cbed498df7725fe2e3b1', '2019-04-29 18:15:57', null, null);
INSERT INTO `tb_users` VALUES ('f87d708994914eca815f576c5cc9e3f4', 'rtrt', '7d48781deb101aae10c3bd917bdacac4', '2019-04-27 00:31:12', null, null);
INSERT INTO `tb_users` VALUES ('fd43d710062240db833ef4fb6e80b290', 'zhangxueyou', '4b4e9edd8335f3cdce6e519f365b16f7', '2019-04-04 20:44:03', null, null);
INSERT INTO `tb_users` VALUES ('hjk', 'string', 'string', null, 'string', 'string');

-- ----------------------------
-- Table structure for tb_wallet
-- ----------------------------
DROP TABLE IF EXISTS `tb_wallet`;
CREATE TABLE `tb_wallet` (
  `wId` bigint(20) NOT NULL auto_increment COMMENT '钱包ID',
  `wName` varchar(50) default NULL COMMENT '钱包名称',
  `money` double(20,2) default NULL COMMENT '余额',
  `payPassword` varchar(50) default NULL COMMENT '支付密码',
  `uId` varchar(255) default NULL COMMENT '用户ID',
  `firstUse` varchar(50) default NULL COMMENT '首次使用标识',
  PRIMARY KEY  (`wId`),
  KEY `FK_userToWallet` USING BTREE (`uId`),
  CONSTRAINT `FK_userToWallet` FOREIGN KEY (`uId`) REFERENCES `tb_users` (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_wallet
-- ----------------------------
INSERT INTO `tb_wallet` VALUES ('6', 'zhubajie的钱包', '1085.39', '123456', 'add3d5483cd74118b6d50107dcb434e9', 'false');
INSERT INTO `tb_wallet` VALUES ('7', '123123的钱包', '82.47', '123456', '43967f402b564f519c65732c7341d0a4', 'false');
INSERT INTO `tb_wallet` VALUES ('8', '456456的钱包', '990.02', '789456', '74b12381d98a4a90940c4f47e9025969', 'false');
INSERT INTO `tb_wallet` VALUES ('9', 'tangseng的钱包', '9.01', '123456', 'adfeedb812ed4fe7b29aa8e5a82e0941', 'false');
INSERT INTO `tb_wallet` VALUES ('10', '456的钱包', '1194.01', '456456', '448f6b6068b1483ba23ac20e8afd2ec2', 'false');
INSERT INTO `tb_wallet` VALUES ('11', 'songjian的钱包', '94.01', '123456', '5360937a0cac45578c9b2dfd9a16cfce', 'false');
INSERT INTO `tb_wallet` VALUES ('12', '的钱包', '0.00', null, null, 'true');
INSERT INTO `tb_wallet` VALUES ('13', '的钱包', '0.00', null, null, 'true');
