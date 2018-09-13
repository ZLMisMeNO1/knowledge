CREATE DATABASE IF NOT EXISTS shiroweb;
-- 创建用户表
CREATE TABLE IF NOT EXISTS shiro_user(
    id BIGINT(20) PRIMARY KEY COMMENT 'id',
    `name` VARCHAR(30) NOT NULL UNIQUE COMMENT '用户名',
    `password` VARCHAR(256) NOT NULL COMMENT '用户密码',
    `salt` VARCHAR(256) NOT NULL COMMENT '密码盐',
    is_del tinyint(2) not null default 0,
    created_by bigint(20) not null comment '创建人',
    created_date datetime not null comment '创建时间',
    updated_by bigint(20) comment '更新人',
    updated_date datetime  comment '更新时间'
)  ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '用户表';
-- 创建角色表
create table if not exists shiro_role (
    id BIGINT(20) PRIMARY KEY COMMENT 'id',
    `name` VARCHAR(30) NOT NULL UNIQUE COMMENT '角色名称',
    is_del tinyint(2) not null default 0,
    created_by bigint(20) not null comment '创建人',
    created_date datetime not null comment '创建时间',
    updated_by bigint(20) comment '更新人',
    updated_date datetime comment '更新时间'
) engine = innodb default CHARSET=utf8 comment '角色表';