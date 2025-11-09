/* Write your T-SQL query statement below */
SELECT c.candidate_id from Candidates c right join Rounds r on c.interview_id=r.interview_id
where c.years_of_exp>=2
GROUP by c.candidate_id
HAVING sum(score)>15 