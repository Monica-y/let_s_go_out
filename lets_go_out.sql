USE [KONGMING234]
GO
/****** Object:  Table [dbo].[HComment]    Script Date: 2022/5/28 14:53:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HComment](
	[hCommentID] [int] NOT NULL,
	[houseID] [int] NULL,
	[userID] [int] NULL,
	[date] [date] NULL,
	[hComment] [varchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[hCommentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[House]    Script Date: 2022/5/28 14:53:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[House](
	[houseID] [int] NOT NULL,
	[housePho] [varchar](100) NULL,
	[houseName] [varchar](100) NULL,
	[houseInfo] [varchar](1000) NULL,
	[houseAddress] [varchar](100) NULL,
	[status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[houseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SiComment]    Script Date: 2022/5/28 14:53:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SiComment](
	[sCommentID] [int] NOT NULL,
	[sightID] [int] NULL,
	[userID] [int] NULL,
	[date] [date] NULL,
	[sComment] [varchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[sCommentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sight]    Script Date: 2022/5/28 14:53:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sight](
	[sightID] [int] NOT NULL,
	[sightPho] [varchar](100) NULL,
	[sightName] [varchar](100) NULL,
	[sightInfo] [varchar](1000) NULL,
	[sightAddress] [varchar](100) NULL,
	[status] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[sightID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[WebAdmin]    Script Date: 2022/5/28 14:53:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[WebAdmin](
	[userID] [int] NOT NULL,
	[name] [varchar](50) NULL,
	[password] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[WebUser]    Script Date: 2022/5/28 14:53:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[WebUser](
	[userID] [int] NOT NULL,
	[name] [varchar](50) NULL,
	[password] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[House] ([houseID], [housePho], [houseName], [houseInfo], [houseAddress], [status]) VALUES (1, N'img\hotel\bf2cb3cfa4f54e7ab93d303935ca1797.jpg', N'三亚·亚特兰蒂斯酒店', N'三亚·亚特兰蒂斯坐落于国家海岸海棠湾，占地面积达54万平方米，度假区由80余家国际著名的建筑和设计机构联手打造，设计风格融汇东西方特色文化以及琼岛本土文化，是集度假酒店、娱乐、餐饮、购物、演艺、物业、国际会展及特色海洋文化体验八大业态于一体的旅游综合体。', N'海南三亚海棠湾海棠北路36号', 1)
INSERT [dbo].[House] ([houseID], [housePho], [houseName], [houseInfo], [houseAddress], [status]) VALUES (2, N'img\hotel\e969954439cc40afb45e6a2ca4e1d62e.jpg', N'上海佘山世茂洲际酒店', N'上海佘山世茂洲际酒店（又名：世茂深坑洲际酒店），位于上海市松江佘山国家旅游度假区的天马山深坑内，由世茂集团投资建设，海拔负88米 ，于采石坑内建成的自然生态酒店。酒店遵循自然环境，一反向天空发展的传统建筑理念，下探地表88米开拓建筑空间 ，依附深坑崖壁而建，是世界首个建造在废石坑内的自然生态酒店。被美国国家地理誉为“世界建筑奇迹”。', N'上海市松江区辰花路5888号', 1)
INSERT [dbo].[House] ([houseID], [housePho], [houseName], [houseInfo], [houseAddress], [status]) VALUES (3, N'img\hotel\e0b571c668474121bf6a051e7ff2fb63.jpg', N'宝墩湖湖山温泉度假村', N'宝墩湖湖山温泉度假村位于素称岭南古邑的清远英德，距市中心仅20分钟车程，距清远、韶关、广州等城市均约1个半小时车程，交通便利。面向万宝墩湖，温润泉水倒影绵延山脉，在此度假，可以让你的身心得到全方位的舒松，瞬间找到了心灵停泊的港湾。
包括湖山温泉中心、温泉微庄园及温泉别墅区三大部分，并将无边际泳池带入这里，与宝墩湖交相辉映。', N'清远市英德市望埠镇宝墩大道宝墩湖温泉小镇', 1)
GO
INSERT [dbo].[SiComment] ([sCommentID], [sightID], [userID], [date], [sComment]) VALUES (1, 2, 0, CAST(N'2022-05-28' AS Date), N'壶口瀑布，好！')
GO
INSERT [dbo].[Sight] ([sightID], [sightPho], [sightName], [sightInfo], [sightAddress], [status]) VALUES (1, N'img\sights\af4ae8ff68de4cdf96692facd75f9963.jpg', N'大明山 （浙西大明山）', N'大明山是国家AAAA级景区，距黄山70公里，地形高差达一千余米，因而山高谷深，层峦叠嶂，群峰耸立，气势十分壮观，气候条件及地质条件与黄山类似，所以被称为浙西小黄山。', N'杭州市临安区西南部', 1)
INSERT [dbo].[Sight] ([sightID], [sightPho], [sightName], [sightInfo], [sightAddress], [status]) VALUES (2, N'img\sights\7d70a742041749ad83dabee38e739a95.jpg', N'壶口瀑布', N'壶口瀑布是国家级风景名胜区，国家AAAA级旅游景区 。东濒山西省临汾市吉县壶口镇，西临陕西省延安市宜川县壶口镇，为两省共有旅游景区。南距陕西西安350千米；北距山西太原387千米。', N'山西省壶口镇和陕西省壶口镇', 1)
INSERT [dbo].[Sight] ([sightID], [sightPho], [sightName], [sightInfo], [sightAddress], [status]) VALUES (3, N'img\sights\3ec727df670f4e8096eff362337a7111.jpg', N'小七孔风景区', N'小七孔风景区，位于贵州省荔波县城南部30余公里的群峰之中，距大七孔景区5公里，景区全长7公里，面积约10平方公里，有百多个游览景点。
整个小七孔 风景区融山、水、林、洞、湖泊和瀑布为一体，有柔美恬静的涵碧潭、飞流狂泻的拉雅瀑布、潭瀑交错的 六十八级瀑布、盘根错节的龟背山、林溪穿插的水上森林、密林镶嵌的鸳鸯湖、悠蓝深邃的卧龙潭，妩媚 而迷人的响水河贯穿了整个风景区，它静如娴花照水，动似蛟龙出海。
', N'黔南州荔波县孟柳风情小镇旁', 1)
INSERT [dbo].[Sight] ([sightID], [sightPho], [sightName], [sightInfo], [sightAddress], [status]) VALUES (5, N'img\sights\25817de0fc7147d5a6042b4afa7ff3fb.jpg', N'呼伦贝尔草原', N'呼伦贝尔草原位于内蒙古自治区东北部，地处大兴安岭以西的呼伦贝尔高原上，因呼伦湖、贝尔湖而得名。整体地势东高西低，海拔在650～700米之间，东西宽约350千米，南北长约300千米，总面积1126.67万公顷（一亿四千九百万亩），其中可利用草场面积833.33万公顷。呼伦贝尔草原是世界著名的天然牧场，是世界四大草原之一，被称为世界上最好的草原，是全国旅游二十胜景之一。', N'呼伦贝尔市新巴尔虎左旗海满一级公路', 1)
GO
INSERT [dbo].[WebAdmin] ([userID], [name], [password]) VALUES (0, N'1', N'1')
GO
INSERT [dbo].[WebUser] ([userID], [name], [password]) VALUES (0, N'1', N'1')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__WebAdmin__6E2DBEDEACE7E2D9]    Script Date: 2022/5/28 14:53:17 ******/
ALTER TABLE [dbo].[WebAdmin] ADD UNIQUE NONCLUSTERED 
(
	[password] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__WebAdmin__72E12F1B3743468B]    Script Date: 2022/5/28 14:53:17 ******/
ALTER TABLE [dbo].[WebAdmin] ADD UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__WebUser__72E12F1B61CB3C1E]    Script Date: 2022/5/28 14:53:17 ******/
ALTER TABLE [dbo].[WebUser] ADD UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[HComment]  WITH CHECK ADD FOREIGN KEY([houseID])
REFERENCES [dbo].[House] ([houseID])
GO
ALTER TABLE [dbo].[HComment]  WITH CHECK ADD FOREIGN KEY([userID])
REFERENCES [dbo].[WebUser] ([userID])
GO
ALTER TABLE [dbo].[SiComment]  WITH CHECK ADD FOREIGN KEY([sightID])
REFERENCES [dbo].[Sight] ([sightID])
GO
ALTER TABLE [dbo].[SiComment]  WITH CHECK ADD FOREIGN KEY([userID])
REFERENCES [dbo].[WebUser] ([userID])
GO
