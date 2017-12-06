/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : greeneggplant

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-05-19 14:51:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for aaa
-- ----------------------------
DROP TABLE IF EXISTS `aaa`;
CREATE TABLE `aaa` (
  `sfssf` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `weqweq` time(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aaa
-- ----------------------------

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookID` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书ID',
  `bookOnlyCoding` varchar(50) DEFAULT NULL COMMENT '图书唯一编码',
  `bookName` varchar(50) DEFAULT NULL COMMENT '图书名称',
  `author` varchar(50) DEFAULT NULL COMMENT '作者',
  `publishingCompany` varchar(50) DEFAULT NULL COMMENT '出版社',
  `publishTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '出版时间',
  `stock` int(20) DEFAULT NULL COMMENT '图书库存',
  `price` decimal(10,2) DEFAULT NULL COMMENT '图书单价',
  `picture` varchar(200) DEFAULT NULL COMMENT '图片路劲',
  `abstruct` varchar(50) DEFAULT NULL COMMENT '内容简介',
  `libraryTypeID` int(11) DEFAULT NULL COMMENT '图书类别ID',
  `libraryPagination` int(10) DEFAULT NULL COMMENT '图书页数',
  `buildTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '入库时间',
  `libraryID` int(11) DEFAULT NULL COMMENT '图书所在分馆编号',
  PRIMARY KEY (`bookID`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('74', '001', '坚持梦想', '马云', '阿里巴巴', '2017-04-26 10:04:40', '89', '88.00', 'mayun.jpg', '99', '1', '88', '2017-04-26 10:04:40', '1');
INSERT INTO `book` VALUES ('75', '002', '你不生气你就赢了', '大光', '光大', '2017-04-26 10:04:41', '77', '77.00', 'bushengqinijiuyingle.jpg', '77', '2', '77', '2017-04-26 10:04:41', '1');
INSERT INTO `book` VALUES ('76', '003', '成语故事', '老先生', '古老出版社', '2017-04-01 16:09:52', '87', '88.00', 'chengyugushi.jpg', '88', '3', '88', '2017-04-01 16:09:52', '1');
INSERT INTO `book` VALUES ('77', '004', '王帝内经', '王帝', '王帝出版社', '2017-04-01 16:09:53', '77', '77.00', 'huangdineijing.jpg', '77', '4', '77', '2017-04-01 16:09:53', '1');
INSERT INTO `book` VALUES ('78', '005', '将来的你', '鲁班', '时空出版社', '2017-04-01 16:09:55', '88', '88.00', 'jiainglaideni.png', '88', '5', '88', '2017-04-01 16:09:55', '1');
INSERT INTO `book` VALUES ('79', '006', '练字宝', '书法家', '书法家出版社', '2017-04-01 16:09:56', '77', '77.00', 'laingzibao.jpg', '77', '6', '77', '2017-04-01 16:09:56', '1');
INSERT INTO `book` VALUES ('80', '007', '人体描述', '梵高', '梵高出版社', '2017-04-26 10:04:45', '88', '88.00', 'miaoxierensheng.jpg', '88', '1', '88', '2017-04-26 10:04:45', '1');
INSERT INTO `book` VALUES ('81', '008', '妈妈我能行', '靠自己', '小小出版社', '2017-04-25 11:33:22', '77', '77.00', 'mmawonengxing.jpg', '77', '2', '77', '2017-04-25 11:33:22', '1');
INSERT INTO `book` VALUES ('82', '018', '豪车', '车行', '车行出版社', '2017-04-01 16:10:00', '88', '88.00', 'th(2).jpg', '88', '3', '88', '2017-04-01 16:10:00', '1');
INSERT INTO `book` VALUES ('84', '009', '执行力', '卡特里', '暴力出版社', '2017-04-01 16:10:02', '88', '88.00', 'qiyeguanli.jpg', '88', '4', '88', '2017-04-01 16:10:02', '2');
INSERT INTO `book` VALUES ('86', '019', '美女与野兽', '野兽先生', '野兽出版社', '2017-04-01 16:19:17', '88', '88.00', 'tuzipo.jpg', '88', '5', '88', '2017-04-01 16:19:17', '2');
INSERT INTO `book` VALUES ('88', '010', '人际交往', '墨子', '墨子出版社', '2017-04-01 16:10:05', '88', '88.00', 'renjijaiowang.jpg', '88', '6', '88', '2017-04-01 16:10:05', '2');
INSERT INTO `book` VALUES ('90', '011', '人性的弱点', '普通人', '人人出版社', '2017-04-26 10:04:47', '99', '99.00', 'renxingderuodian.jpg', '999', '1', '99', '2017-04-26 10:04:47', '2');
INSERT INTO `book` VALUES ('91', '012', '三字经', '王应麟', '万网出版社', '2017-04-01 16:10:12', '554', '9.00', 'sanzijing.jpg', '009', '2', '999', '2017-04-01 16:10:12', '2');
INSERT INTO `book` VALUES ('92', '013', '米小圈上学记', '圈儿', '上学记出版社', '2017-05-17 15:58:42', '77', '77.00', 'shangxueji.jpg', '不要看', '3', '77', '2017-05-17 15:58:42', '2');
INSERT INTO `book` VALUES ('94', '014', '太空历险记', '杨利伟', '太空出版社', '2017-04-01 16:10:15', '98', '66.00', 'taikongtansuo.jpg', '反攻倒算富商大贾', '4', '777', '2017-04-01 16:10:15', '2');
INSERT INTO `book` VALUES ('95', '014', '天生在左', '必备', '牛逼', '2017-04-01 16:10:17', '555', '44.00', 'taincaizuoyou.jpg', '而tyre富商大贾', '5', '666', '2017-04-01 16:10:17', '2');
INSERT INTO `book` VALUES ('96', '015', '兔子城', '兔子先生', '萝卜出版社', '2017-04-01 16:10:18', '33', '33.00', 'tuzipo.jpg', '丰田 ', '6', '333', '2017-04-01 16:10:18', '2');
INSERT INTO `book` VALUES ('98', '017', '真的很爱你', '真爱先生', '真爱出版社', '2017-04-01 16:10:22', '66', '23.00', 'zhendehnaini.jpg', '345塔尔发广告收费方式', '6', '345', '2017-04-01 16:10:22', '2');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `borrowID` int(11) NOT NULL AUTO_INCREMENT COMMENT '借阅编号',
  `userID` int(11) DEFAULT NULL COMMENT '用户ID',
  `bookID` int(11) DEFAULT NULL COMMENT '图书编号',
  `borrowDate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '借阅时间',
  `whetherReturn` bit(1) DEFAULT NULL COMMENT '是否归还',
  `actualReturnTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '实际归还时间',
  `renewNumber` int(10) DEFAULT NULL COMMENT '续借次数',
  `whetherExtended` bit(1) DEFAULT NULL COMMENT '是否超期',
  `borrowingStatus` bit(1) DEFAULT NULL COMMENT '借阅状态',
  PRIMARY KEY (`borrowID`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('88', '6', '74', '2014-01-27 16:15:54', '', '2017-05-17 00:00:00', '0', '', '\0');
INSERT INTO `borrow` VALUES ('91', '6', '80', '2016-10-01 16:15:55', '\0', '2017-04-27 16:16:10', '0', '', '');
INSERT INTO `borrow` VALUES ('92', '6', '92', '2017-04-27 16:15:57', '\0', '2017-04-27 16:15:57', '0', '\0', '');
INSERT INTO `borrow` VALUES ('93', '6', '92', '2016-08-01 09:36:16', '\0', '2017-04-27 16:16:18', '0', '', '');
INSERT INTO `borrow` VALUES ('94', '7', '94', '2016-09-01 00:00:00', '\0', '2017-05-17 19:52:39', '0', '', '');
INSERT INTO `borrow` VALUES ('95', '7', '76', '2016-09-01 00:00:00', '\0', '2017-05-17 19:52:47', '0', '', '');

-- ----------------------------
-- Table structure for datails
-- ----------------------------
DROP TABLE IF EXISTS `datails`;
CREATE TABLE `datails` (
  `detailsID` int(11) NOT NULL AUTO_INCREMENT,
  `detailsTypeID` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `thepicture` varchar(255) DEFAULT NULL,
  `article` varchar(520) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `publishcontent` varchar(8000) DEFAULT NULL,
  `expectthereleasedate` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `createrID` int(11) DEFAULT NULL,
  `creatertime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `changedbyID` int(11) DEFAULT NULL,
  `changedbystate` bit(1) DEFAULT NULL,
  `approvaltime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `approvalID` int(11) DEFAULT NULL,
  `changedbytime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`detailsID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of datails
-- ----------------------------
INSERT INTO `datails` VALUES ('4', '1', '11', 'mayun.jpg', '111', '1111', '11111', '2017-05-18 10:36:08', '6', '2017-05-18 10:36:08', null, '', '2017-05-18 10:36:08', null, '2017-05-18 10:36:08');
INSERT INTO `datails` VALUES ('5', '1', '22', 'huangdineijing.jpg', '222', '2222', '222222', '2017-05-04 11:47:43', '6', '2017-05-04 11:47:43', null, '', '2017-05-04 11:47:43', null, '2017-05-04 11:47:43');
INSERT INTO `datails` VALUES ('6', '1', '33', 'renjijaiowang.jpg', '33', '33', '333', '2017-05-16 11:09:35', '6', '2017-05-17 00:00:00', null, '', null, null, null);
INSERT INTO `datails` VALUES ('7', '1', '44', 'huangdineijing.jpg', '44', '44', '44', '2017-05-16 11:16:42', '6', '2017-05-17 00:00:00', null, '', null, null, null);

-- ----------------------------
-- Table structure for fine
-- ----------------------------
DROP TABLE IF EXISTS `fine`;
CREATE TABLE `fine` (
  `fineID` int(11) NOT NULL AUTO_INCREMENT COMMENT '罚款ID',
  `userID` int(11) DEFAULT NULL COMMENT '用户ID',
  `bookID` int(11) DEFAULT NULL COMMENT '图书ID',
  `borrowID` int(11) DEFAULT NULL COMMENT '借阅记录ID',
  `forfeit` decimal(10,2) DEFAULT NULL COMMENT '罚款金额',
  `fineTypeID` int(11) DEFAULT NULL COMMENT '罚款类型ID',
  `payment` bit(1) DEFAULT NULL COMMENT '是否付款',
  PRIMARY KEY (`fineID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fine
-- ----------------------------
INSERT INTO `fine` VALUES ('1', '6', '74', '88', '111.60', '1', '');

-- ----------------------------
-- Table structure for finetype
-- ----------------------------
DROP TABLE IF EXISTS `finetype`;
CREATE TABLE `finetype` (
  `fineTypeID` int(11) NOT NULL AUTO_INCREMENT COMMENT '罚款类型ID',
  `fineTypeName` varchar(20) DEFAULT NULL COMMENT '罚款类型名称',
  PRIMARY KEY (`fineTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of finetype
-- ----------------------------
INSERT INTO `finetype` VALUES ('1', '超期');
INSERT INTO `finetype` VALUES ('2', '丢失');

-- ----------------------------
-- Table structure for library
-- ----------------------------
DROP TABLE IF EXISTS `library`;
CREATE TABLE `library` (
  `libraryID` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书馆ID',
  `libraryName` varchar(255) NOT NULL COMMENT '图书馆名称',
  PRIMARY KEY (`libraryID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of library
-- ----------------------------
INSERT INTO `library` VALUES ('1', '广信超级无敌大图书馆');
INSERT INTO `library` VALUES ('2', '中央图书馆');

-- ----------------------------
-- Table structure for librarytype
-- ----------------------------
DROP TABLE IF EXISTS `librarytype`;
CREATE TABLE `librarytype` (
  `libraryTypeID` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书类别ID',
  `libraryType` varchar(255) NOT NULL COMMENT '图书类别',
  PRIMARY KEY (`libraryTypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of librarytype
-- ----------------------------
INSERT INTO `librarytype` VALUES ('1', '小说');
INSERT INTO `librarytype` VALUES ('2', '中国漫画');
INSERT INTO `librarytype` VALUES ('3', '科幻');
INSERT INTO `librarytype` VALUES ('4', '励志');
INSERT INTO `librarytype` VALUES ('5', '惊悚');
INSERT INTO `librarytype` VALUES ('6', '恐怖');

-- ----------------------------
-- Table structure for loselibrary
-- ----------------------------
DROP TABLE IF EXISTS `loselibrary`;
CREATE TABLE `loselibrary` (
  `libraryLoseID` int(11) NOT NULL AUTO_INCREMENT COMMENT '丢失图书ID',
  `userID` int(11) DEFAULT NULL COMMENT '用户ID',
  `libraryID` int(11) DEFAULT NULL COMMENT '图书ID',
  `borrowID` int(11) DEFAULT NULL COMMENT '借阅记录ID',
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `loseTypeID` int(11) DEFAULT NULL COMMENT '丢失类型',
  PRIMARY KEY (`libraryLoseID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loselibrary
-- ----------------------------

-- ----------------------------
-- Table structure for losetype
-- ----------------------------
DROP TABLE IF EXISTS `losetype`;
CREATE TABLE `losetype` (
  `loseTypeID` int(11) NOT NULL AUTO_INCREMENT COMMENT '丢失类型ID',
  `loseName` varchar(20) DEFAULT NULL COMMENT '丢失类型名称',
  PRIMARY KEY (`loseTypeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of losetype
-- ----------------------------

-- ----------------------------
-- Table structure for mailmessage
-- ----------------------------
DROP TABLE IF EXISTS `mailmessage`;
CREATE TABLE `mailmessage` (
  `EmailID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `remail` varchar(255) DEFAULT NULL,
  `sendmail` varchar(255) DEFAULT NULL,
  `mailtitle` varchar(255) DEFAULT NULL,
  `ContextType` varchar(255) DEFAULT NULL COMMENT '内容格式',
  `filename` varchar(255) DEFAULT NULL,
  `filename1` varchar(255) DEFAULT NULL,
  `creationtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Expecttosendtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `numberofretries` int(11) DEFAULT NULL,
  `actualtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`EmailID`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mailmessage
-- ----------------------------
INSERT INTO `mailmessage` VALUES ('157', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2014-01-27 16:15:54.0书名为《坚持梦想》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-03 00:00:00', '2017-05-03 00:00:00', '1', '2017-05-03 00:00:00');
INSERT INTO `mailmessage` VALUES ('158', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-10-01 16:15:55.0书名为《人体描述》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-03 00:00:00', '2017-05-03 00:00:00', '1', '2017-05-03 00:00:00');
INSERT INTO `mailmessage` VALUES ('159', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-08-01 09:36:16.0书名为《小圈上学记》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-03 00:00:00', '2017-05-03 00:00:00', '1', '2017-05-03 00:00:00');
INSERT INTO `mailmessage` VALUES ('160', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2014-01-27 16:15:54.0书名为《坚持梦想》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-03 00:00:00', '2017-05-03 00:00:00', '1', '2017-05-03 00:00:00');
INSERT INTO `mailmessage` VALUES ('161', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-10-01 16:15:55.0书名为《人体描述》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-03 00:00:00', '2017-05-03 00:00:00', '1', '2017-05-03 00:00:00');
INSERT INTO `mailmessage` VALUES ('162', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-08-01 09:36:16.0书名为《小圈上学记》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-03 00:00:00', '2017-05-03 00:00:00', '1', '2017-05-03 00:00:00');
INSERT INTO `mailmessage` VALUES ('163', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2014-01-27 16:15:54.0书名为《坚持梦想》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('164', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2014-01-27 16:15:54.0书名为《坚持梦想》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('165', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-10-01 16:15:55.0书名为《人体描述》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('166', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-08-01 09:36:16.0书名为《小圈上学记》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('167', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-10-01 16:15:55.0书名为《人体描述》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('168', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-08-01 09:36:16.0书名为《小圈上学记》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('169', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2014-01-27 16:15:54.0书名为《坚持梦想》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('170', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2014-01-27 16:15:54.0书名为《坚持梦想》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('171', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-10-01 16:15:55.0书名为《人体描述》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('172', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-10-01 16:15:55.0书名为《人体描述》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('173', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-08-01 09:36:16.0书名为《米小圈上学记》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('174', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-08-01 09:36:16.0书名为《米小圈上学记》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('175', '7', '1010789554@qq.com', '1010789554@qq.com', '您好！李白根据您2016-09-01 00:00:00.0书名为《太空历险记》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('176', '7', '1010789554@qq.com', '1010789554@qq.com', '您好！李白根据您2016-09-01 00:00:00.0书名为《太空历险记》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('177', '7', '1010789554@qq.com', '1010789554@qq.com', '您好！李白根据您2016-09-01 00:00:00.0书名为《成语故事》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-17 00:00:00', '2017-05-17 00:00:00', '1', '2017-05-17 00:00:00');
INSERT INTO `mailmessage` VALUES ('180', '7', '1010789554@qq.com', '1010789554@qq.com', '你好!李白根据您2016-09-01 00:00:00.0书名为《成语故事》的借书记录，现在已经到期了，请尽快还书，不然将会以每天0.1毛的超期记录费用进行扣费，谢谢合作', 'pop3', '无', '无', '2017-05-18 00:00:00', '2017-05-18 00:00:00', '1', '2017-05-18 00:00:00');
INSERT INTO `mailmessage` VALUES ('181', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-10-01 16:15:55.0书名为《人体描述》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-18 00:00:00', '2017-05-18 00:00:00', '1', '2017-05-18 00:00:00');
INSERT INTO `mailmessage` VALUES ('182', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-10-01 16:15:55.0书名为《人体描述》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-18 00:00:00', '2017-05-18 00:00:00', '1', '2017-05-18 00:00:00');
INSERT INTO `mailmessage` VALUES ('183', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-08-01 09:36:16.0书名为《米小圈上学记》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-18 00:00:00', '2017-05-18 00:00:00', '1', '2017-05-18 00:00:00');
INSERT INTO `mailmessage` VALUES ('184', '7', '1010789554@qq.com', '1010789554@qq.com', '您好！李白根据您2016-09-01 00:00:00.0书名为《太空历险记》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-18 00:00:00', '2017-05-18 00:00:00', '1', '2017-05-18 00:00:00');
INSERT INTO `mailmessage` VALUES ('185', '6', '1010789554@qq.com', '1010789554@qq.com', '您好！张三根据您2016-08-01 09:36:16.0书名为《米小圈上学记》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-18 00:00:00', '2017-05-18 00:00:00', '1', '2017-05-18 00:00:00');
INSERT INTO `mailmessage` VALUES ('186', '7', '1010789554@qq.com', '1010789554@qq.com', '您好！李白根据您2016-09-01 00:00:00.0书名为《太空历险记》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-18 00:00:00', '2017-05-18 00:00:00', '1', '2017-05-18 00:00:00');
INSERT INTO `mailmessage` VALUES ('187', '7', '1010789554@qq.com', '1010789554@qq.com', '您好！李白根据您2016-09-01 00:00:00.0书名为《成语故事》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-18 00:00:00', '2017-05-18 00:00:00', '1', '2017-05-18 00:00:00');
INSERT INTO `mailmessage` VALUES ('188', '7', '1010789554@qq.com', '1010789554@qq.com', '您好！李白根据您2016-09-01 00:00:00.0书名为《成语故事》日的借书记录,现在快到期了，请在三个工作日之内还书，谢谢！！！', 'pop3', '无', '无', '2017-05-18 00:00:00', '2017-05-18 00:00:00', '1', '2017-05-18 00:00:00');
INSERT INTO `mailmessage` VALUES ('189', '7', '1010789554@qq.com', '1010789554@qq.com', '你好!李白根据您2016-09-01 00:00:00.0书名为《成语故事》的借书记录，现在已经到期了，请尽快还书，不然将会以每天0.1毛的超期记录费用进行扣费，谢谢合作', 'pop3', '无', '无', '2017-05-18 00:00:00', '2017-05-18 00:00:00', '1', '2017-05-18 00:00:00');

-- ----------------------------
-- Table structure for overrecord
-- ----------------------------
DROP TABLE IF EXISTS `overrecord`;
CREATE TABLE `overrecord` (
  ` overDueID` int(11) NOT NULL AUTO_INCREMENT COMMENT '超期记录表',
  `userID` int(11) DEFAULT NULL COMMENT '用户ID',
  `bookID` int(11) DEFAULT NULL COMMENT '图书ID',
  `overDueNumber` int(11) DEFAULT NULL COMMENT '超期天数',
  `borrowID` int(11) DEFAULT NULL COMMENT '借阅记录编号',
  PRIMARY KEY (` overDueID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of overrecord
-- ----------------------------
INSERT INTO `overrecord` VALUES ('1', '6', '74', '1116', '88');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `roleName` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `orAdmin` bit(1) DEFAULT NULL COMMENT '是否是管理员',
  `borrowBooksLength` int(11) DEFAULT NULL COMMENT '借书时长',
  PRIMARY KEY (`roleID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '', '90');
INSERT INTO `role` VALUES ('2', '老师', '\0', '60');
INSERT INTO `role` VALUES ('3', '学生', '\0', '30');

-- ----------------------------
-- Table structure for sysnews
-- ----------------------------
DROP TABLE IF EXISTS `sysnews`;
CREATE TABLE `sysnews` (
  `systeminformationID` int(11) NOT NULL AUTO_INCREMENT,
  `senduserID` int(11) DEFAULT NULL,
  `sendusertype` int(11) DEFAULT NULL,
  `resuserID` int(11) DEFAULT NULL,
  `resusertype` int(11) DEFAULT NULL,
  `messagecontent` varchar(1000) DEFAULT NULL,
  `transmissiontime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `Whetherornottoread` bit(1) DEFAULT NULL,
  `readtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`systeminformationID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sysnews
-- ----------------------------
INSERT INTO `sysnews` VALUES ('7', '6', '1', '6', '1', '张三上午好！我们有新出的图书米《小圈上学记》', '2017-03-01 21:02:17', '', '2017-05-17 21:04:02');
INSERT INTO `sysnews` VALUES ('8', '6', '1', '6', '1', '张三上午好！我们有新出的图书《坚持梦想》', '2017-04-29 21:02:17', '', '2017-05-17 21:03:52');
INSERT INTO `sysnews` VALUES ('9', '6', '1', '6', '1', '张三上午好！我们有新出的图书《坚持梦想》', '2017-04-29 21:02:17', '\0', '2017-05-17 21:03:48');
INSERT INTO `sysnews` VALUES ('10', '6', '1', '6', '1', '张三上午好！我们有新出的图书《坚持梦想》', '2017-04-29 21:02:17', '\0', '2017-05-17 21:03:45');
INSERT INTO `sysnews` VALUES ('11', '6', '1', '7', '2', '李白下午好！我们有新出的图书《米小圈上学记》', '2017-05-02 21:02:17', '', '2017-05-17 21:03:43');
INSERT INTO `sysnews` VALUES ('12', '6', '1', '6', '1', '张三上午好！我们有新出的图书《坚持梦想》', '2017-05-03 21:02:17', '\0', '2017-05-17 21:03:40');
INSERT INTO `sysnews` VALUES ('13', '6', '1', '6', '1', '张三上午好！我们有新出的图书《坚持梦想》', '2017-04-01 21:02:17', '\0', '2017-05-17 21:03:36');
INSERT INTO `sysnews` VALUES ('16', '6', '1', '7', '2', '李白下午好！我们有新出的图书《小圈上学记》', '2017-05-12 21:02:17', '\0', '2017-05-17 21:03:34');
INSERT INTO `sysnews` VALUES ('17', '6', '1', '7', '2', '李白下午好！我们有新出的图书《小圈上学记》', '2017-05-17 21:02:17', '', '2017-05-18 16:45:50');
INSERT INTO `sysnews` VALUES ('28', '6', '1', '8', '2', '钟馗上午好！我们有新出的图书《米小圈上学记》', '2017-05-18 11:18:34', '\0', null);
INSERT INTO `sysnews` VALUES ('29', '6', '1', '6', '1', '张三下午好！我们有新出的图书《人性的弱点》', '2017-05-18 16:43:48', '\0', null);
INSERT INTO `sysnews` VALUES ('30', '6', '1', '6', '1', '张三下午好！我们有新出的图书《米小圈上学记》', '2017-05-18 16:43:48', '\0', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(50) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `sex` varchar(5) DEFAULT NULL COMMENT '性别',
  `libraryCard` varchar(20) DEFAULT NULL COMMENT '借书证',
  `mail` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(15) DEFAULT NULL COMMENT '电话',
  `borrow` bit(1) DEFAULT NULL COMMENT '是否可借书',
  `borrowingAmount` int(10) DEFAULT NULL COMMENT '借阅数量',
  `roleID` int(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', '张三', 'e10adc3949ba59abbe56e057f20f883e', '女', '2017032517570085', '1010789554@qq.com', '13138728084', '', '3', '1');
INSERT INTO `user` VALUES ('7', '李白', 'e10adc3949ba59abbe56e057f20f883e', '女', '2017032621393631', '1010789554@qq.com', '13138728084', '', '2', '2');
INSERT INTO `user` VALUES ('8', '钟馗', 'e10adc3949ba59abbe56e057f20f883e', '女', '2017032620580859', '1010789554@qq.com', '13138728084', '', '0', '2');
INSERT INTO `user` VALUES ('9', '我白', 'e10adc3949ba59abbe56e057f20f883e', '女', '2017032708055025', '1010789554@qq.com', '13138728084', '', '0', '3');
INSERT INTO `user` VALUES ('10', '李白', 'e10adc3949ba59abbe56e057f20f883e', '男', '2017032621393631', '1010789554@qq.com', '13138728084', '', '0', '2');
INSERT INTO `user` VALUES ('11', '钟馗', 'e10adc3949ba59abbe56e057f20f883e', '女', '2017032620580859', '1010789554@qq.com', '13138728084', '', '0', '2');
INSERT INTO `user` VALUES ('12', '我白', 'e10adc3949ba59abbe56e057f20f883e', '女', '2017032708055025', '1010789554@qq.com', '13138728084', '', '0', '3');
INSERT INTO `user` VALUES ('13', '李白', 'e10adc3949ba59abbe56e057f20f883e', '男', '2017032621393631', '1010789554@qq.com', '13138728084', '', '0', '2');
INSERT INTO `user` VALUES ('14', '钟馗', 'e10adc3949ba59abbe56e057f20f883e', '女', '2017032620580859', '1010789554@qq.com', '13138728084', '', '0', '2');
INSERT INTO `user` VALUES ('16', '小吴', 'e10adc3949ba59abbe56e057f20f883e', '女', '2017032620576757', '1010789554@qq.com', '13138728084', '', '0', '2');
INSERT INTO `user` VALUES ('17', '钟馗', 'e10adc3949ba59abbe56e057f20f883e', '女', '2017032620580859', '1010789554@qq.com', '13138728084', '', '0', '2');
INSERT INTO `user` VALUES ('65', '小三', 'e10adc3949ba59abbe56e057f20f883e', '女', '2017032808192845', '1010789554@qq.com', '13138728084', '', '0', '2');
