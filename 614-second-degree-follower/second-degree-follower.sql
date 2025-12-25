/* Write your T-SQL query statement below */
SELECT followee as follower, COUNT(*) as num from Follow 
WHERE followee in (SELECT DISTINCT follower from Follow)
GROUP BY followee
ORDER BY 1 ASC