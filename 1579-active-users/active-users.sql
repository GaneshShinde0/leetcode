WITH CTE as(
    SELECT l.id, a.name, login_date, dateadd(day, -dense_rank() OVER (PARTITION BY l.id ORDER BY login_date), login_date) as newdate FROM Logins l
    LEFT JOIN accounts a on a.id = l.id
)

SELECT distinct id, name FROM CTE
GROUP BY id, name, newdate
HAVING count(distinct login_Date)>=5
ORDER BY id