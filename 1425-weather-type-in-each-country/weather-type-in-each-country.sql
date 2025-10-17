/* Write your T-SQL query statement below */
select DISTINCT country_name, CASE WHEN weather_state<=15 THEN 'Cold'
                        WHEN weather_state>=25 THEN 'Hot'
                        ELSE 'Warm' END as weather_type
FROM (SELECT country_id, AVG(CAST(weather_state as FLOAT)) as weather_state FROM Weather w WHERE MONTH(w.day)='11' and YEAR(w.day)='2019' GROUP by country_id )  w left join countries c on w.country_id = c.country_id 
-- WHERE MONTH(w.day)='11' and YEAR(w.day)='2019'
ORDER BY 1 ASC