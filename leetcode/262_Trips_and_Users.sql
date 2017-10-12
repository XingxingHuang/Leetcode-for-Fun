# Write your MySQL query statement below
select 
  t.Request_at Day, 
  round(sum(case when t.Status like 'cancelled_%' then 1 else 0 end)/count(*),2) 'Cancellation Rate'
from Trips t 
inner join Users u 
on t.Client_Id = u.Users_Id and u.Banned='No'
where t.Request_at between '2013-10-01' and '2013-10-03'
group by t.Request_at



SELECT Request_at as Day,
       ROUND(COUNT(IF(Status != 'completed', TRUE, NULL)) / COUNT(*), 2) AS 'Cancellation Rate'
FROM Trips
WHERE (Request_at BETWEEN '2013-10-01' AND '2013-10-03')
      AND Client_id NOT IN (SELECT Users_Id FROM Users WHERE Banned = 'Yes')
GROUP BY Request_at;


# 10.10 
# Write your MySQL query statement below
select 
    Request_at as Day, 
    round(sum(if (Status like 'cancelled_%', 1, 0))/count(*),2) 'Cancellation Rate'
from trips
where (Request_at between date("2013-10-01") and date("2013-10-03")) 
    and Client_Id in (select distinct Users_Id from  Users where Banned = "No" and Role = "client") 
GROUP by Request_at

