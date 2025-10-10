SELECT u.user_id,u.name,COALESCE(sum(distance),0) as [traveled distance]
FROM Users u left join Rides r 
on u.user_id = r.user_id
GROUP BY u.user_id, u.name
ORDER by u.user_id asc