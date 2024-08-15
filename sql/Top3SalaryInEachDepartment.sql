SELECT DEPT.name AS Department, EMP.name AS Employee, EMP.salary 

AS Salary FROM Department DEPT JOIN Employee EMP ON 

EMP.DepartmentId=DEPT.id WHERE 3 > (SELECT COUNT(DISTINCT EMP1.salary)
 
FROM Employee EMP1 WHERE EMP1.salary > EMP.salary AND 

EMP.departmentId = EMP1.departmentId)
