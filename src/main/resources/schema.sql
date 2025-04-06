CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE app_users
(
    user_id       UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username      VARCHAR(100) NOT NULL,
    email         VARCHAR(200) NOT NULL,
    password      VARCHAR(200) NOT NULL,
    level         INTEGER,
    ex            BIGINT,
    profile_image VARCHAR(255),
    is_verified   BOOLEAN          DEFAULT FALSE,
    created_at    TIMESTAMP        DEFAULT CURRENT_TIMESTAMP
);


SELECT *
FROM app_users
WHERE email = 'oengsikeat@gmail.com';

CREATE TABLE achievements
(
    achievement_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    title          VARCHAR(255) NOT NULL,
    description    TEXT,
    badge          VARCHAR(255),
    xp_required    BIGINT
);



CREATE TABLE app_user_achievements
(
    app_user_id    UUID NOT NULL,
    achievement_id UUID NOT NULL,
    PRIMARY KEY (app_user_id, achievement_id),
    FOREIGN KEY (app_user_id) REFERENCES app_users (user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (achievement_id) REFERENCES achievements (achievement_id) ON DELETE CASCADE ON UPDATE CASCADE
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

CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE habits
(
    habit_id    uuid      default gen_random_uuid() PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    frequency   VARCHAR(50),
    is_active   BOOLEAN   DEFAULT TRUE,
    user_id uuid         NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES app_users (user_id)
);