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


CREATE TABLE app_users (
                           app_user_id uuid default uuid_generate_v4() PRIMARY KEY,
                           username VARCHAR(255) NOT NULL UNIQUE,
                           email VARCHAR(255) NOT NULL UNIQUE,
                           password VARCHAR(255) NOT NULL,
                           level INT DEFAULT 0,
                           xp INT DEFAULT 0,
                           profile_image VARCHAR(255),
                           is_verified BOOLEAN DEFAULT FALSE,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE habits (
                        habit_id uuid default uuid_generate_v4() PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        description TEXT,
                        frequency VARCHAR(50),
                        is_active BOOLEAN DEFAULT TRUE,
                        app_user_id uuid NOT NULL,
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        FOREIGN KEY (app_user_id) REFERENCES app_users(app_user_id)
);

CREATE TABLE habit_logs (
                            habit_log_id uuid default uuid_generate_v4() PRIMARY KEY,
                            log_date DATE NOT NULL,
                            status BOOLEAN NOT NULL,
                            xp_earned INT NOT NULL,
                            habit_id uuid NOT NULL,
                            FOREIGN KEY (habit_id) REFERENCES habits(habit_id)
);





INSERT INTO app_users (username, email, password, level, xp, profile_image, is_verified)
VALUES
    ('john_doe', 'john@example.com', 'hashed_password', 1, 100, 'profile_john.jpg', TRUE),
    ('jane_smith', 'jane@example.com', 'hashed_password', 2, 200, 'profile_jane.jpg', TRUE),
    ('alex_wong', 'alex@example.com', 'hashed_password', 3, 300, 'profile_alex.jpg', FALSE);


INSERT INTO habits (title, description, frequency, is_active, app_user_id)
VALUES
    ('Read 1 Book per Week', 'Read at least one book every week.', 'WEEKLY', TRUE, '363aa353-db6a-4ff6-824c-acc883ff39a2'),
    ('Exercise Daily', 'Work out for 30 minutes each day.', 'DAILY', TRUE, '35874432-c1af-4327-b637-d9b9ab5d5eaa'),
    ('Learn a New Skill Monthly', 'Acquire a new skill or technology every month.', 'MONTHLY', TRUE, '4cb5eb5b-2a53-4846-8b13-6a942e836863'),
    ('Meditate Daily', 'Practice meditation for 10 minutes daily.', 'DAILY', TRUE, '4cb5eb5b-2a53-4846-8b13-6a942e836863'),
    ('Write Journal Entries Weekly', 'Write journal entries every Sunday.', 'WEEKLY', TRUE, '4cb5eb5b-2a53-4846-8b13-6a942e836863');

INSERT INTO habit_logs (log_date, status, xp_earned, habit_id)
VALUES
    ('2023-10-01', TRUE, 10, 'dd894245-98d1-4e71-8a00-32cf0e2428b5'),
    ('2023-10-08', TRUE, 10, 'dd894245-98d1-4e71-8a00-32cf0e2428b5'),
    ('2023-10-15', FALSE, 0, 'dd894245-98d1-4e71-8a00-32cf0e2428b5'),
    ('2023-10-01', TRUE, 5, 'cf3480f2-69b5-4f14-86bf-b1c165d5f00e'),
    ('2023-10-02', TRUE, 5, 'cf3480f2-69b5-4f14-86bf-b1c165d5f00e'),
    ('2023-10-03', TRUE, 5, 'b33f44f3-5f39-4580-8089-d279c2b6bf41'),
    ('2023-10-04', FALSE, 0, 'b33f44f3-5f39-4580-8089-d279c2b6bf41'),
    ('2023-10-01', TRUE, 20, 'b33f44f3-5f39-4580-8089-d279c2b6bf41')