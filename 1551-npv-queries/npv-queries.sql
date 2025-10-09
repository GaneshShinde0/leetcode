/* Write your T-SQL query statement below */
SELECT q.id, q.year,ISNULL(n.npv,0) as npv from queries q left join npv n on q.id=n.id and q.year=n.year