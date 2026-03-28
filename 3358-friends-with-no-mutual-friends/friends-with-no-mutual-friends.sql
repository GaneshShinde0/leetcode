/* Write your T-SQL query statement below */
WITH CTE AS(
    SELECT user_id1, user_id2 FROM Friends
    UNION
    SELECT user_id2, user_id1 FROM Friends
)

SELECT fr.user_id1, fr.user_id2 FROM Friends fr
JOIN CTE cte1 on fr.user_id1 = cte1.user_id1
LEFT JOIN CTE cte2 on fr.user_id2 = cte2.user_id1 AND cte1.user_id2=cte2.user_id2
GROUP BY fr.user_id1, fr.user_id2
HAVING count(cte2.user_id2)=0
ORDER BY  fr.user_id1, fr.user_id2 ASC