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
SELECT 'Senior' as experience , COUNT(*) as accepted_candidates FROM CUM_SENIOR_SAL WHERE CumulativeSalary<=70000
UNION ALL
SELECT 'Junior', COUNT(*) as accepted_candidates FROM CUM_JUNIOR_SAL WHERE CumulativeSalary<=(70000-(SELECT COALESCE(Max(CumulativeSalary),0) FROM CUM_SENIOR_SAL 
WHERE CumulativeSalary<=70000
 ))