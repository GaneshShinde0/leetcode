/* Write your T-SQL query statement below */
SELECT distinct buyer_id from Sales s left join product p on s.product_id = p.product_id 
where  p.product_name = 'S8' and buyer_id not in(SELECT buyer_id from Sales s left join product p on s.product_id = p.product_id 
where p.product_name = 'iPhone')
