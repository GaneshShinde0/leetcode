-- DECLARE 
--         @any_perms nvarchar(max)= (
--             SELECT STRING_AGG(permissions, '|') WITHIN GROUP(ORDER BY user_id)
--             FROM user_permissions
--         ),

--         @common_perms nvarchar(max) = (
--             SELECT STRING_AGG(permissions, '&') WITHIN GROUP(ORDER BY user_id)
--             FROM user_permissions
--         );

-- DECLARE 
--         @query nvarchar(max) = CONCAT(
--             'SELECT ',
--             @common_perms,
--             ' AS common_perms, ',
--             @any_perms,
--             ' AS any_perms'
--         );

-- EXEC(@query)

/* Write your T-SQL query statement below */
declare @common_perms INT ;
declare @any_perms INT = 0;

select @common_perms = permissions 
from user_permissions 
where user_id = (select min(user_id) from user_permissions);

select 
      @common_perms &= permissions,
      @any_perms |= permissions
from user_permissions;

select @common_perms as common_perms, @any_perms as any_perms;