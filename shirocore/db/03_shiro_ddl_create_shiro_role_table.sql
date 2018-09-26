-- 创建角色表
CREATE TABLE IF NOT EXISTS shiro_role (
    id BIGINT(20) PRIMARY KEY COMMENT 'id',
    `name` VARCHAR(30) NOT NULL UNIQUE COMMENT '角色名称',
    is_del tinyint(2) not null default 0,
    created_by bigint(20) not null comment '创建人',
    created_date datetime not null comment '创建时间',
    updated_by bigint(20) comment '更新人',
    updated_date datetime comment '更新时间'
) engine = innodb default CHARSET=utf8 comment '角色表';