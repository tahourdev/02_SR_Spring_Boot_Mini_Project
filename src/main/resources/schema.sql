CREATE DATABASE spring_mini_project;
-- Create the enum type for habit status
CREATE TYPE habit_status AS ENUM ('COMPLETED', 'FINISHED');
CREATE TYPE habit_frequency AS ENUM ('WEEKLY', 'MONTHLY', 'DAILY');

-- Table: app_users
CREATE TABLE IF NOT EXISTS app_users
(
    user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    level INTEGER,
    xp BIGINT,
    profile_image VARCHAR(255),
    is_verified BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: achievements
CREATE TABLE IF NOT EXISTS achievements
(
    achievement_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(255) NOT NULL,
    description TEXT,
    badge VARCHAR(255),
    xp_required BIGINT
);

-- Table: app_user_achievements (Join Table)
CREATE TABLE IF NOT EXISTS app_user_achievements
(
    app_user_achievement_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    app_user_id UUID REFERENCES app_users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    achievement_id UUID REFERENCES achievements(achievement_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Table: habits
CREATE TABLE IF NOT EXISTS habits
(
    habit_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title VARCHAR(255) NOT NULL,
    description TEXT,
    frequency habit_frequency,
    app_user_id UUID REFERENCES app_users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Table: habit_logs
CREATE TABLE IF NOT EXISTS habit_logs
(
    log_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    log_date DATE NOT NULL,
    status habit_status,
    xp_earned BIGINT,
    habit_id UUID REFERENCES habits(habit_id) ON DELETE CASCADE ON UPDATE CASCADE
);


