/* Write your T-SQL query statement below */
/* Write your T-SQL query statement below */


with car_fees as(
select car_id ,sum(fee_paid) as total_fee_paid ,
round(sum(fee_paid)*1.00/sum(datediff(minute,entry_time,exit_time)*1.00 /60),2) as avg_hourly_fee 
from ParkingTransactions 
group by car_id )



,lot_ranking as(
select car_id,lot_id ,row_number() over (partition by car_id order by  sum(datediff(minute,entry_time,exit_time)*1.00 /60) desc ) as rn 
from ParkingTransactions
group by car_id ,lot_id ) 



select cf.car_id ,cf.total_fee_paid ,cf.avg_hourly_fee,lr.lot_id as most_time_lot 
from lot_ranking lr inner join car_fees cf 
on cf.car_id =lr.car_id 
where rn=1