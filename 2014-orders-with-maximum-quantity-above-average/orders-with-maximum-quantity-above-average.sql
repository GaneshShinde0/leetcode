-- /* Write your T-SQL query statement below */
-- SELECT DISTINCT od.order_id from OrdersDetails od left join (SELECT order_id , AVG(quantity*1.0) as average,MAX(quantity) as max FROM OrdersDetails GROUP by order_id) src on od.order_id = src.order_id WHERE src.max>(SELECT max(average) FROM (SELECT order_id , AVG(quantity*1.0) as average,MAX(quantity) as max FROM OrdersDetails GROUP by order_id) src )--(SELECT AVG(quantity*1.0) as average from OrdersDetails);

/* Write your T-SQL query statement below */


select order_id
from OrdersDetails 
group by  order_id 
having max(quantity) > all(
select avg(quantity*1.0)
from OrdersDetails  
group by  order_id ) 