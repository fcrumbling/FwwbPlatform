/*
 Navicat Premium Data Transfer

 Source Server         : sqlserver
 Source Server Type    : SQL Server
 Source Server Version : 12002000
 Source Host           : localhost:1433
 Source Catalog        : fwwb_platform
 Source Schema         : fwwb_schema

 Target Server Type    : SQL Server
 Target Server Version : 12002000
 File Encoding         : 65001

 Date: 19/03/2024 14:33:47
*/


-- ----------------------------
-- Table structure for Achievement
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[fwwb_schema].[Achievement]') AND type IN ('U'))
	DROP TABLE [fwwb_schema].[Achievement]
GO

CREATE TABLE [fwwb_schema].[Achievement] (
  [id] int  NOT NULL,
  [product_name] varchar(100) COLLATE Chinese_PRC_CI_AS  NULL,
  [product_description] text COLLATE Chinese_PRC_CI_AS  NULL,
  [source_url] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [other] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [fwwb_schema].[Achievement] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'成果id',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Achievement',
'COLUMN', N'id'
GO

EXEC sp_addextendedproperty
'MS_Description', N'产品名字',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Achievement',
'COLUMN', N'product_name'
GO

EXEC sp_addextendedproperty
'MS_Description', N'产品描述',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Achievement',
'COLUMN', N'product_description'
GO

EXEC sp_addextendedproperty
'MS_Description', N'资源下载链接',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Achievement',
'COLUMN', N'source_url'
GO

EXEC sp_addextendedproperty
'MS_Description', N'备用字段，可放下载链接等',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Achievement',
'COLUMN', N'other'
GO


-- ----------------------------
-- Records of Achievement
-- ----------------------------
INSERT INTO [fwwb_schema].[Achievement] ([id], [product_name], [product_description], [source_url], [other]) VALUES (N'1', N'2023西湖论剑-11周年精华特刊
', N'建没数宇中国是我国的重要国策。在《数宇中国建设整体布局规划〉 (以下简称《规划》)中明确了数字中国建设按照“2522”的整体框架进行布局。整体框架中，一方面着重强调了数字安全的重要性，数字安全和数字技术并列为支撑数字中国建设的两大能力。另一方面，“安全”在2522框架中无处不在——数字基础设施不可无安全保障，数据资源大循环不', N'http://sa80c6d6d.hd-bkt.clouddn.com/2024/03/19/efd2e7ee8b6246ea8ce9d5b6a23e127a.zip', NULL)
GO

INSERT INTO [fwwb_schema].[Achievement] ([id], [product_name], [product_description], [source_url], [other]) VALUES (N'2', N'2023数字安全能力洞察报告
', N'数字经济成为全球新一轮科技革命和产业变革的重要引擎，将开启人类数字文明的新时代。数字安全的基础性作用日益突出，在数字化建设进程中，加紧实施国家信息化发展战略，筑牢可信可控的数字安全屏障，夯实数字基础设施安全底座，增强关键基础设施安全韧性，助力数字社会安全发展，已成为支撑现代化建设、增强国家综合实力的必然选择。', N'456', NULL)
GO


-- ----------------------------
-- Table structure for Comment
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[fwwb_schema].[Comment]') AND type IN ('U'))
	DROP TABLE [fwwb_schema].[Comment]
GO

CREATE TABLE [fwwb_schema].[Comment] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [event_id] int  NOT NULL,
  [root_id] int  NULL,
  [content] text COLLATE Chinese_PRC_CI_AS  NULL,
  [to_comment_user_id] int  NULL,
  [to_comment_id] int  NULL,
  [create_by] int  NULL,
  [create_time] datetime2(7)  NULL,
  [update_by] int  NULL,
  [update_time] datetime2(7)  NULL,
  [del_flag] int  NULL
)
GO

ALTER TABLE [fwwb_schema].[Comment] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'外键',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Comment',
'COLUMN', N'event_id'
GO

EXEC sp_addextendedproperty
'MS_Description', N'根评论id',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Comment',
'COLUMN', N'root_id'
GO

EXEC sp_addextendedproperty
'MS_Description', N'评论内容',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Comment',
'COLUMN', N'content'
GO

EXEC sp_addextendedproperty
'MS_Description', N'回复目标评论的userid',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Comment',
'COLUMN', N'to_comment_user_id'
GO

EXEC sp_addextendedproperty
'MS_Description', N'回复的评论的id',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Comment',
'COLUMN', N'to_comment_id'
GO

EXEC sp_addextendedproperty
'MS_Description', N'逻辑删除字段',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Comment',
'COLUMN', N'del_flag'
GO


-- ----------------------------
-- Records of Comment
-- ----------------------------
SET IDENTITY_INSERT [fwwb_schema].[Comment] ON
GO

INSERT INTO [fwwb_schema].[Comment] ([id], [event_id], [root_id], [content], [to_comment_user_id], [to_comment_id], [create_by], [create_time], [update_by], [update_time], [del_flag]) VALUES (N'2', N'1', N'-1', N'根评论1号', N'-1', N'-1', N'1', N'2024-03-06 22:05:23.0000000', NULL, NULL, N'0')
GO

INSERT INTO [fwwb_schema].[Comment] ([id], [event_id], [root_id], [content], [to_comment_user_id], [to_comment_id], [create_by], [create_time], [update_by], [update_time], [del_flag]) VALUES (N'3', N'2', N'-1', N'根评论2号', N'-1', N'-1', N'1', N'2024-03-06 22:05:27.0000000', NULL, NULL, N'0')
GO

INSERT INTO [fwwb_schema].[Comment] ([id], [event_id], [root_id], [content], [to_comment_user_id], [to_comment_id], [create_by], [create_time], [update_by], [update_time], [del_flag]) VALUES (N'4', N'3', N'-1', N'根评论3号', N'-1', N'-1', N'1', N'2024-03-06 22:05:30.0000000', NULL, NULL, N'0')
GO

INSERT INTO [fwwb_schema].[Comment] ([id], [event_id], [root_id], [content], [to_comment_user_id], [to_comment_id], [create_by], [create_time], [update_by], [update_time], [del_flag]) VALUES (N'5', N'1', N'-1', N'根评论4号', N'-1', N'-1', N'1', N'2024-03-05 22:05:31.0000000', NULL, NULL, N'0')
GO

INSERT INTO [fwwb_schema].[Comment] ([id], [event_id], [root_id], [content], [to_comment_user_id], [to_comment_id], [create_by], [create_time], [update_by], [update_time], [del_flag]) VALUES (N'6', N'1', N'-1', N'评论了捏', N'-1', N'-1', N'-1', N'2024-03-07 13:48:51.2560000', N'-1', N'2024-03-07 13:48:51.2560000', NULL)
GO

SET IDENTITY_INSERT [fwwb_schema].[Comment] OFF
GO


-- ----------------------------
-- Table structure for Event
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[fwwb_schema].[Event]') AND type IN ('U'))
	DROP TABLE [fwwb_schema].[Event]
GO

CREATE TABLE [fwwb_schema].[Event] (
  [event_name] varchar(100) COLLATE Chinese_PRC_CI_AS  NULL,
  [event_time] datetime  NULL,
  [event_location] varchar(100) COLLATE Chinese_PRC_CI_AS  NULL,
  [event_content] text COLLATE Chinese_PRC_CI_AS  NULL,
  [is_live] bit  NULL,
  [videoreplay_link] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [subscribers_count] int  NULL,
  [event_popularity] int  NULL,
  [picture_url] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [type] int  NULL,
  [event_end_time] datetime  NULL,
  [other] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [id] int  IDENTITY(1,1) NOT NULL
)
GO

ALTER TABLE [fwwb_schema].[Event] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'活动名',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Event',
'COLUMN', N'event_name'
GO

EXEC sp_addextendedproperty
'MS_Description', N'活动开始时间',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Event',
'COLUMN', N'event_time'
GO

EXEC sp_addextendedproperty
'MS_Description', N'活动地点',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Event',
'COLUMN', N'event_location'
GO

EXEC sp_addextendedproperty
'MS_Description', N'活动内容',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Event',
'COLUMN', N'event_content'
GO

EXEC sp_addextendedproperty
'MS_Description', N'是否直播 1表示直播，0表示不直播',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Event',
'COLUMN', N'is_live'
GO

EXEC sp_addextendedproperty
'MS_Description', N'视频转播链接',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Event',
'COLUMN', N'videoreplay_link'
GO

EXEC sp_addextendedproperty
'MS_Description', N'预约人数',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Event',
'COLUMN', N'subscribers_count'
GO

EXEC sp_addextendedproperty
'MS_Description', N'活动人气',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Event',
'COLUMN', N'event_popularity'
GO

EXEC sp_addextendedproperty
'MS_Description', N'介绍用缩略图',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Event',
'COLUMN', N'picture_url'
GO

EXEC sp_addextendedproperty
'MS_Description', N'活动类型，不同数字表示不同类型',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Event',
'COLUMN', N'type'
GO

EXEC sp_addextendedproperty
'MS_Description', N'活动结束时间',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Event',
'COLUMN', N'event_end_time'
GO

EXEC sp_addextendedproperty
'MS_Description', N'保留字段',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Event',
'COLUMN', N'other'
GO

EXEC sp_addextendedproperty
'MS_Description', N'id字段，需要设置主键自增',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Event',
'COLUMN', N'id'
GO


-- ----------------------------
-- Records of Event
-- ----------------------------
SET IDENTITY_INSERT [fwwb_schema].[Event] ON
GO

INSERT INTO [fwwb_schema].[Event] ([event_name], [event_time], [event_location], [event_content], [is_live], [videoreplay_link], [subscribers_count], [event_popularity], [picture_url], [type], [event_end_time], [other], [id]) VALUES (N'格致论道@西湖论剑', N'2023-05-05 18:30:00.000', N'线上', N'“格致论道”是中国科学院计算机网络信息中心和中国科学院科学传播局联合主办的科学文化讲坛。致力于非凡思想的跨界交流，提倡以"格物致知"的精神探讨科技、教育、生活、未来的发展。', N'0', N'', N'47', N'111', N'http://sa80c6d6d.hd-bkt.clouddn.com/2024/03/19/2d694d27a81f47f4be4c4a98c9fa9e59.png', N'1', N'2023-05-05 21:45:00.000', N'0', N'1')
GO

INSERT INTO [fwwb_schema].[Event] ([event_name], [event_time], [event_location], [event_content], [is_live], [videoreplay_link], [subscribers_count], [event_popularity], [picture_url], [type], [event_end_time], [other], [id]) VALUES (N'西湖论剑安全特训营·网络攻防蓝队实战技法进阶班', N'2023-05-04 09:00:00.000', N'线上', N'本次培训面向网络安全从业人员，特别是负责网络安全防护的蓝队人员，以及有意向从事蓝队工作的人员。 培训所需具备的基础能力：应具备网络安全的基本知识，了解常见的网络攻击手法和防御策略，', N'0', NULL, N'13', N'33', NULL, N'2', N'2023-05-04 18:00:00.000', N'0', N'2')
GO

INSERT INTO [fwwb_schema].[Event] ([event_name], [event_time], [event_location], [event_content], [is_live], [videoreplay_link], [subscribers_count], [event_popularity], [picture_url], [type], [event_end_time], [other], [id]) VALUES (N'新·见未来 实·现梦想', N'2023-04-19 13:30:00.000', N'线上', N'今年是习近平总书记提出“八八战略”实施的20周年，是杭州亚运会举办之年，是数字浙江建设20周年,同时也是西湖论剑网络安全大会迈向第二个十年的起始之年。作为西湖论剑系列预热活动之一，此次新品', N'0', NULL, N'56', N'11', NULL, N'3', N'2023-04-19 17:00:00.000', N'0', N'3')
GO

SET IDENTITY_INSERT [fwwb_schema].[Event] OFF
GO


-- ----------------------------
-- Table structure for EventStatistics
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[fwwb_schema].[EventStatistics]') AND type IN ('U'))
	DROP TABLE [fwwb_schema].[EventStatistics]
GO

CREATE TABLE [fwwb_schema].[EventStatistics] (
  [id] int  NOT NULL,
  [participants_count] int  NULL,
  [registrations_count] int  NULL,
  [other] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [fwwb_schema].[EventStatistics] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'活动id',
'SCHEMA', N'fwwb_schema',
'TABLE', N'EventStatistics',
'COLUMN', N'id'
GO

EXEC sp_addextendedproperty
'MS_Description', N'参与者数量',
'SCHEMA', N'fwwb_schema',
'TABLE', N'EventStatistics',
'COLUMN', N'participants_count'
GO

EXEC sp_addextendedproperty
'MS_Description', N'注册数',
'SCHEMA', N'fwwb_schema',
'TABLE', N'EventStatistics',
'COLUMN', N'registrations_count'
GO

EXEC sp_addextendedproperty
'MS_Description', N'备用字段',
'SCHEMA', N'fwwb_schema',
'TABLE', N'EventStatistics',
'COLUMN', N'other'
GO


-- ----------------------------
-- Records of EventStatistics
-- ----------------------------

-- ----------------------------
-- Table structure for exhibitor
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[fwwb_schema].[exhibitor]') AND type IN ('U'))
	DROP TABLE [fwwb_schema].[exhibitor]
GO

CREATE TABLE [fwwb_schema].[exhibitor] (
  [id] int  NOT NULL,
  [brand] varchar(100) COLLATE Chinese_PRC_CI_AS  NULL,
  [logourl] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [posterurl] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [newsinformation] text COLLATE Chinese_PRC_CI_AS  NULL,
  [productinfomation] text COLLATE Chinese_PRC_CI_AS  NULL,
  [other] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [fwwb_schema].[exhibitor] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'品牌',
'SCHEMA', N'fwwb_schema',
'TABLE', N'exhibitor',
'COLUMN', N'brand'
GO

EXEC sp_addextendedproperty
'MS_Description', N'logo地址',
'SCHEMA', N'fwwb_schema',
'TABLE', N'exhibitor',
'COLUMN', N'logourl'
GO

EXEC sp_addextendedproperty
'MS_Description', N'海报地址',
'SCHEMA', N'fwwb_schema',
'TABLE', N'exhibitor',
'COLUMN', N'posterurl'
GO

EXEC sp_addextendedproperty
'MS_Description', N'信息',
'SCHEMA', N'fwwb_schema',
'TABLE', N'exhibitor',
'COLUMN', N'newsinformation'
GO

EXEC sp_addextendedproperty
'MS_Description', N'介绍信息',
'SCHEMA', N'fwwb_schema',
'TABLE', N'exhibitor',
'COLUMN', N'productinfomation'
GO

EXEC sp_addextendedproperty
'MS_Description', N'备用字段',
'SCHEMA', N'fwwb_schema',
'TABLE', N'exhibitor',
'COLUMN', N'other'
GO


-- ----------------------------
-- Records of exhibitor
-- ----------------------------
INSERT INTO [fwwb_schema].[exhibitor] ([id], [brand], [logourl], [posterurl], [newsinformation], [productinfomation], [other]) VALUES (N'1', N'安恒信息', N'URL1', N'URL2', N'杭州安恒信息技术股份有限公司（简称：安恒信息）成立于2007年，于2019年11月5日正式登陆上交所科创板股票上市，股票代码：688023。自成立以来一直专注于网络信息安全领域，公司秉承“构建安全可信的数字世界”的企业使命，以数字经济的安全基石为企业定位，将“诚信正直、成就客户，责任至上，开放创新，以人为本，共同成长”作为企业的价值观，致力于成为全球领先的数字安全企业。

      安恒信息以云安全、大数据安全、物联网安全、智慧城市安全、工业控制系统安全及工业互联网安全五大方向为市场战略。凭借强大的研发实力和持续的产品创新，已形成覆盖网络信息安全生命全周期的产品体系，包括网络信息安全基础产品、网络信息安全平台以及网络信息安全服务，各产品线及业务线在行业中均形成了强大的竞争力。2021年全年营收营收同比增长37.59%，公司总资产同比增长96.98%，2021年6月入选"科创板价值50强"榜单。
      2020年11月23日，安恒信息正式签约杭州2022年第19届亚运会，成为其官方网络安全服务合作伙伴，这也是国际大型综合性赛事网络信息安全类最高层级合作。作为国家级核心安保单位，安恒信息参与了近乎全部国家重大活动网络安保，实现零失误，以先进的理念和专业的服务获得各盛事主办方和监管机构的一致好评。
      未来，安恒信息将牢牢抓住网络强国和数字中国战略背景下网络信息安全行业市场发展机遇，依托西湖论剑网络安全大会的影响力，不断扩大产业生态圈的合作，成就数字经济第一盾护航数字经济高速发展。', N'自成立以来一直专注于网络信息安全领域，公司秉承“构建安全可信的数字世界”的企业使命，以数字经济的安全基石为企业', N'null')
GO

INSERT INTO [fwwb_schema].[exhibitor] ([id], [brand], [logourl], [posterurl], [newsinformation], [productinfomation], [other]) VALUES (N'2', N'孝道科技', N'URL3', N'URL4', N'2023西湖论剑，共话数字安全@数字中国

 

      2023年5月初，“第十一届西湖论剑·网络安全大会”在杭城拉开序幕。相关政府部门、科研院所及数字生态各领域的参与者、构架者、守护者齐聚杭城汇聚，共商时代议题，共论前沿技术，共商数字安全，共建数字中国。

 安全玻璃盒作为优秀厂商代表，携“六道”产品、“四服”服务、“三解”方案，亮相活动，一展“软件供应链安全领航者”风采。', N'致力于为用户提供软件供应链安全解决方案，是国内软件供应链安全领航者。公司拥有近百项自主知识产权，掌握全球领先的AI智能动态污点分析、大数据人工神经网络以及二进制代码片段分析与验证等创新安全技术。', N'null')
GO


-- ----------------------------
-- Table structure for MediaContent
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[fwwb_schema].[MediaContent]') AND type IN ('U'))
	DROP TABLE [fwwb_schema].[MediaContent]
GO

CREATE TABLE [fwwb_schema].[MediaContent] (
  [id] int  NOT NULL,
  [type] int  NULL,
  [content] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [picture_url] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [summary] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [title] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [create_time] datetime  NULL,
  [other] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [fwwb_schema].[MediaContent] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'资讯图片视频id',
'SCHEMA', N'fwwb_schema',
'TABLE', N'MediaContent',
'COLUMN', N'id'
GO

EXEC sp_addextendedproperty
'MS_Description', N'类型',
'SCHEMA', N'fwwb_schema',
'TABLE', N'MediaContent',
'COLUMN', N'type'
GO

EXEC sp_addextendedproperty
'MS_Description', N'活动内容',
'SCHEMA', N'fwwb_schema',
'TABLE', N'MediaContent',
'COLUMN', N'content'
GO

EXEC sp_addextendedproperty
'MS_Description', N'介绍图地址',
'SCHEMA', N'fwwb_schema',
'TABLE', N'MediaContent',
'COLUMN', N'picture_url'
GO

EXEC sp_addextendedproperty
'MS_Description', N'摘要',
'SCHEMA', N'fwwb_schema',
'TABLE', N'MediaContent',
'COLUMN', N'summary'
GO

EXEC sp_addextendedproperty
'MS_Description', N'题目',
'SCHEMA', N'fwwb_schema',
'TABLE', N'MediaContent',
'COLUMN', N'title'
GO

EXEC sp_addextendedproperty
'MS_Description', N'发布时间',
'SCHEMA', N'fwwb_schema',
'TABLE', N'MediaContent',
'COLUMN', N'create_time'
GO


-- ----------------------------
-- Records of MediaContent
-- ----------------------------
INSERT INTO [fwwb_schema].[MediaContent] ([id], [type], [content], [picture_url], [summary], [title], [create_time], [other]) VALUES (N'1', N'1', N'内容', N'缩略图', N'指路贴来啦！大家都关心的嘉宾PPT下载指南在这里！一图解锁西湖论剑官网&小程序下载路径，看众多专家真知灼见，干货满满 ，引领行业思辨！', N'【重磅干货】大家都关心的嘉宾PPT下载指南来啦！', N'2023-05-12 00:00:00.000', NULL)
GO

INSERT INTO [fwwb_schema].[MediaContent] ([id], [type], [content], [picture_url], [summary], [title], [create_time], [other]) VALUES (N'2', N'1', N'内容', N'缩略图', N'央广网杭州5月8日消息(记者 姜頔)自山下而仰山巅谓之高远，自山前而窥山后谓之深远自近山而望远山谓之平远。5月7日，以“数字安全@数字中国”为主题的2023西湖论剑·数字安全大会在杭州成功举办。', N'
2023西湖论剑·数字安全大会举办', N'2023-05-08 00:00:00.000', NULL)
GO


-- ----------------------------
-- Table structure for Register
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[fwwb_schema].[Register]') AND type IN ('U'))
	DROP TABLE [fwwb_schema].[Register]
GO

CREATE TABLE [fwwb_schema].[Register] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [eventid] int  NULL,
  [userid] int  NULL
)
GO

ALTER TABLE [fwwb_schema].[Register] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of Register
-- ----------------------------
SET IDENTITY_INSERT [fwwb_schema].[Register] ON
GO

INSERT INTO [fwwb_schema].[Register] ([id], [eventid], [userid]) VALUES (N'4', N'1', N'2')
GO

INSERT INTO [fwwb_schema].[Register] ([id], [eventid], [userid]) VALUES (N'5', N'2', N'2')
GO

SET IDENTITY_INSERT [fwwb_schema].[Register] OFF
GO


-- ----------------------------
-- Table structure for Users
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[fwwb_schema].[Users]') AND type IN ('U'))
	DROP TABLE [fwwb_schema].[Users]
GO

CREATE TABLE [fwwb_schema].[Users] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [user_name] varchar(50) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [password] varchar(100) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [gender] varchar(10) COLLATE Chinese_PRC_CI_AS  NULL,
  [phone_number] varchar(100) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [nick_name] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [admin] varchar(1) COLLATE Chinese_PRC_CI_AS  NULL,
  [email] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [del_flag] int  NULL,
  [create_time] datetime  NULL,
  [update_time] datetime  NULL,
  [create_by] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [update_by] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL
)
GO

ALTER TABLE [fwwb_schema].[Users] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'用户名/昵称',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Users',
'COLUMN', N'user_name'
GO

EXEC sp_addextendedproperty
'MS_Description', N'密码',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Users',
'COLUMN', N'password'
GO

EXEC sp_addextendedproperty
'MS_Description', N'性别',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Users',
'COLUMN', N'gender'
GO

EXEC sp_addextendedproperty
'MS_Description', N'手机号',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Users',
'COLUMN', N'phone_number'
GO

EXEC sp_addextendedproperty
'MS_Description', N'昵称',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Users',
'COLUMN', N'nick_name'
GO

EXEC sp_addextendedproperty
'MS_Description', N'是否为管理员',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Users',
'COLUMN', N'admin'
GO

EXEC sp_addextendedproperty
'MS_Description', N'邮箱',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Users',
'COLUMN', N'email'
GO

EXEC sp_addextendedproperty
'MS_Description', N'逻辑删除字段',
'SCHEMA', N'fwwb_schema',
'TABLE', N'Users',
'COLUMN', N'del_flag'
GO


-- ----------------------------
-- Records of Users
-- ----------------------------
SET IDENTITY_INSERT [fwwb_schema].[Users] ON
GO

INSERT INTO [fwwb_schema].[Users] ([id], [user_name], [password], [gender], [phone_number], [nick_name], [admin], [email], [del_flag], [create_time], [update_time], [create_by], [update_by]) VALUES (N'1', N'crumbling', N'$2a$10$KuJdrIEWNTylrpCJflJHW.WENg9VpzmqcHqEKqNf5fPVnxeNLQPeS', N'男', N'2123456', N'crumblingNickName', N'1', N'crumbling@qq.com', N'0', NULL, NULL, NULL, NULL)
GO

INSERT INTO [fwwb_schema].[Users] ([id], [user_name], [password], [gender], [phone_number], [nick_name], [admin], [email], [del_flag], [create_time], [update_time], [create_by], [update_by]) VALUES (N'2', N'testuser', N'$2a$10$rJYZXPqH1bHG/UwxQ.erweIiqEEef1xaZHk5LPhLG.rf6NIdhvVZC', N'女', N'123456789', N'joker', N'0', N'123@qq.com', N'0', NULL, NULL, NULL, NULL)
GO

INSERT INTO [fwwb_schema].[Users] ([id], [user_name], [password], [gender], [phone_number], [nick_name], [admin], [email], [del_flag], [create_time], [update_time], [create_by], [update_by]) VALUES (N'6', N'feifeiUserName', N'$2a$10$4W0iTEa1s8ceV3w8uYno3eCLkYCMv0LKfvXuVh.5tiOjcj3obQfSq', NULL, N'12345678', N'feifeiNickName', NULL, N'feifei@qq.com', N'0', NULL, NULL, NULL, NULL)
GO

SET IDENTITY_INSERT [fwwb_schema].[Users] OFF
GO


-- ----------------------------
-- Primary Key structure for table Achievement
-- ----------------------------
ALTER TABLE [fwwb_schema].[Achievement] ADD CONSTRAINT [PK__Achievem__276330E0A0B189E4] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for Comment
-- ----------------------------
DBCC CHECKIDENT ('[fwwb_schema].[Comment]', RESEED, 6)
GO


-- ----------------------------
-- Auto increment value for Event
-- ----------------------------
DBCC CHECKIDENT ('[fwwb_schema].[Event]', RESEED, 8)
GO


-- ----------------------------
-- Primary Key structure for table Event
-- ----------------------------
ALTER TABLE [fwwb_schema].[Event] ADD CONSTRAINT [PK__Event__3213E83FF696F217] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table EventStatistics
-- ----------------------------
ALTER TABLE [fwwb_schema].[EventStatistics] ADD CONSTRAINT [PK__EventSta__7944C8706B70E70B] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table exhibitor
-- ----------------------------
ALTER TABLE [fwwb_schema].[exhibitor] ADD CONSTRAINT [PK__Exhibito__60E8967C46148B5C] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table MediaContent
-- ----------------------------
ALTER TABLE [fwwb_schema].[MediaContent] ADD CONSTRAINT [PK__MediaCon__2907A87E8B67672E] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for Register
-- ----------------------------
DBCC CHECKIDENT ('[fwwb_schema].[Register]', RESEED, 5)
GO


-- ----------------------------
-- Primary Key structure for table Register
-- ----------------------------
ALTER TABLE [fwwb_schema].[Register] ADD CONSTRAINT [PK__User_Eve__2DC8B1113F162C71] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for Users
-- ----------------------------
DBCC CHECKIDENT ('[fwwb_schema].[Users]', RESEED, 6)
GO


-- ----------------------------
-- Uniques structure for table Users
-- ----------------------------
ALTER TABLE [fwwb_schema].[Users] ADD CONSTRAINT [UserName] UNIQUE NONCLUSTERED ([user_name] ASC)
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table Users
-- ----------------------------
ALTER TABLE [fwwb_schema].[Users] ADD CONSTRAINT [PK__Users__3213E83FD50F9F46] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

