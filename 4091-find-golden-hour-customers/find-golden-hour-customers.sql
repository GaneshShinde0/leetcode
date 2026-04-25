select customer_id, total_orders,
(round((peak_orders*1.0/total_orders)*100,0)) peak_hour_percentage, average_rating
from (select customer_id, count(*) total_orders, 
round(avg(order_rating * 1.00),2) average_rating, count(order_rating) orderratingcount,
sum(case 
        when (datepart(hour, order_timestamp) between 11 and 13)
        or (datepart(hour, order_timestamp) between 18 and 20)
        then 1 
        else 0 
    end) as peak_orders from restaurant_orders
group by customer_id having count(*) >=3 and round(avg(order_rating * 1.00),2) >= 4.0)
t where (((orderratingcount*1.00)/total_orders)*100) >=50 and (round((peak_orders*1.0/total_orders)*100,0))>=60 order by average_rating desc, customer_id desc


