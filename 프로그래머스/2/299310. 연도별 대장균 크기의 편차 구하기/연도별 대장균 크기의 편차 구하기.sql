select year(p.DIFFERENTIATION_DATE) as YEAR, (c.max - p.SIZE_OF_COLONY) as YEAR_DEV, p.ID
from ECOLI_DATA p join 
    (
    select 
        year(DIFFERENTIATION_DATE) as year,
        max(SIZE_OF_COLONY) as max
    from ECOLI_DATA
    group by year(DIFFERENTIATION_DATE)
    ) as c 
on year(p.DIFFERENTIATION_DATE) = c.year
order by year(p.DIFFERENTIATION_DATE), (c.max - p.SIZE_OF_COLONY) 