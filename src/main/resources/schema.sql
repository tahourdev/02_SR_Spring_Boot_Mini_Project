-- Table: app_users
CREATE TABLE IF NOT EXISTS app_users
(
    user_id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    level INTEGER,
    xp INTEGER,
    profile_image VARCHAR(255),
    is_verified BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: achievements
CREATE TABLE IF NOT EXISTS achievements
(
    achievement_id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    badge VARCHAR(255),
    xp_required INTEGER
);

-- Table: app_user_achievements (Join Table)
CREATE TABLE IF NOT EXISTS app_user_achievements
(
    app_user_achievement_id UUID PRIMARY KEY,
    app_user_id UUID REFERENCES app_users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    achievement_id UUID REFERENCES achievements(achievement_id) ON DELETE CASCADE ON UPDATE CASCADE
);

-- Table: habits
CREATE TABLE IF NOT EXISTS habits
(
    habit_id UUID PRIMARY KEY,
    habit_title VARCHAR(255) NOT NULL,
    description TEXT,
    habit_frequency VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE,
    app_user_id UUID REFERENCES app_users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ALTER TABLE habits
--     ADD COLUMN created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
--
-- ALTER TABLE habits
--     ADD COLUMN isActive BOOLEAN DEFAULT TRUE;


-- Table: habit_logs
CREATE TABLE IF NOT EXISTS habit_logs(
    log_id UUID PRIMARY KEY,
    log_date DATE NOT NULL,
    status VARCHAR(100),
    xp_earned INTEGER,
    habit_id UUID REFERENCES habits(habit_id) ON DELETE CASCADE ON UPDATE CASCADE
);


DROP TABLE IF EXISTS habit_logs;
DROP TABLE IF EXISTS habits;
DROP TABLE IF EXISTS app_user_achievements;
DROP TABLE IF EXISTS achievements;
DROP TABLE IF EXISTS app_users;



