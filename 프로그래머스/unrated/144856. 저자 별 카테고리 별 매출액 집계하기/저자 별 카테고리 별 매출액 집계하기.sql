-- 코드를 입력하세요
SELECT a.AUTHOR_ID, a.AUTHOR_NAME, CATEGORY, sum(bs.sales * price) as TOTAL_SALES
FROM BOOK b join AUTHOR a
on b.AUTHOR_ID = a.AUTHOR_ID
join BOOK_SALES bs
on b.BOOK_ID = bs.BOOK_ID
where TO_CHAR(sales_date, 'YYMM') = '2201'
GROUP BY a.AUTHOR_ID, a.AUTHOR_NAME, CATEGORY
order by a.AUTHOR_ID , CATEGORY desc;

