/* Write your T-SQL query statement below */
WITH MAX_MIN_SCORES AS(
    SELECT exam_id, max(score) as max, min(score) as min  FROM Exam GROUP BY exam_id
),
EDGE_STUDENTS AS (SELECT s.student_id, s.student_name FROM Student s LEFT JOIN EXAM e on s.student_id = e.student_id
INNER JOIN MAX_MIN_SCORES mms on e.exam_id = mms.exam_id
WHERE (score=max or score=min )) 
SELECT * FROM Student where student_id not in (select student_id from edge_students) and 
student_id in (select distinct student_id from Exam);