SELECT employee, salary, department
FROM (
    SELECT 
        e.name AS employee,
        e.salary,
        d.name AS department,
        DENSE_RANK() OVER (PARTITION BY d.id ORDER BY e.salary DESC) AS rn
    FROM Employee e
    JOIN Department d ON e.departmentId = d.id
) ranked
WHERE rn <= 3
ORDER BY department, salary DESC;