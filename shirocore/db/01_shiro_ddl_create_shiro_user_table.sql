
-- 创建用户表
CREATE TABLE IF NOT EXISTS shiro_user(
    id BIGINT(20) PRIMARY KEY COMMENT 'id',
    `password_hash` VARCHAR(256) NOT NULL COMMENT '用户密码',
    `salt` VARCHAR(256) NOT NULL COMMENT '密码盐',
    is_del tinyint(2) not null default 0 comment '是否删除 1：删除',
    created_by bigint(20) not null comment '创建人',
    created_date datetime not null comment '创建时间',
    updated_by bigint(20) comment '更新人',
    updated_date datetime  comment '更新时间'
)  ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '用户表';
