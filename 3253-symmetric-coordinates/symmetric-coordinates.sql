/* Write your T-SQL query statement below */

WITH CTE AS(SELECT X,Y from Coordinates WHERE X<>Y GROUP BY X,Y 
UNION ALL 
SELECT y, x from Coordinates WHERE X<>Y GROUP BY X,Y 
UNION ALL
SELECT x,y FROM Coordinates WHERE X=y
)
SELECT X, Y FROM CTE GROUP BY X,Y HAVING COUNT(*)>=2 AND X<=Y
ORDER BY X ASC, Y ASC