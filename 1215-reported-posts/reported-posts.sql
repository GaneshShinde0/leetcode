/* Write your T-SQL query statement below */

SELECT extra as report_reason, COUNT(distinct post_id) as report_count from Actions WHERE Action_date = '2019-07-04' AND action='report'
GROUP by extra