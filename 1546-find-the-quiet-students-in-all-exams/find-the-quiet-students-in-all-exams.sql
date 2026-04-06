/* Write your T-SQL query statement below */
WITH MAX_MIN_SCORES AS(
    SELECT exam_id, max(score) as max, min(score) as min  FROM Exam GROUP BY exam_id
),
EDGE_STUDENTS as (SELECT distinct s.student_id, s.student_name FROM Student s LEFT JOIN EXAM e on s.student_id = e.student_id
left JOIN MAX_MIN_SCORES mms on e.exam_id = mms.exam_id
WHERE (score=max or score=min ) or e.student_id is null)
SELECT * FROM Student WHERE student_id not in (SELECT student_id from EDGE_STUDENTS)