/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.17 : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `blog`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (53),(53),(53),(53),(53);

/*Table structure for table `t_blog` */

DROP TABLE IF EXISTS `t_blog`;

CREATE TABLE `t_blog` (
  `id` bigint(20) NOT NULL,
  `appreciation` bit(1) NOT NULL,
  `commentabled` bit(1) NOT NULL,
  `content` longtext COLLATE utf8_bin,
  `create_time` datetime(6) DEFAULT NULL,
  `first_picture` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `flag` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `published` bit(1) NOT NULL,
  `recommend` bit(1) NOT NULL,
  `share_statement` bit(1) NOT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `person_info_id` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKey4ft6cp9iiqaceg7qmerv38s` (`person_info_id`),
  KEY `FK292449gwg5yf7ocdlmswv9w4j` (`type_id`),
  CONSTRAINT `FK292449gwg5yf7ocdlmswv9w4j` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`),
  CONSTRAINT `FKey4ft6cp9iiqaceg7qmerv38s` FOREIGN KEY (`person_info_id`) REFERENCES `t_person_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_blog` */

insert  into `t_blog`(`id`,`appreciation`,`commentabled`,`content`,`create_time`,`first_picture`,`flag`,`published`,`recommend`,`share_statement`,`title`,`update_time`,`views`,`person_info_id`,`type_id`,`description`) values (22,'\0','','##第一章\r\n\r\n###spring boot 是什么？\r\n spring boot 一个spring 框架的一部分 用于快速构建 j2ee项目\r\n 测试修改功能！看一看博客游览次数 是否更改',NULL,'https://picsum.photos/800/400','转载','\0','','','Spring Boot 学习','2019-12-13 10:32:35.557000',1,1,3,'这是我的第一篇 博客'),(26,'','','#html\r\n\r\n##什么是html？\r\nHTML 是用来描述网页的一种语言。\r\n **html**\r\n <ul>\r\n <li>HTML 指的是超文本标记语言 (Hyper Text Markup Language)</li>\r\n </ul>\r\n','2019-12-13 15:31:18.368000','https://picsum.photos/800/450','转载','','','','HTML','2019-12-13 15:31:18.368000',1,1,24,'这是一个HTML第一篇博客'),(28,'','','spring 框架 是 轻量级框架\r\n 主要用作与 对象的依赖','2019-12-14 06:55:30.563000','https://picsum.photos/800/450','原创','','','','Spring','2019-12-14 06:55:30.563000',6,1,3,'Spring 框架 概述'),(52,'','','#  git学习\r\n\r\n## git的安装\r\n详情参考 [https://git-scm.com/book/en/v2/Getting-Started-Installing-Git](\"https://git-scm.com/book/en/v2/Getting-Started-Installing-Git\")\r\n\r\n\r\n## 如何使用git\r\n\r\n###   第一步进入想要被git管理的目录并初始化  使用如下命令\r\n```\r\ngit init\r\n```\r\n 执行完成之后你会在你的目录中发现一个.git的隐藏文件表示该文件已经被git正式的管理起来\r\n### 第二步 查看 文件是否被git管理状态\r\n```\r\ngit status\r\n```\r\n结果：如果该目录中有新的文件添加,或者已存在的文件被修改,可以通过 git status 检测到\r\n1.如果该文件为红色标记 表示该文件未被git 管理起来\r\n2.如果该文件为绿色标记 表示该文件已经被 git 管理起来\r\n\r\n### 第三步 新增加被git 管理的文件\r\n```\r\n git  add  xxxx\r\n```\r\n如果想把 该文件夹下面的所有的文件 以及子文件 都被git管理 可以使用\r\n```\r\ngit add .\r\n```\r\n**备注：. 表示所有**\r\n通过该命令可以该文件交给git去管理\r\n\r\n###  第四步 提交版本\r\n\r\n```\r\n git  commit -m  \'描述\'\r\n```\r\n\r\n如果此时你发现 你无法提交 表示 你还没有配置 你的nickname 以及email\r\n```\r\n git config --global user.name \"John Doe\"\r\n git config --global user.email johndoe@example.com\r\n```\r\n\r\nuser.name 表示提交的用户\r\nuser.email 表示提交的用户邮箱，该邮箱必须是可用邮箱。如果你提交的内容被修改，会发送相关信息到该邮箱提示相关信息\r\n\r\n## 操作完成 可以通过 如下命令查看 提交的历史版本 如何操作？\r\n使用如下命令即可\r\n```\r\n git log \r\n```\r\n\r\n',NULL,'https://picsum.photos/800/450','原创','','','','git 学习笔记（一）','2019-12-17 07:17:08.899000',6,1,51,'该文章为博主自己的学习笔记,喜欢记得评论哦~');

