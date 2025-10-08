/* Write your T-SQL query statement below */

Select s1.student_name as member_A,
s2.student_name as member_B,
s3.student_name as member_C
from SchoolA s1, schoolb s2, schoolc s3 
where 
s1.student_id<>s2.student_id AND
s1.student_id<>s3.student_id AND
s2.student_id<>s3.student_id AND

s1.student_name<>s2.student_name AND
s1.student_name<>s3.student_name AND
s2.student_name<>s3.student_name 