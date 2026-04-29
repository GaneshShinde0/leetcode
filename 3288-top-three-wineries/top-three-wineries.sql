with t1 as (
    select country, sum(points) as points, winery
    from Wineries
    group by country, winery
), t2 as (
    select country, concat(winery, ' (', points,')') as 'winery', 
        dense_rank() over(partition by country order by points desc, winery asc) as "rk"
    from t1
)

select country,
    max(case when rk=1 then winery else NULL end) as 'top_winery',
    coalesce(max(case when rk=2 then winery else NULL end),'No second winery') as 'second_winery',
    coalesce(max(case when rk=3 then winery else NULL end),'No third winery') as 'third_winery'
from t2
group by country
