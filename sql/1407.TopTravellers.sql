/* Write your T-SQL query statement below */
/*
SELECT usr.name, sum(ISNULL(distance,0)) as travelled_distance from Users usr left join Rides rd on usr.id=rd.user_id GROUP BY name order by sum(ISNULL(distance,0)) desc
*/
/* Write your T-SQL query statement below */
SELECT max(usr.name) as name, SUM(ISNULL(distance,0)) as travelled_distance from Users usr left join Rides rd on usr.id=rd.user_id GROUP BY user_id order by SUM(ISNULL(distance,0)) desc,name asc
