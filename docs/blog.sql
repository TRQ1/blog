CREATE TABLE `comments` (
	`id`	int(20)	NOT NULL AUTO_INCREMENT,
	`post_id`	int(20)	NOT NULL	DEFAULT '0',
	`author`	tinytext	NOT NULL,
	`author_email`	varchar(100)	NOT NULL	DEFAULT "",
	`author_url`	varchar(200)	NOT NULL	DEFAULT "",
	`todate`	datetime	NOT NULL	DEFAULT '0000-00-00 00:00:00',
	`todate_gmt`	datetime	NOT NULL	DEFAULT '0000-00-00 00:00:00',
	`content`	text	NOT NULL,
	`type`	varchar(20)	NOT NULL	DEFAULT "",
	`parent`	int(20)	NULL,
	`user_id`	int(20)	NOT NULL	DEFAULT '0',
    primary key(id)
);

CREATE TABLE `posts` (
	`id`	int(20)	NOT NULL AUTO_INCREMENT,
	`user_id`	int(20)	NOT NULL	DEFAULT '0',
	`todate`	datetime	NOT NULL	DEFAULT '0000-00-00 00:00:00',
	`todate_gmt`	datetime	NOT NULL	DEFAULT '0000-00-00 00:00:00',
	`content`	longtext	NOT NULL,
	`title`	text	NOT NULL,
	`excerpt`	text	NOT NULL,
	`status`	varchar(20)	NOT NULL	DEFAULT 'publish',
	`comment_status`	varchar(20)	NOT NULL	DEFAULT 'open',
	`password`	varchar(255)	NOT NULL	DEFAULT "",
	`name`	varchar(200)	NOT NULL	DEFAULT "",
	`modified`	datetime	NOT NULL	DEFAULT '0000-00-00 00:00:00',
	`modified_gmt`	datetime	NOT NULL	DEFAULT '0000-00-00 00:00:00',
	`parent`	int(20)	NULL,
	`type`	varchar(20)	NOT NULL,
	`comment_count`	int(20)	NOT NULL,
    primary key(id)
);

CREATE TABLE `users` (
	`id`	int(20)	NOT NULL AUTO_INCREMENT,
	`loginid`	varchar(200)	NOT NULL DEFAULT '0',
	`password`	varchar(255)	NOT NULL DEFAULT "",
	`nickname`	varchar(255)	NOT NULL DEFAULT "",
	`email`	varchar(50)	NOT NULL DEFAULT "", 
	`url`	varchar(100)	NOT NULL DEFAULT "",
	`regdate`	datetime	NOT NULL	DEFAULT '0000-00-00 00:00:00',
	`status`	int(11)	NOT NULL	DEFAULT '0',
    primary key(id)
);


ALTER TABLE `comments` ADD CONSTRAINT `FK_posts_TO_comments_1` FOREIGN KEY (
	`post_id`
)
REFERENCES `posts` (
	`id`
);

ALTER TABLE `comments` ADD CONSTRAINT `FK_comments_TO_comments_1` FOREIGN KEY (
	`parent`
)
REFERENCES `comments` (
	`id`
);

ALTER TABLE `comments` ADD CONSTRAINT `FK_users_TO_comments_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `users` (
	`id`
);

ALTER TABLE `posts` ADD CONSTRAINT `FK_users_TO_posts_1` FOREIGN KEY (
	`user_id`
)
REFERENCES `users` (
	`id`
);

ALTER TABLE `posts` ADD CONSTRAINT `FK_posts_TO_posts_1` FOREIGN KEY (
	`parent`
)
REFERENCES `posts` (
	`id`
);