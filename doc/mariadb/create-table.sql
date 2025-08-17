CREATE TABLE `company` (
  `company_no` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `company_name` varchar(100) NOT NULL,
  `company_info` text DEFAULT NULL,
  `company_meet` text DEFAULT NULL,
  `company_email_content` text DEFAULT NULL,  
  `company_status` varchar(2) DEFAULT NULL,
  `company_delete` char(1) DEFAULT '0',
  `insert_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`company_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;