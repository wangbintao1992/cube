/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.6.18-enterprise-commercial-advanced : Database - blog
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

/*Table structure for table `articles` */

DROP TABLE IF EXISTS `articles`;

CREATE TABLE `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `title` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `summary` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '摘要',
  `content` text COLLATE utf8_bin NOT NULL COMMENT '内容',
  `imgPath` varchar(120) COLLATE utf8_bin DEFAULT NULL COMMENT '图片',
  `label` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '标签',
  `inputTime` date NOT NULL COMMENT '创建时间',
  `type` int(11) NOT NULL COMMENT '0首页1排行2随笔',
  `viewTimes` int(11) DEFAULT NULL COMMENT '访问次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `articles` */

insert  into `articles`(`id`,`title`,`summary`,`content`,`imgPath`,`label`,`inputTime`,`type`,`viewTimes`) values (1,'在','阿达','<p>用户名：wangbintao 密码： 5tg*UH3ed xct_broker_info.jar xct_manage_platform.jar xct_internal_test.jar http://localhost:8080/XctInternalTestWebApp/queryInfo/insert.jhtml http://localhost:8080/XctInternalTestWebApp/login.jsp 管理平台 1.券商信息管理（初始化） ------------------------ 时间的列宽太小，显示不完全------------------------------- 按创建时间倒序排列---------------------------- 券商ID不可重复----------------------- 3.券商基本信息 新增券商窗口，改为选择券商名称，带入券商ID。------------------- 按创建时间倒序排列---------------------------- 4.券商列表管理（券商下载） 按创建时间倒序排列----------------------- 券商ID不可重复-------------------------------- BrokerInfoAction -----1. response、type、protocolVer没有用到，可以移除 -----2. merchantBrokersTab、交易地址为空的情况下，也要继续下面的步骤，不能返回失败响应 3. 失败响应参数也需要加密--------------------------------- 4. 两个catch可以写成一个-------------------------------- ------5. log.error(\"BrokerInfoAction ,getBrokerInfo Exception version =\" + version);没有错误详情 券商基本信息 1.功能名称显示---------------------------------- 2.新增券商，点确定没反应------------------------------- 3.详情，是否选择营业部、是否选择地区，显示是否，不是有效无效----------------------------- 4.编辑，跟新增一样，选择券商名称。-------------------------- 5.货币基金列表为空，也应该展示新增券商窗口，其他同理。---------------------------------- 券商列表管理 1.修改券商ID，券商基本信息里对应的券商ID也要更改。------------------------------ List mftList = super.find(\" from MoneyFundTabs as m where m.isValid = 0 \"); 像这种只判断一个参数的，可以用super.findBy(name, value)方法。 1. 新增资讯信息，提示&ldquo;修改成功&rdquo;````````````````````````````````` 2. 上传的图片，只显示一小条，没上传图片显示一个半截的图。`````````````````````` 3. 如果不存置顶顺序，显示0，建议显示空。````````````````````````` 4. 建议是否有效显示在grid里，业务可能更关心这个。``````````````````````` 5.搜索框直接显示搜索内容`````````````````````````` 6. 编辑之后，图片没了。``````````````````````````````````````````` 信息商户管理 1. 商户标识用下拉框 Shiro 某用户多个资金账号同时在线时，上传多个资金账号的排名信息。 参与总人数 节假日表 好友 用户鑫财通账号、昵称、券商id、券商名称、资金账号、该资金账号的排名、今日盈亏比 今日参加排名的盈亏比最高值和最低值，我的盈亏比 近一个月的今日盈亏比，向右滑动请求更多。最多返回三个月的数据。 需返回每一个开盘日的数据，某一天没有数据的，需要传日期，当日今日盈亏比为- - 好友今日盈亏排行榜，头像、昵称、盈亏比、名次、评论数和赞数 登录类型/ 1为交易密码， 2为交易密码和通讯密码， 3为交易密码和验证码， 4为交易密码和动态口令， 5为交易密码和短信口令 var loginTypeData = loginTypeFormat(data[0].data.loginType); Ext.getCmp(\"mloginType\").setValue({ loginType:loginTypeData }); pageQuery 发送 获取 o g r y b r w y o g w y b r w r o b g r w o b w g o b y g o y w r w y r o b y g y r w b y o g w b o g b r g //0red 1white 2blue 3green 4orange 5yellow</p>','D:\\apache-tomcat-7.0.62\\webapps\\cube\\uploadImg\\2015-11-11 16-26-30-163.gif','测试','2015-11-11',0,NULL),(3,'楼下是测试','z','a','','a','2015-10-07',1,3),(4,'老子是测试','b','asdasd',NULL,'b','2015-10-07',1,4),(5,'楼上是测试','c','c',NULL,'c','2015-10-07',1,5),(6,'我们都是测试','d','d','','d','2015-10-07',1,6),(7,'e','e','d',NULL,'e','2015-10-07',1,7),(8,'f','f','f',NULL,'f','2015-10-07',1,8),(9,'g','g','g',NULL,'g','2015-10-07',1,9),(10,'j','j','j',NULL,'j','2015-10-10',1,10),(11,'h','h','h',NULL,'h','2015-10-10',1,11),(12,'我是充数的','我是充数的','我是充数的',NULL,'我是充数的','2015-10-10',0,12),(13,'你也是充数的','你也是充数的','你也是充数的',NULL,'你也是充数的','2015-10-10',0,123),(14,'你也是充数的2','你也是充数的2','你也是充数的2',NULL,'你也是充数的','2015-10-10',0,312),(15,'你也是充数的3','你也是充数的3','你也是充数的3',NULL,'你也是充数的','2015-10-10',0,11),(16,'你也是充数的4','你也是充数的3','你也是充数的4',NULL,'阿达','2015-10-10',0,22),(20,'多个','水电费','<p>是大法官</p>','D:\\apache-tomcat-7.0.62\\webapps\\cube\\uploadImg\\2015-11-10 18-12-10-829.jpg','水电费','2015-11-10',2,NULL),(21,'多个','水电费','<p>是大法官</p>','D:\\apache-tomcat-7.0.62\\webapps\\cube\\uploadImg\\2015-11-10 18-13-07-146.jpg','水电费','2015-11-10',2,NULL);

/*Table structure for table `menus` */

DROP TABLE IF EXISTS `menus`;

CREATE TABLE `menus` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `menuName` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '菜单名',
  `sort` int(11) NOT NULL COMMENT '排序',
  `url` varchar(20) COLLATE utf8_bin NOT NULL COMMENT 'url',
  `parentId` int(11) DEFAULT NULL COMMENT '父id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `menus` */

insert  into `menus`(`id`,`menuName`,`sort`,`url`,`parentId`) values (1,'文章管理',1,'articleManage',0),(2,'文章修改',1,'modify',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
