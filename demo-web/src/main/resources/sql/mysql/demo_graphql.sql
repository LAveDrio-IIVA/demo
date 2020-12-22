/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : 172.16.120.38:3306
 Source Schema         : demo_graphql

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 22/12/2020 17:27:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for advertisement
-- ----------------------------
DROP TABLE IF EXISTS `advertisement`;
CREATE TABLE `advertisement`  (
  `id` int(10) NOT NULL COMMENT 'id',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `place` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '位置',
  `image_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '连接地址',
  `publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布者',
  `publish_time` datetime(0) NULL DEFAULT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of advertisement
-- ----------------------------
INSERT INTO `advertisement` VALUES (1, 'PC', 'top', '/image/advertisement1.jpg', 'https://graphql.cn/learn/schema/#type-system', '李博博', '2020-12-08 11:15:23');
INSERT INTO `advertisement` VALUES (2, 'PC', 'top', '/image/advertisement2.jpg', 'https://graphql.cn/learn/schema/#type-system', '王多鱼', '2019-09-08 11:15:23');
INSERT INTO `advertisement` VALUES (3, 'H5', 'left', '/image/advertisement3.jpg', 'https://graphql.cn/learn/schema/#type-system', '马冬梅', '2006-12-01 11:15:23');
INSERT INTO `advertisement` VALUES (4, 'APP', 'right', '/image/advertisement4.jpg', 'https://graphql.cn/learn/schema/#type-system', '马化腾', '2015-02-28 11:15:23');

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES (1, '余华');
INSERT INTO `author` VALUES (2, '莫言');
INSERT INTO `author` VALUES (3, '东野圭吾');
INSERT INTO `author` VALUES (4, '马尔克斯');
INSERT INTO `author` VALUES (5, '艾萨克森');
INSERT INTO `author` VALUES (6, '杨绛');
INSERT INTO `author` VALUES (7, '林语堂');
INSERT INTO `author` VALUES (8, '藤子·F·不二雄');
INSERT INTO `author` VALUES (9, '曹雪芹');
INSERT INTO `author` VALUES (10, '曹雪芹');
INSERT INTO `author` VALUES (11, '曹雪芹');
INSERT INTO `author` VALUES (12, '曹雪芹');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(10) NOT NULL COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '书名',
  `category_id` int(10) NULL DEFAULT NULL COMMENT '类别id',
  `author_id` int(10) NULL DEFAULT NULL COMMENT '作者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '活着', 1, 1);
INSERT INTO `book` VALUES (2, '许三观卖血记', 1, 1);
INSERT INTO `book` VALUES (3, '檀香刑', 1, 2);
INSERT INTO `book` VALUES (4, '生死疲劳', 1, 2);
INSERT INTO `book` VALUES (5, '红高粱家族', 1, 2);
INSERT INTO `book` VALUES (6, '嫌疑人X的献身', 1, 3);
INSERT INTO `book` VALUES (7, '白夜行', 1, 3);
INSERT INTO `book` VALUES (8, '百年孤独', 1, 4);
INSERT INTO `book` VALUES (9, '霍乱时期的爱情', 1, 4);
INSERT INTO `book` VALUES (10, '史蒂夫·乔布斯传', 2, 5);
INSERT INTO `book` VALUES (11, '我们仨', 2, 6);
INSERT INTO `book` VALUES (12, '苏东坡传', 2, 7);
INSERT INTO `book` VALUES (13, '哆啦A梦', 3, 8);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(10) NOT NULL COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '小说');
INSERT INTO `category` VALUES (2, '传记');
INSERT INTO `category` VALUES (3, '动漫');
INSERT INTO `category` VALUES (4, '少儿');
INSERT INTO `category` VALUES (5, '历史');
INSERT INTO `category` VALUES (6, '励志');

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES (1, '清华大学');
INSERT INTO `school` VALUES (2, '北京大学');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字',
  `school_id` int(10) NOT NULL COMMENT '学校id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '朱自清', 1);
INSERT INTO `teacher` VALUES (2, '闻一多', 1);
INSERT INTO `teacher` VALUES (3, '王力', 1);
INSERT INTO `teacher` VALUES (4, '严复', 2);
INSERT INTO `teacher` VALUES (5, '胡仁源', 2);
INSERT INTO `teacher` VALUES (6, '蔡元培', 2);

SET FOREIGN_KEY_CHECKS = 1;
