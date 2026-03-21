select
    count(fn.FISH_NAME) as FISH_COUNT,
    fn.FISH_NAME
from FISH_INFO as fi
join FISH_NAME_INFO as fn
    on fi.FISH_TYPE = fn.FISH_TYPE
group by fn.FISH_NAME
order by FISH_COUNT desc