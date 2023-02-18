-- 코드를 입력하세요
select * from (SELECT PRICE_GROUP,	count(PRODUCT_ID) as PRODUCTS
from  (SELECT PRODUCT_ID, TRUNC(PRICE,-4) as PRICE_GROUP
from PRODUCT)
group by PRICE_GROUP)
order by PRICE_GROUP ;

