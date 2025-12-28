/* Write your T-SQL query statement below */
-- SELECT first_col, second_col FROM (
SELECT first_col, second_col FROM 
(select first_col, ROW_NUMBER() OVER (ORDER BY FIRST_COL ASC) as rn1 FROM Data ) as d1
LEFT JOIN 
(SELECT second_col, ROW_NUMBER() OVER (ORDER BY second_col DESC) as rn2 from dATA ) as d2
on d1.rn1=d2.rn2
