/* Write your T-SQL query statement below */
SELECT city_id, day, degree FROM (SELECT city_id, day, degree, RANK() OVER(PARTITION BY city_id ORDER BY degree desc, day asc) as rnk
FROM Weather)as src
WHERE rnk = 1