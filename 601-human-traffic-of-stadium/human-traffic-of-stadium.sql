
/*
SELECT DISTINCT a.* FROM Stadium as A, Stadium as b, Stadium as C Where a.people>=100 AND b.people>=100 and c.people>=100
AND (
    (a.id-b.id=1 and b.id-c.id=1)
    OR (c.id - b.id = 1 AND b.id - a.id = 1)
    OR (b.id - a.id = 1 AND a.id - c.id = 1)
    )
ORDER BY a.visit_date
*/

WITH BASE AS(
    SELECT *,
        LEAD(id,1) OVER(ORDER BY id) as next_id,
        LEAD(id,2) OVER(ORDER BY id) as second_next_id,
        LAG(id,1) OVER(order BY id) as last_id,
        LAG(id,2) OVER(ORDER BY id) as second_last_id
    FROM stadium
    WHERE people>=100
)
SELECT DISTINCT id, visit_date, people FROM BASE
WHERE (next_id-id=1 AND id-last_id =1)
OR second_next_id-next_id=1 AND next_id- id =1
OR id-last_id = 1 AND last_id - second_last_id = 1
ORDER BY visit_date