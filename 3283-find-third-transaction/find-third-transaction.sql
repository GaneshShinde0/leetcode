
with cte as (
select *, rnk= rank() over(partition by user_id order by transaction_date) from Transactions
)
select distinct c.user_id ,c.spend third_transaction_spend ,c.transaction_date third_transaction_date 
from cte c
  join cte c2 on c.rnk-1=c2.rnk and c.user_id=c2.user_id
 join cte c3 on c.rnk-2=c3.rnk and c.user_id =c3.user_id
where c.spend>c2.spend and c.spend>c3.spend and
c.rnk=3
order by c.user_id
