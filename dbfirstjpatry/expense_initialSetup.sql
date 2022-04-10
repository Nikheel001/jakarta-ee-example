use expense;

drop table Record;
drop table PeriodicRecord;
drop table Category;
drop table TransactionMode;


-- smallint 0-65535
create table Category
(
categoryid smallint unsigned not null primary key AUTO_INCREMENT,
name varchar(20) not null,
group_categoryid smallint unsigned
);

-- tinyint 0-255
create table TransactionMode
(
trmodeid tinyint unsigned not null primary key AUTO_INCREMENT,
name varchar(20) not null
);

-- int 0-4294967295
create table Record
(
recordid int unsigned not null primary key AUTO_INCREMENT,
title varchar(75) not null,
description varchar(100),
transacted_on datetime default CURRENT_TIMESTAMP,
last_modified datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
is_debit boolean,
amount float unsigned,
categoryid smallint unsigned,
trmodeid tinyint unsigned,
foreign key (categoryid) references Category(categoryid),
foreign key (trmodeid) references TransactionMode(trmodeid)
);

create table PeriodicRecord
(
recordid int unsigned not null primary key AUTO_INCREMENT,
title varchar(75) not null,
description varchar(100),
transacted_on datetime default CURRENT_TIMESTAMP,
last_modified datetime default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
is_debit boolean,
amount float unsigned,
categoryid smallint unsigned,
trmodeid tinyint unsigned,
duration smallint unsigned,
foreign key (categoryid) references Category(categoryid),
foreign key (trmodeid) references TransactionMode(trmodeid)
);
