/*
Navicat MySQL Data Transfer

Source Server         : 22
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : lrms

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-05-20 01:47:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `pwd` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'a01', 'aaa', '15322626', 'a01');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(50) NOT NULL,
  `roomId` int(11) NOT NULL,
  `roomName` varchar(50) NOT NULL,
  `teacherId` int(11) NOT NULL,
  `teacherName` varchar(50) NOT NULL,
  `studentId` int(11) NOT NULL,
  `studentName` varchar(50) NOT NULL,
  `year` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `day` int(11) NOT NULL,
  `stuNum` int(11) NOT NULL,
  `courseNo` int(11) NOT NULL,
  `equipment` text,
  `remark` text,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '数学', '4', '实验室01', '2', '王帅', '1', 's01', '2017', '5', '2', '22', '1', '无', '无', '1');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `location` varchar(500) DEFAULT NULL,
  `remark` text,
  `stuNum` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('2', '化学实验室', '1楼', '啊啊啊', '20');
INSERT INTO `room` VALUES ('3', '实验室02', '2楼', '', '25');
INSERT INTO `room` VALUES ('4', '实验室01', 'ds', '', '23');
INSERT INTO `room` VALUES ('5', '实验室04', '222', '', '22');
INSERT INTO `room` VALUES ('6', '实验室05', 'ds', '', '222');
INSERT INTO `room` VALUES ('7', '实验室06', '3232', '', '32');
INSERT INTO `room` VALUES ('8', '实验室07', '22', '', '22');
INSERT INTO `room` VALUES ('9', '实验室07', '22', '22', '22');
INSERT INTO `room` VALUES ('10', '实验室08', '22', '22', '22');
INSERT INTO `room` VALUES ('11', '实验室09', '232', '', '32');
INSERT INTO `room` VALUES ('12', '实验室22', 'ds', '', '32');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `courseName` varchar(50) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `pwd` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 's01', 's01', '数学', '1515', 's01');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `courseName` varchar(50) NOT NULL,
  `pwd` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('2', 't01', '王帅', '15364548848', '数学', 't01');
