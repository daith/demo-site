CREATE TABLE IF NOT EXISTS employee
(
  id char(36) NOT NULL comment 'ID',
  name varchar(20) NOT NULL comment 'name',
  role varchar(20) NOT NULL comment 'role name',
  create_time datetime  comment 'create time' DEFAULT CURRENT_TIMESTAMP,
  update_time datetime  comment 'update time' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  KEY index_createTime (create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;