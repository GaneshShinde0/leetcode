SELECT 
    candidate_id 
FROM 
    Candidates 
WHERE 
    skill = 'Python'
INTERSECT
SELECT 
    candidate_id
FROM 
    Candidates 
WHERE 
    skill = 'Tableau'
INTERSECT
SELECT 
    candidate_id
FROM 
    Candidates 
WHERE 
    skill = 'PostgreSQL'
