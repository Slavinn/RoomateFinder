DROP DATABASE  IF EXISTS `roommate_finder`;

CREATE DATABASE  IF NOT EXISTS `roommate_finder`;
USE `roommate_finder`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
`user_id` int not null auto_increment,
`first_name` varchar(50) not null,
`last_name` varchar(50) not null,
`email` varchar(50) not null,
`password` varchar(50) not null,
`summary` varchar(50) not null,
PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--

INSERT INTO `users` 
VALUES 
(1, 'john','smith', 'john.smith@email.com', '{noop}test123', 'my name is john smith'),
(2, 'bob','wall', 'emma.jackson@email.com', '{noop}test123', 'my name is bob wall'),
(3, 'emma','jackson', 'emma.jackson@email.com', '{noop}test123', 'my name is emma jackson');


--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
CREATE TABLE `reviews` (
`review_id` int not null,
`review_text` varchar(254) NOT NULL,
`sender_name` varchar(50) NOT NULL,
`star` int(1) not null,
`user_id` int not null,
`date` date,
primary key(`review_id`),
foreign key (`user_id`) references users(`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `reviews`
--

INSERT INTO `reviews` 
VALUES 
(1, 'Great roommate', 'bob', 5, 1, "2019-04-27"),
(2, 'Great roommate', 'emma', 4, 1, "2019-04-27"),
(3, 'bad roommate', 'john', 2, 2, "2019-04-27"),
(4, 'bad roommate', 'emma', 1, 2, "2019-04-27"),
(5, 'Clean roommate', 'john', 5, 3, "2019-04-27"),
(6, 'Clean roommate', 'bill', 4, 3, "2019-04-27")