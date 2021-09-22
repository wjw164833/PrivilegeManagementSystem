/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : pms

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 21/09/2021 14:10:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for role_func
-- ----------------------------
DROP TABLE IF EXISTS `role_func`;
CREATE TABLE `role_func`  (
  `roleId` bigint(20) NOT NULL,
  `funcId` bigint(20) NOT NULL,
  PRIMARY KEY (`roleId`) USING BTREE,
  INDEX `role_func_funcid_fk`(`funcId`) USING BTREE,
  CONSTRAINT `role_func_funcid_fk` FOREIGN KEY (`funcId`) REFERENCES `sys_func` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_func_roleid_fk` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_func
-- ----------------------------

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `menuId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (19, 2);
INSERT INTO `role_menu` VALUES (14, 2);
INSERT INTO `role_menu` VALUES (20, 2);
INSERT INTO `role_menu` VALUES (21, 2);
INSERT INTO `role_menu` VALUES (26, 2);
INSERT INTO `role_menu` VALUES (23, 2);
INSERT INTO `role_menu` VALUES (24, 2);
INSERT INTO `role_menu` VALUES (25, 2);
INSERT INTO `role_menu` VALUES (27, 1);
INSERT INTO `role_menu` VALUES (30, 1);
INSERT INTO `role_menu` VALUES (31, 1);
INSERT INTO `role_menu` VALUES (28, 1);
INSERT INTO `role_menu` VALUES (32, 1);
INSERT INTO `role_menu` VALUES (33, 1);
INSERT INTO `role_menu` VALUES (34, 1);
INSERT INTO `role_menu` VALUES (35, 1);
INSERT INTO `role_menu` VALUES (29, 1);

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '部门名称',
  `leader` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '部门负责人',
  `sortCode` int(11) NOT NULL COMMENT '排序码',
  `parentId` bigint(20) NOT NULL COMMENT '上级部门',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '0正常 1停用',
  `isDeleted` smallint(6) NOT NULL DEFAULT 1 COMMENT '0否 1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (1, '销售部', '张三', 1, 1, '0', 1);
INSERT INTO `sys_dept` VALUES (2, '生产部', '李四', 1, 1, '0', 1);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint(20) NOT NULL COMMENT '字典编码',
  `dict_sort` int(4) NOT NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '样式属性',
  `list_class` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'N' COMMENT '是否默认（Y是N否）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '0' COMMENT '状态（0正常1停用）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------

-- ----------------------------
-- Table structure for sys_func
-- ----------------------------
DROP TABLE IF EXISTS `sys_func`;
CREATE TABLE `sys_func`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `appUrl` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `imgUrl` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sortCode` int(11) NOT NULL,
  `menuId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `sys_func_menuid_fk`(`menuId`) USING BTREE,
  CONSTRAINT `sys_func_menuid_fk` FOREIGN KEY (`menuId`) REFERENCES `sys_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_func
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单名称',
  `appUrl` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '程序路径',
  `imgUrl` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `type` smallint(6) NOT NULL COMMENT '0菜单 1按钮',
  `sortCode` int(11) NOT NULL,
  `parentId` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `isDeleted` smallint(6) NOT NULL DEFAULT 1 COMMENT '0否 1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '用户管理', '#', 'cb8360bc-060c-44a3-9c5b-f56478ab6fed.png', 2, 1, 0, 1);
INSERT INTO `sys_menu` VALUES (2, '角色管理', '#', '67c09bf7-77bc-4dfd-983f-9174284998a5.png', 2, 2, 0, 1);
INSERT INTO `sys_menu` VALUES (6, '菜单管理', '#', 'd6bce3ba-ab0f-4d86-ba98-419d1a0bdb5f.png', 2, 3, 0, 1);
INSERT INTO `sys_menu` VALUES (16, '权限管理', '#', '', 1, 1, 4, 1);
INSERT INTO `sys_menu` VALUES (27, '用户列表', '/userList', '', 0, 1, 1, 1);
INSERT INTO `sys_menu` VALUES (28, '角色列表', '/roleList', '', 0, 1, 2, 1);
INSERT INTO `sys_menu` VALUES (29, '菜单列表', '/menuList', '', 0, 1, 6, 1);
INSERT INTO `sys_menu` VALUES (30, '用户编辑', '#', '', 1, 1, 27, 1);
INSERT INTO `sys_menu` VALUES (31, '用户删除', '#', '', 1, 2, 27, 1);
INSERT INTO `sys_menu` VALUES (32, '角色添加', '#', '', 1, 1, 28, 1);
INSERT INTO `sys_menu` VALUES (33, '角色编辑', '#', '', 1, 2, 28, 1);
INSERT INTO `sys_menu` VALUES (34, '角色删除', '#', '', 1, 3, 28, 1);
INSERT INTO `sys_menu` VALUES (35, '角色授权', '#', '', 1, 4, 28, 1);

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `oper_id` bigint(20) NOT NULL COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) NOT NULL DEFAULT 0 COMMENT '业务类型（0其他 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) NOT NULL DEFAULT 0 COMMENT '操作类别（0其他 1后台用户 2手机用户）',
  `oper_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '请求url',
  `oper_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '返回参数',
  `status` int(1) NOT NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT 'error信息',
  `oper_time` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '角色名',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '描述',
  `status` int(255) NOT NULL DEFAULT 0 COMMENT '0正常 1禁用',
  `isDeleted` smallint(6) NOT NULL DEFAULT 1 COMMENT '0否 1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', '这是超级管理员', 0, 0);
INSERT INTO `sys_role` VALUES (2, '管理员', '这是管理员', 0, 1);
INSERT INTO `sys_role` VALUES (31, '普通用户', '普通用户', 0, 1);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `depId` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `account` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '登录账号',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '登录密码',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '联系电话',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '邮箱',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '性别',
  `status` int(11) NULL DEFAULT 0 COMMENT '0：正常  1：禁用',
  `isDeleted` smallint(6) NULL DEFAULT 1 COMMENT '0：否  1：是',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_dept_fk`(`depId`) USING BTREE,
  CONSTRAINT `user_dept_fk` FOREIGN KEY (`depId`) REFERENCES `sys_dept` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'system', 1, 'admin', 'admin', '13594171866', '1231231@qq.com', '0', 0, 1);
INSERT INTO `sys_user` VALUES (2, 'admin', 2, 'admin1', 'admin1', '13594171866', '1231231@qq.com', '1', 0, 1);
INSERT INTO `sys_user` VALUES (3, 'user', 1, 'user', '423324', '13412322313', '4234@qq.com', '0', 0, 0);
INSERT INTO `sys_user` VALUES (4, 'user1', 2, 'user1', '123123', '14322222222', '123421@qq.com', '2', 0, 1);
INSERT INTO `sys_user` VALUES (5, 'user2', 1, 'user2', '12312', '12321113434', '2342@qq.com', '1', 0, 1);
INSERT INTO `sys_user` VALUES (8, '杨瑞', 1, 'system', 'system', '13598765678', 'yr748534589@gmail.com', '0', 0, 1);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `userId` bigint(20) NOT NULL COMMENT '用户ID',
  `roleId` bigint(20) NOT NULL,
  INDEX `user_role_userid_fk`(`userId`) USING BTREE,
  INDEX `user_role_roleid_fk`(`roleId`) USING BTREE,
  CONSTRAINT `user_role_roleid_fk` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_userid_fk` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (3, 31);
INSERT INTO `user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
