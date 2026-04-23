/* Write your T-SQL query statement below */
WITH MONTHS as (
    SELECT 1 as month 
    UNION ALL
    SELECT MONTH+1 FROM MONTHS WHERE MONTH<12
)
SELECT month , COUNT(distinct d.driver_id) as active_drivers, COUNT(distinct a.ride_id) as accepted_rides FROM MONTHS m left join Drivers d on (MONTH(d.join_date) <= m.MONTH AND YEAR(join_date)=2020) OR YEAR(JOIN_DATE)<2020 
left Join Rides r on (MONTH(r.requested_at ) = m.MONTH AND YEAR(r.requested_at )=2020)
left join AcceptedRides a on r.ride_id = a.ride_id  
GROUP BY m.MONTH 