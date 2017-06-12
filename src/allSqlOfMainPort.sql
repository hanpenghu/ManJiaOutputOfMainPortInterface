---注意,在母站的商品表中的guid和商品规格表中的guid是对应相等的,但是他们跟分类表中的guid是不等的

----满嘉主站修改,商品表,规格表,分类表,增加2个字段,TenantID代表那个站点的
----guid代表该商品全球唯一标识
--修改分类表
alter table Hishop_Categories add TenantID int default 0
go
alter table Hishop_Categories add guid varchar(40) default NEWID()
go
----初始化上面加的2个字段的值
update Hishop_Categories set TenantID=0---此为满嘉主站代号,设为0(0代表满嘉主站)
go
update Hishop_Categories set guid=NEWID()----设置分类全球唯一标识符
go
-----------------------------------------------------------------------------------------
---修改满嘉商品表
alter table Hishop_Products add TenantID int default 0
GO
alter table Hishop_Products add guid varchar(40) default NEWID()
GO
----初始化上面加的2个字段的值
update Hishop_Products set TenantID=0---此为满嘉主站代号,设为0(0代表满嘉主站)
GO
update Hishop_Products set guid=NEWID()----设置分类全球唯一标识符
GO
-----------------------------------------------------------------------------------------
-----修改商品规格表，该表有点特殊,必须在该表对应的productid对应的guid跟商品表一样
---修改满嘉商品表
alter table Hishop_SKUs add TenantID int default 0
GO
alter table Hishop_SKUs add guid varchar(40) default NEWID()
GO
update Hishop_SKUs set TenantID=0---此为满嘉主站代号,设为0(0代表满嘉主站)
GO
-----商品表必须跟规格表的唯一标识符guid相同,用存储实现(把商品表productid对应的guid迁移到规格表中)
CREATE PROCEDURE make_Hishop_SKUs_Hishop_Products_have_same_guid
  as
	declare @i int
	select ProductId into #TABLE from Hishop_SKUs
BEGIN
    while ((select COUNT(ProductId)from #TABLE)>0)
      BEGIN
        SET @i=(SELECT top(1) ProductId from #TABLE)
        UPDATE Hishop_SKUs  SET guid=(select guid from Hishop_Products where ProductId=@i) where ProductId=@i
        delete from #TABLE where ProductId=@i
      end
END
go
---执行上面存储过程
EXECUTE make_Hishop_SKUs_Hishop_Products_have_same_guid
go
------------------------------------------------------------------------------------------------