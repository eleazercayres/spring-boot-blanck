CREATE table "configurer-catalog"."catalog" (
	id int8 NOT NULL,
	"key" varchar(255) NULL,
	rule_id int8 NOT NULL,
	CONSTRAINT catalog_pkey PRIMARY KEY (id),
	CONSTRAINT uk_12p7x9lqfuhgb1hee624uqtk9 UNIQUE (key),
	CONSTRAINT fkd3r161j9wh7ylpwecfr7eddf5 FOREIGN KEY (rule_id) REFERENCES "configurer-catalog".rule(id)
);

CREATE TABLE "configurer-catalog".catalog_history (
	id int8 NOT NULL,
	rev int4 NOT NULL,
	revtype int2 NULL,
	"key" varchar(255) NULL,
	rule_id int8 NULL,
	CONSTRAINT catalog_history_pkey PRIMARY KEY (id, rev),
	CONSTRAINT fk4bda3pb1jkyycn4ayvei3a66q FOREIGN KEY (rev) REFERENCES "configurer-catalog".revinfo(rev)
);

CREATE TABLE "configurer-catalog".offer_view (
	id int8 NOT NULL,
	order_view int4 NULL,
	offer_id int8 NULL,
	view_id int8 NULL,
	CONSTRAINT offer_view_pkey PRIMARY KEY (id),
	CONSTRAINT fkco8j6xdr2ndxvp8qrhu4sqbr FOREIGN KEY (view_id) REFERENCES "configurer-catalog".view(id)
);

CREATE TABLE configurer_catalog.offer_view_history (
	id int8 NOT NULL,
	rev int4 NOT NULL,
	revtype int2 NULL,
	order_view int4 NULL,
	view_id int8 NULL,
	CONSTRAINT offer_view_history_pkey PRIMARY KEY (id, rev),
	CONSTRAINT fk5mytjggkbts5hp4sasg5w055q FOREIGN KEY (rev) REFERENCES configurer_catalog.revinfo(rev)
);

CREATE TABLE "configurer-catalog".revinfo (
	rev int4 NOT NULL,
	revtstmp int8 NULL,
	CONSTRAINT revinfo_pkey PRIMARY KEY (rev)
);

CREATE TABLE "configurer-catalog"."rule" (
	id int8 NOT NULL,
	"type" varchar(255) NULL,
	value varchar(255) NULL,
	dad_rule_id int8 NULL,
	view_id int8 NOT NULL,
	CONSTRAINT rule_pkey PRIMARY KEY (id),
	CONSTRAINT fk6nl6xca2ortg5ubdborlvpeh7 FOREIGN KEY (view_id) REFERENCES "configurer-catalog".view(id),
	CONSTRAINT fks87boet9qwo7f70w0lep32vqv FOREIGN KEY (dad_rule_id) REFERENCES "configurer-catalog".rule(id)
);

CREATE TABLE "configurer-catalog".rule_history (
	id int8 NOT NULL,
	rev int4 NOT NULL,
	revtype int2 NULL,
	"type" varchar(255) NULL,
	value varchar(255) NULL,
	dad_rule_id int8 NULL,
	view_id int8 NULL,
	order_rule int4 NULL,
	CONSTRAINT rule_history_pkey PRIMARY KEY (id, rev),
	CONSTRAINT fkney0oqmyaax2ao1u9ovolam6n FOREIGN KEY (rev) REFERENCES "configurer-catalog".revinfo(rev)
);

CREATE TABLE "configurer-catalog".rule_link (
	son_rule int8 NOT NULL,
	dad_rule int8 NOT NULL,
	CONSTRAINT fk4jfjnhupl1ceg5v358s6c2evw FOREIGN KEY (dad_rule) REFERENCES "configurer-catalog".rule(id),
	CONSTRAINT fki8bgm9pf3vphjcfv5i0sqhyyo FOREIGN KEY (son_rule) REFERENCES "configurer-catalog".rule(id)
);

CREATE TABLE "configurer-catalog".rule_link_aud (
	rev int4 NOT NULL,
	son_rule int8 NOT NULL,
	"rule" int8 NOT NULL,
	revtype int2 NULL,
	dad_rule int8 NOT NULL,
	CONSTRAINT rule_link_aud_pkey PRIMARY KEY (rev, son_rule, rule),
	CONSTRAINT fkjlk9gnudujqh9rirpudoqbu7g FOREIGN KEY (rev) REFERENCES "configurer-catalog".revinfo(rev)
);

CREATE TABLE "configurer-catalog"."view" (
	id int8 NOT NULL,
	CONSTRAINT view_pkey PRIMARY KEY (id)
);

CREATE TABLE "configurer-catalog".view_history (
	id int8 NOT NULL,
	rev int4 NOT NULL,
	revtype int2 NULL,
	CONSTRAINT view_history_pkey PRIMARY KEY (id, rev),
	CONSTRAINT fknwww08nx7tdgpna94kfvtv9ed FOREIGN KEY (rev) REFERENCES "configurer-catalog".revinfo(rev)
);

CREATE SEQUENCE configurer_catalog.hibernate_sequence
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 22
	CACHE 1
	NO CYCLE;

ALTER SEQUENCE configurer_catalog.hibernate_sequence OWNER TO postgres;
GRANT ALL ON SEQUENCE configurer_catalog.hibernate_sequence TO postgres;

CREATE TABLE "configurer-catalog".revinfo (
	rev int4 NOT NULL,
	revtstmp int8 NULL,
	CONSTRAINT revinfo_pkey PRIMARY KEY (rev)
);