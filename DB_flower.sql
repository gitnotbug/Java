/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : DB_flower

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 26/01/2024 15:29:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for carts
-- ----------------------------
DROP TABLE IF EXISTS `carts`;
CREATE TABLE `carts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fid` int DEFAULT NULL,
  `flower` varchar(255) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `price` float DEFAULT NULL,
  `uid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `flower` (`flower`),
  KEY `uid` (`uid`),
  KEY `fk2` (`fid`),
  CONSTRAINT `carts_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `users` (`id`),
  CONSTRAINT `fk2` FOREIGN KEY (`fid`) REFERENCES `flowers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of carts
-- ----------------------------
BEGIN;
INSERT INTO `carts` VALUES (32, 2, '粉色玫瑰花', 1, NULL, 10);
INSERT INTO `carts` VALUES (33, 4, '金枝玉叶玫瑰', 3, NULL, 10);
INSERT INTO `carts` VALUES (34, 1, '杭州水果捞', 1, NULL, 10);
COMMIT;

-- ----------------------------
-- Table structure for flowers
-- ----------------------------
DROP TABLE IF EXISTS `flowers`;
CREATE TABLE `flowers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `species_name` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `img_guid` varchar(255) DEFAULT NULL,
  `state` int DEFAULT '1' COMMENT '商品状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `species_name` (`species_name`),
  CONSTRAINT `flowers_ibfk_1` FOREIGN KEY (`species_name`) REFERENCES `species` (`species_name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of flowers
-- ----------------------------
BEGIN;
INSERT INTO `flowers` VALUES (1, '杭州水果捞', '春日', 10, '杭州水果捞', 'fe71ee4538644b4da67b046d3a6825a8.jpg', 1);
INSERT INTO `flowers` VALUES (2, '粉色玫瑰花', '夏日', 199, '粉色玫瑰花，送爱人~', '67975badf69646c0a70e8154208c7acd.jpg', 1);
INSERT INTO `flowers` VALUES (3, '牡丹', '夏日', 299, '国花，价格优惠', 'hehua.jpg', 1);
INSERT INTO `flowers` VALUES (4, '金枝玉叶玫瑰', '秋日', 999.99, '金枝玉叶玫瑰', '8d59b8723ad6409ab3b10847f86ef196.jpg', 1);
INSERT INTO `flowers` VALUES (5, '紫色小雏菊', '夏日', 188, '紫色小雏菊~', 'eff301d8ca194fb99639ebe4f1d328b9.jpg', 1);
INSERT INTO `flowers` VALUES (6, NULL, NULL, NULL, NULL, '', 1);
INSERT INTO `flowers` VALUES (7, '粉百合', '冬日', 10000, '粉百合', '6d901436d6e84160b04de4cafa79a611.jpg', 1);
COMMIT;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_guid` varchar(255) DEFAULT NULL,
  `flower` varchar(255) DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `price` float DEFAULT NULL,
  `state` int DEFAULT NULL,
  `uid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `flower` (`flower`),
  KEY `uid` (`uid`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of orders
-- ----------------------------
BEGIN;
INSERT INTO `orders` VALUES (27, NULL, '杭州水果捞', 3, 30, 0, 10);
INSERT INTO `orders` VALUES (28, NULL, '金枝玉叶玫瑰', 1, 999.99, 0, 10);
COMMIT;

-- ----------------------------
-- Table structure for species
-- ----------------------------
DROP TABLE IF EXISTS `species`;
CREATE TABLE `species` (
  `id` int NOT NULL AUTO_INCREMENT,
  `species_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `species` (`species_name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of species
-- ----------------------------
BEGIN;
INSERT INTO `species` VALUES (8, NULL);
INSERT INTO `species` VALUES (7, '冬日');
INSERT INTO `species` VALUES (11, '友情花');
INSERT INTO `species` VALUES (2, '夏日');
INSERT INTO `species` VALUES (9, '情人花');
INSERT INTO `species` VALUES (1, '春日');
INSERT INTO `species` VALUES (3, '秋日');
COMMIT;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES (1, 'user2', 'user2', '123456', '13566662222', '北京市昌平区2号', 'user');
INSERT INTO `users` VALUES (2, 'admin', '系统管理员', '123456', '123456', '上海市黄浦区南京西路8号', 'admin');
INSERT INTO `users` VALUES (10, 'user', '杭州水果捞', '123456', '18679121111', '杭州余杭区', 'user');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
