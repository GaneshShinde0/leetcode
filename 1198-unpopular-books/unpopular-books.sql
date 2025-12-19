/* Write your T-SQL query statement below */
/* Write your T-SQL query statement below */



--Get all available
SELECT b.book_id,b.name
FROM Books b
WHERE  b.available_from <= '2019-05-23'

EXCEPT

--EXCLUDE the ones that have quantity more than 10 
SELECT b.book_id,b.name
FROM Books b
inner JOIN Orders o
ON b.book_id = o.book_id
WHERE o.dispatch_date between '2018-06-23' AND '2019-06-23'     
GROUP BY b.book_id,b.name
HAVING SUM(o.quantity)>=10