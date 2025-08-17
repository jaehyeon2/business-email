-- For Develop
GRANT ALL PRIVILEGES ON ca_bsc.* TO dev_ca_user@localhost IDENTIFIED BY 'bscqq77';
GRANT ALL PRIVILEGES ON ca_bsc.* TO dev_ca_user@'192.168.0.%' IDENTIFIED BY 'bscqq77';
GRANT ALL PRIVILEGES ON ca_bsc.* TO dev_ca_user@'10.233.10.%' IDENTIFIED BY 'bscqq77';
FLUSH PRIVILEGES;

-- For Staging
GRANT ALL PRIVILEGES ON ca_bsc.* TO stg_ca_user@localhost IDENTIFIED BY 'bscqq77';
GRANT ALL PRIVILEGES ON ca_bsc.* TO stg_ca_user@'192.168.0.%' IDENTIFIED BY 'bscqq77';
GRANT ALL PRIVILEGES ON ca_bsc.* TO stg_ca_user@'10.233.10.%' IDENTIFIED BY 'bscqq77';
FLUSH PRIVILEGES;

-- For Product
GRANT ALL PRIVILEGES ON ca_bsc.* TO pro_ca_user@localhost IDENTIFIED BY 'bscqq77';
GRANT ALL PRIVILEGES ON ca_bsc.* TO pro_ca_user@'192.168.0.%' IDENTIFIED BY 'bscqq77';
GRANT ALL PRIVILEGES ON ca_bsc.* TO pro_ca_user@'10.233.10.%' IDENTIFIED BY 'bscqq77';
FLUSH PRIVILEGES;