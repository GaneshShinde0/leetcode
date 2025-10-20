/* Write your T-SQL query statement below */

SELECT product_id, price*(1-COALESCE(discount,0)/100.0) as final_price, p.category FROM
Products p LEFT JOIN Discounts d on p.category = d.category 
