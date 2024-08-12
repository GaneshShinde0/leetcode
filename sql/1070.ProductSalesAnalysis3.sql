/* Write your T-SQL query statement below */

-- If we use aggregate functions with other columns than group by we can use them in our result
SELECT distinct s.product_id,s.year as first_year,s.quantity, s.price from Sales s right join (SELECT min(year) year,min(sale_id) sale_id,product_id from sales GROUP BY product_id) src on s.year =src.year and s.product_id =src.product_id

-- Using CTE
with cte as (
select product_id,year as first_year,quantity,price,
rank() over(partition by product_id order by year) as rn
from Sales )

select product_id,first_year,quantity,price
from cte where rn=1
