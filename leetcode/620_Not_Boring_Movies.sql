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


# 10.18
Select *
from cinema
where 
    id % 2 = 1 and
    description not like "%boring%"
order by rating desc


#  https://www.postgresql.org/docs/9.5/static/functions-matching.html
'abc' LIKE 'abc'    true
'abc' LIKE 'a%'     true
'abc' LIKE '_b_'    true
'abc' LIKE 'c'      false

'abc' SIMILAR TO 'abc'      true
'abc' SIMILAR TO 'a'        false
'abc' SIMILAR TO '%(b|d)%'  true
'abc' SIMILAR TO '(b|c)%'   false