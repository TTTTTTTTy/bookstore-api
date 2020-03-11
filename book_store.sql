-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: book_store
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(45) NOT NULL,
  `isbn` varchar(13) NOT NULL,
  `author` varchar(255) NOT NULL,
  `price` varchar(12) NOT NULL,
  `category` varchar(93) NOT NULL,
  `url` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `number` int(11) NOT NULL,
  `summary` varchar(500) DEFAULT NULL,
  `kind` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ISBN_UNIQUE` (`isbn`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (3,'Spring Boot+Vue全栈开发实战','9787302517979','','54.50元','10,0,0,0,0,0,0,0,0,0,0,1,0,0','https://book.douban.com/subject/30747218/','https://img3.doubanio.com/view/subject/m/public/s30551966.jpg',1,'',10),(4,'Spring实战（第4版）','9787115417305','Craig Walls 沃尔斯','CNY 89.00','10,0,0,0,0,0,0,0,0,0,0,2,0,0','https://book.douban.com/subject/26767354/','https://img3.doubanio.com/view/subject/m/public/s28607882.jpg',1,'《Spring实战（第4版）》是经典的、畅销的Spring学习和实践指南。\n第4版针对Spring 4进行了全面更新。全书分为四部分。第1部分介绍Spring框架的核心知识。第二部分在此基础上介绍了如何使用Spring构建Web应用程序。第三部分告别前端，介绍了如何在应用程序的后端使用Spring。第四部分描述了如何使用Spring与其他的应用和服务进行集成。\n《Spring实战（第4版）》适用于已具有一定Java 编程基础的读者，以及在Java 平台下进行各类软件开发的开发人员、测试人员，尤其适用于企业级Java 开发人员。本书既可以被刚开始学习Spring 的读者当作学习指南，也可以被那些想深入了解Spring 某方面功能的专业用户作为参考用书。',10),(5,'Spring Boot实战','9787115433145','[美]克雷格·沃斯','59.00元','10,0,0,0,0,0,0,0,0,0,0,1,0,0','https://book.douban.com/subject/26857423/','https://img3.doubanio.com/view/subject/m/public/s28983685.jpg',1,'本书以Spring应用程序开发为中心，全面讲解如何运用Spring Boot提高效率，使应用程序的开发和管理更加轻松有趣。作者行文亲切流畅，以大量示例讲解了Spring Boot在各类情境中的应用，内容涵盖起步依赖、Spring Boot CLI、Groovy、Grails、Actuator。对于Spring Boot开发应用中较为繁琐的内容，附录奉上整理完毕的表格，一目了然，方便读者查阅。',10),(6,'算法导论（原书第3版）','9787111407010','Thomas H.Cormen,Charles E.Leiserson,Ronald L.Rivest,Clifford Stein','128.00元','10,0,0,0,0,0,0,0,0,0,0,1,0,0','https://book.douban.com/subject/20432061/','https://img3.doubanio.com/view/subject/m/public/s25648004.jpg',0,'在有关算法的书中，有一些叙述非常严谨，但不够全面；另一些涉及了大量的题材，但又缺乏严谨性。本书将严谨性和全面性融为一体，深入讨论各类算法，并着力使这些算法的设计和分析能为各个层次的读者接受。全书各章自成体系，可以作为独立的学习单元；算法以英语和伪代码的形式描述，具备初步程序设计经验的人就能看懂；说明和解释力求浅显易懂，不失深度和数学严谨性。\n全书选材经典、内容丰富、结构合理、逻辑清晰，对本科生的数据结构课程和研究生的算法课程都是非常实用的教材，在IT专业人员的职业生涯中，本书也是一本案头必备的参考书或工程实践手册。\n第3版的主要变化：\n新增了van Emde Boas树和多线程算法，并且将矩阵基础移至附录。\n修订了递归式（现在称为“分治策略”）那一章的内容，更广泛地覆盖分治法。\n移除两章很少讲授的内容：二项堆和排序网络。\n修订了动态规划和贪心算法相关内容。\n流网络相关材料现在基于边上的全部流。\n由于关于矩阵基础和Strassen算法的材料移到了其他章，矩阵运算这一章的内容所占篇幅更小。\n修改了对Knuth-Morris-Pratt字符串匹配算法的讨论。\n新增100道练习和28道思考题，',10),(7,'UNIX环境高级编程（第3版）','9787115352118','史蒂文斯 (W.Richard Stevens),拉戈 (Stephen A.Rago)','128.00元','10,0,0,0,0,0,0,0,0,0,0,1,0,0','https://book.douban.com/subject/25900403/','https://img1.doubanio.com/view/subject/m/public/s28284137.jpg',1,'《UNIX环境高级编程（第3版）》是被誉为UNIX编程“圣经”的Advanced Programming in the UNIX Environment一书的第3版。在本书第2版出版后的8年中，UNIX行业发生了巨大的变化，特别是影响UNIX编程接口的有关标准变化很大。本书在保持前一版风格的基础上，根据最新的标准对内容进行了修订和增补，反映了最新的技术发展。书中除了介绍UNIX文件和目录、标准I/O库、系统数据文件和信息、进程环境、进程控制、进程关系、信号、线程、线程控制、守护进程、各种I/O、进程间通信、网络IPC、伪终端等方面的内容，还在此基础上介绍了众多应用实例，包括如何创建数据库函数库以及如何与网络打印机通信等。此外，还在附录中给出了函数原型和部分习题的答案。\n《UNIX环境高级编程（第3版）》内容权威，概念清晰，阐述精辟，对于所有层次UNIX/Linux程序员都是一本不可或缺的参考书。\n适读人群 ：所有层次UNIX/Linux程序员\n20多年来，严谨的C程序员都是依靠一本书来深入了解驱动UNIX和Linux内核的编程接口的实用知识的，这本书就是W. Richard Steve',10),(8,'数据结构与算法分析','9787115139849','维斯','49.00元','10,0,0,0,0,0,0,0,0,0,0,1,0,0','https://book.douban.com/subject/1444648/','https://img3.doubanio.com/view/subject/m/public/s8983082.jpg',0,'《数据结构与算法分析:C语言描述》(英文版第2版)是数据结构和算法分析方面的经典教材。第2版更加精炼并强化了《数据结构与算法分析:C语言描述》(英文版第2版)创新的对算法和数据结构的讲授方法。通过C程序的实现，着重阐述了抽象数据类型（ADT）的概念，并对算法的效率、性能和运行时间进行了分析。《数据结构与算法分析:C语言描述》(英文版第2版)适合作为本科数据结构课程或研究生第一年算法分析课程的教材。第1~9章为大多数本科一学期数据结构课程提供了足够的材料。多学时课程可讲授第10章。研究生的算法分析课程可以使用第6~12章的内容。',10);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_table`
