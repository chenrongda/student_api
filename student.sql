/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : student

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 12/02/2019 11:12:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增量',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `pass_word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `add_time` datetime(0) DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '2018-12-20 09:38:02');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增量',
  `grade` int(11) UNSIGNED NOT NULL COMMENT '年级',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级名称',
  `bz` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `admin_id` int(11) UNSIGNED DEFAULT NULL COMMENT '管理员id',
  `sort_order` int(3) UNSIGNED DEFAULT 255 COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, 3, '（5）班', '2018-2019学期', 1, 1);
INSERT INTO `classes` VALUES (2, 3, '（2）班', '2018-2019', 1, 255);
INSERT INTO `classes` VALUES (3, 3, '1', '2', 1, 3);
INSERT INTO `classes` VALUES (4, 4, '123', '32', 1, 2);

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增量',
  `exam_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考试名称',
  `exam_time` datetime(0) DEFAULT NULL COMMENT '考试时间',
  `classes_id` int(11) UNSIGNED NOT NULL COMMENT '考试班级',
  `math_avg_score` float(10, 2) UNSIGNED DEFAULT NULL COMMENT '数学平均分',
  `chinese_avg_score` float(10, 2) UNSIGNED DEFAULT NULL COMMENT '语文平均分',
  `english_avg_score` float(10, 2) UNSIGNED DEFAULT NULL COMMENT '英语平均分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES (1, '第一次月考', '2018-12-25 00:00:00', 1, 70.00, 75.00, 89.50);
INSERT INTO `exam` VALUES (2, '第二次月考', '2018-12-13 00:00:00', 1, 61.00, 66.00, 71.50);

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增量',
  `exam_id` int(11) UNSIGNED NOT NULL COMMENT '考试id',
  `student_id` int(11) UNSIGNED NOT NULL COMMENT '学生id',
  `math_score` float(10, 2) UNSIGNED DEFAULT NULL COMMENT '数学分数',
  `chinese_score` float(10, 2) UNSIGNED DEFAULT NULL COMMENT '语文分数',
  `english_score` float(10, 2) UNSIGNED DEFAULT NULL COMMENT '英语成绩',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (1, 1, 1, 60.00, 80.00, 99.00);
INSERT INTO `score` VALUES (2, 1, 2, 80.00, 70.00, 80.00);
INSERT INTO `score` VALUES (6, 2, 2, 66.00, 55.00, 77.00);
INSERT INTO `score` VALUES (5, 2, 1, 56.00, 77.00, 66.00);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自动增量',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `grade_1_id` int(11) UNSIGNED DEFAULT NULL COMMENT '一年级所在班级',
  `grade_2_id` int(11) UNSIGNED DEFAULT NULL COMMENT '二年级所在班级',
  `grade_3_id` int(11) UNSIGNED DEFAULT NULL COMMENT '三年级所在班级',
  `grade_4_id` int(10) UNSIGNED DEFAULT NULL COMMENT '四年级所在班级',
  `grade_5_id` int(10) UNSIGNED DEFAULT NULL COMMENT '五年级所在班级',
  `grade_6_id` int(10) UNSIGNED DEFAULT NULL COMMENT '六年级所在班级',
  `sex` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '性别，0-女生，1-男生',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `nation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '民族',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系电话',
  `parent_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '家长姓名',
  `start_school` date DEFAULT NULL COMMENT '入学时间',
  `hukou` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '户口所在地',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '小明', NULL, NULL, 1, 4, NULL, NULL, 0, NULL, NULL, NULL, '123456', NULL, NULL, NULL);
INSERT INTO `student` VALUES (2, '小李', NULL, NULL, 1, 4, NULL, NULL, 1, '2007-01-02', '汉', '三亚市吉阳镇月川社区358号', '13876396240', '吴冬梅', '2016-09-01', '友谊派出所');

SET FOREIGN_KEY_CHECKS = 1;
