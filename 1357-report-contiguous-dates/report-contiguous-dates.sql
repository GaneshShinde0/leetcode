/* Write your T-SQL query statement below */
WITH all_states as (
SELECT 'failed' as period_state, fail_date as dates 
FROM Failed
UNION ALL
SELECT 'succeeded' as period_state, success_Date as dates
FROM Succeeded
)

SELECT period_state, MIN(dates) as start_date, MAX(dates) as end_date
FROM (
    SELECT *, DATEADD(DAY,-1*ROW_NUMBER() OVER (PARTITION BY PERIOD_STATE ORDER BY dates asc), dates) as grp
    FROM all_states
    WHERE dates BETWEEN '2019-01-01' AND '2019-12-31'
) SRC
GROUP BY period_state, grp
ORDER by start_date ASC