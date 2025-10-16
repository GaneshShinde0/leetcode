/* Write your T-SQL query statement below */
SELECT a.symbol as metal, b.symbol as nonmetal from Elements a, Elements b where a.type='metal' and b.type = 'nonmetal' 