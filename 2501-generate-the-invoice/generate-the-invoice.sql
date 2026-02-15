WITH CTE as (SELECT TOP 1 invoice_id,SUM(quantity*price) as Total FROM Products pr right join Purchases p on pr.product_id=p.product_id GROUP BY invoice_id ORDER BY SUM(quantity*price) DESC, invoice_id asc)
SELECT p.product_id, quantity, quantity*price as price from Purchases p left join Products pr on p.product_id=pr.product_id
WHERE invoice_id in (select invoice_id from CTE)