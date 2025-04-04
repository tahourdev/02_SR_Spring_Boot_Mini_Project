CREATE TABLE app_users
(
    user_id       SERIAL PRIMARY KEY,
    username      VARCHAR(100) NOT NULL,
    email         VARCHAR(200) NOT NULL,
    password      VARCHAR(200) NOT NULL,
    level         INTEGER,
    ex            BIGINT,
    profile_image VARCHAR(255),
    is_verified   BOOLEAN   DEFAULT FALSE,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE achievements
(
    achievement_id SERIAL PRIMARY KEY,
    title          VARCHAR(255) NOT NULL,
    description    TEXT,
    badge          VARCHAR(255),
    xp_required    BIGINT
);

CREATE TABLE app_user_achievements
(
    app_user_achievement_id SERIAL PRIMARY KEY,
    app_user_id             INTEGER REFERENCES app_users (user_id),
    achievement_id          INTEGER REFERENCES achievements (achievement_id)
);

CREATE TABLE habits
(
    habit_id    SERIAL PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    frequency   VARCHAR(255),
    app_user_id INTEGER REFERENCES app_users (user_id)
);

CREATE TABLE habit_logs
(
    log_id    SERIAL PRIMARY KEY,
    log_date  DATE NOT NULL,
    status    VARCHAR(50),
    xp_earned BIGINT,
    habit_id  INTEGER REFERENCES habits (habit_id)
);
