select
f.ID as ID,
n.FISH_NAME,
f.LENGTH
from FISH_INFO f
join FISH_NAME_INFO n
  on n.FISH_TYPE = f.FISH_TYPE
where f.LENGTH = (
    select max(f2.length)
    from FISH_INFO as f2
    where f2.FISH_TYPE = f.FISH_TYPE
    )
order by f.ID