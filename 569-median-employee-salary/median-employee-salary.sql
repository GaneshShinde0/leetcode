/* Write your T-SQL query statement below */
-- This question is basically asking to take median salary for each company... If it had odd count of number of people then return 1, if It has even then return 2 rows.

-- SELECT id, company, salary FROM (SELECT id,company,salary , 
-- rank() over(partition by company order by salary asc, ID ASC) as RN_ASC,
-- rank() OVER(PARTITION BY company ORDER BY salary DESC, ID DESC) as RN_DSC
-- FROM Employee) e 
-- WHERE abs(RN_ASC-RN_DSC) BETWEEN 0 AND 1

WITH RankedEmployees AS(
    SELECT e1.id, e1.company, e1.salary, (
        SELECT COUNT(*) FROM Employee e2 WHERE e2.company = e1.company AND (e2.salary<e1.salary OR (e2.salary = e1.salary AND e2.id<e1.id)))+1 as rnk FROM Employee e1
),
CompanyStats as (
    SELECT company, count(*) as total_employees, (COUNT(*)+1)/2 as median_rank FROM Employee GROUP BY Company
)
SELECT re.id, re.company, re.salary FROM RankedEmployees re
JOIN CompanyStats cs ON re.company = cs.company
WHERE re.rnk = cs.median_rank  OR (cs.total_employees%2=0 AND re.rnk = cs.median_rank+1)
-- ORDER BY re.company, re.salary;