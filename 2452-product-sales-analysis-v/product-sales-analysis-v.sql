/* Write your T-SQL query statement below */
SELECT user_id, sum(quantity*price) as spending from sales s left join product p on s.product_id=p.product_id GROUP by user_id
order by sum(quantity*price) DESC