select
SQ.PRICE as PRICE_GROUP,
count(*) as PRODUCTS
from 
(
    select
        FLOOR(PRICE/10000) * 10000 as PRICE
    from PRODUCT
) as SQ
group by SQ.PRICE
order by SQ.PRICE