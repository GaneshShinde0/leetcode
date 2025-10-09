/* Write your T-SQL query statement below */
select format(order_date, 'yyyy-MM') as month, count(distinct order_id) as order_count , count(distinct customer_id) as customer_count  from Orders
where invoice > 20
group by format(order_date, 'yyyy-MM')