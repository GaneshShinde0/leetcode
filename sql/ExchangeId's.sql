/* Write your T-SQL query statement below */
SELECT 
IIF(id%2=0,id-1,IIF(id+1 not in (select id from seat),id,id+1)) as id, student FROM Seat 
ORDER BY id asc
