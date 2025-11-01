/* Write your T-SQL query statement below */


with calcul as(
SELECT book_id, 
        MAX(session_rating) may, MIN(session_rating) men ,
        SUM(CASE WHEN session_rating <=2 then 1 else 0 end) as pmin,
        SUM(CASE WHEN session_rating >=4 then 1 else 0 end )as pmax,
        COUNT(*) tot
from reading_sessions
group by book_id
)

SELECT b.book_id,b.title,b.author,b.genre,b.pages,
        c.may-c.men as rating_spread,
        ROUND(( c.pmin + c.pmax *1.00 ) / tot,2) as polarization_score 
from books b 
join calcul c 
on c.book_id = b.book_id
where ROUND(( c.pmin + c.pmax *1.00) / tot,2) >= 0.6
        AND c.tot >=5
        AND  c.pmin>0 AND c.pmax>0 

order by ( c.pmin + c.pmax *1.00 ) / tot desc, b.title desc
        