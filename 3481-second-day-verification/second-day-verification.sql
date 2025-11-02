select user_id 
from emails a
join texts b
on a.email_id =b.email_id 
and
action_date between      signup_date and signup_date+1   
and signup_action='Verified'
order by 1