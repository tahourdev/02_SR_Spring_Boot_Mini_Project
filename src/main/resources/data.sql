-- Insert an AppUser
INSERT INTO app_users (user_id, username, email, password, level, xp, profile_image, is_verified, created_at)
VALUES ('3fa85f64-5717-4562-b3fc-2c963f66afa6', 'john_doe', 'john@example.com', 'password123', 1, 100, 'https://example.com/profile.jpg', true, CURRENT_TIMESTAMP);

-- Insert an Achievement
INSERT INTO achievements (achievement_id, title, description, badge, xp_required)
VALUES ('4fa85f64-5717-4562-b3fc-2c963f66afa7', 'First Win', 'Win your first challenge', 'badge1.png', 50);

-- Insert an AppUserAchievement
INSERT INTO app_user_achievements (app_user_achievement_id, app_user_id, achievement_id)
VALUES ('5fa85f64-5717-4562-b3fc-2c963f66afa8', '3fa85f64-5717-4562-b3fc-2c963f66afa6', '4fa85f64-5717-4562-b3fc-2c963f66afa7');

-- Insert a Habit
INSERT INTO habits (habit_id, title, description, frequency, app_user_id)
VALUES ('6fa85f64-5717-4562-b3fc-2c963f66afa9', 'Morning Run', 'Run 5km every morning', 'DAILY', '3fa85f64-5717-4562-b3fc-2c963f66afa6');

-- Insert a HabitLog
INSERT INTO habit_logs (log_id, log_date, status, xp_earned, habit_id)
VALUES ('7fa85f64-5717-4562-b3fc-2c963f66afa0', '2025-04-04', 'COMPLETED', 50, '6fa85f64-5717-4562-b3fc-2c963f66afa9');