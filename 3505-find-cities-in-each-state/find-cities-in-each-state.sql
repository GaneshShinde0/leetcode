/* Write your T-SQL query statement below */
SELECT State, STRING_AGG(city,', ') WITHIN GROUP (ORDER BY city) as cities
FROM cities
GROUP BY State
ORDER BY State