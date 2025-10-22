WITH CTE AS (SELECT ad_id,user_id, CASE WHEN ACTION='Clicked' THEN 1.0 ELSE 0.0 END as clickCount, CASE WHEN ACTION = 'Viewed' THEN 1.0 ELSE 0.0 END AS viewCount FROM Ads) 
SELECT a.ad_id, ROUND(100*SUM(clickCount)/IIF(SUM(clickCount+viewCount)=0.0,1,SUM(clickCount+viewCount)),2) as ctr FROM Ads a left join CTE on a.ad_id = cte.ad_id
 GROUP BY a.ad_id ORDER BY ROUND(100*SUM(clickCount)/IIF(SUM(clickCount+viewCount)=0.0,1,SUM(clickCount+viewCount)),2) DESC, a.Ad_id asc

