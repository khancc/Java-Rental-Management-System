DROP TABLE IF EXISTS `registration`;
DROP TABLE IF EXISTS `admin`;
DROP TABLE IF EXISTS `facility`;
DROP TABLE IF EXISTS `property`;
DROP TABLE IF EXISTS `agent`;
DROP TABLE IF EXISTS `owner`;
DROP TABLE IF EXISTS `tenant`;


CREATE TABLE `cyberent`.`registration` (
  `registration_id` int NOT NULL AUTO_INCREMENT,
    `registration_name` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
    `registration_phone` int NOT NULL,
    `registration_email` varchar(45) CHARACTER SET utf8mb4 NOT NULL,
    `registration_account` int NOT NULL,
    PRIMARY KEY (`registration_id`),
    UNIQUE KEY `registration_phone_UNIQUE` (`registration_phone`),
    UNIQUE KEY `registration_email_UNIQUE` (`registration_email`)
);

CREATE TABLE `cyberent`.`agent` (
    `agent_id` int NOT NULL AUTO_INCREMENT,
    `agent_name` varchar(45) NOT NULL,
    `agent_phone` int NOT NULL,
    `agent_email` varchar(45) NOT NULL,
    `agent_username` varchar(45) NOT NULL,
    `agent_password` varchar(45) NOT NULL,
    PRIMARY KEY (`agent_id`),
    UNIQUE KEY `agent_phone_UNIQUE` (`agent_phone`),
    UNIQUE KEY `agent_email_UNIQUE` (`agent_email`),
    UNIQUE KEY `agent_username_UNIQUE` (`agent_username`),
    UNIQUE KEY `agent_password_UNIQUE` (`agent_password`)
);

