WITH MandatoryCourses As(
    SELECT c.course_id, c.major
    FROM Courses c
    WHERE c.mandatory = 'Yes'
),
ElectiveCourses as (
    SELECT c.course_id, c.major
    FROM Courses c
    WHERE c.mandatory = 'No'
),
StudentMandatory as (
    SELECT e.student_id, s.major
    FROM enrollments e
    JOIN MandatoryCourses m  on e.course_id = m.course_id
    JOIN students s ON e.student_id = s.student_id AND s.major = m.major
    WHERE e.grade = 'A'
    GROUP BY e.student_id, s.major
    HAVING COUNT(DISTINCT e.course_id ) = (SELECT COUNT(*) FROM MandatoryCourses WHERE major = s.major)
),
StudentElective AS (
    SELECT e.student_id, s.major
    FROM enrollments e
    JOIN ElectiveCourses ec ON e.course_id = ec.course_id
    JOIN students s ON e.student_id = s.student_id AND s.major = ec.major
    WHERE e.grade IN ('A', 'B')
    GROUP BY e.student_id, s.major
    HAVING COUNT(DISTINCT e.course_id) >= 2
),
AverageGPA AS (
    SELECT e.student_id, AVG(e.GPA) as avg_gpa
    FROM enrollments e
    GROUP BY e.student_id
    HAVING avg(e.GPA)>=2.5
)
SELECT DISTINCT sm.student_id
FROM StudentMandatory sm
JOIN StudentElective se ON sm.student_id = se.student_id
JOIN AverageGPA ag on sm.student_id = ag.student_id
ORDER BY sm.student_id