/* Write your T-SQL query statement below */
-- This question is basically asking to take median salary for each company... If it had odd count of number of people then return 1, if It has even then return 2 rows.

SELECT id, company, salary FROM (SELECT id,company,salary , 
rank() over(partition by company order by salary asc, ID ASC) as RN_ASC,
rank() OVER(PARTITION BY company ORDER BY salary DESC, ID DESC) as RN_DSC
FROM Employee) e 
WHERE abs(RN_ASC-RN_DSC) BETWEEN 0 AND 1