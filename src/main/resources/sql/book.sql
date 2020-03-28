/*
Navicat MySQL Data Transfer

Source Server         : localhost_root&1-6
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : mytest

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-03-28 21:34:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'java');
INSERT INTO `book` VALUES ('2', 'c#');
INSERT INTO `book` VALUES ('3', 'golang');
INSERT INTO `book` VALUES ('4', 'weng');
INSERT INTO `book` VALUES ('5', 'weng');
