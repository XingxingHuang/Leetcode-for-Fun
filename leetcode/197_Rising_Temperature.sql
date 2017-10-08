# 10.05
# 注意如何使用日期来计算

# Write your MySQL query statement below
SELECT wt1.Id 
FROM Weather wt1, Weather wt2
WHERE wt1.Temperature > wt2.Temperature AND 
      TO_DAYS(wt1.DATE)-TO_DAYS(wt2.DATE)=1;



SELECT
    weather.id AS 'Id'
FROM
    weather
        JOIN
    weather w ON DATEDIFF(weather.date, w.date) = 1
        AND weather.Temperature > w.Temperature
;


SELECT Id FROM (
    SELECT CASE
        WHEN Temperature > @prevtemp AND DATEDIFF(Date, @prevdate) = 1 THEN Id ELSE NULL END AS Id,
        @prevtemp:=Temperature,
        @prevdate:=Date
    FROM Weather, (SELECT @prevtemp:=NULL) AS A, (SELECT @prevdate:=NULL) AS B ORDER BY Date ASC
) AS D WHERE Id IS NOT NULL



select A.Id from Weather A,Weather B where A.Date = (
select date_add(B.Date, interval 1 day)
) AND A.Temperature>B.Temperature;


select a.Id as Id
from
Weather as a
join
Weather as b
ON
b.Date = subdate(a.Date,1)
where
a.Temperature > b.Temperature;