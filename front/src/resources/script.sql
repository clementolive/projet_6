
-- User (allows to login directly). Credentials are linked with Postman login request. password is : Test!1234
INSERT INTO `users` (`id`, `email`, `password`, `username`) VALUES
 ('1', 'test@test.com', '$2a$10$12IuD/6d/lFM/zqJ.BXiP.bFp2AHfKy1QNV8ZlKf/8OlFaLejrTZ2', 'test');

-- New topics
INSERT INTO `topic` (`topic_id`, `description`, `title`) VALUES ('1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'SQL news ');

INSERT INTO `topic` (`topic_id`, `description`, `title`) VALUES ('2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'Angular news ');

INSERT INTO `topic` (`topic_id`, `description`, `title`) VALUES ('3', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 'CSS news ');

-- From here, user should be able to create posts, subscribe to topics, update profile and comment posts. 