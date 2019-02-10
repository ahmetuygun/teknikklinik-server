CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `username` varchar(15) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(100) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_users_username` (`username`),
  UNIQUE KEY `uk_users_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_roles_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_roles_role_id` (`role_id`),
  CONSTRAINT `fk_user_roles_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `fk_user_roles_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `polls` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `question` varchar(140) NOT NULL,
  `expiration_date_time` datetime NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `choices` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `text` varchar(40) NOT NULL,
  `poll_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_choices_poll_id` (`poll_id`),
  CONSTRAINT `fk_choices_poll_id` FOREIGN KEY (`poll_id`) REFERENCES `polls` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `votes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `poll_id` bigint(20) NOT NULL,
  `choice_id` bigint(20) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_votes_user_id` (`user_id`),
  KEY `fk_votes_poll_id` (`poll_id`),
  KEY `fk_votes_choice_id` (`choice_id`),
  CONSTRAINT `fk_votes_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `fk_votes_poll_id` FOREIGN KEY (`poll_id`) REFERENCES `polls` (`id`),
  CONSTRAINT `fk_votes_choice_id` FOREIGN KEY (`choice_id`) REFERENCES `choices` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `teknikklinik2`.`Device` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `brand_model_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));
  
  
  CREATE TABLE `teknikklinik2`.`defect` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`));
  
  
  CREATE TABLE `teknikklinik2`.`offer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `deviceid` INT NOT NULL,
  `price` DECIMAL(15,8) NOT NULL,
  `startdate` DATE NOT NULL,
  `enddate` DATE NOT NULL,
  `active` INT NOT NULL,
  `fixer_id` INT NOT NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `teknikklinik2`.`transaction` (
  `id` INT NOT NULL,
  `offer_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `t_type` INT NULL,
  `current_status_id` INT NULL,
  `description` VARCHAR(500) NULL,
  `kurye` INT NULL,
  `t_date` TIMESTAMP NULL,
  `t_code` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `teknikklinik2`.`status` (
  `id` INT NOT NULL,
  `name` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `teknikklinik2`.`transactionHistory` (
  `id` INT NOT NULL,
  `trancation_id` INT NOT NULL,
  `status_id` INT NULL,
  `t_date` TIMESTAMP NULL,
  PRIMARY KEY (`id`));


  
ALTER TABLE `teknikklinik2`.`offer` 
ADD INDEX `device_idx` (`deviceid` ASC);
ALTER TABLE `teknikklinik2`.`offer` 
ADD CONSTRAINT `device`
  FOREIGN KEY (`deviceid`)
  REFERENCES `teknikklinik2`.`Device` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
ALTER TABLE `teknikklinik2`.`transaction` 
ADD INDEX `offer_idx` (`offer_id` ASC),
ADD INDEX `status_idx` (`current_status_id` ASC);
ALTER TABLE `teknikklinik2`.`transaction` 
ADD CONSTRAINT `offer`
  FOREIGN KEY (`offer_id`)
  REFERENCES `teknikklinik2`.`offer` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `status`
  FOREIGN KEY (`current_status_id`)
  REFERENCES `teknikklinik2`.`status` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  

  
ALTER TABLE `teknikklinik2`.`offer` 
ADD COLUMN `defect_id` INT NULL AFTER `fixer_id`,
ADD INDEX `defect_idx` (`defect_id` ASC);
ALTER TABLE `teknikklinik2`.`offer` 
ADD CONSTRAINT `defect`
  FOREIGN KEY (`defect_id`)
  REFERENCES `teknikklinik2`.`defect` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `teknikklinik2`.`transaction` 
DROP FOREIGN KEY `status`;
ALTER TABLE `teknikklinik2`.`transaction` 
DROP INDEX `status_idx` ;

ALTER TABLE `teknikklinik2`.`transactionHistory` 
ADD INDEX `transaction_idx` (`trancation_id` ASC);
ALTER TABLE `teknikklinik2`.`transactionHistory` 
ADD CONSTRAINT `transaction`
  FOREIGN KEY (`trancation_id`)
  REFERENCES `teknikklinik2`.`transaction` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
  ALTER TABLE `teknikklinik2`.`offer` 
CHANGE COLUMN `fixer_id` `fixer_id` INT(11) NULL ;



INSERT INTO `teknikklinik2`.`Device` (`id`, `brand_model_name`) VALUES ('1', 'Ekran kırık/çatlak');
INSERT INTO `teknikklinik2`.`Device` (`id`, `brand_model_name`) VALUES ('2', 'Arka kamera çalışmıyor');
INSERT INTO `teknikklinik2`.`Device` (`id`, `brand_model_name`) VALUES ('3', 'Karşıya ses gitmiyor');
