select b.team_name ,
case when  time_stamp <='45:00' then 1 else 2 end half_number ,
 sum(case when b.team_name =c.team_name then 1 else -1 end ) As dominance 
 from Passes 
 join Teams b
 on b.player_id  =pass_from 
 join Teams c
 on c.player_id  =pass_to 
 group by b.team_name ,
case when  time_stamp <='45:00' then 1 else 2 end 
 order by 1,2