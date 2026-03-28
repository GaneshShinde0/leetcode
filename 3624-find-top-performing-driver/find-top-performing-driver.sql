SELECT fuel_type, driver_id, rating, distance FROM (SELECT fuel_type, d.driver_id,ROUND(AVG(1.0*rating),2) as rating, SUM(distance)  as distance, accidents, RANK() OVER(PARTITION BY fuel_type ORDER BY ROUND(AVG(1.0*rating),2) desc, SUM(distance) desc, accidents asc) as rnk
FROM Drivers d join Vehicles v on d.driver_id = v.driver_id
join Trips t on t.vehicle_id = v.vehicle_id
GROUP BY fuel_type, d.driver_id, accidents
) src WHERE RNK = 1
ORDER BY 1 ASC