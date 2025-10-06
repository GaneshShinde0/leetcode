/* Write your T-SQL query statement below 
SELECT distinct city from Listings where (SELECT SUM(price)/count(1) as nat FROM Listings)
< (SELECT sum(price)/count(*) as avgPrice, city group by city) as avgPriceCity
ORDER By city ASC
*/

SELECT  city FROM Listings group by city
HAVING  sum(price)/count(*)>(SELECT SUM(price)/count(1) as nat FROM Listings)
ORDER BY city asc