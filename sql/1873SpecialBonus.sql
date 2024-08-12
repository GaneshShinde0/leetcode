SELECT employee_id, iif(employee_id%2=1,IIF(name not like 'M%',salary,0),0) bonus from Employees order by employee_id asc
