/* Write your T-SQL query statement below */
Select company_id, 
       employee_id, 
       employee_name, 
       Round((Case 
            When Max(Salary) Over(Partition by company_id) < 1000
            Then salary
            When Max(Salary) Over(Partition by company_id) >= 1000
            And  Max(Salary) Over(Partition by company_id) <= 10000
            Then Salary - (24.0 / 100) * salary
            Else Salary - (49.0 / 100) * salary
            End
         ), 0) As salary
From Salaries