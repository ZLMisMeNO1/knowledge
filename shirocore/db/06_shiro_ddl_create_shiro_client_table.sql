-- 创建客户端表
CREATE TABLE IF NOT EXISTS shiro_client (
    id BIGINT(20) PRIMARY KEY COMMENT 'id',
    `name` VARCHAR(30) NOT NULL UNIQUE COMMENT '客户端名称',
    key_secrity varchar(256) not null unique comment '客户端key',
    is_del tinyint(2) not null default 0,
    created_by bigint(20) not null comment '创建人',
    created_date datetime not null comment '创建时间',
    updated_by bigint(20) comment '更新人',
    updated_date datetime comment '更新时间'
) engine = innodb default CHARSET=utf8 comment '客户端表';