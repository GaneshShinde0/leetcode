/* Write your T-SQL query statement below 
SELECT distinct city from Listings where (SELECT SUM(price)/count(1) as nat FROM Listings)
< (SELECT sum(price)/count(*) as avgPrice, city group by city) as avgPriceCity
ORDER By city ASC
*/

SELECT  city FROM Listings group by city
HAVING  sum(price)/count(*)>(SELECT SUM(price)/count(1) as nat FROM Listings)
ORDER BY city asc

/*
-- Method 1
-- SELECT city
-- FROM Listings
-- GROUP BY city
-- HAVING AVG(price) > (SELECT AVG(price) FROM Listings)
-- ORDER BY city
 


-- Method 2
WITH NationalAverage
AS (
    SELECT AVG(price) AS national_average
    FROM Listings
),

CityAverage 
AS (
    SELECT city, AVG(price) as city_average
    FROM Listings
    GROUP BY city
)

SELECT city
FROM CityAverage
JOIN NationalAverage 
ON TRUE
WHERE city_average > national_average
ORDER BY city
*/

/*
WITH expense_window AS (
    SELECT DISTINCT city
    , AVG(price) OVER (PARTITION BY city) AS city_average
    , AVG(price) OVER () AS national_average
    FROM Listings
)

SELECT city
FROM expense_window
WHERE city_average > national_average
ORDER BY city ASC
*/