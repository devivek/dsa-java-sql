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


- https://leetcode.com/problems/trips-and-users/

    select trips.request_at as 'Day',
        round(sum(
            case 
                when trips.status in ('cancelled_by_driver', 'cancelled_by_client')
                    then 1
                else 0
            end
        ) / count(*) , 2) as 'Cancellation Rate'
    from trips
    inner join users as cu
        on cu.users_id = trips.client_id
    inner join users as du
        on du.users_id = trips.driver_id
    where 
        cu.banned = 'No' 
        and du.banned = 'No' 
        and request_at BETWEEN '2013-10-01' AND '2013-10-03'
    group by trips.request_at
    order by  trips.request_at


    # better approach is to compute the banned_users and re-use insted of two whole table join

    with unbanned_user as (
        SELECT 
        users_id 
        FROM 
        Users 
        WHERE 
        banned = 'Yes'
    )
    SELECT 
    request_at AS Day, 
    ROUND(
        SUM(status != 'completed') / COUNT(status), 
        2
    ) AS 'Cancellation Rate' 
    FROM 
    Trips 
    WHERE 
        request_at BETWEEN '2013-10-01' 
        AND '2013-10-03' 
        AND driver_id NOT IN (SELECT users_id FROM unbanned_user)
        AND client_id NOT IN (SELECT users_id FROM unbanned_user)
    GROUP BY 
    Day

    







