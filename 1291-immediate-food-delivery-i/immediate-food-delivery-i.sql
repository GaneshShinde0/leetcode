/* Write your T-SQL query statement below */
SELECT 100*ROUND((SELECT COUNT(*) FROM Delivery WHERE order_date = customer_pref_delivery_date)
/(SELECT count(*)*1.0 from delivery),4) as immediate_percentage
