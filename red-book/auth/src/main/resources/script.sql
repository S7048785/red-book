create table t_permission
(
    id             bigint unsigned auto_increment comment '主键ID'
        primary key,
    parent_id      bigint unsigned  default '0'               not null comment '父ID',
    name           varchar(16)                                not null comment '权限名称',
    type           tinyint unsigned                           not null comment '类型(1：目录 2：菜单 3：按钮)',
    menu_url       varchar(32)      default ''                not null comment '菜单路由',
    menu_icon      varchar(255)     default ''                not null comment '菜单图标',
    sort           int unsigned     default '0'               not null comment '管理系统中的显示顺序',
    permission_key varchar(64)                                not null comment '权限标识',
    status         tinyint unsigned default '0'               not null comment '状态(0：启用；1：禁用)',
    create_time    datetime         default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time    datetime         default CURRENT_TIMESTAMP not null comment '更新时间',
    deleted        bit              default b'0'              not null comment '逻辑删除(0：未删除 1：已删除)'
)
    comment '权限表' engine = InnoDB
                     collate = utf8mb4_unicode_ci;

create table t_role
(
    id          bigint unsigned auto_increment comment '主键ID'
        primary key,
    role_name   varchar(32)                            not null comment '角色名',
    role_key    varchar(32)                            not null comment '角色唯一标识',
    status      tinyint      default 0                 not null comment '状态(0：启用 1：禁用)',
    sort        int unsigned default '0'               not null comment '管理系统中的显示顺序',
    remark      varchar(255)                           null comment '备注',
    create_time datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime     default CURRENT_TIMESTAMP not null comment '最后一次更新时间',
    deleted     bit          default b'0'              not null comment '逻辑删除(0：未删除 1：已删除)',
    constraint uk_role_key
        unique (role_key)
)
    comment '角色表' engine = InnoDB
                     collate = utf8mb4_unicode_ci;

create table t_role_permission_rel
(
    id            bigint unsigned auto_increment comment '主键ID'
        primary key,
    role_id       bigint unsigned                    not null comment '角色ID',
    permission_id bigint unsigned                    not null comment '权限ID',
    create_time   datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time   datetime default CURRENT_TIMESTAMP not null comment '更新时间',
    deleted       bit      default b'0'              not null comment '逻辑删除(0：未删除 1：已删除)'
)
    comment '用户权限表' engine = InnoDB
                         collate = utf8mb4_unicode_ci;

create table t_user
(
    id             bigint unsigned auto_increment comment '主键ID'
        primary key,
    red_book_id    varchar(15)                        not null comment '小哈书号(唯一凭证)',
    password       varchar(64)                        null comment '密码',
    nickname       varchar(24)                        not null comment '昵称',
    avatar         varchar(120)                       null comment '头像',
    birthday       date                               null comment '生日',
    background_img varchar(120)                       null comment '背景图',
    phone          varchar(11)                        not null comment '手机号',
    sex            tinyint  default 0                 null comment '性别(0：女 1：男)',
    status         tinyint  default 0                 not null comment '状态(0：启用 1：禁用)',
    introduction   varchar(100)                       null comment '个人简介',
    create_time    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time    datetime default CURRENT_TIMESTAMP not null comment '更新时间',
    deleted        bit      default b'0'              not null comment '逻辑删除(0：未删除 1：已删除)',
    constraint uk_phone
        unique (phone),
    constraint uk_xiaohashu_id
        unique (red_book_id)
)
    comment '用户表' engine = InnoDB
                     collate = utf8mb4_unicode_ci;

create table t_user_role_rel
(
    id          bigint unsigned auto_increment comment '主键ID'
        primary key,
    user_id     bigint unsigned                    not null comment '用户ID',
    role_id     bigint unsigned                    not null comment '角色ID',
    create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time datetime default CURRENT_TIMESTAMP not null comment '更新时间',
    deleted     bit      default b'0'              not null comment '逻辑删除(0：未删除 1：已删除)'
)
    comment '用户角色表' engine = InnoDB
                         collate = utf8mb4_unicode_ci;