/*Table structure for table `t_blog_tags` */

DROP TABLE IF EXISTS `t_blog_tags`;

CREATE TABLE `t_blog_tags` (
  `blogs_id` bigint(20) NOT NULL,
  `tags_id` bigint(20) NOT NULL,
  KEY `FK5feau0gb4lq47fdb03uboswm8` (`tags_id`),
  KEY `FKh4pacwjwofrugxa9hpwaxg6mr` (`blogs_id`),
  CONSTRAINT `FK5feau0gb4lq47fdb03uboswm8` FOREIGN KEY (`tags_id`) REFERENCES `t_tag` (`id`),
  CONSTRAINT `FKh4pacwjwofrugxa9hpwaxg6mr` FOREIGN KEY (`blogs_id`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_blog_tags` */

insert  into `t_blog_tags`(`blogs_id`,`tags_id`) values (22,21),(26,23),(28,21),(52,21),(52,25);

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL,
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nickname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `blog_id` bigint(20) DEFAULT NULL,
  `parent_comment_id` bigint(20) DEFAULT NULL,
  `admin_comment` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKke3uogd04j4jx316m1p51e05u` (`blog_id`),
  KEY `FK4jj284r3pb7japogvo6h72q95` (`parent_comment_id`),
  CONSTRAINT `FK4jj284r3pb7japogvo6h72q95` FOREIGN KEY (`parent_comment_id`) REFERENCES `t_comment` (`id`),
  CONSTRAINT `FKke3uogd04j4jx316m1p51e05u` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_comment` */

insert  into `t_comment`(`id`,`avatar`,`content`,`create_time`,`email`,`nickname`,`blog_id`,`parent_comment_id`,`admin_comment`) values (33,'/images/avatar.png','写的不错','2019-12-14 09:20:10.557000','xiaobai@163.com','小白',28,NULL,'\0'),(34,'/images/avatar.png','这个是@小白的测试信息','2019-12-14 09:21:03.037000','xiaohong@163.com','小红',28,33,'\0'),(35,'/images/avatar.png','测试回复信息','2019-12-14 10:27:28.502000','xiao@163.com','小黑',28,34,'\0'),(36,'/images/avatar.png','谢谢 你小黑','2019-12-14 10:37:35.883000','xiao@163.com','小白',28,33,'\0'),(37,'/images/avatar.png','小兰的评论','2019-12-14 10:39:15.626000','xiao@163.com','小兰',28,NULL,'\0'),(38,'/images/avatar.png','小黑 你看的怎么样','2019-12-14 10:39:39.688000','xiao@163.com','小红',28,35,'\0'),(49,'https://picsum.photos/100/100','测试管理员评论消息','2019-12-14 13:43:00.854000','13280009615@63.com','小凡',28,NULL,''),(50,'https://picsum.photos/100/100','小白 你学的怎么样了','2019-12-14 13:43:15.524000','13280009615@63.com','小凡',28,36,'');

/*Table structure for table `t_person_info` */

DROP TABLE IF EXISTS `t_person_info`;

CREATE TABLE `t_person_info` (
  `id` bigint(20) NOT NULL,
  `avatar` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `nickname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_person_info` */

insert  into `t_person_info`(`id`,`avatar`,`create_time`,`email`,`nickname`,`password`,`type`,`update_time`,`username`) values (1,'https://picsum.photos/100/100','2019-12-11 22:28:39.000000','13280009615@63.com','小凡','96e79218965eb72c92a549dd5a330112',1,'2019-12-11 22:29:04.000000','zhengfan');

/*Table structure for table `t_tag` */

DROP TABLE IF EXISTS `t_tag`;

CREATE TABLE `t_tag` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_tag` */

insert  into `t_tag`(`id`,`name`) values (21,'Spring Boot'),(23,'sublime'),(25,'idea');

/*Table structure for table `t_type` */

DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`name`) values (3,'JAVA'),(9,'错误日志'),(20,'SQL'),(24,'HTML'),(51,'GIT');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
