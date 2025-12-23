select 
    F.FLAVOR
from
    FIRST_HALF as F
join
    (
        select
        FLAVOR,
        sum(TOTAL_ORDER) as july_sum
        from JULY
        group by FLAVOR
    ) as J
on F.FLAVOR = J.FLAVOR
order by F.TOTAL_ORDER + J.july_sum desc
limit 3