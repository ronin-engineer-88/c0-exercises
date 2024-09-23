DROP SCHEMA IF EXISTS fundamental_database ;
CREATE SCHEMA fundamental_database;
USE fundamental_database;

-- Tạo bảng student
CREATE TABLE student(
	id					INT AUTO_INCREMENT PRIMARY KEY,
    name				VARCHAR(256),
    age					INT,
    grade 				TINYINT,
    class				VARCHAR(256),
    math_score			DECIMAL(4,2),
    literature_score	DECIMAL(4,2),
    english_score		DECIMAL(4,2),
    total_score			DECIMAL(5,2)
);

-- 1. Thêm 100 học sinh vào bảng
INSERT INTO student (name, age, class, grade, math_score, literature_score, english_score, total_score)
VALUES 
	('Nguyễn Văn A', 16, '10A1', 10, 8.50, 7.75, 9.00, 25.25),
	('Nguyễn Văn B', 17, '11A1', 11, 7.00, 8.50, 7.75, 23.25),
	('Nguyễn Văn C', 16, '10A2', 10, 9.00, 8.25, 8.75, 26.00),
	('Nguyễn Văn D', 17, '11A2', 11, 7.75, 6.50, 8.00, 22.25),
	('Nguyễn Văn E', 16, '10A3', 10, 8.25, 8.00, 7.50, 23.75),
	('Nguyễn Văn F', 17, '11A3', 11, 7.50, 7.25, 8.25, 23.00);

-- 2. Tìm danh sách các lớp học hiện có trong bảng
SELECT DISTINCT class FROM student;
    
-- 3. Đếm số học sinh trong bảng
SELECT COUNT(id) AS total_student FROM student;
	
-- 4. Tính tổng điểm các môn(Toán, Văn, Anh..) của tất cả học sinh
SELECT 
	SUM(math_score) AS total_math_score,
    SUM(literature_score) AS total_literature_score,
    SUM(english_score) AS english_score
FROM student;

-- 5. Tính điểm trung bình các môn(Toán, Văn, Anh..) của tất cả học sinh
SELECT 
	AVG(math_score) AS total_math_score,
    AVG(literature_score) AS total_literature_score,
    AVG(english_score) AS english_score
FROM student;

-- 6. Tìm điểm cao nhất của từng môn theo từng lớp
SELECT 
	class, 
    MAX(math_score) AS highest_math_score,
    MAX(literature_score) AS highest_literature_score,
    MAX(english_score) AS highest_english_score
FROM student
GROUP BY class;

-- 7. Tìm điểm thấp nhất của từng môn theo từng lớp
SELECT 
	class, 
    MIN(math_score) AS lowest_math_score,
    MIN(literature_score) AS lowest_literature_score,
    MIN(english_score) AS lowest_english_score
FROM student
GROUP BY class;

-- 8. Tìm học sinh có tên bắt đầu với chữ cái 'A'
SELECT * FROM student WHERE name LIKE "% A%";

-- 9. Tìm học sinh có điểm môn Toán là 9 hoặc 10
SELECT * FROM STUDENT WHERE math_score = 9 OR math_score = 10;

-- 10. Lấy thông tin học sinh và sắp xếp theo điểm tổng kết từ cao đến thấp theo từng khối
SELECT * FROM student 
ORDER BY grade, total_score DESC;

-- 11. Lấy thông tin 5 học sinh đầu tiên trong bảng có điểm tổng kết tổng 
-- cao nhất theo thứ tự cao đến thấp.
SELECT * FROM student 
ORDER BY total_score DESC
LIMIT 5;

-- 12. Tìm học sinh có điểm môn Văn >= 8 và điểm môn Anh < 6
SELECT * FROM student
WHERE literature_score >= 8 AND english_score <6;

-- 13. Tìm học sinh có điểm môn Toán < 5 hoặc điểm tổng kết tổng < 10
SELECT * FROM student
WHERE math_score < 5 OR total_score < 10;

-- 14. Giả sử, đây là điểm tổng kết cuối kì, Viết câu update để cập nhập lớp mới 
-- cho các học sinh đủ điều kiện lên lớp(điểm tổng kết >= 5 và không có điểm các môn nào = 0)
UPDATE student
SET grade = grade + 1
WHERE total_score >=5 AND (math_score > 0 AND literature_score > 0 AND english_score > 0);
