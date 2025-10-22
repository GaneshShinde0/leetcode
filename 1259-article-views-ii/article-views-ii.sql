# Write your MySQL query statement below

SELECT DISTINCT viewer_id as id FROM Views 
GROUP BY viewer_id,view_date
HAVING COUNT(Distinct article_id,author_id,view_date) >1