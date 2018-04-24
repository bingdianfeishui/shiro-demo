/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : shiro_demo

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-04-24 17:28:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `u_permission`
-- ----------------------------
DROP TABLE IF EXISTS `u_permission`;
CREATE TABLE `u_permission` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) DEFAULT NULL COMMENT 'url描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_permission
-- ----------------------------
INSERT INTO `u_permission` VALUES ('4', '/permission/index.shtml', '权限列表');
INSERT INTO `u_permission` VALUES ('6', '/permission/addPermission.shtml', '权限添加');
INSERT INTO `u_permission` VALUES ('7', '/permission/deletePermissionById.shtml', '权限删除');
INSERT INTO `u_permission` VALUES ('8', '/member/list.shtml', '用户列表');
INSERT INTO `u_permission` VALUES ('9', '/member/online.shtml', '在线用户');
INSERT INTO `u_permission` VALUES ('10', '/member/changeSessionStatus.shtml', '用户Session踢出');
INSERT INTO `u_permission` VALUES ('11', '/member/forbidUserById.shtml', '用户激活&禁止');
INSERT INTO `u_permission` VALUES ('12', '/member/deleteUserById.shtml', '用户删除');
INSERT INTO `u_permission` VALUES ('13', '/permission/addPermission2Role.shtml', '权限分配');
INSERT INTO `u_permission` VALUES ('14', '/role/clearRoleByUserIds.shtml', '用户角色分配清空');
INSERT INTO `u_permission` VALUES ('15', '/role/addRole2User.shtml', '角色分配保存');
INSERT INTO `u_permission` VALUES ('16', '/role/deleteRoleById.shtml', '角色列表删除');
INSERT INTO `u_permission` VALUES ('17', '/role/addRole.shtml', '角色列表添加');
INSERT INTO `u_permission` VALUES ('18', '/role/index.shtml', '角色列表');
INSERT INTO `u_permission` VALUES ('19', '/permission/allocation.shtml', '权限分配');
INSERT INTO `u_permission` VALUES ('20', '/role/allocation.shtml', '角色分配');

