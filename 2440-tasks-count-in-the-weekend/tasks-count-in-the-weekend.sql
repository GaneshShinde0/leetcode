/* Write your T-SQL query statement below */
-- SELECT count(*) as weekend_cnt, (SELECT COUNT(*) FROM TASKS)-COUNT(*) as working_cnt FROM Tasks WHERE DATENAME(WEEKDAY,submit_date) IN ('Saturday','Sunday')

select sum(case when wkdy=7 or wkdy=1 then 1 else 0 end) as weekend_cnt, sum(case when wkdy=7 or wkdy=1 then 0 else 1 end) as working_cnt 
from (
select *, DATEPART(weekday, submit_date) as wkdy
from Tasks 
) a