CREATE TABLE `cyberent`.`admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
    `admin_name` varchar(45) NOT NULL,
    `admin_phone` int NOT NULL,
    `admin_email` varchar(45) NOT NULL,
    `admin_username` varchar(45) NOT NULL,
    `admin_password` varchar(45) NOT NULL,
    PRIMARY KEY (`admin_id`),
    UNIQUE KEY `admin_password_UNIQUE` (`admin_password`),
    UNIQUE KEY `admin_username_UNIQUE` (`admin_username`),
    UNIQUE KEY `admin_email_UNIQUE` (`admin_email`),
    UNIQUE KEY `admin_phone_UNIQUE` (`admin_phone`)
);


CREATE TABLE `cyberent`.`owner` (
  `owner_id` int NOT NULL AUTO_INCREMENT,
    `owner_name` varchar(45) NOT NULL,
    `owner_phone` int NOT NULL,
    `owner_email` varchar(45) NOT NULL,
    `owner_username` varchar(45) NOT NULL,
    `owner_password` varchar(45) NOT NULL,
    PRIMARY KEY (`owner_id`),
    UNIQUE KEY `owner_phone_UNIQUE` (`owner_phone`),
    UNIQUE KEY `owner_email_UNIQUE` (`owner_email`),
    UNIQUE KEY `owner_username_UNIQUE` (`owner_username`),
    UNIQUE KEY `owner_password_UNIQUE` (`owner_password`)
);


CREATE TABLE `cyberent`.`tenant` (
  `tenant_id` int NOT NULL AUTO_INCREMENT,
    `tenant_name` varchar(45) NOT NULL,
    `tenant_phone` int NOT NULL,
    `tenant_email` varchar(45) NOT NULL,
    `tenant_username` varchar(45) NOT NULL,
    `tenant_password` varchar(45) NOT NULL,
    PRIMARY KEY (`tenant_id`),
    UNIQUE KEY `tenant_phone_UNIQUE` (`tenant_phone`),
    UNIQUE KEY `tenant_email_UNIQUE` (`tenant_email`),
    UNIQUE KEY `tenant_username_UNIQUE` (`tenant_username`),
    UNIQUE KEY `tenant_password_UNIQUE` (`tenant_password`)
);


CREATE TABLE `cyberent`.`property` (
  `property_id` int NOT NULL AUTO_INCREMENT,
    `property_name` varchar(80) NOT NULL,
    `property_address` varchar(150) NOT NULL,
    `property_type` varchar(45) NOT NULL,
    `property_price` decimal(10,2) DEFAULT NULL,
    `property_project` varchar(45) NOT NULL,
    `property_size` int NOT NULL,
    `property_numRoom` int NOT NULL,
    `property_numBathroom` int NOT NULL,
    `property_status` char(1) NOT NULL,
    `property_owner` int DEFAULT NULL,
    `property_agent` int DEFAULT NULL,
    PRIMARY KEY (`property_id`),
    KEY `proeprty_owner_idx` (`property_owner`),
    KEY `property_agent_idx` (`property_agent`),
    CONSTRAINT `property_agent` FOREIGN KEY (`property_agent`) REFERENCES `agent` (`agent_id`),
    CONSTRAINT `property_owner` FOREIGN KEY (`property_owner`) REFERENCES `owner` (`owner_id`)
);

CREATE TABLE `cyberent`.`facility` (
  `property_ID` int NOT NULL AUTO_INCREMENT,
    `pool` tinyint NOT NULL,
    `parking` tinyint NOT NULL,
    `wifi` tinyint NOT NULL,
    `air_conditioner` tinyint NOT NULL,
    `tv` tinyint NOT NULL,
    `fridge` tinyint NOT NULL,
    `washing_machine` tinyint NOT NULL,
    `gym` tinyint NOT NULL,
    `water_heater` tinyint NOT NULL,
    `stove` tinyint NOT NULL,
    PRIMARY KEY (`property_ID`),
    CONSTRAINT `facility_propertyID` FOREIGN KEY (`property_id`) REFERENCES property(property_id)
);

INSERT INTO `registration` VALUES (1,'Cindy Sia',122563227,'xingtungngo@gmail.com',2),(2, 'Puah Jie Yi', 186593002, '1181103291@student.mmu.edu.my', 0),(3, 'Nabi Muhammad', 145622203, 'xingtung1108@gmail.com', 1);

INSERT INTO `admin` VALUES (1,'Mandy Sia',122820662,'mdsia13@gmail.com','mandy123','mandy123'),(2,'Loh Yue Yi',123736127,'yueyi01@gmail.com','yueyi123','yueyi123'),(3,'Ngo Xing Tung',173925821,'ngoxt01@gmail.com','ngoxt123','ngoxt123'),(4,'Lim Wei jie',125681547,'weijie01@gmail.com','weijie123','weijie123');

INSERT INTO `agent` VALUES (1,'Ali Muhamad Abdullah',123652451,'ali1998@gmail.com','Ali_Muhammad','ali19980203'),(2,'Ahmad',123652443,'ahmad74@gmail.com','AllMightAhmad','ahmad74'),(3,'Michelle Loh',169542235,'lohmh56@gmail.com','michelle','michelle0712'),(4,'Ting Ke Yuan',145865532,'tkeyuan@yahoo.com','TingKeYuan','abc1234'),(5,'Pavitra',168953325,'pavitra66@hotmail.com','PpPavitra','P5562P'),(6,'Ng Shui Xuan',125637789,'shuixuanng@gmail.com','shuixuanng2468','Khtf8546');

INSERT INTO `owner` VALUES (1,'Eugene Sia',127035628,'egsia88@gmail.com','EugeneSia','eugene3505'),(2,'Abu Bakar',168542269,'abubakar98@gmail.com','AbuBakar1998','1998BakarAbu'),(3,'Emilly Lim Xin Li',168459953,'emily1995@gmail.com','FunnyValantine','emily0214'),(4,'Dhruv Jaya',169785523,'dhruv@yahoo.com','Jaya_of_Dhruv','DJ18325'),(5,'Aarna ',128953302,'aarna85@gmail.com','Aaaarna','aditiAarna85'),(6,'Ismail Hafiz',149653326,'ismailhafiz@yahoo.com','ismailhafiz1249','PowJ4695');

INSERT INTO `tenant` VALUES (1,'Cal Corey McGinnis',128452232,'calcorey88@gmail.com','KalEl_Cal','Corey6503'),(2,'Carlota Christophers',146852230,'carlotachris@hotmail.com','Carlota','carlotaABC'),(3,'Deng Chao',135896223,'dengchao23@qq.com','BigBullDC','bigbull23DC'),(4,'Izzat bin Wajdi',138556243,'izzat46@gmail.com','IzzatWaj','izzat6954'),(5,'Vishal Khatri',168435596,'vishalkhatri@gmail.com','VisK','zxcasdqwe123'),(6,'Adiputeri binti Indera',168540023,'adiputeri@yahoo.com','Adi_The_Puteri','puteriAdi79'),(7,'Kalyani Chand',128465322,'kaycha32@outlook.com','CallMeKayani','23inaykal'),(8,'Jin Wenqian',168459985,'wqjin63@gmail.com','Wen_Qian_','wenqian1963'),(9,'Xiao Guozhi',122568003,'gzxiao@gmail.com','XiaoGuoZhi','guo_1475_zhi'),(10,'Raafi bin Junaid',1235486552,'raafi51@outlook.com','raafi512358','PHyF5621');

INSERT INTO `property` VALUES (1,'Condominium At The Place@ Cyberjaya','T2-17, 04, Jalan Teknokrat 1/1, Cyberjaya, 63000 Cyberjaya, Selangor','Condominium',1100.00,'The Place Cyberjaya',550,3,1,'Y',NULL,1),(2,'Service Residence At Tamarind Suites','Tamarind Suites, Persiaran Multimedia, Cyber 10, 63000 Cyberjaya, Selangor','Studio',900.00,'Tamarind Suites',403,1,1,'N',NULL,1),(3,'Condominium At Cyberia SmartHomes','Cyberjaya, 63000 Cyberjaya, Selangor.','Condominium',1000.00,'Cyberia SmartHomes',980,3,2,'Y',NULL,2),(4,'Service Residence At Garden Plaza','Persiaran Harmoni, Cyber 3, 63000 Cyberjaya, Selangor.','Other',850.00,'Garden Plaza',450,3,2,'Y',NULL,2),(5,'SummerGlades Cyberjaya','central hub of Cyberjaya, and near the border of Putrajaya.','Double Storey',3300.00,'Summerglades Cyberjaya',3000,5,5,'Y',1,NULL),(6,'Third Avenue Cyberjaya','Third Avenue, Eclipse,Kenwingston,Thehyve,Lakefront,Skypark Cyberjaya.','Apartment',1500.00,'Third Avenue Cyberjaya',780,2,2,'Y',1,NULL),(7,'Solstice Pangaea Cyberjaya','Persiaran Bestari, Cyber 11, 63000 Cyberjaya, Selangor.','Apartment',1000.00,'Solstice',450,1,1,'Y',1,NULL),(8,'Service Residence At Solstice @ Pan\'gaea','Persiaran Bestari, Cyber 11, 63000, Cyberjaya, Selangor.','Other',900.00,'Solstice',450,1,1,'Y',NULL,3),(9,'Beethoven, Symphony Hills, Cyberjaya','Beethoven, Symphony Hills, Cyberjaya, Selangor.','Other',8500.00,'Symphony Hills',4620,4,6,'Y',2,NULL),(10,'Garden Residence, Cyberjaya','Garden Residence, Cyberjaya， Selangor.','Triple Storey',3000.00,'Garden Residence Resort Homes Cyberjaya',3700,6,5,'Y',3,NULL),(11,'Perdana Lakeview East, Cyberjaya','Perdana Lakeview East, Cyberjaya, Selangor.','Semi Detached',4000.00,'Perdana Lakeview East Cyberjaya',4000,5,5,'Y',NULL,3),(12,'Condominium At The Place in Cyberjaya','T2-17, 04, Jalan Teknokrat 1/1, Cyberjaya, 63000, Cyberjaya, Selangor','Condominium',950.00,'The Place Cyberjaya',500,1,1,'Y',2,NULL),(13,'Lepironia Setia Eco Glades Cyberjaya','Lepironia Setia Eco Glades, Cyberjaya, Selangor.','Semi Detached',4000.00,'Setia Eco Glades',3257,4,6,'Y',NULL,4),(14,'Ceria Residence (PART FURNISH) Cyberjaya','Ceria Residence, Cyberjaya, Selangor.','Terrace',3000.00,'Ceria Residence',1900,5,4,'Y',NULL,4),(15,'Cassia Garden Residence, Cyberjaya','2 Storey Superlink Cassia Garden Residence, Cyberjaya, Selangor.','Double Storey',2800.00,'Cassia Garden Residence',2845,5,5,'Y',4,NULL),(16,'Double Storey Laurel Laman View Cyberjaya','Laurel Laman View Cyberjaya,Selangor.','Double Storey',2450.00,'Laurel Laman View Cyberjaya',1900,4,4,'Y',4,NULL),(17,'Mirage By The Lake, Cyberjaya','Mirage By The Lake @ Cyberjaya, Selangor.','Double Storey',3500.00,'Lakeside Terrace',2800,3,5,'Y',NULL,5),(18,'Mozart Symphony Hills, Cyberjaya','Jalan Fauna, Selangor, 63000 Cyberjaya, Selangor.','Triple Storey',2800.00,'Symphony Hills',3338,4,5,'Y',NULL,6),(19,'Liu Li Garden Setia Eco Glades Cyberjaya','Liu Li Garden Setia Eco Glades Cyberjaya, 63000, Selangor','Double Storey',2800.00,'Setia Eco Glades',2900,3,4,'Y',4,NULL),(20,'Double storey corner ceria residence cyberjaya','Ceria Residence, Jalan Ceria 1C, Cyberjaya, 63000 Cyberjaya, Selangor.','Double Storey',2300.00,'Ceria Residence',3315,4,5,'Y',5,NULL),(21,'3 Storey Bungalow Jacaranda Garden Residence Cyberjaya','3 Storey Bungalow Jacaranda Garden Residence Cyberjaya, 63000, Selangor.','Bungalow',3800.00,'Jacaranda Garden Residence Cyberjaya',4541,7,6,'Y',6,NULL),(22,'Cyberjaya Double Storey Ceria Residence','Ceria Residence, Jalan Ceria 1C, Cyberjaya, 63000 Cyberjaya, Selangor','Double Storey',1800.00,'Ceria Residence',2200,4,3,'Y',5,NULL),(23,'2 sty Ceria Residence (PART FURNISH) Cyberjaya','Ceria Residence, Jalan Ceria 1C, Cyberjaya, 63000 Cyberjaya, Selangor','Double Storey',3000.00,'Ceria Residence',1902,5,4,'Y',5,NULL),(24,'Charm of Nusantara Setia Eco Glades Cyberjaya','Persiaran Setia Eco Glades Setia Eco Glades, Cyber 1, Setia Eco Glades, 63000 Cyberjaya, Selangor.','Other',3200.00,'Setia Eco Glades',3100,4,5,'Y',NULL,1),(25,'FULLY FURNISHED Serin Residence Cyberjaya','Jln Fauna 1, Cyberjaya, 63000 Cyberjaya, Selangor.','Apartment',1700.00,'Serin Residence',1307,3,2,'Y',NULL,2),(26,'Jewels of Grasmere, Cyberjaya (SEMI FURNISHED)','Jewels of Grasmere, Setia Eco Glades , Cyberjaya, Selangor.','Double Storey',3800.00,'Setia Eco Glades',2118,3,4,'Y',2,NULL),(27,'[MURAH] Shaftsbury 1R1B fully furnished Cyberjaya','Shaftsbury Residence, Cyberjaya, Selangor.','Apartment',2975.00,'Shaftsbury Residence',639,1,1,'Y',NULL,6),(28,'Summerglades, Cyberjaya','Jalan Sri Tasik Barat 1, Cyberjaya, Selangor.','Double Storey',3500.00,'Summerglades Cyberjaya',3500,5,4,'Y',6,NULL),(29,'Symphony Hills 3 Sty Fully Furnished for Rent, Cyberjaya','Jalan Fauna, Selangor, 63000 Cyberjaya, Selangor.','Triple Storey',4500.00,'Symphony Hills',3200,5,5,'Y',3,NULL),(30,'Tamarind Suites Cyberjaya Studio For Rent','Tamarind Square, Cyberjaya, 63000, Cyberjaya, Selangor.','Studio',1000.00,'Tamarind Suites',403,1,1,'Y',NULL,1);

INSERT INTO `facility` VALUES (1,1,1,0,1,0,1,0,0,1,1),(2,1,1,0,1,0,1,1,1,0,1),(3,1,1,0,1,0,1,1,1,1,0),(4,1,1,0,1,0,1,1,0,1,0),(5,0,0,0,1,0,0,1,0,1,0),(6,1,0,0,1,0,0,1,1,0,0),(7,1,0,0,0,0,0,0,1,0,0),(8,1,1,0,1,1,1,1,1,1,1),(9,0,1,0,0,0,0,0,0,0,0),(10,1,1,0,1,0,1,1,1,1,1),(11,0,1,0,1,0,0,0,0,0,0),(12,1,0,0,1,0,1,0,0,1,0),(13,1,1,0,1,0,0,0,1,0,0),(14,1,1,0,1,0,0,0,1,1,0),(15,0,1,0,1,0,1,0,0,1,0),(16,0,1,0,0,1,0,0,0,0,1),(17,1,1,0,1,1,0,1,1,0,0),(18,0,1,0,0,0,0,0,0,0,0),(19,1,1,0,1,0,0,0,1,0,0),(20,1,1,0,0,0,0,0,1,0,0),(21,1,1,0,0,0,0,0,1,0,0),(22,1,1,0,0,0,0,0,1,0,0),(23,1,1,0,1,0,0,0,1,1,0),(24,1,1,0,1,0,0,0,1,0,0),(25,1,1,0,1,0,0,1,1,0,0),(26,0,1,0,0,0,0,0,0,1,0),(27,1,1,0,1,1,0,1,1,0,0),(28,0,1,0,1,0,0,0,0,0,0),(29,0,1,0,1,0,0,0,1,0,0),(30,0,0,0,1,1,1,0,0,1,0);



