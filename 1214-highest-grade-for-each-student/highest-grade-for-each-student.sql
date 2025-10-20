-- /* Write your T-SQL query statement below */
-- WITH CTE AS (SELECT student_id,course_id, MAX(GRADE) over(PARTITION BY student_id) as grade, rank() OVER (PARTITION BY student_id order by grade desc, course_id asc) rank FROM Enrollments)
-- SELECT student_id,course_id,grade FROM CTE WHERE rank = 1;

/* Write your T-SQL query statement below */
with cte as (
select * , row_number() over (partition by student_id order by  grade desc , course_id   ) ranked
from Enrollments as e
)
select student_id , course_id  , grade
from cte
where ranked=1