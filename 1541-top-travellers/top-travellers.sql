/* Write your T-SQL query statement below */
SELECT name, travelled_distance from (SELECT u.id,u.name, COALESCE(sum(r.distance),0) as travelled_distance from Users u left JOIN Rides r on u.id = r.user_id 
GROUP by u.id,u.name)
SRC
 ORDER BY 2 DESC;