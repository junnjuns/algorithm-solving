select
CAR_ID,
(
case 
    when max (case
    when START_DATE <= '2022-10-16' and END_DATE >= '2022-10-16' then 1
    else 0
end) = 1 then '대여중'
else '대여 가능'
end
) as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
order by CAR_ID desc