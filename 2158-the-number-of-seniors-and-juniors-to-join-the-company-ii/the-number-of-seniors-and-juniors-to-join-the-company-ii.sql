/* Write your T-SQL query statement below */
/* Write your T-SQL query statement below */
WITH CUM_SENIOR_SAL as (SELECT 
    employee_id, 
    experience, 
    SUM(salary) OVER (ORDER BY salary asc, employee_id asc) AS CumulativeSalary
FROM Candidates WHERE experience = 'Senior')
, CUM_JUNIOR_SAL as (SELECT 
    employee_id, 
    experience, 
    SUM(salary) OVER (ORDER BY salary asc, employee_id asc) AS CumulativeSalary
FROM Candidates WHERE experience = 'Junior')
SELECT employee_id FROM CUM_SENIOR_SAL WHERE CumulativeSalary<=70000
UNION ALL
SELECT employee_id FROM CUM_JUNIOR_SAL WHERE CumulativeSalary<=(70000-(SELECT COALESCE(Max(CumulativeSalary),0) FROM CUM_SENIOR_SAL 
WHERE CumulativeSalary<=70000
 ))