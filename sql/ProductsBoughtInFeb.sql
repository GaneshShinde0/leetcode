/* Write your T-SQL query statement below */
/*
SELECT product_name,sum(unit) as unit from products pd left join Orders od on pd.product_id=od.product_id where order_date BETWEEN '2020-02-01' AND '2020-02-29' GROUP BY product_name having sum(unit)>=100
*/
select a.product_name ,sum(b.unit) as unit
from products a 
left join 
orders b on a.product_id=b.product_id
where b.order_date like '%2020-02-%' 
group by a.product_name
having sum(b.unit)>=100

/*
SELECT 
    a.product_name,
    SUM(b.unit) AS unit
FROM 
    products a
LEFT JOIN 
    orders b ON a.product_id = b.product_id
WHERE 
    YEAR(b.order_date) = 2020 
    AND MONTH(b.order_date) = 2
GROUP BY 
    a.product_name
HAVING 
    SUM(b.unit) >= 100;
*/
