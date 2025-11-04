-- /* Write your T-SQL query statement below */
-- select 'prime_eligible' as item_type, (SUM(ceiling(square_footage/100)*100)*SUM(square_footage)) as item_count FROM Inventory WHERE item_type = 'prime_eligible'
-- UNION ALL
-- select 'not_prime' as item_type, 500000- (SUM(ceiling(square_footage/100)*100)*SUM(square_footage)) as item_count FROM Inventory WHERE item_type = 'prime_eligible'

Select 'prime_eligible' item_type, floor(500000/sum(square_footage))*count(square_footage) item_count
from inventory
where item_type = 'prime_eligible'
UNION
Select 'not_prime', floor((500000 % (select sum(square_footage) from inventory where item_type = 'prime_eligible'))/sum(square_footage))*count(square_footage)
from inventory
where item_type = 'not_prime'