/* Write your T-SQL query statement below */
SELECT s1.gender, s1.day, sum(s2.score_points) as total
FROM scores s1, scores s2 
WHERE s1.gender = s2.gender and s1.day>=s2.day 
GROUP by s1.gender, s1.day
ORDER BY gender, day