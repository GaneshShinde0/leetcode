Select name as Employee from Employee e1 where 
salary > (select salary from Employee where id=e1.managerId)

# Write your MySQL query statement below
select email
from person 
group by email
having count(email)>1
