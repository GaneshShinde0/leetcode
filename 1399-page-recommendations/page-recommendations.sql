/* Write your T-SQL query statement below */
SELECT DISTINCT recommended_page FROM (
SELECT page_id as recommended_page from Likes l join Friendship f on l.user_id = f.user2_id and f.user1_id = 1 
UNION ALL
SELECT page_id as recommended_page from Likes l join Friendship f on l.user_id = f.user1_id and f.user2_id = 1 
) SRC WHERE recommended_page not IN (SELECT page_id from Likes where user_id=1)