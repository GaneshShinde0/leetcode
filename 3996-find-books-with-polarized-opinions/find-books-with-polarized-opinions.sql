/* Write your T-SQL query statement below */
with cte as(
select
book_id
, SUM(case when session_rating >= 4 then 1 else 0 end) as good_ratings
, SUM(case when session_rating  <=2 then 1 else 0 end) as bad_ratings
, MAX(session_rating) as highest_rating
, MIN(session_rating) as lowest_rating
, COUNT(*) as total_sessions
from reading_sessions
group by book_id
having count(*) >= 5
)
, cte2 as(
select
b.*
, highest_rating - lowest_rating as rating_spread
, ROUND((good_ratings + bad_ratings) / cast(total_sessions as float), 2) as polarization_score
from cte
JOIN books as b
ON cte.book_id = b.book_id
where cte.good_ratings >= 1 and cte.bad_ratings >= 1
)

select *
from cte2
where polarization_score >= 0.6
order by polarization_score desc, title desc