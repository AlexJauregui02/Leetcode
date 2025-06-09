SELECT department_name AS Department, name AS Employee, salary AS Salary
FROM (
    SELECT 
        Employee.id AS employee_id,
        Employee.name,
        Employee.salary,
        Employee.departmentId,
        Department.name AS department_name,
        DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY salary DESC) AS salary_rank
    FROM Employee
    JOIN Department ON Employee.departmentId = Department.id
) ranked
WHERE salary_rank <= 3;
