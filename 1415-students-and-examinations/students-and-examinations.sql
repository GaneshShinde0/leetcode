/* Write your T-SQL query statement below */
SELECT st.student_id, st.student_name, sub.subject_name, COUNT(e.subject_name) as attended_exams
FROM Students st cross JOIN Subjects sub left join Examinations e on st.student_id = e.student_id and e.subject_name = sub.subject_name
GROUP BY  st.student_id, st.student_name, sub.subject_name
ORDER BY st.student_id, sub.subject_name