/* Write your T-SQL query statement below */
SELECT dept_name, count(student_id) as student_number from Department d left join Student s on d.dept_id = s.dept_id 
GROUP by dept_name ORDER BY count(student_id) desc,dept_name asc