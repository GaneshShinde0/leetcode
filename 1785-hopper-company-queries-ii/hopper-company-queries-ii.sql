/* Write your T-SQL query statement below */
/* Write your T-SQL query statement below */
WITH MONTHS as (
    SELECT 1 as month 
    UNION ALL
    SELECT MONTH+1 FROM MONTHS WHERE MONTH<12
)
SELECT month , ROUND(IIF(COUNT(distinct d.driver_id)=0,0,(COUNT(distinct a.driver_id)*100.0/COUNT(distinct d.driver_id))),2) as working_percentage FROM MONTHS m left join Drivers d on (MONTH(d.join_date) <= m.MONTH AND YEAR(join_date)=2020) OR YEAR(JOIN_DATE)<2020 
left Join Rides r on (MONTH(r.requested_at ) = m.MONTH AND YEAR(r.requested_at )=2020)
left join AcceptedRides a on r.ride_id = a.ride_id  
GROUP BY m.MONTH 