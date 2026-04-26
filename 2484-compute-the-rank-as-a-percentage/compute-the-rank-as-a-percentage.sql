/* Write your T-SQL query statement below */

SELECT student_id,
    department_id,
    ISNULL(ROUND((drnk - 1)*100.0/NULLIF(cnt - 1, 0), 2), 0) AS percentage
FROM (SELECT *, RANK() OVER(PARTITION BY department_id ORDER BY mark DESC) AS drnk, COUNT(*) OVER(PARTITION BY department_id) AS cnt FROM Students) AS S;