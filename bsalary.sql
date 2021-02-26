# Host: localhost  (Version 5.7.23)
# Date: 2021-02-09 15:37:01
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "salary"
#

CREATE TABLE `salary` (
  `salary_id` int(11) NOT NULL AUTO_INCREMENT,
  `work_id` varchar(255) DEFAULT NULL COMMENT '工号',
  `salary` varchar(255) DEFAULT NULL COMMENT '工资',
  `time` varchar(6) DEFAULT NULL COMMENT '时间',
  `costmoney` varchar(255) DEFAULT NULL COMMENT '扣款金额',
  `total` varchar(255) DEFAULT NULL COMMENT '总工时',
  PRIMARY KEY (`salary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "salary"
#

INSERT INTO `salary` VALUES (1,'1','346','17','1','1');

#
# Structure for table "salary_list"
#

CREATE TABLE `salary_list` (
  `list_id` int(11) NOT NULL AUTO_INCREMENT,
  `work_id` varchar(255) DEFAULT NULL COMMENT '工号',
  `money` varchar(255) DEFAULT NULL COMMENT '金额',
  `word` varchar(255) DEFAULT NULL COMMENT '扣款事由',
  `status` varchar(255) DEFAULT NULL COMMENT '申请状态',
  PRIMARY KEY (`list_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "salary_list"
#

INSERT INTO `salary_list` VALUES (1,'1','1','255','1'),(2,NULL,'55','22','0');

#
# Structure for table "t_dict"
#

CREATE TABLE `t_dict` (
  `DICT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典ID',
  `KEYY` bigint(20) NOT NULL COMMENT '键',
  `VALUEE` varchar(100) NOT NULL COMMENT '值',
  `FIELD_NAME` varchar(100) NOT NULL COMMENT '字段名称',
  `TABLE_NAME` varchar(100) NOT NULL COMMENT '表名',
  PRIMARY KEY (`DICT_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "t_dict"
#


#
# Structure for table "t_log"
#

CREATE TABLE `t_log` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志ID',
  `USERNAME` varchar(50) NOT NULL COMMENT '操作用户',
  `OPERATION` varchar(20) NOT NULL COMMENT '操作内容',
  `TIME` decimal(11,0) DEFAULT NULL COMMENT '耗时',
  `METHOD` text COMMENT '操作方法',
  `PARAMS` text COMMENT '方法参数',
  `IP` varchar(64) DEFAULT NULL COMMENT '操作者IP',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `location` varchar(50) DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `USERNAME` (`USERNAME`) USING BTREE,
  KEY `OPERATION` (`OPERATION`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "t_log"
#


#
# Structure for table "t_menu"
#

CREATE TABLE `t_menu` (
  `MENU_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单/按钮ID',
  `PARENT_ID` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `MENU_NAME` varchar(50) NOT NULL COMMENT '菜单/按钮名称',
  `URL` varchar(100) DEFAULT NULL COMMENT '菜单URL',
  `PERMS` text COMMENT '权限标识',
  `ICON` varchar(50) DEFAULT NULL COMMENT '图标',
  `TYPE` char(2) NOT NULL COMMENT '类型 0菜单 1按钮',
  `ORDER_NUM` bigint(20) DEFAULT NULL COMMENT '排序',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "t_menu"
#


#
# Structure for table "t_role"
#

CREATE TABLE `t_role` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `ROLE_NAME` varchar(100) NOT NULL COMMENT '角色名称',
  `REMARK` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "t_role"
#


#
# Structure for table "t_role_menu"
#

CREATE TABLE `t_role_menu` (
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID',
  `MENU_ID` bigint(20) NOT NULL COMMENT '菜单/按钮ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "t_role_menu"
#


#
# Structure for table "t_user"
#

CREATE TABLE `t_user` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `USERNAME` varchar(50) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(128) NOT NULL COMMENT '密码',
  `DEPT_ID` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `EMAIL` varchar(128) DEFAULT NULL COMMENT '邮箱',
  `MOBILE` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `STATUS` char(1) NOT NULL COMMENT '状态 0锁定 1有效',
  `CRATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `MODIFY_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `LAST_LOGIN_TIME` datetime DEFAULT NULL COMMENT '最近访问时间',
  `SSEX` char(1) DEFAULT NULL COMMENT '性别 0男 1女',
  `THEME` varchar(10) DEFAULT NULL COMMENT '主题',
  `AVATAR` varchar(100) DEFAULT NULL COMMENT '头像',
  `DESCRIPTION` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "t_user"
#


#
# Structure for table "t_user_dept"
#

CREATE TABLE `t_user_dept` (
  `user_id` bigint(20) NOT NULL,
  `dept_id` int(20) NOT NULL,
  PRIMARY KEY (`user_id`,`dept_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "t_user_dept"
#


#
# Structure for table "t_user_role"
#

CREATE TABLE `t_user_role` (
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "t_user_role"
#


#
# Structure for table "user2"
#

CREATE TABLE `user2` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `workId` varchar(255) DEFAULT NULL COMMENT '工号',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `salary` varchar(255) DEFAULT NULL COMMENT '工资',
  `dept` varchar(255) DEFAULT NULL COMMENT '角色',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

#
# Data for table "user2"
#

INSERT INTO `user2` VALUES (2,'1','2','2','2','-18','1','3333','56'),(3,NULL,NULL,NULL,NULL,NULL,NULL,'666','32'),(4,NULL,NULL,NULL,NULL,NULL,NULL,'噢噢噢噢','32'),(5,NULL,NULL,NULL,NULL,NULL,NULL,'333','323'),(6,NULL,NULL,NULL,NULL,NULL,NULL,'333','323'),(7,NULL,NULL,NULL,NULL,NULL,NULL,'66','6666'),(8,NULL,NULL,NULL,NULL,NULL,NULL,'88888','88'),(9,NULL,NULL,NULL,NULL,NULL,NULL,'66666999','32'),(10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,NULL,NULL,NULL,NULL,NULL,NULL,'36526','888999626'),(12,NULL,NULL,NULL,NULL,NULL,NULL,'6969','33');
