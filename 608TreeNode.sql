/* Write your T-SQL query statement below */
/*
SELECT id, 'Root' AS type
FROM tree
WHERE p_id IS NULL

UNION ALL

SELECT distinct p_id as id,'Inner' FROM tree t where p_id is not null and p_id not in (select id from tree where p_id is null)

UNION ALL

SELECT id, 'Leaf' AS type
FROM tree t
WHERE NOT EXISTS (
    SELECT 1
    FROM tree
    WHERE p_id = t.id
) and id not in (select id from tree where p_id is null);
*/

select distinct id, 
case
    when p_id is null then 'Root'
    when child_id is null then 'Leaf'
    else 'Inner'
end as type
from (
    select t1.id, t1.p_id, t2.id as child_id
    from tree t1
    left join tree t2
    on t1.id = t2.p_id) a
