DROP DATABASE  IF EXISTS `roommate_finder`;

CREATE DATABASE  IF NOT EXISTS `roommate_finder`;
USE `roommate_finder`;

SET FOREIGN_KEY_CHECKS = 0;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
`id` int(11) not null auto_increment,
`first_name` varchar(50) not null,
`last_name` varchar(50) not null,
`email` varchar(50) not null,
`password` varchar(50) not null,
`summary` varchar(50) default null,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
(1, 'john','smith', 'john.smith@email.com', '{noop}test123', 'my name is john smith'),
(2, 'bob','wall', 'bob.wall@email.com', '{noop}test123', 'my name is bob wall'),
(3, 'emma','jackson', 'emma.jackson@email.com', '{noop}test123', 'my name is emma jackson');


--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
CREATE TABLE `reviews` (
`id` int not null,
`text` varchar(254) NOT NULL,
`sender_name` varchar(50) NOT NULL,
`star` int(1) not null,
`user_id` int(11) default null,
`date` date,
primary key(`id`),

key `FK_USER_ID_idx` (`user_id`),

constraint `FK_USER` foreign key (`user_id`) references `users` (`id`)
ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `reviews`
--
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `reviews` 
VALUES 
(1, 'Great roommate', 'bob', 5, 1, "2019-04-27"),
(2, 'Great roommate', 'emma', 4, 1, "2019-04-27"),
(3, 'bad roommate', 'john', 2, 2, "2019-04-27"),
(4, 'bad roommate', 'emma', 1, 2, "2019-04-27"),
(5, 'Clean roommate', 'john', 5, 3, "2019-04-27"),
(6, 'Clean roommate', 'bill', 4, 3, "2019-04-27")