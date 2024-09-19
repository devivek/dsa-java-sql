- https://leetcode.com/problems/consecutive-numbers/solutions/321205/runtime-299-ms-faster-than-94-39/

    select distinct Num as ConsecutiveNums
    from Logs
    where (Id + 1, Num) in (select * from Logs) and (Id + 2, Num) in (select * from Logs)

    with data as (
        select num, lead(num, 1) over() num1, lead (num, 2) over() num2
        from logs
    )
    select distinct num ConsecutiveNums
    from data
    where num = num1 and num1 = num2;

