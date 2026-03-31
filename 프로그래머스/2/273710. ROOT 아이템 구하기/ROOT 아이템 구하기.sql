select
II.ITEM_ID,
II.ITEM_NAME
from ITEM_INFO as II
    join ITEM_TREE as IT
    on II.ITEM_ID = IT.ITEM_ID
where IT.PARENT_ITEM_ID is null
order by II.ITEM_ID