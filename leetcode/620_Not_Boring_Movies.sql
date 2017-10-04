# Write your MySQL query statement below
SELECT * 
FROM cinema
WHERE id MOD 2 = 1 AND description != 'boring'
ORDER BY rating desc




SELECT * FROM cinema WHERE (id % 2 = 1) AND (description <> 'boring') ORDER BY rating DESC



select *
from cinema
where mod(id, 2) = 1 and description != 'boring'
order by rating DESC