--

DROP TABLE IF EXISTS `order_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `order_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_book_id` int(11) NOT NULL,
  `bookname` varchar(45) NOT NULL,
  `buyer_name` varchar(45) NOT NULL,
  `seller_name` varchar(45) NOT NULL,
  `phone` char(11) NOT NULL,
  `price` double NOT NULL,
  `mode` tinyint(1) NOT NULL,
  `state` tinyint(2) NOT NULL,
  `create_date` date NOT NULL,
  `finish_date` date DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_table`
--

LOCK TABLES `order_table` WRITE;
/*!40000 ALTER TABLE `order_table` DISABLE KEYS */;
INSERT INTO `order_table` VALUES (2,9,'算法导论（原书第3版）','admin','user1','18868111916',98.5,0,2,'2019-06-27','2019-06-27',NULL),(3,11,'数据结构与算法分析','admin','user1','18868111916',20.5,0,1,'2019-06-27',NULL,NULL),(4,7,'Spring Boot+Vue全栈开发实战','user1','admin','18965487522',36.5,1,0,'2019-06-27',NULL,'浙江省杭州市西湖区浙江大学玉泉校区'),(5,6,'Spring实战（第4版）','user1','admin','18868111916',73.5,1,2,'2019-07-01','2019-07-01','浙江省嘉兴市秀洲区王江泾镇');
/*!40000 ALTER TABLE `order_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `bookname` varchar(45) NOT NULL,
  `date` date NOT NULL,
  `price` double NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES (2,'admin','默读','2019-06-28',50,'最好全套，单本也可，价格另议'),(5,'user1','残次品','2019-07-01',42,'最好全套，单本也可，价格另议');
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(32) NOT NULL,
  `phone` char(11) DEFAULT NULL,
  `realname` varchar(32) DEFAULT NULL,
  `qq` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (12,'admin','$2a$10$.K5.x/zcsj7GKBUmy.d9Y.wyFdQzEBGmhhRRzTAaMFz8HjhBnCxZa','1461723687@qq.com','18868111916','汤烨春','1461723687'),(13,'user1','$2a$10$CGf8hsVAmJCuODD6kNsAN.PjF00uoD2nRvStFcxM9i9zwduHYf6y6','zhangsan@gmail.com','18868111919','张三','2897849809'),(14,'user2','$2a$10$S7nlH8ugg9Vit9vTF6DQLOzKU4fv94ytOFdT4CpQ4a0rQZtavIpp.','3160102257@zju.edu.cn','18868111916','Lisi','1461723687'),(15,'user3','$2a$10$a5XQJogFTskRThkPEJh5hevIZL9L4kjC6yUh3kMgrn.W1yVx/cqiO','22222222@qq.com','18868111916','汤烨春','1461723687'),(16,'user5','$2a$10$hsJLUrK0PC51/B9jHDzUkeGMtbwkAeSnvnJwQK/JHuR0FlHjkpWlu','1563224@qq.com','18868111916','汤烨春','1461723687');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_book`
--

DROP TABLE IF EXISTS `user_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `bookId` int(11) NOT NULL,
  `state` tinyint(1) NOT NULL DEFAULT '0',
  `sell_price` double NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `image` varchar(255) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_book`
--

LOCK TABLES `user_book` WRITE;
/*!40000 ALTER TABLE `user_book` DISABLE KEYS */;
INSERT INTO `user_book` VALUES (2,'admin',3,0,32.5,'九成新，买了一个多月，正版保证','http://localhost:8081/images/2019-06-23/adb40b04-6f49-4101-a582-401ef37e55c8.jpg','2019-06-23'),(6,'admin',4,1,65.5,'基本全新，书没有什么损坏痕迹','http://localhost:8081/images/2019-06-24/eceb0eb7-b4dd-4dd5-bf5d-5bbee3ceaefd.jpg','2019-06-24'),(7,'admin',3,1,28.5,'帮朋友挂，有一点破损，不影响使用，介意勿拍','http://localhost:8081/images/2019-06-24/4a4c1f52-a1cc-4a26-a4d7-35d2954b30d9.jpg','2019-06-24'),(8,'admin',5,0,19.6,'无','http://localhost:8081/images/2019-06-25/58ca23e7-ad94-4d3c-b39c-e696fecf4e50.jpg','2019-06-25'),(9,'user1',6,1,98.5,'二手','http://localhost:8081/images/2019-06-25/86ba9028-61a1-4161-9d43-97010fe57dbc.jpg','2019-06-25'),(10,'user1',7,0,99,'全新','http://localhost:8081/images/2019-06-25/869f354a-3751-4e2a-97f4-ac64fc86e580.jpg','2019-06-25'),(11,'user1',8,1,12.5,'有点旧，随意出','http://localhost:8081/images/2019-06-25/9fe8d469-d234-4fb7-adbb-6c7090381771.jpg','2019-06-25'),(12,'admin',4,0,28.5,'九成新，买了一个多月，正版','http://localhost:8081/images/2019-07-01/bd890de0-d3c2-44f0-8f76-e9b30b0e8f0b.jpg','2019-07-01');
/*!40000 ALTER TABLE `user_book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-01 23:25:14
