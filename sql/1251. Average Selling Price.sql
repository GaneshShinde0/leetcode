SELECT p.product_id, ISNULL(ROUND((cast(sum(price*units) as float)/sum(units)),2),0) as average_price from Prices  p left join UnitsSold u on (u.product_id=p.product_id  
AND u.purchase_date >= p.start_date
AND u.purchase_date <= p.end_date)
GROUP BY p.product_id
