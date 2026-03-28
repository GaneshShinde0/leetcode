-- Write your PostgreSQL query statement below
SELECT DISTINCT a.* FROM Stadium as A, Stadium as b, Stadium as C Where a.people>=100 AND b.people>=100 and c.people>=100
AND (
    (a.id-b.id=1 and b.id-c.id=1)
    OR (c.id - b.id = 1 AND b.id - a.id = 1)
    OR (b.id - a.id = 1 AND a.id - c.id = 1)
    )
ORDER BY a.visit_date
