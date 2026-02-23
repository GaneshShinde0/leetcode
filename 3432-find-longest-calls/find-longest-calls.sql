/* Write your T-SQL query statement below */
WITH CTE AS(
    SELECT contact_id, type, duration, RANK() OVER(PARTITION BY TYPE ORDER BY DURATION DESC) AS RNK FROM CALLS
), 
D AS ( 
    SELECT contact_id, type, RIGHT('0'+CAST(C.Duration/3600 as varchar(2)),2)+':'+
    RIGHT('0'+CAST((C.duration%3600)/60 AS VARCHAR(2)),2) +':'+
    RIGHT('0'+CAST(C.duration%60 AS VARCHAR(2)),2) AS duration_formatted 
    from CTE c
    JOIN Contacts cont on cont.id = c.contact_id
    WHERE rnk<=3
)
SELECT cont.first_name, D.type, D.duration_formatted
FROM D
JOIN Contacts cont on cont.id = D.contact_id
ORDER By type desc, duration_formatted desc, first_name