/* Write your T-SQL query statement below */
SELECT order_date, ROUND(SUM(CASE WHEN customer_pref_delivery_date = order_date  THEN 1 ELSE 0 END)*100.0/COUNT(*),2) as immediate_percentage
FROM Delivery
GROUP BY Order_Date
ORDER BY ORDER_DATE ASC