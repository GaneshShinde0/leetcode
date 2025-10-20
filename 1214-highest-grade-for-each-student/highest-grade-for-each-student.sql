/* Write your T-SQL query statement below */
WITH CTE AS (SELECT student_id,course_id, MAX(GRADE) over(PARTITION BY student_id) as grade, rank() OVER (PARTITION BY student_id order by grade desc, course_id asc) rank FROM Enrollments)
SELECT student_id,course_id,grade FROM CTE WHERE rank = 1;