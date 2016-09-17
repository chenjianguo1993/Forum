--1.用户表（enable  int ，1表示可以，0表示禁用）
create table t_user(
				userid varchar(40) primary key,
				username varchar(100),
				password varchar(20),
				email varchar(30),
				phone varchar(11),
				sex varchar(10),
				birthday datetime,
				headimage text,
				createdate datetime,
				signnum int,
				medal int,
				money int,
				prestige int,
		        enable  int 
		);
--2.签到表
create table t_sign(
				signid varchar(40) primary key,
				signdate datetime,
				feel varchar(50),
				userid varchar(40)
);
--3.版块表
create table t_plate(
				plateId varchar(40) primary key,
				plateName varchar(50),
				createDate datetime,
				plateSequence int,
				clickNum int,
				plateType varchar(20),
				userid varchar(40)
);
--3.1版块和版块中间表
create table t_fatherchildplate(
				fartherPlateId varchar(40),
				childPlateId varchar(40),
				createDate datetime
);

--4.角色表
create table t_role(
		roleId varchar(40) primary key,
		roleName varchar(50) not null unique,
		createDate datetime not null,
		userId varchar(40)
);		
--5.权限表
create table t_privilege(
		privilegeId varchar(40) primary key,
		privilegeName varchar(50) not null unique,
		privilegeUrl text,
		createDate datetime not null,
		userId varchar(40)
);		
--5.1权限角色中间表
create table t_privilege_role(
		privilegeId varchar(40),
		roleId varchar(40),
		createDate datetime not null,
		userId varchar(40)
);	

	