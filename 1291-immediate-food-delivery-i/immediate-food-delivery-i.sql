-- /* Write your T-SQL query statement below */
-- SELECT 100*ROUND((SELECT COUNT(*) FROM Delivery WHERE order_date = customer_pref_delivery_date)
-- /(SELECT count(*)*1.0 from delivery),4) as immediate_percentage
/* Write your T-SQL query statement below */


select 
    round(sum(case when order_date = customer_pref_delivery_date then 1.0 else 0 end) / count(*), 4) * 100 as immediate_percentage
from Delivery