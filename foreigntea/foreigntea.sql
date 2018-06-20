/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50136
Source Host           : localhost:3306
Source Database       : foreigntea

Target Server Type    : MYSQL
Target Server Version : 50136
File Encoding         : 65001

Date: 2018-06-20 10:35:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lesson
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dept` varchar(45) DEFAULT NULL,
  `classes` varchar(45) DEFAULT NULL,
  `subject` varchar(45) NOT NULL,
  `time` varchar(100) NOT NULL,
  `place` varchar(45) DEFAULT NULL,
  `teanum` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lesson
-- ----------------------------
INSERT INTO `lesson` VALUES ('1', '信息学部', '15软本1', 'JAVA', '周一周二', '教学楼301', 'A100', '审核成功');
INSERT INTO `lesson` VALUES ('2', '信息学部', '15软本1', '软件工程', '周三周四', '综合楼402', 'C101', '审核成功');
INSERT INTO `lesson` VALUES ('3', '经管学部', '15注会1', '会计电算化', '周一周五', '综合楼410', 'C102', '审核成功');
INSERT INTO `lesson` VALUES ('4', '信息学部', '15软本1', '软件测试', '周一周二周三周四', '3S112', 'C101', '审核成功');
INSERT INTO `lesson` VALUES ('5', '信息学部', '16软本2', 'JAVA ', '周二周五', '综合楼801', 'B100', '审核成功');
INSERT INTO `lesson` VALUES ('6', '信息学部', '15软本1', '团队开发', '周一周五', '3S222', 'B101', '审核成功');
INSERT INTO `lesson` VALUES ('7', '信息学部', '16软本2', '软件工程', '周五', '综合楼811', 'A102', '审核成功');
INSERT INTO `lesson` VALUES ('8', '信息学部', '15软本1', 'C语音', '周一周二周三周四', '综合楼811', 'B100', '审核成功');
INSERT INTO `lesson` VALUES ('9', '信息学部', '17软本2', 'JAVA', '周二周三周五', '3S110', 'A102', '审核成功');
INSERT INTO `lesson` VALUES ('10', '信息学部', '17软本2', 'JSP', '周一周三周四周五', '教学楼405', 'C100', '审核成功');
INSERT INTO `lesson` VALUES ('11', '信息学部', '15软本2', '数据库设计', '周四周五', '3S115', 'A101', '审核成功');
INSERT INTO `lesson` VALUES ('12', '信息学部', '16软本2', 'JAVA', '周一周五', '3S102', 'A102', '审核成功');
INSERT INTO `lesson` VALUES ('13', '信息学部', '15软本2', 'C语音', '周二周四', '综合楼805', 'B100', '审核成功');
INSERT INTO `lesson` VALUES ('14', '城建学部', '15土木1', '绘图', '周一周三', '教学楼323', 'B101', '审核成功');
INSERT INTO `lesson` VALUES ('15', '城建学部', '15土木1', 'PS', '周一周五', '综合楼804', 'B100', '审核成功');
INSERT INTO `lesson` VALUES ('16', '经管学部', '15注会1', '会计基础', '周一周四', '综合楼311', 'B101', '审核成功');
INSERT INTO `lesson` VALUES ('17', '信息学部', '15软本2', '3DMAX', '周一周三周四周五', '3S103', 'B102', '审核成功');
INSERT INTO `lesson` VALUES ('18', '信息学部', '16软本2', 'JSP', '周一周二周三周四', '3S112', 'C100', '审核成功');
INSERT INTO `lesson` VALUES ('19', '信息学部', '15软本2', 'Unit', '周一周三周四', '3S222', 'A100', '审核失败');
INSERT INTO `lesson` VALUES ('20', '信息学部', '15软本1', 'COCOS', '周二周三', '3S224', 'A101', '审核成功');
INSERT INTO `lesson` VALUES ('24', null, null, '机械工程', '周二', null, 'A100', '审核中');
INSERT INTO `lesson` VALUES ('25', '城建学部', '15土木本1', '高数2', '周二周三', '3s杯211', 'A100', '审核成功');
INSERT INTO `lesson` VALUES ('26', '城建学部', '16土木本1', '大学英语', '周三周四', '3S北115', 'I888', '审核成功');

-- ----------------------------
-- Table structure for teaevaluate
-- ----------------------------
DROP TABLE IF EXISTS `teaevaluate`;
CREATE TABLE `teaevaluate` (
  `teanum` varchar(10) NOT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `gradetxt` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`teanum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teaevaluate
-- ----------------------------
INSERT INTO `teaevaluate` VALUES ('A100', '优秀', '该教师上课讲解细致，解答学生问题好！');

-- ----------------------------
-- Table structure for teames
-- ----------------------------
DROP TABLE IF EXISTS `teames`;
CREATE TABLE `teames` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `age` int(10) unsigned NOT NULL,
  `tel` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `position` varchar(45) NOT NULL,
  `company` varchar(45) NOT NULL,
  `year` int(10) unsigned NOT NULL,
  `time` varchar(90) NOT NULL,
  `teanum` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teames
-- ----------------------------
INSERT INTO `teames` VALUES ('1', '徐硕', '男', '60', '15511452578', '123@qq.com', '教授', '微软', '30', '周一周二周三', 'A100');
INSERT INTO `teames` VALUES ('2', '张博达', '男', '55', '13211458797', '9789754@qq.com', '教授', '华硕', '30', '周一周二周五', 'A101');
INSERT INTO `teames` VALUES ('3', '王善荣', '男', '45', '15322457458', '1234@qq.com', '副教授', '苹果', '20', '周三周五', 'B100');
INSERT INTO `teames` VALUES ('4', '郑东成', '男', '25', '13411452236', '464546867@163.com', '副教授', '阿里巴巴', '3', '周一周二周三周五', 'B101');
INSERT INTO `teames` VALUES ('5', '卫雨沛', '男', '35', '16974216574', '55422544@qq.com', '讲师', '联想', '15', '周一周五', 'C100');
INSERT INTO `teames` VALUES ('6', '李子奇', '男', '40', '14786245624', '6748454@qq.com', '讲师', '搜狗', '15', '周二周四周五', 'C101');
INSERT INTO `teames` VALUES ('7', 'alkjflas', '女', '50', '1165165', '1516515625@qq.com', '教授', '联想', '10', '周二周三', 'I888');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `identity` varchar(45) NOT NULL,
  `teanum` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('aaa', '111', '2', 'K111');
INSERT INTO `user` VALUES ('aaaaa', '111', '2', 'I000');
INSERT INTO `user` VALUES ('admin', 'admin', '1', '');
INSERT INTO `user` VALUES ('assistant', 'assistant', '3', null);
INSERT INTO `user` VALUES ('teacher', 'teacher', '2', 'A100');
INSERT INTO `user` VALUES ('teacher1', 'teacher123', '2', 'A101');
INSERT INTO `user` VALUES ('teacher2', 'teacher2', '2', 'B100');
INSERT INTO `user` VALUES ('teacherlmx', 'teacherlmx', '2', 'B101');
INSERT INTO `user` VALUES ('teacherlzq', 'teacherlzq', '2', 'C100');
INSERT INTO `user` VALUES ('teacherwyp', 'teacherwyp', '2', 'C101');
INSERT INTO `user` VALUES ('zbd', 'zbd123', '2', 'I888');
