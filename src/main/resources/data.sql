INSERT INTO app_users (user_id, username, email, password, level, ex, profile_image, is_verified, created_at)
VALUES
    (gen_random_uuid(), 'nimol', 'pathnimol0425@gmail.com', '$2a$12$YPAj9rUTabWh6.9oMYK0MOHvP9C9OhSGOrGKn9.VxX3FFDKvhf7Mm', 1, 0, 'profile1.png', TRUE, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'user2', 'user2@example.com', 'password2', 1, 0, 'profile2.png', TRUE, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'user3', 'user3@example.com', 'password3', 1, 0, 'profile3.png', TRUE, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'user4', 'user4@example.com', 'password4', 1, 0, 'profile4.png', TRUE, CURRENT_TIMESTAMP),
    (gen_random_uuid(), 'user5', 'user5@example.com', 'password5', 1, 0, 'profile5.png', TRUE, CURRENT_TIMESTAMP);


INSERT INTO app_user_achievements (app_user_id, achievement_id)
VALUES (1, '443bcabd-5ff5-428f-9939-f878e3aecc88'),
       (2, '0a2cbbe1-6456-41ba-b75c-382a75efb34a'),
       (3, 'e02f8bd8-34b9-4a5c-b8da-4518cae5e661'),
       (4, '308a12bf-a978-4970-ade0-f10625375221'),
       (5, '5f8203b2-2580-43fe-af06-8461110740b0');

INSERT INTO achievements (achievement_id, title, description, badge, xp_required)
VALUES (gen_random_uuid(), 'First Login', 'Awarded for logging in for the first time', 'badge_1.png', 100),
       (gen_random_uuid(), 'Level 5', 'Awarded for reaching level 5', 'badge_2.png', 200),
       (gen_random_uuid(), '10 Tasks Completed', 'Awarded for completing 10 tasks', 'badge_3.png', 300),
       (gen_random_uuid(), '100 XP', 'Awarded for earning 100 XP', 'badge_4.png', 400),
       (gen_random_uuid(), 'Daily Login', 'Awarded for logging in every day for a week', 'badge_5.png', 500),
       (gen_random_uuid(), 'Perfect Score', 'Awarded for achieving a perfect score in a challenge', 'badge_6.png', 600),
       (gen_random_uuid(), 'First Achievement', 'Awarded for unlocking your first achievement', 'badge_7.png', 150),
       (gen_random_uuid(), 'Level 10', 'Awarded for reaching level 10', 'badge_8.png', 700),
       (gen_random_uuid(), 'Top Contributor', 'Awarded for contributing the most in a challenge', 'badge_9.png', 800),
       (gen_random_uuid(), 'Speed Runner', 'Awarded for completing a task in record time', 'badge_10.png', 900),
       (gen_random_uuid(), 'Master of Tasks', 'Awarded for completing 50 tasks', 'badge_11.png', 1000),
       (gen_random_uuid(), 'Level 20', 'Awarded for reaching level 20', 'badge_12.png', 1100),
       (gen_random_uuid(), 'Challenge Winner', 'Awarded for winning a major challenge', 'badge_13.png', 1200),
       (gen_random_uuid(), 'Level 30', 'Awarded for reaching level 30', 'badge_14.png', 1300),
       (gen_random_uuid(), 'The Collector', 'Awarded for unlocking 100 achievements', 'badge_15.png', 1400);


