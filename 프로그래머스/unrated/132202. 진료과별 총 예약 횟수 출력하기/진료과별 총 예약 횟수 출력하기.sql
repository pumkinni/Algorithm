select MCDP_CD, count(MCDP_CD)
from appointment
where TO_CHAR(APNT_YMD, 'YYMM') = 2205
group by MCDP_CD
order by count(MCDP_CD), MCDP_CD;