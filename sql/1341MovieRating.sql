/* Write your T-SQL query statement below */
SELECT results from (
SELECT top 1 name as results,count(u.user_id) freq from Users u left join MovieRating mv on u.user_id = mv.user_id GROUP by u.user_id,u.name order by count(u.user_id) desc,name asc
UNION ALL
SELECT TOP 1 title as results, AVG(cast(rating as float)) freq from Movies m left join MovieRating mv on m.movie_id=mv.movie_id where mv.created_at like '2020-02%' GROUP by m.movie_id,m.title order by AVG(cast(rating as float))  desc,title asc
) src 
