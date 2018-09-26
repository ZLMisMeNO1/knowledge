-- 创建人员表
CREATE TABLE IF NOT EXISTS shiro_person(
    id bigint(20) primary key comment 'id',
    `nick_name` varchar(30) not null comment '昵称',
    `code` varchar(30) not null comment '人员编码，登录账号，is_del为0状态全表唯一',
    user_id bigint(20) not null comment '用户id',
    `identity` bigint(2) not null default 0 comment '身份 0：普通用户，1：普通管理员，2：超级管理员',
    is_del tinyint(2) not null default 0,
    created_by bigint(20) not null comment '创建人',
    created_date datetime not null comment '创建时间',
    updated_by bigint(20) comment '更新人',
    updated_date datetime  comment '更新时间'
) engine=innodb default charset=utf8 comment '人员表';