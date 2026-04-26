/* Write your T-SQL query statement below */
WITH CTE AS (SELECT student_id, subject, score, exam_date, RANK() OVER(PARTITION BY student_id, subject ORDER BY exam_date asc) as rnk From Scores),
CTE2 AS (SELECT student_id, subject, MIN(rnk) as first, max(rnk) as last FROM CTE GROUP BY student_id, subject)
SELECT c1.student_id, c1.subject, c1.score as first_score, c2.score as latest_score FROM CTE c1 JOIn CTE C2 on c1.student_id = c2.student_id AND c1.subject = c2.subject 
JOIN CTE2 c3 on c1.student_id = c3.student_id AND c1.subject = c3.subject
WHERE c1.rnk = first and c2.rnk = last and c1.rnk!=c2.rnk and c1.score<c2.score