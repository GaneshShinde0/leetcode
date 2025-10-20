/* Write your T-SQL query statement below */
SELECT * FROM (
SELECT e1.employee_id, 
    SUM(CASE WHEN e1.end_time>e2.start_time AND e1.start_time <e2.start_time THEN 1 ELSE 0 END) as overlapping_shifts 
FROM EmployeeShifts e1 left join EmployeeShifts e2 on e1.employee_id=e2.employee_id and e1.start_time<> e2.start_time 
GROUP BY e1.employee_id
) SRC WHERE overlapping_shifts !=0;