CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M=N-1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT M, 1
  );
END


Select TOP 1 Salary from Employee where Salary in ( SELECT TOP N DISTINCT Salary FROM Employee ORDER BY Salary DESC )



Select Salary from Employee where Salary in ( SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT N) LIMIT 1



