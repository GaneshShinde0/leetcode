/* Write your T-SQL query statement below */
WITH r_cte as (
    SELECT 1 ids, MAX(customer_id) as maxId from Customers
    UNION all
    SELECT ids+1, maxId FROM r_cte where ids<maxId
)
SELECT ids FROM r_cte rc left join Customers c on rc.ids = c.customer_id
WHERE c.customer_id is null