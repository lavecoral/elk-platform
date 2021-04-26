CREATE TABLE IF NOT EXISTS `subject`
(
    `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `name`       varchar(64)     NOT NULL COMMENT '名称',
    `password`   varchar(64)     NOT NULL COMMENT '密码',
    `enable`     tinyint(1)      NOT NULL DEFAULT '1' COMMENT '是否启用',
    `created_at` DATETIME        NOT NULL COMMENT '创建时间',
    `updated_at` DATETIME        NOT NULL COMMENT '更新时间',
    UNIQUE KEY `unique_subject_name` (`name`),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
    COMMENT '主体表';

CREATE TABLE IF NOT EXISTS `role`
(
    `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `name`       varchar(64)     NOT NULL COMMENT '名称',
    `enable`     tinyint(1)      NOT NULL DEFAULT '1' COMMENT '是否启用',
    `created_at` DATETIME        NOT NULL COMMENT '创建时间',
    `updated_at` DATETIME        NOT NULL COMMENT '更新时间',
    UNIQUE KEY `unique_role_name` (`name`),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
    COMMENT '角色表';

CREATE TABLE IF NOT EXISTS `rel_subject_role`
(
    `id`         BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `subject_id` BIGINT UNSIGNED NOT NULL COMMENT '主体ID',
    `role_id`    BIGINT UNSIGNED NOT NULL COMMENT '角色ID',
    INDEX `index_rel_subject_role_subject_id` (`subject_id`),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
    COMMENT '主体角色关系表';

CREATE TABLE IF NOT EXISTS `permission`
(
    `id`   BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `name` varchar(64)     NOT NULL COMMENT '名称',
    `uri`  varchar(128)    NOT NULL COMMENT 'URI模式',
    UNIQUE KEY `unique_permission_name` (`name`),
    PRIMARY KEY (`id`)
) ENGINE InnoDB
  DEFAULT CHARSET utf8mb4
    COMMENT '许可表';

CREATE TABLE IF NOT EXISTS `rel_role_permission`
(
    `id`            BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `role_id`      BIGINT UNSIGNED NOT NULL COMMENT '角色ID',
    `permission_id` BIGINT UNSIGNED NOT NULL COMMENT '许可ID',
    INDEX `index_rel_role_permission_role_id` (`role_id`),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
    COMMENT '角色许可关系表';
