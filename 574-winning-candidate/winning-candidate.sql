# Write your MySQL query statement below
WITH SRC AS (SELECT v.candidateId, COUNT(*) as count FROM Vote v left join Candidate c on c.id = v.candidateId GROUP BY v.candidateId)
SELECT name FROM Candidate c WHERE c.id in (SELECT candidateId FROM SRC WHERE count = (SELECT MAX(count) FROM src))
