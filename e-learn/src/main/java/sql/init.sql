USE elearning;

-- Inserting sample data into the admin table
INSERT INTO admin (status, username, password, created_date, updated_date)
VALUES ('active', 'admin1', 'hashed_password_1', NOW(), NULL),
       ('active', 'admin2', 'hashed_password_2', NOW(), NULL);

-- Inserting sample data into the student table
INSERT INTO student (name, status, age, username, password, created_date, updated_date)
VALUES ('John Doe', 'active', 19, 'johndoe', 'hashed_password_3', NOW(), NULL),
       ('Jane Smith', 'active', 20, 'janesmith', 'hashed_password_4', NOW(), NULL),
       ('Alice Brown',  'inactive', 18, 'alicebrown', 'hashed_password_5', NOW(), NULL),
       ('Alice X',  'inactive', 18, 'alicebrown', 'hashed_password_5', NOW(), NULL);

-- Inserting sample data into the teacher table
INSERT INTO teacher (name, status, username, password, created_date, updated_date)
VALUES ('Mr. Anderson', 'active', 'mr_anderson', 'hashed_password_6', NOW(), NULL),
       ('Ms. Johnson', 'active', 'ms_johnson', 'hashed_password_7', NOW(), NULL),
       ('Mr. X', 'active', 'ms_x', 'hashed_password_7', NOW(), NULL);

-- Inserting sample data into the course table
INSERT INTO course (name, description, status, created_date, updated_date, teacher_id)
VALUES ('Introduction to Programming', 'Learn the basics of programming using Java.', 'active', NOW(), NULL, 1),
       ('Web Development Basics', 'An introduction to HTML, CSS, and JavaScript.', 'active', NOW(), NULL, 2),
       ('Data Structures and Algorithms', 'Understand essential data structures and algorithms.', 'inactive', NOW(), null,1),
       ('Kafka', 'kafka', 'inactive', NOW(), NULL, null);

-- Inserting sample data into the chapter table
INSERT INTO chapter (name, description, status, `order`, created_date, updated_date, course_id)
VALUES ('Getting Started with Java', 'Introduction to Java programming language.', 'active', 1, NOW(), NULL, 1),
       ('HTML Basics', 'Understanding the structure of a webpage.', 'active', 1, NOW(), NULL, 2),
       ('Sorting Algorithms', 'Learn about different sorting algorithms.', 'inactive', 1, NOW(), NULL, 3);

-- Inserting sample data into the lesson table
INSERT INTO lesson (name, description, status, type, url, `order`, created_date, updated_date, chapter_id)
VALUES ('Setting Up Java', 'How to install and configure Java.', 'active', 'video', 'http://example.com/java-setup', 1,
        NOW(), NULL, 1),
       ('Creating Your First HTML Page', 'Step by step guide to create an HTML page.', 'active', 'video',
        'http://example.com/html-first-page', 1, NOW(), NULL, 2),
       ('Bubble Sort', 'Explaining bubble sort algorithm with examples.', 'inactive', 'video',
        'http://example.com/bubble-sort', 1, NOW(), NULL, 3);

-- Inserting sample data into the student_course table
INSERT INTO student_course (student_id, course_id, rating, review, status, created_date, updated_date)
VALUES (1, 1, 5, 'Great course! Very informative.', 'active', NOW(), NULL),
       (1, 2, 4, 'Good introduction, but could use more examples.', 'active', NOW(), NULL),
       (2, 1, 3, 'Decent course, but not engaging.', 'active', NOW(), NULL),
       (3, 3, NULL, NULL, 'inactive', NOW(), NULL);

-- Inserting sample data into the student_course_lesson table
INSERT INTO student_course_lesson (user_course_user_id, user_course_course_id, lesson_id, status, created_date,
                                   updated_date)
VALUES (1, 1, 1, 'completed', NOW(), NULL),
       (1, 1, 2, 'in_progress', NOW(), NULL),
       (2, 1, 1, 'not_started', NOW(), NULL),
       (1, 2, 3, 'completed', NOW(), NULL);