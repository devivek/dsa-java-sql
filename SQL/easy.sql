- https://leetcode.com/problems/invalid-tweets/
select tweet_id from tweets where length(content) > 15


- https://leetcode.com/problems/department-top-three-salaries/
select a.Department, a.Employee, a.Salary
from
(
    select d.name as Department, e.name as Employee, e.salary as Salary, 
    dense_rank() over (partition by d.id order by e.salary desc) as ranking
    from employee as e
    inner join department as d
    on e.departmentId = d.id
) a
where a.ranking <= 3


- https://leetcode.com/problems/customers-who-bought-all-products/
select customer_id
from customer
group by customer_id
having count(distinct product_key) = (select count(distinct product_key) from product);

- https://leetcode.com/problems/employees-whose-manager-left-the-company/
select employee_id
from Employees
where salary < 30000
and employee_id not in (
    select e1.employee_id
    from Employees as e1
    inner join Employees as e2
    where e1.manager_id = e2.employee_id
) 
and manager_id is not null
order by employee_id;





