/* Write your T-SQL query statement below */
select min(A.log_id) as "start_id" , max(A.log_id) as "end_id"
from
	(
		select log_id , ROW_NUMBER() OVER (order by log_id) as "rn"
		from Logs
	) A
group by (log_id-rn)