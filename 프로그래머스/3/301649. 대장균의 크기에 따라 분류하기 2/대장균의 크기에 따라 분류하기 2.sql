select
t.ID,
case t.grade
    when 1 then 'LOW'
    when 2 then 'MEDIUM'
    when 3 then 'HIGH'
    else 'CRITICAL'
end as COLONY_NAME
from
(
    select
    ID,
    ntile(4) over(order by SIZE_OF_COLONY) as grade
    from ECOLI_DATA
) as t
order by ID