
/*
SELECT DISTINCT a.* FROM Stadium as A, Stadium as b, Stadium as C Where a.people>=100 AND b.people>=100 and c.people>=100
AND (
    (a.id-b.id=1 and b.id-c.id=1)
    OR (c.id - b.id = 1 AND b.id - a.id = 1)
    OR (b.id - a.id = 1 AND a.id - c.id = 1)
    )
ORDER BY a.visit_date
*/
/*
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

*/

/*
Approach 3: Finding the Islands
Algorithm
The key to identifying the islands (consecutive values) from a column is to calculate the difference between the column (in this problem, it is the column id) and a new rank (looks like an index id) we append to all rows. Any islands will be the rows that share the same result from this calculation. If all ids are consecutive, the differences between this new rank and the id will be the same for all rows, in other words, all rows belong to this one island. If no ids are consecutive, every row will return a different value from this calculation, and no island is identified.
For this problem, we want to identify the islands (consecutive values) from all the records. To do this, we need to create a new rank for all the qualified records, which are the records of people greater than or equal to 100. Either RANK() or ROW_NUMBER() works for this purpose.
*/

WITH stadium_with_rnk as(
    SELECT id, visit_date, people, rnk, (id-rnk) as island FROM (SELECT id, visit_date, people, RANK() OVER(ORDER BY id) as RNK FROM Stadium WHERE People>=100) as src
)
SELECT id, visit_date, people FROM stadium_with_rnk WHERE island IN ( SELECT island FROM stadium_with_rnk GROUP BY island HAVING(COUNT(*))>=3)
ORDER BY visit_date