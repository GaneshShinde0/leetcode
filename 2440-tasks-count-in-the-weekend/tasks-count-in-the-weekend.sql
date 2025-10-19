/* Write your T-SQL query statement below */
SELECT count(*) as weekend_cnt, (SELECT COUNT(*) FROM TASKS)-COUNT(*) as working_cnt FROM Tasks WHERE DATENAME(WEEKDAY,submit_date) IN ('Saturday','Sunday')
