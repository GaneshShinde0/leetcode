/* Write your T-SQL query statement below */
WITH CTE AS(
    SELECT power, concat(IIF(factor>0,'+','-'), IIF(POWER>1,CONCAT('',ABS(factor),'X^',power), IIF(POWER=1,CONCAT(ABS(Factor),'X'),cast(ABS(factor) as varchar)))) as t FROM terms
)
SELECT CONCAT(STRING_AGG(t, '') WITHIN GROUP (ORDER BY power DESC), '=0') AS equation
FROM CTE