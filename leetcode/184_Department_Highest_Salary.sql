# Write your MySQL query statement below
SELECT d.Name as Department, e.Name as Employee, e.salary as Salary
FROM Employee as e
JOIN Department as d on e.DepartmentId = d.Id
where e.salary >= ALL(Select e2.salary from Employee as e2 where e.DepartmentId = e2.DepartmentId)
# WHERE e.salary >= (SELECT MAX(salary) from Employee as e2 where e.DepartmentId = e2.DepartmentId)


# # wrong anwser
# SELECT d.Name as 'Department', e.Name as Employee, e.salary as Salary
# FROM Employee as e
# JOIN Department as d on e.DepartmentId = d.Id
# JOIN Employee as e2 on e.DepartmentId = e2.DepartmentId
# where (e.salary >= e2.salary)


# 1    1000       5   1   *
#                     2
#                     3
# 2    2000       5   1   *
#                     2   *
#                     3
# 3    3000       5   1   *
#                     2   *
#                     3   *
