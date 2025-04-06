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

-- add
create extension if not exists "uuid-ossp";


CREATE TABLE app_users
(
    app_user_id   uuid      default uuid_generate_v4() PRIMARY KEY,
    username      VARCHAR(255) NOT NULL UNIQUE,
    email         VARCHAR(255) NOT NULL UNIQUE,
    password      VARCHAR(255) NOT NULL,
    level         INT       DEFAULT 0,
    xp            INT       DEFAULT 0,
    profile_image VARCHAR(255),
    is_verified   BOOLEAN   DEFAULT FALSE,
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE habits
(
    habit_id    uuid      default uuid_generate_v4() PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    frequency   VARCHAR(50),
    is_active   BOOLEAN   DEFAULT TRUE,
    app_user_id uuid         NOT NULL,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (app_user_id) REFERENCES app_users (app_user_id)
);

CREATE TABLE habit_logs
(
    habit_log_id uuid default uuid_generate_v4() PRIMARY KEY,
    log_date     DATE    NOT NULL,
    status       BOOLEAN NOT NULL,
    xp_earned    INT     NOT NULL,
    habit_id     uuid    NOT NULL,
    FOREIGN KEY (habit_id) REFERENCES habits (habit_id)
);
