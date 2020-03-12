
CREATE TABLE trainings (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    duration INT UNSIGNED DEFAULT 0,
    description TEXT,
    trainer_id INT UNSIGNED
);



CREATE TABLE users (
    id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role INT UNSIGNED,
    password VARCHAR(255)
);

CREATE TABLE enrollments (
    trainee_id INT UNSIGNED,
    training_id INT UNSIGNED,
    enrollment_date DATETIME,
    PRIMARY KEY (trainee_id, training_id)
);