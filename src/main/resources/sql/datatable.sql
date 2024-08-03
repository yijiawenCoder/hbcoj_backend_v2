create database hbcoj_backend DEFAULT CHARACTER SET utf8;

use hbcoj_backend;

create table sys_user
(
    user_id         varchar(256) primary key comment '用户唯一ID',
    user_name       varchar(256) comment '用户昵称',
    user_account    varchar(256) comment '用户账户',
    user_password   varchar(256) comment '用户密码',
    union_id        varchar(256) comment '微信开放平台ID',
    user_avatar     varchar(256) comment '用户头像',
    user_profile    varchar(256) comment '用户简介',
    user_state      int(64) comment '用户状态',
    user_mp_open_id varchar(256) comment '公众号openID',
    create_time     datetime comment '创建时间',
    update_time     datetime comment '更新时间',
    is_delete       int(64) comment '逻辑删除'

) ENGINE = InnoDB
    comment '用户表';

create table sys_user_role
(
    uuid        varchar(256) primary key comment '唯一ID',
    user_id     varchar(256) comment '用户ID',
    role_id     varchar(256) comment '角色ID',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间',
    is_delete   int(64) comment '逻辑删除'
) ENGINE = InnoDB
    comment '用户角色关联表';
create table sys_role
(
    role_id     varchar(256)
        primary key comment '用户角色唯一id',
    user_role   int comment '角色名称',
    remark      varchar(256) comment '备注',
    user_id     varchar(256) comment '关联用户id',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间',
    is_delete   int(64) comment '逻辑删除'

)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8 comment '用户角色表';

create table sys_user_post
(
    uuid        varchar(256) primary key comment '唯一ID',
    user_id     varchar(256) comment '用户ID',
    post_id     varchar(256) comment '帖子ID',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间',
    is_delete   int(64) comment '逻辑删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '用户帖子关联表';

create table sys_post
(
    post_id       varchar(256) comment '帖子唯一id',
    post_title    varchar(256) comment '帖子标题',
    post_content  varchar(256) comment '帖子内容',
    post_tags     varchar(256) comment '帖子标签',
    post_hotpoint int comment '帖子热度值',
    user_id       varchar(256) comment '用户ID',
    create_time   datetime comment '创建时间',
    update_time   datetime comment '更新时间',
    is_delete     int(64) comment '逻辑删除'

)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8 comment '帖子表';
create table sys_user_comment
(
    uuid        varchar(256) primary key comment '唯一ID',
    comment_id  varchar(256) comment '评论ID',
    user_id     varchar(256) comment '用户ID',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间',
    is_delete   int(64) comment '逻辑删除'
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8 comment '用户评论关联表';

create table sys_comment
(
    comment_id      varchar(256) comment '评论ID',
    service_id      varchar(256) comment '业务ID',
    service_type    int comment '业务类型',
    comment_content varchar(256) comment '评论内容',
    root_id         varchar(256) comment '根评论ID',
    ref_id          varchar(256) comment '映射id',
    create_time     datetime comment '创建时间',
    update_time     datetime comment '更新时间',
    is_delete       int(64) comment '逻辑删除'

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '评论表';


create table sys_user_thumb
(
    uuid        varchar(256) primary key comment '唯一ID',
    user_id     varchar(256) comment '用户ID',
    thumb_id    varchar(256) comment '点赞id',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间',
    is_delete   int(64) comment '逻辑删除'

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '用户点赞关联表';

create table sys_thumb
(
    thumb_id     varchar(256) primary key comment '帖子点赞唯一ID',
    service_id   varchar(256) comment '业务ID',
    service_type int comment '业务类型',
    user_id      varchar(256) comment '用户ID',
    create_time  datetime comment '创建时间',
    update_time  datetime comment '更新时间',
    is_delete    int(64) comment '逻辑删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '点赞表';


create table sys_user_view
(
    uuid        varchar(256) primary key comment '唯一ID',
    user_id     varchar(256) comment '用户ID',
    view_id     varchar(256) comment '浏览id',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间',
    is_delete   int(64) comment '逻辑删除'

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '用户浏览关联表';



create table sys_view
(
    view_id      varchar(256) comment '浏览id',
    service_id   varchar(256) comment '业务ID',
    service_type int comment '业务类型',
    user_id      varchar(256) comment '用户ID',
    create_time  datetime comment '创建时间',
    update_time  datetime comment '更新时间',
    is_delete    int(64) comment '逻辑删除'

)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8 comment '浏览表';

create table sys_user_question
(
    uuid        varchar(256) primary key comment '唯一ID',
    user_id     varchar(256) comment '创建用户ID',
    question_id varchar(256) comment '题目id',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间',
    is_delete   int(64) comment '逻辑删除'
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8 comment '用户题目关联表';

create table sys_question
(
    question_id      varchar(256) primary key comment '题目id',
    question_title   varchar(256) comment '题目标题',
    question_content text comment '题目内容',
    question_tags    text comment '题目标签',
    question_answer  text comment '题目答案',
    judgeCase        text comment '判题用例（json 数组）',
    judgeConfig      text comment '判题配置（json 对象）',
    user_id          varchar(256) comment '被创建用户ID',
    create_time      datetime comment '创建时间',
    update_time      datetime comment '更新时间',
    is_delete        int(64) comment '逻辑删除'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 comment '题目表';

create table sys_question_sumbmit
(
    question_submit_id     varchar(256) primary key comment 'id',
    language               varchar(128) comment '编程语言',
    code                   text comment '用户代码',
    judgeInfo              text comment '判题信息（json 对象）',
    question_submit_status int comment '判题状态（0 - 待判题、1 - 判题中、2 - 成功、3 - 失败）',
    questionId             varchar(256) comment '题目 id',
    user_id                varchar(256) comment '被创建用户ID',
    create_time            datetime comment '创建时间',
    update_time            datetime comment '更新时间',
    is_delete              int(64) comment '逻辑删除'
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8 comment '题目提交表';
