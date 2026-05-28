/* Write your T-SQL query statement below */
WITH INVALID as (
    SELECT log_id FROM logs CROSS APPLY STRING_SPLIT(IP, '.') GROUP BY log_id
    having count(*) <> 4
    OR SUM(CASE WHEN VALUE>255 OR VALUE LIKE '0%' then 1 else 0 END)>0
)
SELECT IP, COUNT(*) as invalid_count
FROM INVALID il, logs l
WHERE il.log_id = l.log_id
GROUP BY ip
ORDER BY invalid_count desc, ip desc