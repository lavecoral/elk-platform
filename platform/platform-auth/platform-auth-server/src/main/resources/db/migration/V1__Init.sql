CREATE TABLE IF NOT EXISTS `oauth_client`
(
    `id`                      BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `name`                    varchar(256)    NOT NULL COMMENT '名称',
    `client_id`               VARCHAR(256)    NOT NULL COMMENT '客户端ID',
    `client_secret`           VARCHAR(256)    NULL DEFAULT NULL COMMENT '客户端密钥',
    `resource_ids`            VARCHAR(256)    NULL DEFAULT NULL COMMENT '资源id列表',
    `scope`                   VARCHAR(256)    NULL DEFAULT NULL COMMENT '域',
    `authorized_grant_types`  VARCHAR(256)    NULL DEFAULT NULL COMMENT '授权方式',
    `web_server_redirect_uri` varchar(256)    NULL DEFAULT NULL COMMENT '回调地址',
    `authorities`             varchar(256)    NULL DEFAULT NULL COMMENT '权限列表',
    `access_token_validity`   int(0)          NULL DEFAULT NULL COMMENT '认证令牌时效',
    `refresh_token_validity`  int(0)          NULL DEFAULT NULL COMMENT '刷新令牌时效',
    `additional_information`  varchar(4096)   NULL DEFAULT NULL COMMENT '扩展信息',
    `auto_approve`            varchar(256)    NULL DEFAULT NULL COMMENT '是否自动放行',
    UNIQUE KEY `unique_oauth_client_client_id` (`client_id`),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
    COMMENT 'OAuth客户端';
