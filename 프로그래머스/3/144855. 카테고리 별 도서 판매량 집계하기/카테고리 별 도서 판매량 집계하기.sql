-- 코드를 입력하세요
SELECT category AS CATEGORY, sum(sales) as TOTAL_SALES 
from book b inner join book_sales bs
on b.book_id = bs.book_id
where sales_date between '2022-01-01' and '2022-01-31'
group by category
order by category