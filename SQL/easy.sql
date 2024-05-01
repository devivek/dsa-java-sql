- https://leetcode.com/problems/invalid-tweets/?envType=study-plan-v2&envId=top-sql-50
select tweet_id from tweets where length(content) > 15


- https://leetcode.com/problems/department-top-three-salaries/description/?envType=study-plan-v2&envId=top-sql-50
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


- https://leetcode.com/problems/customers-who-bought-all-products/description/?envType=study-plan-v2&envId=top-sql-50
select customer_id
from customer
group by customer_id
having count(distinct product_key) = (select count(distinct product_key) from product);


