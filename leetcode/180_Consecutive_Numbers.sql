SELECT DISTINCT
    l1.Num AS ConsecutiveNums
FROM
    Logs l1,
    Logs l2,
    Logs l3
WHERE
    l1.Id = l2.Id - 1
    AND l2.Id = l3.Id - 1
    AND l1.Num = l2.Num
    AND l2.Num = l3.Num
;


# Write your MySQL query statement below
SELECT distinct(l1.Num) as ConsecutiveNums
from logs as l1
join logs as l2 on l2.id-l1.id = 1
join logs as l3 on l3.id-l1.id = 2
where l1.num = l2.num and l1.num = l3.num




SELECT distinct num as ConsecutiveNums
from 
    (
    select num,  case 
                    when  @record = num then @count:=@count+1
                    when @record <> @record:=num then @count:=1 end as n
    from 
        Logs ,(select @count:=0,@record:=(SELECT num from Logs limit 1))  r
    ) a
where a.n >= 3





SET @prev := 0;
SET @cnt := 0;
SELECT DISTINCT Num AS ConsecutiveNums
FROM 
(
SELECT Num, @cnt := IF(@prev = Num, @cnt + 1, 1) AS cnt, @prev := Num 
FROM Logs
) t
WHERE cnt > 2;