SELECT contest_id,ROUND(CAST(count(user_id)*100 as FLOAT)/(select count(*) from users),2) as percentage from Register GROUP BY contest_id order by percentage desc, contest_id asc
