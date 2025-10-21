/* Write your T-SQL query statement below */

SELECT round(avg(n.Num*1.0),1) median
FROM NUMBERS n 
WHERE n.Frequency >= ABS((SELECT SUM(Frequency) From Numbers Where num<=n.num)
                        -(SELECT SUM(Frequency) FROM Numbers WHERE num>=n.num)
                        )