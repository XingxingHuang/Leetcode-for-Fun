# Write your MySQL query statement below
SELECT class
from courses
group by class
having count(DISTINCT student) >= 5



SELECT class
FROM
(
SELECT class, count(distinct student) AS cnt
FROM
courses
GROUP BY class
) c
WHERE cnt >= 5