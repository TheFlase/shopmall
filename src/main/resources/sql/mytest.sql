/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     3/28/2020 9:33:02 PM                         */
/*==============================================================*/


drop table if exists t_inventory;

drop index idx_itemCode on t_item;

drop table if exists t_item;

drop index idx_orderCode on t_order;

drop table if exists t_order;

drop index idx_orderCodeitemCode on t_order_detail;

drop table if exists t_order_detail;

/*==============================================================*/
/* Table: t_inventory                                           */
/*==============================================================*/
create table t_inventory
(
   id                   bigint not null auto_increment comment 'id',
   item_code            varchar(25) not null default '' comment '��Ʒ����',
   item_name            varchar(25) not null default '' comment '��Ʒ����',
   stock_qty            int default 0 comment '�������
            ',
   locked_qty           int default 0 comment '��������',
   frozen_qty           int default 0 comment '��������',
   create_time          timestamp default CURRENT_TIMESTAMP comment '����ʱ��',
   modify_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '�޸�ʱ��',
   primary key (id)
);

/*==============================================================*/
/* Table: t_item                                                */
/*==============================================================*/
create table t_item
(
   id                   bigint not null auto_increment,
   item_code            varchar(25) not null default '' comment '��Ʒ����',
   item_name            varchar(25) not null default '' comment '��Ʒ����',
   item_price           decimal(15,2) default 0.00 comment '��Ʒ����',
   create_time          timestamp default CURRENT_TIMESTAMP comment '����ʱ��',
   modify_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '�޸�ʱ��',
   primary key (id)
);

alter table t_item comment '��Ʒ��';

/*==============================================================*/
/* Index: idx_itemCode                                          */
/*==============================================================*/
create unique index idx_itemCode on t_item
(
   item_code
);

/*==============================================================*/
/* Table: t_order                                               */
/*==============================================================*/
create table t_order
(
   id                   bigint not null auto_increment,
   order_code           varchar(25) not null default '' comment '��������',
   total_price          decimal(15,2) default 0.00 comment '�ܼ�',
   create_time          timestamp default CURRENT_TIMESTAMP comment '����ʱ��',
   modify_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '�޸�ʱ��',
   primary key (id)
);

/*==============================================================*/
/* Index: idx_orderCode                                         */
/*==============================================================*/
create unique index idx_orderCode on t_order
(
   order_code
);

/*==============================================================*/
/* Table: t_order_detail                                        */
/*==============================================================*/
create table t_order_detail
(
   id                   bigint not null auto_increment,
   order_code           varchar(25) not null default '' comment '��������',
   item_code            varchar(25) not null default '' comment '��Ʒ����',
   item_qty             int default 0 comment '��Ʒ����',
   create_time          timestamp default CURRENT_TIMESTAMP comment '����ʱ��',
   modify_time          timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '�޸�ʱ��',
   primary key (id)
);

/*==============================================================*/
/* Index: idx_orderCodeitemCode                                 */
/*==============================================================*/
create index idx_orderCodeitemCode on t_order_detail
(
   order_code,
   item_code
);

