-- SELECT src.platform, src.Experiment_name, COUNT(experiment_id) as num_experiments FROM (SELECT DISTINCT a.platform,b.Experiment_name from Experiments  a, Experiments  b ) src left join Experiments e on 
-- e.platform = src.platform and e.experiment_name = src.experiment_name
-- GROUP BY src.platform, src.Experiment_name
-- ORDER BY  1 ASCa

WITH platform_type as (
    SELECT 'IOS' as platform 
    UNION ALL
    select 'Android' a
    UNION ALL
    select 'Web'
), experiment_type as (
    SELECT 'Programming' as experiment_name
    UNION all
    SELECT 'Sports'
    UNION all
    SELECT 'Reading'
), 
all_experiments as (
    SELECT platform, experiment_name
    FROM platform_type cross join experiment_type
)

SELECT ax.platform, ax.experiment_Name, count(ex.experiment_id) as num_experiments
FROM all_experiments ax left join experiments ex on ex.platform = ax.platform and ax.experiment_name =ex.experiment_name
GROUP by ax.platform, ax.experiment_name