-- ----------------------------
-- Table structure for `u_resource`
-- ----------------------------
DROP TABLE IF EXISTS `u_resource`;
CREATE TABLE `u_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_resource
-- ----------------------------

-- ----------------------------
-- Table structure for `u_role`
-- ----------------------------
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role
-- ----------------------------
INSERT INTO `u_role` VALUES ('1', '系统管理员', '888888');
INSERT INTO `u_role` VALUES ('3', '权限角色', '100003');
INSERT INTO `u_role` VALUES ('4', '用户中心', '100002');

-- ----------------------------
-- Table structure for `u_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `u_role_permission`;
CREATE TABLE `u_role_permission` (
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `pid` int(20) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role_permission
-- ----------------------------
INSERT INTO `u_role_permission` VALUES ('4', '8');
INSERT INTO `u_role_permission` VALUES ('4', '9');
INSERT INTO `u_role_permission` VALUES ('4', '10');
INSERT INTO `u_role_permission` VALUES ('4', '11');
INSERT INTO `u_role_permission` VALUES ('4', '12');
INSERT INTO `u_role_permission` VALUES ('3', '4');
INSERT INTO `u_role_permission` VALUES ('3', '6');
INSERT INTO `u_role_permission` VALUES ('3', '7');
INSERT INTO `u_role_permission` VALUES ('3', '13');
INSERT INTO `u_role_permission` VALUES ('3', '14');
INSERT INTO `u_role_permission` VALUES ('3', '15');
INSERT INTO `u_role_permission` VALUES ('3', '16');
INSERT INTO `u_role_permission` VALUES ('3', '17');
INSERT INTO `u_role_permission` VALUES ('3', '18');
INSERT INTO `u_role_permission` VALUES ('3', '19');
INSERT INTO `u_role_permission` VALUES ('3', '20');
INSERT INTO `u_role_permission` VALUES ('1', '4');
INSERT INTO `u_role_permission` VALUES ('1', '6');
INSERT INTO `u_role_permission` VALUES ('1', '7');
INSERT INTO `u_role_permission` VALUES ('1', '8');
INSERT INTO `u_role_permission` VALUES ('1', '9');
INSERT INTO `u_role_permission` VALUES ('1', '10');
INSERT INTO `u_role_permission` VALUES ('1', '11');
INSERT INTO `u_role_permission` VALUES ('1', '12');
INSERT INTO `u_role_permission` VALUES ('1', '13');
INSERT INTO `u_role_permission` VALUES ('1', '14');
INSERT INTO `u_role_permission` VALUES ('1', '15');
INSERT INTO `u_role_permission` VALUES ('1', '16');
INSERT INTO `u_role_permission` VALUES ('1', '17');
INSERT INTO `u_role_permission` VALUES ('1', '18');
INSERT INTO `u_role_permission` VALUES ('1', '19');
INSERT INTO `u_role_permission` VALUES ('1', '20');
INSERT INTO `u_role_permission` VALUES ('4', '8');
INSERT INTO `u_role_permission` VALUES ('4', '9');
INSERT INTO `u_role_permission` VALUES ('4', '10');
INSERT INTO `u_role_permission` VALUES ('4', '11');
INSERT INTO `u_role_permission` VALUES ('4', '12');
INSERT INTO `u_role_permission` VALUES ('3', '4');
INSERT INTO `u_role_permission` VALUES ('3', '6');
INSERT INTO `u_role_permission` VALUES ('3', '7');
INSERT INTO `u_role_permission` VALUES ('3', '13');
INSERT INTO `u_role_permission` VALUES ('3', '14');
INSERT INTO `u_role_permission` VALUES ('3', '15');
INSERT INTO `u_role_permission` VALUES ('3', '16');
INSERT INTO `u_role_permission` VALUES ('3', '17');
INSERT INTO `u_role_permission` VALUES ('3', '18');
INSERT INTO `u_role_permission` VALUES ('3', '19');
INSERT INTO `u_role_permission` VALUES ('3', '20');
INSERT INTO `u_role_permission` VALUES ('1', '4');
INSERT INTO `u_role_permission` VALUES ('1', '6');
INSERT INTO `u_role_permission` VALUES ('1', '7');
INSERT INTO `u_role_permission` VALUES ('1', '8');
INSERT INTO `u_role_permission` VALUES ('1', '9');
INSERT INTO `u_role_permission` VALUES ('1', '10');
INSERT INTO `u_role_permission` VALUES ('1', '11');
INSERT INTO `u_role_permission` VALUES ('1', '12');
INSERT INTO `u_role_permission` VALUES ('1', '13');
INSERT INTO `u_role_permission` VALUES ('1', '14');
INSERT INTO `u_role_permission` VALUES ('1', '15');
INSERT INTO `u_role_permission` VALUES ('1', '16');
INSERT INTO `u_role_permission` VALUES ('1', '17');
INSERT INTO `u_role_permission` VALUES ('1', '18');
INSERT INTO `u_role_permission` VALUES ('1', '19');
INSERT INTO `u_role_permission` VALUES ('1', '20');

-- ----------------------------
-- Table structure for `u_user`
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `username` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `salt` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` tinyint(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('1', '管理员', 'admin', '08d592b5478f3d692e643370147ee901', '68E45C4D', '2016-06-16 11:15:33', '2016-06-16 11:24:10', '1');
INSERT INTO `u_user` VALUES ('11', 'tom', 'tom', 'aeebd7c9496c79686bb216430ba5b08a', 'BC12A435', '2016-05-26 20:50:54', '2016-06-16 11:24:35', '1');
INSERT INTO `u_user` VALUES ('12', 'jerry', 'jerry', '6597b667bb567f6c6522f1f63a6d7075', '7AEAA0A4', '2016-05-27 22:34:19', '2016-06-15 17:03:16', '1');

-- ----------------------------
-- Table structure for `u_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `u_user_role`;
CREATE TABLE `u_user_role` (
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `rid` int(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user_role
-- ----------------------------
INSERT INTO `u_user_role` VALUES ('12', '4');
INSERT INTO `u_user_role` VALUES ('11', '3');
INSERT INTO `u_user_role` VALUES ('11', '4');
INSERT INTO `u_user_role` VALUES ('1', '1');
INSERT INTO `u_user_role` VALUES ('12', '4');
INSERT INTO `u_user_role` VALUES ('11', '3');
INSERT INTO `u_user_role` VALUES ('11', '4');
INSERT INTO `u_user_role` VALUES ('1', '1');

-- ----------------------------
-- Procedure structure for `init_shiro_demo`
-- ----------------------------
DROP PROCEDURE IF EXISTS `init_shiro_demo`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `init_shiro_demo`()
BEGIN	
/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.6.16-log : Database - 
*********************************************************************
*/
/*表结构插入*/
DROP TABLE IF EXISTS `u_permission`;
CREATE TABLE `u_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) DEFAULT NULL COMMENT 'url描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*Table structure for table `u_role` */
DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*Table structure for table `u_role_permission` */
DROP TABLE IF EXISTS `u_role_permission`;
CREATE TABLE `u_role_permission` (
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `pid` bigint(20) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*Table structure for table `u_user` */
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `pswd` varchar(32) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` bigint(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*Table structure for table `u_user_role` */
DROP TABLE IF EXISTS `u_user_role`;
CREATE TABLE `u_user_role` (
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*
SQLyog 企业版 - MySQL GUI v7.14 
MySQL - 5.6.16-log : Database - i_wenyiba_com
*********************************************************************
*/
/*所有的表数据插入*/
/*Data for the table `u_permission` */
insert  into `u_permission`(`id`,`url`,`name`) values (4,'/permission/index.shtml','权限列表'),(6,'/permission/addPermission.shtml','权限添加'),(7,'/permission/deletePermissionById.shtml','权限删除'),(8,'/member/list.shtml','用户列表'),(9,'/member/online.shtml','在线用户'),(10,'/member/changeSessionStatus.shtml','用户Session踢出'),(11,'/member/forbidUserById.shtml','用户激活&禁止'),(12,'/member/deleteUserById.shtml','用户删除'),(13,'/permission/addPermission2Role.shtml','权限分配'),(14,'/role/clearRoleByUserIds.shtml','用户角色分配清空'),(15,'/role/addRole2User.shtml','角色分配保存'),(16,'/role/deleteRoleById.shtml','角色列表删除'),(17,'/role/addRole.shtml','角色列表添加'),(18,'/role/index.shtml','角色列表'),(19,'/permission/allocation.shtml','权限分配'),(20,'/role/allocation.shtml','角色分配');
/*Data for the table `u_role` */
insert  into `u_role`(`id`,`name`,`type`) values (1,'系统管理员','888888'),(3,'权限角色','100003'),(4,'用户中心','100002');
/*Data for the table `u_role_permission` */
insert  into `u_role_permission`(`rid`,`pid`) values (4,8),(4,9),(4,10),(4,11),(4,12),(3,4),(3,6),(3,7),(3,13),(3,14),(3,15),(3,16),(3,17),(3,18),(3,19),(3,20),(1,4),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(1,17),(1,18),(1,19),(1,20);
/*Data for the table `u_user` */
insert  into `u_user`(`id`,`nickname`,`email`,`pswd`,`create_time`,`last_login_time`,`status`) values (1,'管理员','admin','9c3250081c7b1f5c6cbb8096e3e1cd04','2016-06-16 11:15:33','2016-06-16 11:24:10',1),(11,'soso','8446666@qq.com','d57ffbe486910dd5b26d0167d034f9ad','2016-05-26 20:50:54','2016-06-16 11:24:35',1),(12,'8446666','8446666','4afdc875a67a55528c224ce088be2ab8','2016-05-27 22:34:19','2016-06-15 17:03:16',1);
/*Data for the table `u_user_role` */
insert  into `u_user_role`(`uid`,`rid`) values (12,4),(11,3),(11,4),(1,1);
   
    END
;;
DELIMITER ;
