/* Write your T-SQL query statement below */
SELECT DISTINCT o1.product_id from Orders o1 inner join Orders o2 on o1.product_id = o2.product_id and YEAR(o1.purchase_date)+1=YEAR(o2.purchase_date)
GROUP BY o1.PRODUCT_ID, YEAR(o1.purchase_date)
HAVING COUNT(DISTINCT o1.order_id)>=3 and COUNT(DISTINCT o2.order_id)>=3
ORDER BY o1.product_id
