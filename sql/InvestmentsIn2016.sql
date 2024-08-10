/* Write your T-SQL query statement below */
/*SELECT SUM(tiv_2016) from Insurance where pid in (select pid from (Select pid, count(tiv_2015) counts from Insurance where count(tiv_2015)>1) src) GROUP BY */
SELECT 
    ROUND(SUM(tiv_2016), 2) AS tiv_2016 
FROM 
    Insurance 
WHERE 
    tiv_2015 IN (
        SELECT tiv_2015 
        FROM Insurance 
        GROUP BY tiv_2015 
        HAVING COUNT(tiv_2015) > 1
    ) 
    AND CONCAT(lat, lon) NOT IN (
        SELECT CONCAT(lat, lon) 
        FROM Insurance 
        GROUP BY lat, lon 
        HAVING COUNT(CONCAT(lat, lon)) > 1
    );
