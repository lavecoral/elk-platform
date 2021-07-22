CREATE TABLE IF NOT EXISTS `subject`
(
    `id`     BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `name`   varchar(256)    NOT NULL COMMENT '名称',
    `avatar` VARCHAR(1024)   NULL COMMENT '头像',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
    COMMENT '主体表';

CREATE TABLE IF NOT EXISTS `username_password_principal`
(
    `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `username`   varchar(64)     NOT NULL COMMENT '名称',
    `password`   VARCHAR(64)     NOT NULL COMMENT '密码',
    `subject_id` BIGINT          NOT NULL COMMENT '关联的主体ID',
    UNIQUE KEY `unique_username_password_principal_subject_id` (`subject_id`),
    UNIQUE KEY `unique_username_password_principal_username` (`username`),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
    COMMENT '主体用户名密码表';
