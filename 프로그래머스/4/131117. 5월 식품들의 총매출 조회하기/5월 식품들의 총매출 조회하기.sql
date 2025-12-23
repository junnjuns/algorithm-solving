select
p.PRODUCT_ID as PRODUCT_ID,
p.PRODUCT_NAME as PRODUCT_NAME,
(p.PRICE * o.total) as TOTAL_SALES
from
    FOOD_PRODUCT as p
    join
    (
    select 
        PRODUCT_ID,
        sum(AMOUNT) as total,
        PRODUCE_DATE
    from
        FOOD_ORDER
    where PRODUCE_DATE >= '2022-05-01' and PRODUCE_DATE <= '2022-05-31' 
    group by
        PRODUCT_ID
    ) as o
    on
    p.PRODUCT_ID = o.PRODUCT_ID
order by TOTAL_SALES desc, p.PRODUCT_ID
