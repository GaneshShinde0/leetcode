/* Write your T-SQL query statement below */

select 
    age_bucket, 
    round(100 * sum(iif(activity_type = 'send', time_spent, 0)) / sum(time_spent), 2) as send_perc, 
    round(100 * sum(iif(activity_type = 'open', time_spent, 0)) / sum(time_spent), 2) as open_perc 
from activities as a
join age as a1
on a.user_id = a1.user_id
group by age_bucket