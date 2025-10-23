SELECT word, SUM(count) as COUNT FROM (
select 'bull' word ,(CASE WHEN content like '% bull %' THEN 1 ELSE 0 END) count
from Files 
union all
select 'bear' word ,CASE WHEN content like '% bear %' THEN 1 ELSE 0 END as  count
from Files 
) src GROUP BY word