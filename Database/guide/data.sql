Create database [Coffe_Management]

USE [Coffe_Management]
GO
SET IDENTITY_INSERT [dbo].[Table] ON 

INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (1, N'Table1', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (2, N'Table2', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (3, N'Table3', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (4, N'Table4', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (5, N'Table5', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (6, N'Table6', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (7, N'Table7', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (8, N'Table8', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (9, N'Table9', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (10, N'Table10', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (11, N'Table11', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (12, N'Table12', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (13, N'Table13', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (14, N'Table14', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (15, N'Table15', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (16, N'Table16', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (17, N'Table17', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (18, N'Table18', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (19, N'Table19', 0, 1)
INSERT [dbo].[Table] ([id], [name], [table_status], [status]) VALUES (20, N'Table20', 0, 1)
SET IDENTITY_INSERT [dbo].[Table] OFF
GO
SET IDENTITY_INSERT [dbo].[Unit] ON 

INSERT [dbo].[Unit] ([id], [name], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (1, N'cup', NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Unit] ([id], [name], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (2, N'bottle', NULL, NULL, NULL, NULL, 1)
SET IDENTITY_INSERT [dbo].[Unit] OFF
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([id], [name], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (1, N'Hot Coffes', NULL, CAST(N'2022-12-06T16:33:24.240' AS DateTime), NULL, 1, 1)
INSERT [dbo].[Category] ([id], [name], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (2, N'Hot Teas', NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Category] ([id], [name], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (3, N'Hot Drinks', NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Category] ([id], [name], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (4, N'Cold Coffes', NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Category] ([id], [name], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (5, N'Iced Teas', NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Category] ([id], [name], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (6, N'Cold Drinks', NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Category] ([id], [name], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (7, N'Food', CAST(N'2022-12-06T16:34:08.677' AS DateTime), CAST(N'2022-12-06T16:34:12.817' AS DateTime), 1, 1, 0)
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (1, N'Caffe Americano', 1, 1, 100000, NULL, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (2, N'Chai Tea Latte', 2, 1, 100000, NULL, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (3, N'Peppermint Hot Chocolate', 3, 1, 100000, NULL, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (4, N'Pumpkin Cream Cold Brew', 4, 1, 100000, NULL, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (5, N'Teavana Mango Black Tea', 5, 2, 100000, 596, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (6, N'Dragon Drink Starbucks Refreshers Beverage', 6, 1, 100000, NULL, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (7, N'Caffe Misto', 1, 1, 100000, NULL, CAST(N'2022-11-14T00:58:04.610' AS DateTime), NULL, 1, NULL, 1)
INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (8, N'Earl Grey Tea', 2, 1, 100000, NULL, CAST(N'2022-11-14T01:02:44.430' AS DateTime), NULL, 1, NULL, 1)
INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (9, N'Hot Chocolate', 3, 1, 100000, NULL, CAST(N'2022-11-15T17:57:40.053' AS DateTime), CAST(N'2022-11-15T17:59:42.630' AS DateTime), 1, 1, 1)
INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (10, N'Iced Black Tea', 5, 1, 100000, NULL, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (11, N'Energy Mango Guava', 6, 2, 100000, 100, NULL, NULL, NULL, NULL, 1)
INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (12, N'White Hot Chocolate', 3, 1, 100000, NULL, CAST(N'2022-11-26T15:04:14.907' AS DateTime), NULL, 1, NULL, 1)
INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (13, N'Vanilla Creme', 3, 1, 100000, NULL, CAST(N'2022-11-26T15:10:27.587' AS DateTime), NULL, 1, NULL, 1)
INSERT [dbo].[Product] ([id], [name], [category_id], [unit_id], [price], [quantity], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (14, N'Iced Coffe Mocha', 4, 1, 200000, NULL, CAST(N'2022-11-26T15:13:34.167' AS DateTime), CAST(N'2022-11-26T16:39:45.090' AS DateTime), 1, 1, 1)
SET IDENTITY_INSERT [dbo].[Product] OFF
GO
SET IDENTITY_INSERT [dbo].[Discount] ON 

INSERT [dbo].[Discount] ([id], [name], [value]) VALUES (1, N'default', 1)
INSERT [dbo].[Discount] ([id], [name], [value]) VALUES (2, N'employee', 0.75)
INSERT [dbo].[Discount] ([id], [name], [value]) VALUES (3, N'bronze', 0.9)
INSERT [dbo].[Discount] ([id], [name], [value]) VALUES (4, N'silver', 0.8)
INSERT [dbo].[Discount] ([id], [name], [value]) VALUES (5, N'gold', 0.7)
SET IDENTITY_INSERT [dbo].[Discount] OFF
GO
SET IDENTITY_INSERT [dbo].[Avatar] ON 

INSERT [dbo].[Avatar] ([id], [link], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (1, N'H:\\ImageForCaffeManagement\\Screenshot 2022-11-27 153113.png', NULL, CAST(N'2022-11-27T19:05:32.037' AS DateTime), NULL, 1, 1)
SET IDENTITY_INSERT [dbo].[Avatar] OFF
GO
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([id], [username], [password], [fullname], [dob], [email], [phone], [avatar_id], [discount_id], [total_contribute], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (1, N'admin', N'123456', N'admin', NULL, N'admin@gmail.com', N'123', 2, 2, 1500000, NULL, CAST(N'2022-12-02T01:30:43.637' AS DateTime), NULL, 1, 1)
INSERT [dbo].[User] ([id], [username], [password], [fullname], [dob], [email], [phone], [avatar_id], [discount_id], [total_contribute], [created_at], [updated_at], [created_by], [updated_by], [status]) VALUES (2, N'employee', N'123456', N'employee', NULL, N'employee@gmail.com', N'0', 3, 2, 0, CAST(N'2022-11-13T23:05:47.083' AS DateTime), CAST(N'2022-12-03T21:44:39.127' AS DateTime), 1, 1, 1)
SET IDENTITY_INSERT [dbo].[User] OFF
GO

SET IDENTITY_INSERT [dbo].[Role] ON 

INSERT [dbo].[Role] ([id], [name], [status]) VALUES (1, N'admin', 1)
INSERT [dbo].[Role] ([id], [name], [status]) VALUES (2, N'employee', 1)
SET IDENTITY_INSERT [dbo].[Role] OFF
GO
SET IDENTITY_INSERT [dbo].[UserRole] ON 

INSERT [dbo].[UserRole] ([id], [user_id], [role_id]) VALUES (1, 1, 1)
INSERT [dbo].[UserRole] ([id], [user_id], [role_id]) VALUES (2, 2, 2)
SET IDENTITY_INSERT [dbo].[UserRole] OFF
GO
