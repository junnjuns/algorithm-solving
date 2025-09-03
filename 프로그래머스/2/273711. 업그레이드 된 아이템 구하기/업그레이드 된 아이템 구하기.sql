select
I.ITEM_ID,
I.ITEM_NAME,
I.RARITY
from ITEM_INFO as I join ITEM_TREE as T on I.ITEM_ID = T.ITEM_ID
where T.PARENT_ITEM_ID in
(
    select ITEM_ID
    from ITEM_INFO
    where RARITY = 'RARE'
)
order by I.ITEM_ID desc