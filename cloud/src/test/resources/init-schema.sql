drop table if exists `user`;
create table `user`
(
    `id`       int(11) unsigned not null auto_increment comment '用户id',
    `name`     varchar(64)      not null default '' comment '用户名',
    `password` varchar(128)     not null default '' comment '密码',
    `salt`     varchar(32)      not null default '' comment '盐',
    `head_url` varchar(256)     not null default '' comment '头像url',
    primary key (`id`),
    unique key `name` (`name`)
) engine = innodb
  default charset = utf8;

drop table if exists `login_ticket`;
create table `login_ticket`
(
    `id`      int(11)      not null auto_increment comment '登录凭证id',
    `user_id` int(11)      not null comment '用户id',
    `ticket`  varchar(256) not null comment '登录凭证',
    `expired` datetime     not null comment '过期时间',
    `status`  int          null default 0 comment '状态',
    primary key (`id`),
    unique index `ticket_unique` (`ticket` asc)
) engine = innodb
  default charset = utf8;

drop table if exists `sensor_type`;
create table `sensor_type`
(
    `id`         int(11) unsigned not null auto_increment comment '传感器类型枚举编号',
    `name`       varchar(256)     not null default '' comment '传感器名',
    `value_type` int(11)          not null default 0 comment '传感器测量数值类型',
    `extension`  varchar(256)     not null default '' comment '扩展字段',
    primary key (`id`)
) engine = innodb
  default charset = utf8;

drop table if exists `sensor`;
create table `sensor`
(
    `id`           bigint(20) unsigned not null auto_increment comment '传感器id',
    `sensor_type`  int(11)             not null default 0 comment '传感器类型枚举编号',
    `warehouse_id` bigint(20)          not null default 0 comment '归属仓库id',
    `pi_id`        bigint(20)          not null default 0 comment '树莓派id',
    `location`     varchar(256)        not null default '' comment '传感器坐标',
    `extension`    varchar(256)        not null default '' comment '扩展字段',
    primary key (`id`)
) engine = innodb
  default charset = utf8;

drop table if exists `sensor_data_record`;
create table `sensor_data_record`
(
    `id`           bigint(20) unsigned not null auto_increment comment '记录id',
    `sensor_type`  int(11)             not null default 0 comment '传感器类型枚举编号',
    `warehouse_id` bigint(20)          not null default 0 comment '归属仓库id',
    `sensor_id`    bigint(20)          not null default 0 comment '传感器id',
    `value`        varchar(256)        not null default '' comment '记录值',
    `create_time`  datetime            not null default '1970-01-01 00:00:00' comment '记录时间',
    `extension`    varchar(256)        not null default '' comment '扩展字段',
    primary key (`id`)
) engine = innodb
  default charset = utf8;

drop table if exists `response_device_type`;
create table `response_device_type`
(
    `id`        int(11) unsigned not null auto_increment comment '响应外设类型枚举编号',
    `name`      varchar(256)     not null default '' comment '响应外设名',
    `extension` varchar(256)     not null default '' comment '扩展字段',
    primary key (`id`)
) engine = innodb
  default charset = utf8;

drop table if exists `response_device`;
create table `response_device`
(
    `id`                   bigint(20) unsigned not null auto_increment comment '响应外设id',
    `response_device_type` int(11)             not null default 0 comment '响应外设类型枚举编号',
    `warehouse_id`         bigint(20)          not null default 0 comment '归属仓库id',
    `pi_id`                bigint(20)          not null default 0 comment '树莓派id',
    `location`             varchar(256)        not null default '' comment '坐标',
    `extension`            varchar(256)        not null default '' comment '扩展字段',
    primary key (`id`)
) engine = innodb
  default charset = utf8;

drop table if exists `response_record`;
create table `response_record`
(
    `id`                   bigint(20) unsigned not null auto_increment comment '记录id',
    `response_device_type` int(11)             not null default 0 comment '响应外设类型',
    `warehouse_id`         bigint(20)          not null default 0 comment '归属仓库id',
    `response_device_id`   bigint(20)          not null default 0 comment '设备id',
    `create_time`          datetime            not null default '1970-01-01 00:00:00' comment '记录时间',
    `extension`            varchar(256)        not null default '' comment '扩展字段',
    primary key (`id`)
) engine = innodb
  default charset = utf8;

drop table if exists `pi`;
create table `pi`
(
    `id`           bigint(20) unsigned not null auto_increment comment '边缘设备id',
    `warehouse_id` bigint(20)          not null default 0 comment '归属仓库id',
    `location`     varchar(256)        not null default '' comment '坐标',
    `url`          varchar(256)        not null default '' comment '树莓派上的服务的访问地址',
    `extension`    varchar(256)        not null default '' comment '扩展字段',
    primary key (`id`)
) engine = innodb
  default charset = utf8;

drop table if exists `authority_type`;
create table `authority_type`
(
    `id`   int(11)      not null default 0 comment '权限类型枚举编号',
    `name` varchar(256) not null default '' comment '权限名称',
    primary key (`id`)
) engine = innodb
  default charset = utf8;

drop table if exists `user_authority`;
create table `user_authority`
(
    `id`             bigint(20) unsigned not null auto_increment comment '用户权限id',
    `authority_type` int(11)             not null default 0 comment '权限类型枚举编号',
    `user_id`        int(11)             not null default 0 comment '用户id',
    primary key (`id`)
) engine = innodb
  default charset = utf8;

drop table if exists `monitor`;
create table `monitor`
(
    `id`                   bigint(20) unsigned not null auto_increment comment '监控计划id',
    `sensor_id`            bigint(20)          not null default 0 comment '传感器id',
    `response_device_list` varchar(256)        not null default '' comment '响应设备列表',
    `time`                 varchar(256)        not null default '' comment '执行时间',
    `emails`               varchar(256)        not null default '' comment '邮件通知组',
    `sync_num`             int(11)             not null default 0 comment '从边缘设备批量同步一次监控数据的条数',
    `using`                tinyint             not null default 0 comment '是否启用',
    `create_time`          datetime            not null default '1970-01-01 00:00:00' comment '记录时间',
    `extension`            varchar(256)        not null default '' comment '扩展字段',
    primary key (`id`)
) engine = innodb
  default charset = utf8;

insert into authority_type (name)
values ('查看全部数据');