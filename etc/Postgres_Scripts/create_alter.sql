create table customer(
	userid serial primary key,
	--sha-256
	password_user char(64) not null,
	first_name varchar(30) not null,
	last_name varchar(30),
	address varchar(100) not null,
	city varchar(30) not null,
	zip char(6) not null,
	state varchar(30) not null,
	country varchar(30) not null,
	email_address varchar(254) unique not null,
	phone_number varchar(15) unique not null	
);

create table state_tax(
	state_name varchar(30) primary key,
	sales_tax_rate float8 not null 
);

create table shopping_cart_items(
	shopping_cart_id serial primary key,
	inventory_id int not null,--fk to ProductCatalog mongodb
	unit_price float8 not null,
	time_added timestamp not null,
	sci_userid integer references customer(userid),
	quantity integer not null
);

create table order_details(
	order_id serial primary key,
	od_userid integer references customer(userid),
	--reciever details
	rcv_name varchar(30),
	rcv_address varchar(100),
	rcv_city varchar(30),
	rcv_zip char(6),
	rcv_state varchar(30) references state_tax(state_name),
	od_shipping_type_id varchar(30)
);


create table shipping_type(
	shipping_type_id varchar(30) primary key,
	price float8 not null,
	days_for_delivery int not null
);



create table purchase_history(
	ph_id serial primary key,
	inventory_id char(24) not null,--fk to ProductCatalog mongodb
	date_of_purchase date not null,
	ph_order_id integer references order_details(order_id),
	quantity integer not null
);


alter table customer add constraint state_fk foreign key(state) references state_tax(state_name);

alter table order_details add constraint shipping_fk foreign key(od_shipping_type_id) references shipping_type(shipping_type_id);

alter table customer rename to Users;


