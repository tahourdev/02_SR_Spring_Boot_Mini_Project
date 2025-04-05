INSERT INTO app_users (username, email, password, level, ex, profile_image, is_verified, created_at)
VALUES ('john_doe', 'john.doe@example.com', 'hashed_password1', 5, 1200, 'profile1.jpg', TRUE, CURRENT_TIMESTAMP),
       ('jane_smith', 'jane.smith@example.com', 'hashed_password2', 3, 800, 'profile2.jpg', FALSE, CURRENT_TIMESTAMP),
       ('mike_tyson', 'mike.tyson@example.com', 'hashed_password3', 7, 2500, 'profile3.jpg', TRUE, CURRENT_TIMESTAMP),
       ('alice_wonder', 'alice.wonder@example.com', 'hashed_password4', 2, 400, NULL, FALSE, CURRENT_TIMESTAMP),
       ('bob_builder', 'bob.builder@example.com', 'hashed_password5', 4, 1500, 'profile5.jpg', TRUE, CURRENT_TIMESTAMP);


INSERT INTO app_user_achievements (app_user_id, achievement_id)
VALUES (1, '443bcabd-5ff5-428f-9939-f878e3aecc88'),
       (2, '0a2cbbe1-6456-41ba-b75c-382a75efb34a'),
       (3, 'e02f8bd8-34b9-4a5c-b8da-4518cae5e661'),
       (4, '308a12bf-a978-4970-ade0-f10625375221'),
       (5, '5f8203b2-2580-43fe-af06-8461110740b0');

