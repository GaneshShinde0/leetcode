/* Write your T-SQL query statement below */
Select left_operand, operator, right_operand,
CASE WHEN Operator = '<' AND v1.value < v2.value THEN 'true'
WHEN Operator = '>' AND v1.value > v2.value THEN 'true'
When Operator = '=' AND v1.value = v2.value THEN 'true'
ELSE 'false' END AS Value
from Expressions e
inner join Variables v1 on e.left_operand = v1.name
inner join Variables v2 on e.right_operand = v2.name