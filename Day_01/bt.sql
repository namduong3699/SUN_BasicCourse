/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : bt

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-09-12 13:41:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for token_auth
-- ----------------------------
DROP TABLE IF EXISTS `token_auth`;
CREATE TABLE `token_auth` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `random_hash` varchar(255) NOT NULL,
  `is_expired` int(11) NOT NULL DEFAULT '0',
  `expiry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of token_auth
-- ----------------------------
INSERT INTO `token_auth` VALUES ('1', 'admin', '$2y$10$rZPVqhqRb1NZZxIhmbuYIuVFN/dNo8logcK.Vm/cX0Icwyv0FliPW', '$2y$10$AI1RWxlAeQnNZEPa1iD.d.mQuUDagMY16JkxhDr/DWMvpmTL0elcO', '1', '2019-09-12 11:20:39');
INSERT INTO `token_auth` VALUES ('2', 'admin', '$2y$10$G/pvmeSORwcQ8ft4nVSgXOZtPf5XaAdiaGesqIXX.bI6eGBmpZuuG', '$2y$10$WvstvpQhZOMcTtW3b53mHO.dOifF5..gece/Y9TCoWbqNkT3PwOo2', '1', '2019-09-12 11:23:46');
INSERT INTO `token_auth` VALUES ('3', 'admin', '$2y$10$2IXvqcpRsGiYJEAeEx94PuFfmCg8XFI6COYABb6F1vQg.M2dOQrbC', '$2y$10$MB7Gxmxz4hVmhp9V5foieOz1rczBhrC1hZZWPwbPygwI.z45tS/X6', '1', '2019-09-12 11:34:49');
INSERT INTO `token_auth` VALUES ('4', 'admin', '$2y$10$4KR/ppMu4wQPTGifF596Zuw/JhfDW56k3WhKXPvks1pBQJ8aQttCe', '$2y$10$XZ/E5T9T4xGermEya1J2z.29Xq3W/Tiut7S393GFLZ15sITSJ8iai', '1', '2019-09-12 11:39:02');
INSERT INTO `token_auth` VALUES ('8', 'admin', '$2y$10$Z8McadDNcE1KhubNAARO0OeBQLABFuObEZeu25XJUrN8aAUUnaKpO', '$2y$10$IkAaUee0AE5LZbVbwBgD4ehHvGMsO1D6jEyXjl60sy7ZC.JshIxeK', '1', '2019-09-12 11:50:07');
INSERT INTO `token_auth` VALUES ('9', 'admin', '$2y$10$vbJ5jz54jIFNV/6NJHzwB.pBLH9pGtPt1F3UVfNVJVB9FjzW3vtGy', '$2y$10$iDlULUo7SI6q7kfQ97Up8ePu/qh6i99UDWFKC1Bb2ULs0Cm0keE5C', '1', '2019-09-12 11:50:11');
INSERT INTO `token_auth` VALUES ('10', 'admin', '$2y$10$rGFfSxoJXq6PLYAa8PVX7uXLQqIjcrsHZyvAXB65xZgoTZyVPlOqi', '$2y$10$okOVmnF./jQKKSnASNWui.FxX0VaNuyoaYDEPqtm/lHp05wUTHPWi', '1', '2019-09-12 12:54:53');
INSERT INTO `token_auth` VALUES ('11', 'admin', '$2y$10$095Vpkbepk7V3w5hwLTM6uPyCPWVJUuIQ4C53..Wx/zPTFiy.0tqq', '$2y$10$m/EB3zPu4rVcuCpDpoEuruDrY1C0QootrUTfpx9aIiA2PIpBkUB1y', '1', '2019-09-12 12:59:33');
INSERT INTO `token_auth` VALUES ('12', 'admin', '$2y$10$XPYTFtPC5FJyIGdkhYMBLu1ZfxNuSv//Oafd2iuRbojtcDee73PQq', '$2y$10$ysE/XkH69vAQLHsEeJv3eOYhCgR6chd6ko4Rm8uX2oMwS/u9pLsWG', '1', '2019-09-12 13:00:00');
INSERT INTO `token_auth` VALUES ('13', 'admin', '$2y$10$C1QSXnDM1l.izcv23jqtbO7W0ouehISvVh3OaOE2OBS.5ezknu4C2', '$2y$10$KkuapCR87rcws4C3luZt5.13tVzD4IjOApukyu2uIqtPI/XOrjHfm', '1', '2019-09-12 13:10:03');
INSERT INTO `token_auth` VALUES ('14', 'admin', '$2y$10$Y1GxK9BaSX3W24Z7dr4csO9pPYhV2zulIDCw2Gw/v0pYu5DMxjcrW', '$2y$10$mPFHO8o8Dv.4p0b8YMxD.uQAyDQNd1ApvwBGFcRErWJ2NPEjoLwwa', '1', '2019-09-12 13:13:26');
INSERT INTO `token_auth` VALUES ('15', 'admin', '$2y$10$NgreD4u/gEJygNaovlSA4eNAcsZvdX36l35zl8EVWIwwpmjYS605e', '$2y$10$vnxJLgrM49cX7llL55xvbO3NJAeUHLryxYgKeDVUAmgUHav7JyguG', '1', '2019-09-12 13:18:05');
INSERT INTO `token_auth` VALUES ('16', 'admin', '$2y$10$qeWxh6HNCINjQBBzihssReRbGUhIANHUS2TPur4pTPXwecLfxDbYq', '$2y$10$rSfLPT0VWEJpj8QTaRS7JudyeT/ALSUkYZJfnVrz9qoJmc1Q/NXMO', '0', '2019-10-12 08:18:04');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '$2y$10$JyN4AbKdfJLOAzHvVlvmLu1/fpq.2Anb6EwVidRVLoqTo6XgVxYxu', 'user@gmail.com');
