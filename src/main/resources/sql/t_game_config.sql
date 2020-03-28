/*
Navicat MySQL Data Transfer

Source Server         : localhost_root&1-6
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : monster

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-03-28 21:34:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_game_config
-- ----------------------------
DROP TABLE IF EXISTS `t_game_config`;
CREATE TABLE `t_game_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `config_name` varchar(50) DEFAULT '‘’' COMMENT '配置key',
  `config_value` varchar(5000) DEFAULT '‘’' COMMENT '配置值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='游戏配置表';

-- ----------------------------
-- Records of t_game_config
-- ----------------------------
INSERT INTO `t_game_config` VALUES ('1', 'a', 'valuea');
INSERT INTO `t_game_config` VALUES ('2', 'b', 'valueb');
