create database if not exists `houses`;
use `houses`;

# 房产表
create table `house`
(
    `id`             int(20) unsigned not null auto_increment comment '主键Id',
    `name`           varchar(32)      not null default '' comment '房产名称',
    `type`           tinyint(1)       not null default 0 comment '1销售 ， 2出租',
    `price`          int(11)          not null comment '售价，单位：元',
    `images`         varchar(1024)    not null default '' comment '图片地址',
    `area`           int(11)          not null default 0 comment '面积',
    `beds`           int(11)          not null default 0 comment '卧室数量',
    `baths`          int(11)          not null default 0 comment '卫生间数量',
    `rating`         double           not null default 0 comment '评级',
    `description`    varchar(512)     not null default '' comment '房产描述',
    `properties`     varchar(512)     not null default '' comment '属性',
    `floor_plan`     varchar(256)     not null default '' comment '户型图',
    `tags`           varchar(20)      not null default '' comment '标签',
    `create_time`    date             not null comment '创建时间',
    `community_id`   int(11)          not null default 0 comment '城市标号，对应城市表中的城市id',
    `address`        varchar(128)     not null default '' comment '房产地址',
    `state`          tinyint(1)                default 1 comment '房产状态，1-上架，2-下架',
    `last_edit_time` date             not null comment '最后修改时间',
    primary key (`id`)
) engine = InnoDB
  auto_increment = 2
  default character set = utf8mb4;

# # 省级表
#
# # 市级表
# create table `city`
# (
#     `id`             int(11) unsigned auto_increment not null comment '城市id',
#     `city_name`      varchar(64)                     not null default '' comment '城市名称',
#     `create_time`    date                            not null comment '创建时间',
#     `last_edit_time` date                            not null comment '最后修改时间',
# ) engine = InnoDB
#   auto_increment = 2
#   default character set = utf8mb4;

# 小区表
create table `community`
(
    `id`             int(11) unsigned not null auto_increment comment '主键id',
    `city_code`      varchar(11)      not null default '' comment '城市编码',
    `name`           varchar(64)      not null default '' comment '小区名称',
    `city_name`      varchar(11)      not null default '' comment '城市名称',
    `create_time`    date             not null comment '创建时间',
    `last_edit_time` date             not null comment '最后修改时间',
    primary key (`id`)
) engine = InnoDB
  auto_increment = 2
  default character set = utf8mb4;

# 用户表
create table `user`
(
    `id`                int(32) unsigned not null auto_increment comment '主键id',
    `username`          varchar(32)      not null default '' comment '用户名称',
    `password`          varchar(32)      not null default '' comment '用户密码',
    `phone`             varchar(13)      not null default '' comment '用户手机号码',
    `email`             varchar(32)      not null default '' comment '电子邮件',
    `self_introduction` varchar(64)      not null default '' comment '自我介绍',
    `avatar`            varchar(256)     not null default '' comment '用户头像',
    `type`              tinyint(1)       not null comment '1-普通用户，2-房产经纪人',
    `enable`            tinyint(1)       not null default 0 comment '是否启用：1-启用，0-禁用',
    `agency_id`         int(11)          not null default 0 comment '所属经济机构',
    `create_time`       date             not null comment '创建时间',
    `last_edit_time`    date             not null comment '最后修改时间',
    primary key (`id`)
) engine = InnoDB
  auto_increment = 2
  default character set = utf8mb4;

# 房产用户关系表——维护房产和用户的关系
create table `house_user`
(
    `id`             int(20) unsigned not null auto_increment comment '主键id',
    `house_id`       int(11)          not null comment '房屋id',
    `user_id`        int(11)          not null comment '用户id',
    `type`           tinyint(1)       not null comment '1-售卖，2-收藏',
    `create_time`    date             not null comment '创建时间',
    `last_edit_time` date             not null comment '最后修改时间',
    unique key `house_id_user_id_type` (`house_id`, `user_id`, `type`),
    primary key (`id`)
) engine = InnoDB
  auto_increment = 2
  default character set = utf8mb4;

# 房产留言表
create table `house_message`
(
    `id`             int(11) unsigned not null auto_increment comment '主键id',
    `message`        varchar(512)     not null default '' comment '消息',
    `agent_id`       int(11)          not null comment '经纪人id',
    `house_id`       int(11)          not null comment '房屋id',
    `user_id`        int(11)          not null comment '用户id',
    `create_time`    date             not null comment '创建时间',
    `last_edit_time` date             not null comment '最后修改时间',
    primary key (`id`)
) engine = InnoDB
  auto_increment = 2
  default character set = utf8mb4;

# 经纪机构表
create table `agency`
(
    `id`             int(11) unsigned not null auto_increment comment '主键id',
    `name`           varchar(32)      not null default '' comment '经纪机构名称',
    `address`        varchar(64)      not null default '' comment '经纪机构地址',
    `phone`          varchar(13)      not null default '' comment '经纪机构联系方式',
    `email`          varchar(16)      not null default '' comment '经纪机构邮件',
    `description`    varchar(64)      not null default '' comment '经纪机构描述',
    `web_site`       varchar(20)      not null default '' comment '网站',
    `create_time`    date             not null comment '创建时间',
    `last_edit_time` date             not null comment '最后修改时间',
    primary key (`id`)
) engine = InnoDB
  auto_increment = 2
  default character set = utf8mb4;

# 评论表
create table `comment`
(
    `id`             int(11) unsigned not null auto_increment comment '主键id',
    `content`        varchar(256)     not null default '' comment '评论内容',
    `house_id`       int(11)          not null comment '房屋id',
    `blog_id`        int(11)          not null comment '博客Id',
    `type`           tinyint(1)       not null comment '类型：1-房产评论，2-博客评论',
    `user_id`        int(11)          not null comment '评论用户',
    `create_time`    date             not null comment '创建时间',
    `last_edit_time` date             not null comment '最后修改时间',
    primary key (`id`)
) engine = InnoDB
  auto_increment = 2
  default character set = utf8mb4;

# 百科表（博客）
create table `blog`
(
    `id`             int(11) unsigned not null auto_increment comment '主键id',
    `tags`           varchar(32)      not null default '' comment '标签',
    `content`        text             not null comment '内容',
    `title`          varchar(32)      not null comment '标题',
    `category`       tinyint(1)                default null comment '分类：1-准备买房，2-看房、选房，3-签约、订房，4-全款、贷款，5-缴税、过户，6-入住、交接，7-买房风险',
    `create_time`    date             not null comment '创建时间',
    `last_edit_time` date             not null comment '最后修改时间',
    primary key (`id`)
) engine = InnoDB
  auto_increment = 2
  default character set = utf8mb4;