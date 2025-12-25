SELECT p1.id as p1, p2.id as p2, ABS(p1.x_value-p2.x_value)*ABS(p1.y_value-p2.y_value) as area
FROM Points p1 join Points p2
ON P1.x_value<>p2.x_value 
AND p1.y_value<>p2.y_value
AND p1.id<p2.id
ORDER BY 3 DESC, 1 ASC, 2 ASC