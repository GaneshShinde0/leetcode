/* Write your T-SQL query statement below */
select b.item_category as 'CATEGORY', sum(case when DATENAME(weekday,a.order_date) = 'MONDAY' then a.quantity else 0 end) as 'MONDAY',
sum(case when DATENAME(weekday, a.order_date) = 'TUESDAY' then a.quantity else 0 end) as 'TUESDAY',
sum(case when DATENAME(weekday, a.order_date) = 'WEDNESDAY' then a.quantity else 0 end) as 'WEDNESDAY',
sum(case when DATENAME(weekday, a.order_date) = 'THURSDAY' then a.quantity else 0 end) as 'THURSDAY',
sum(case when DATENAME(weekday, a.order_date) = 'FRIDAY' then a.quantity else 0 end) as 'FRIDAY',
sum(case when DATENAME(weekday, a.order_date) = 'SATURDAY' then a.quantity else 0 end) as 'SATURDAY',
sum(case when DATENAME(weekday, a.order_date) = 'SUNDAY' then a.quantity else 0 end) as 'SUNDAY'
from orders a right join items b on a.item_id = b.item_id
group by b.item_category
order by b.item_category