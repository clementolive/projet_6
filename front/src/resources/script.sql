
-- User (allows to login directly). Credentials are linked with Postman login request. password is : Test!1234
INSERT INTO `users` (`id`, `email`, `password`, `username`) VALUES
 ('1', 'test@test.com', '$2a$10$12IuD/6d/lFM/zqJ.BXiP.bFp2AHfKy1QNV8ZlKf/8OlFaLejrTZ2', 'test');

-- New topics
INSERT INTO `topic` (`topic_id`, `description`, `title`) VALUES ('1', 
'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Actualités C++');

INSERT INTO `topic` (`topic_id`, `description`, `title`) VALUES ('2',
 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Actualités Angular');

INSERT INTO `topic` (`topic_id`, `description`, `title`) VALUES ('3', 
'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Actualités CSS');

-- From here, user should be able to create posts, subscribe to topics, update profile and comment posts. 

-- Some articles 
INSERT INTO `post` (`id`, `content`, `created_at`, `title`, `topic_topic_id`, `user_id`) VALUES (NULL,
 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',
 '2022-05-09 13:52:18.000000', 'Article sur le C++', '1', '1');

 INSERT INTO `post` (`id`, `content`, `created_at`, `title`, `topic_topic_id`, `user_id`) VALUES (NULL,
 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',
 '2021-05-09 13:52:18.000000', 'Article sur Angular', '2', '1');

 INSERT INTO `post` (`id`, `content`, `created_at`, `title`, `topic_topic_id`, `user_id`) VALUES (NULL,
 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',
 '2014-05-09 13:52:18.000000', 'Article ancien sur le CSS', '3', '1');

 INSERT INTO `post` (`id`, `content`, `created_at`, `title`, `topic_topic_id`, `user_id`) VALUES (NULL,
 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',
 '2023-05-09 13:52:18.000000', 'Article récent sur le CSS', '3', '1');