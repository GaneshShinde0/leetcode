/* Write your T-SQL query statement below */

SELECT DISTINCT t1.N, 
CASE 
    WHEN T1.P IS NULL THEN 'Root'
    WHEN T2.N IS NULL THEN 'Leaf'
    ELSE 'Inner' end as Type
  FROM Tree t1 left join Tree t2 on T1.N=t2.P
  ORDER By t1.N asc