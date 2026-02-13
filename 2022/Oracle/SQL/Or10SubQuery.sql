/******************************
ÆÄÀÏ¸í : Or10SubQuery.sql
¼­ºêÄõ¸®
¼³¸í : Äõ¸®¹® ¾È¿¡ ¶Ç´Ù¸¥ Äõ¸®¹®ÀÌ µé¾î°¡´Â ÇüÅÂÀÇ select¹®
******************************/

/*
´ÜÀÏÇà ¼­ºêÄõ¸®
    Çü½Ä] 
        select * from Å×ÀÌºí¸í where ÄÃ·³=(
            select ÄÃ·³ from Å×ÀÌºí¸í where Á¶°Ç
        );
        ¡Ø°ıÈ£ ¾ÈÀÇ ¼­ºêÄõ¸®´Â ¹İµå½Ã ÇÏ³ªÀÇ °á°ú¸¦ ÀÎÃâÇØ¾ß ÇÑ´Ù.
*/
/*
½Ã³ª¸®¿À ] »ç¿øÅ×ÀÌºí¿¡¼­ ÀüÃ¼»ç¿øÀÇ Æò±Õ ±Ş¿©º¸´Ù ³·Àº ±Ş¿©¸¦ ¹Ş´Â »ç¿øµéÀ»
                ÃßÃâÇÏ¿© Ãâ·ÂÇÏ½Ã¿À.
                Ãâ·ÂÇ×¸ñ : »ç¿ø¹øÈ£, ÀÌ¸§, ÀÌ¸ŞÀÏ, ¿¬¶ôÃ³, ±Ş¿©
*/
select
    employee_id, first_name, last_name, email, salary
from employees
where salary < round(avg(salary)); /*
        ÇØ´ç Äõ¸®¹®Àº ¹®¸Æ»ó ¸Â´ÂµíÇÏ³ª,
        ±×·ìÇÔ¼ö¸¦ ´ÜÀÏÇà¿¡ Àû¿ëÇÑ Àß¸øµÈ Äõ¸®¹®ÀÌ´Ù.       >> error
*/ 
--1´Ü°è Æò±Õ±Ş¿©°¡ ¾ó¸¶ÀÎÁö¸¦ ±¸ÇÑ´Ù.
select
    round(avg(salary))
from employees;

--2´Ü°è : 1´Ü°è ÀÎÃâ°á°ú(6462)º¸´Ù ÀûÀº ±Ş¿©¸¦ ¹Ş´Â Á÷¿øÀ» ÀÎÃâÇÑ´Ù.
select * 
    from employees
where salary<6462;          --3´Ü°è¿¡¼­ 6462¸¦ ()·Î ¹Ù²Û ÈÄ 1´Ü°è¸¦ »ğÀÔÇÔ

--3´Ü°è : 2°³ÀÇ Äõ¸®¸¦ ÇÏ³ªÀÇ ¼­ºêÄõ¸®¹®À¸·Î ÇÕÄ£´Ù (1+2´Ü°è)
select * from employees
    where salary<(select round(avg(salary)) from employees);
    

/*
½Ã³ª¸®¿À] ÀüÃ¼ »ç¿øÁß ±Ş¿©°¡ °¡Àå ÀûÀº »ç¿øÀÇ ÀÌ¸§°ú ±Ş¿©¸¦ Ãâ·ÂÇÏ´Â ¼­ºêÄõ¸®¹®À» ÀÛ¼ºÇÏ½Ã¿À.
    Ãâ·ÂÇ×¸ñ : ÀÌ¸§1, ÀÌ¸§2, ÀÌ¸ŞÀÏ, ±Ş¿©
*/
--1
select
    min(salary)
from employees;
--2
select
    first_name, last_name, email, salary from employees
where salary=2100;
--3
select
    first_name, last_name, email, salary from employees
where salary=(select min(salary) from employees);


/*
½Ã³ª¸®¿À] Æò±Õ±Ş¿©º¸´Ù ¸¹Àº ±Ş¿©¸¦ ¹Ş´Â »ç¿øµéÀÇ ¸í´ÜÀ» Á¶È¸ÇÒ ¼ö ÀÖ´Â
            ¼­ºêÄõ¸®¹®À» ÀÛ¼ºÇÏ½Ã¿À.
            Ãâ·Â³»¿ë : ÀÌ¸§1, ÀÌ¸§2, ´ã´ç¾÷¹«¸í, ±Ş¿©
            ¡Ø ´ã´ç¾÷¹«¸íÀº jobs Å×ÀÌºí¿¡ ÀÖÀ¸¹Ç·Î joinÇØ¾ß ÇÑ´Ù.
*/
--1´Ü°è : Æò±Õ±Ş¿© ±¸ÇÏ±â
select 
    trunc(avg(salary),2)
from employees;

--2´Ü°è : 6461.83º¸´Ù ±Ş¿©°¡ ¸¹Àº »ç¿ø ÀÎÃâ
select * from employees where salary>6461.83;

--3´Ü°è : jobs Å×ÀÌºí°ú Á¶ÀÎÀ» °Ç´Ù.
select
    first_name, last_name, job_title
from employees inner join jobs using (job_id)
where salary>6461.83;

--4´Ü°è : ¼­ºêÄõ¸®·Î º´ÇÕ
select
    first_name, last_name, job_title
from employees inner join jobs using (job_id)
where salary>(select trunc(avg(salary),2) from employees);


/*
º¹¼öÇà ¼­ºêÄõ¸®
    Çü½Ä]
        select * from Å×ÀÌºí¸í where ÄÃ·³ in(
            select ÄÃ·³ from Å×ÀÌºí¸í where Á¶°Ç
        );
        ¡Ø°ıÈ£ ¾ÈÀÇ ¼­ºêÄõ¸®´Â 2°³ ÀÌ»óÀÇ °á°ú¸¦ ÀÎÃâÇØ¾ß ÇÑ´Ù.
*/
/*
½Ã³ª¸®¿À] ´ã´ç¾÷¹«º°·Î °¡Àå ³ôÀº ±Ş¿©¸¦ ¹Ş´Â »ç¿øÀÇ ¸í´ÜÀ» Á¶È¸ÇÏ½Ã¿À.
    Ãâ·Â¸ñ·Ï : »ç¿ø¾ÆÀÌµğ, ÀÌ¸§, ´ã´ç¾÷¹«¾ÆÀÌµğ, ±Ş¿©
*/
--1 : »ç¿øÅ×ÀÌºí¿¡¼­ ´Ü¼ø Á¤·ÄÀ» ÅëÇØ ¾÷¹«º° °í¾×¿¬ºÀÀÚ È®ÀÎ
select
    job_id, salary
from employees
order by job_id, salary desc;

--2 : 1¹ø¿¡¼­ È®ÀÎÇÑ ·¹ÄÚµå¸¦ group byÀı·Î ±×·ìÈ­ÇÏ¿© °¢ Á÷Á¾º° ÃÖ´ë±Ş¿©¸¦ È®ÀÎÇÑ´Ù.
select
    job_id, max(salary)
from employees
group by job_id;

--3 : 2¹øÀÇ °á°ú¸¦ ´ë»óÀ¸·Î ´Ü¼ø Äõ¸®¹® ÀÛ¼º
select
    employee_id, first_name, job_id, salary
from employees
where
    (job_id= 'IT PROG' and salary=9000) or
    (job_id= 'AC_MGR' and salary=12008) or
    (job_id= 'AC_ACCOUNT' and salary=8300) or
    (job_id= 'ST_MAN' and salary=8200) or
    (job_id= 'PU_MAN' and salary=11000); /*
            2¹ø¿¡¼­ ÀÎ­ŒµÈ 19°³ÀÇ °á°ú¸¦ ´Ü¼ø Äõ¸®·Î ÀÛ¼ºÇÏ¸é
            À§¿Í °°ÀÌ or¿¬»êÀÚ¸¦ ÅëÇØ ¿¬°áÇÒ ¼ö ÀÖ´Ù.
            ÇÏÁö¸¸ °á°ú°¡ ¸¹´Ù¸é ÀÛ¼ºÀÌ ºÒ°¡´ÉÇÒ °ÍÀÌ´Ù.
            */
--4 : 3¹øÀÇ Äõ¸®¹®À» ¼­ºêÄõ¸®·Î º¯°æÇÑ´Ù. º¹¼öÇàÀÌ¹Ç·Î inÀ» »ç¿ë.
select
    employee_id, first_name, job_id, salary
from employees
where
    (job_id, salary) in (
            select
                  job_id, max(salary)
            from employees
            group by job_id
    );
    
    
/*
º¹¼öÇà ¿¬»êÀÚ2 : any
    ¸ŞÀÎÄõ¸®ÀÇ ºñ±³Á¶°ÇÀÌ ¼­ºêÄõ¸®ÀÇ °Ë»ö°á°ú¿Í ÇÏ³ª ÀÌ»ó ÀÏÄ¡ÇÏ¸é ÂüÀÌ µÇ´Â ¿¬»êÀÚ.
    Áï, µÑÁß ÇÏ³ª¸¸ ¸¸Á·ÇÑ´Ù¸é ÇØ´ç ·¹ÄÚµå¸¦ °¡Á®¿Â´Ù.
*/
/*
½Ã³ª¸®¿À] ÀüÃ¼ »ç¿øÁß¿¡¼­ ºÎ¼­¹øÈ£°¡ 20ÀÎ »ç¿øµéÀÇ ±Ş¿©º¸´Ù ³ôÀº ±Ş¿©¸¦ ¹Ş´Â Á÷¿øµéÀ»
                ÃßÃâÇÏ´Â ¼­ºêÄõ¸®¹®À» ÀÛ¼ºÇÏ½Ã¿À.
*/
--1´Ü°è : 20¹ø ºÎ¼­ÀÇ ±Ş¿©¸¦ ¿ì¼± È®ÀÎ
select  * from employees
where department_id=20;
--2´Ü°è : 1ÀÇ °á°ú¸¦ ´Ü¼øÄõ¸®¸¦ ¸¸µé¾îº»´Ù¸é,
select * from employees
where salary>=13000 or salary>=6000;
--3´Ü°è : 2ÀÇ °á°ú¸¦ ¼­ºêÄõ¸®·Î ÀÛ¼º. ÀÌ¶§ any¸¦ »ç¿ëÇÑ´Ù.
--select * from employees
 --   where salary>=any(select  * from employees where department_id=20);       --¼­ºêÄõ¸®¹®ÀÇ *´Â ÀüÃ¼¸¦ ÀÇ¹ÌÇÏ¿© error >> salary·Î ¹Ù²ãÁØ´Ù.
select 
    first_name, last_name, department_id, salary
from employees
    where salary>=any(select  salary from employees where department_id=20); /*
                            º¹¼öÇà ¿¬»êÀÚ any¸¦ »ç¿ëÇÏ¸é 2¹ø°ú °°ÀÌ or Á¶°ÇÀ¸·Î °á°úµéÀ» ¿¬°áÇÏ°Ô µÈ´Ù.
                            6000 ¶Ç´Â 13000 ÀÌ»óÀÎ ·¹ÄÚµå¸¸ ÃßÃâµÈ´Ù.
                            */
                            
                            
/*
º¹¼öÇà¿¬»êÀÚ3 : all
    : ¸ŞÀÎÄõ¸®ÀÇ ºñ±³Á¶°ÇÀÌ ¼­ºêÄõ¸®ÀÇ °Ë»ö°á°ú¿Í ¸ğµÎ ÀÏÄ¡ÇØ¾ß ÂüÀÌ µÈ´Ù.
*/
select 
    first_name, last_name, department_id, salary
from employees
    where salary>=all(select  salary from employees where department_id=20); /*
                6000º¸´Ù Å©°í 13000º¸´Ùµµ Ä¿¾ßÇÏ¹Ç·Î °á°úÀûÀ¸·Î 13000ÀÌ»óÀÎ ·¹ÄÚµå¸¸ ÃßÃâÇÏ°Ô µÈ´Ù.
                */
                
                
/*
Top Äõ¸® : Á¶È¸µÈ °á°ú¿¡¼­ ±¸°£À» Á¤ÇØ ·¹ÄÚµå¸¦ °¡Á®¿Ã ¶§ »ç¿ëÇÑ´Ù.
                ÁÖ·Î °Ô½ÃÆÇÀÇ ÆäÀÌÂ¡¿¡ »ç¿ëµÊ.
                
                rownum : Å×ÀÌºí¿¡¼­ ·¹ÄÚµå¸¦ Á¶È¸ÇÑ ¼ø¼­´ë·Î ¼ø¹øÀÌ ºÎ¿©µÇ´Â °¡»óÀÇ ÄÃ·³À» ¸»ÇÔ.
                                ÇØ´ç ÄÃ·³Àº ¸ğµç Å×ÀÌºí¿¡ Á¸Àç.
*/
select * from employees;
select employee_id, first_name, rownum from employees;
select employee_id, first_name, rownum from employees order by first_name;
select employee_id, first_name, rownum from (
    select * from employees order by first_name
);


/*
»ç¿øÅ×ÀÌºíÀ» Á¤ÇØÁø ±¸°£À» ÅëÇØ °¡Á®¿À±â À§ÇÑ ¼­ºêÄõ¸®¹®
*/
select * from
    (select Tb.*, rownum rNum from (                        --rownumºÎ¿© ½Ã 2¹ø
        select * from employees order by employee_id desc   --rownumºÎ¿© ½Ã 1¹ø(rownumÀº ¿À¶óÅ¬¿¡¼­ ÀÚµ¿À¸·Î ºÎ¿©ÇÏ¹Ç·Î ÀÌ ¹æ¹ıÀ» ÅëÇØ 'Á¤·Ä'ÇÑ´Ù.)
    )  Tb) --(select Tb.~ Tb)±îÁö Å×ÀÌºí µé¾î°¥ ÀÚ¸®
--where rNum between 1 and 10;        -- rNum>=1 and rNum<=10   --°Ô½ÃÆÇ ÀÛ¼º½Ã 1page
where rNum between 11 and 20;                                   --°Ô½ÃÆÇ ÀÛ¼º½Ã 2page

/*
    betweenÀÇ ±¸°£À» À§¿Í °°ÀÌ º¯°æÇØÁÖ¸é ÇØ´ç ÆäÀÌÁöÀÇ ·¹ÄÚµå¸¸ °¡Á®¿À°Ô µÈ´Ù.
    À§ÀÇ ±¸°£Àº Â÷ÈÄ JSP¿¡¼­ ¿©·¯°¡Áö º¯¼ö¸¦ Á¶ÇÕÇÏ°í °è»êÇØ¼­ ±¸ÇöÇÏ°Ô µÈ´Ù.

¨é ¨èÀÇ °á°ú ÀüÃ¼¸¦ °¡Á®¿Í¼­..
    (¨è ¨çÀÇ °á°ú¿¡ rownumÀ» ¼øÂ÷ÀûÀ¸·Î ºÎ¿©ÇÔ  (
        ¨ç»ç¿øÅ×ÀÌºíÀÇ ¸ğµç ·¹ÄÚµå¸¦ ³»¸²Â÷¼ø Á¤·ÄÇØ¼­ ÀÎÃâ
    )  Tb)
ÇÊ¿äÇÑ ºÎºĞÀ» rownu,À¸·Î ±¸°£À» Á¤ÇØ ÀÎÃâ  
*/

--------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------
--¿¬½À¹®Á¦                                               #scott °èÁ¤¿¡¼­ ÁøÇà
set serveroutput on;

--01.»ç¿ø¹øÈ£°¡ 7782ÀÎ »ç¿ø°ú ´ã´ç ¾÷¹«°¡ °°Àº »ç¿øÀ» Ç¥½Ã(»ç¿øÀÌ¸§°ú ´ã´ç¾÷¹«)ÇÏ½Ã¿À.
--1´Ü°è : »ç¿ø¹øÈ£°¡ 7782ÀÎ »ç¿øÀÇ ´ã´ç¾÷¹«
select
    job
from emp
where empno=7782;
--2´Ü°è : 1´Ü°èÀÇ ´ã´ç¾÷¹«°¡ °°Àº »ç¿ø Ç¥½Ã
select
    ename, job
from emp
where job='MANAGER';
--3´Ü°è : ÇÕÄ¡±â
select
    ename, job
from emp
where job=(select job from emp where empno=7782);


--02.»ç¿ø¹øÈ£°¡ 7499ÀÎ »ç¿øº¸´Ù ±Ş¿©°¡ ¸¹Àº »ç¿øÀ» Ç¥½Ã(»ç¿øÀÌ¸§°ú ´ã´ç¾÷¹«)ÇÏ½Ã¿À.
--1 : »ç¿ø¹øÈ£°¡ 7499ÀÎ »ç¿ø
select
    sal
from emp
where empno=7499;

--2 : allen(7499)º¸´Ù ±Ş¿©°¡ ¸¹Àº »ç¿ø
select
    ename, job
from emp
where sal>(select sal from emp where empno=7499);


--03.ÃÖ¼Ò ±Ş¿©¸¦ ¹Ş´Â »ç¿øÀÇ ÀÌ¸§, ´ã´ç ¾÷¹« ¹× ±Ş¿©¸¦ Ç¥½ÃÇÏ½Ã¿À(±×·ìÇÔ¼ö »ç¿ë).
--1 : ÃÖ¼Ò ±Ş¿© È®ÀÎ  >> 800
select
    ename, job, sal
from emp
order by sal asc;

--2 : 1¹ø¿¡¼­ È®ÀÎÇÑ ·¹ÄÚµå¸¦ group byÀı·Î ±×·ìÈ­, ÃÖ¼Ò ±Ş¿© È®ÀÎ
select
    job, min(sal)
from emp
group by job;

--3
select
    ename, job, sal
from emp
where
    (job, sal) in (
            select
                job, min(sal)
            from emp
            group by job);

/*¼±»ı´Ô Ç®ÀÌ*/
select min(sal) from emp;
select * from emp where sal=800;
--¼­ºêÄõ¸®·Î °áÇÕ
select empno, ename, job, sal from emp
    where sal=(select min(sal) from emp);

--04.Æò±Õ ±Ş¿©°¡ °¡Àå ÀûÀº Á÷±Ş(job)°ú Æò±Õ ±Ş¿©¸¦ Ç¥½ÃÇÏ½Ã¿À. ¡Ú¡Ú¡Ú
--0. Æò±Õ±Ş¿© È®ÀÎ
select
    trunc(avg(sal),2)
from emp;

select* from emp;
select * from emp group by job;    --error : group by·Î ±×·ìÈ­ÇÑ µ¥ÀÌÅÍ¿¡¼­ ±×·ìÇÔ¼ö¸¦ ÅëÇÑ °á°ú ÀÌ¿ÜÀÇ °ªÀº Ãâ·ÂÀÌ ¾Ö¸ÅÇÏ¹Ç·Î


--2. Á÷±Şº° Æò±Õ±Ş¿© È®ÀÎ
select
    job, trunc(avg(sal),2)
from emp
group by job;

-- : 1¿¡¼­ °¡Àå Æò±Õ±Ş¿©°¡ ÀûÀº Á÷±Ş    >> CLERK
select
    trunc(avg(sal),2)
from emp
where job='CLERK';

--4
select
    trunc(avg(sal),2)
from emp
where (job,sal) in (select
                        job, trunc(avg(sal),2)
                    from emp
                    group by job);

/*¼±»ı´Ô Ç®ÀÌ*/
--´ã´ç¾÷¹«·Î ±×·ìÈ­ÇÏ¿© ¾÷¹«º° Æò±Õ±Ş¿© Á¶È¸
select job, round(avg(sal)) from emp group by job;
--¿À·ù¹ß»ı : not a single-group group function
select job, min(round(avg(sal))) from emp group by job;
--select Àı¿¡¼­ jobÀ» Á¦¿ÜÇÑ ÈÄ ½ÇÇà
select min(round(avg(sal))) from emp group by job;

/*Æò±Õ±Ş¿©´Â ¹°¸®ÀûÀ¸·Î Á¸ÀçÇÏ´Â ÄÃ·³ÀÌ ¾Æ´Ï°í whereÀı¿¡´Â »ç¿ëÇÒ ¼ö ¾ø°í
  havingÀı¿¡ »ç¿ëÇØ¾ß ÇÑ´Ù.
  Áï, Æò±Õ±Ş¿©°¡ 1017ÀÎ Á÷±ŞÀ» Ãâ·ÂÇÏ´Â ¹æ½ÄÀ¸·Î ¼­ºêÄõ¸®¸¦ ÀÛ¼º*/
select job, round(avg(sal))
    from emp group by job
    having round(avg(sal))=(select min(round(avg(sal))) from emp group by job);
    

--05.°¢ ºÎ¼­ÀÇ ÃÖ¼Ò ±Ş¿©¸¦ ¹Ş´Â »ç¿øÀÇ ÀÌ¸§, ±Ş¿©, ºÎ¼­¹øÈ£¸¦ Ç¥½ÃÇÏ½Ã¿À.
--1. °¢ ºÎ¼­ÀÇ ÃÖ¼Ò±Ş¿© È®ÀÎ
select
    ename, sal, deptno
from emp
order by sal asc;

--2.
select
    job, min(sal)
from emp
group by job;

--3.
select
    ename, sal, deptno
from emp
where (job, sal) in (
         select
              job, min(sal)
         from emp
         group by job
      );


--06.´ã´ç ¾÷¹«°¡ ºĞ¼®°¡(ANALYST)ÀÎ »ç¿øº¸´Ù ±Ş¿©°¡ ÀûÀ¸¸é¼­ ¾÷¹«°¡ ºĞ¼®°¡(ANALYST)°¡ ¾Æ´Ñ »ç¿øµéÀ» Ç¥½Ã(»ç¿ø¹øÈ£, ÀÌ¸§, ´ã´ç¾÷¹«, ±Ş¿©)ÇÏ½Ã¿À.
--1. ´ã´ç ¾÷¹«°¡ ºĞ¼®°¡(ANALYST)ÀÎ »ç¿ø
select
    empno, ename, job, sal
from emp
where job='ANALYST';

--2.
select
    empno, ename, job, sal
from emp
where sal<3000 and job!='ANALYST';


--07.ºÎÇÏÁ÷¿øÀÌ ¾ø´Â »ç¶÷ÀÇ ÀÌ¸§À» Ç¥½ÃÇÏ½Ã¿À.
select
    ename
from emp
where MGR is null;

--08.ºÎÇÏÁ÷¿øÀÌ ÀÖ´Â »ç¶÷ÀÇ ÀÌ¸§À» Ç¥½ÃÇÏ½Ã¿À.
select
    ename
from emp
where MGR is not null;

--09.BLAKE¿Í µ¿ÀÏÇÑ ºÎ¼­¿¡ ¼ÓÇÑ »ç¿øÀÇ ÀÌ¸§°ú ÀÔ»çÀÏÀ» Ç¥½ÃÇÏ´Â ÁúÀÇ¸¦ ÀÛ¼ºÇÏ½Ã¿À. (´Ü, BLAKE´Â Á¦¿Ü).
--1 : BLAKEÀÇ ºÎ¼­¹øÈ£
select
    deptno
from emp
where ename='BLAKE';

--2 : 
select
    ename, hiredate
from emp
where deptno in (select deptno from emp where ename='BLAKE');

--10.±Ş¿©°¡ Æò±Õ ±Ş¿©º¸´Ù ¸¹Àº »ç¿øµéÀÇ »ç¿ø¹øÈ£¿Í ÀÌ¸§À» Ç¥½ÃÇÏµÇ °á°ú¸¦ ±Ş¿©¿¡ ´ëÇØ¼­
   --¿À¸§Â÷¼øÀ¸·Î Á¤·ÄÇÏ½Ã¿À.
--1. Æò±Õ±Ş¿© È®ÀÎ
select
    avg(sal)
from emp;

--2. Æò±Õ±Ş¿©º¸´Ù ±Ş¿©°¡ ¸¹Àº »ç¿øµéÀÇ »ç¿ø¹øÈ£¿Í ÀÌ¸§ Ç¥½Ã
select
    empno, ename
from emp
where sal>(select avg(sal) from emp);

--3. ¿À¸§Â÷¼ø Á¤·Ä
select
    empno, ename
from emp
where sal>(select avg(sal) from emp)
order by sal asc;

--11.ÀÌ¸§¿¡ K°¡ Æ÷ÇÔµÈ »ç¿ø°ú °°Àº ºÎ¼­¿¡¼­ ÀÏÇÏ´Â »ç¿øÀÇ »ç¿ø¹øÈ£¿Í ÀÌ¸§À» Ç¥½ÃÇÏ´Â ÁúÀÇ¸¦
--   ÀÛ¼ºÇÏ½Ã¿À
--1.ÀÌ¸§¿¡ K°¡ Æ÷ÇÔµÈ »ç¿ø°ú ºÎ¼­(¹øÈ£)
select
    ename, deptno
from emp
where ename like ('%K%');               --º¹¼öÇà ¿¬»êÀÚ »ç¿ëÇØ¾ßµÈ´Ù.

--2.°°Àº ºÎ¼­¿¡¼­ ÀÏÇÏ´Â »ç¿øÀÇ »ç¿ø¹øÈ£¿Í ÀÌ¸§        --error ¡Ú
select
    empno, ename
from emp
where deptno in (select
    ename, deptno
from emp
where ename like ('%K%'));

/*¼±»ı´Ô Ç®ÀÌ*/
select * from emp where deptno=10 or deptno =30;        --or·Î Á¶°Ç°É±â
select * from emp where deptno in (10,30);              --inÀ¸·Î Á¶°Ç°É±â

/*
    orÁ¶°ÇÀ» inÀ¸·Î º¯°æÇÒ ¼ö ÀÖÀ¸¹Ç·Î
    ¼­ºêÄõ¸®¿¡¼­ º¹¼öÇà ¿¬»ê¿¡ inÀ» »ç¿ë
    2°³ ÀÌ»óÀÇ °á°ú¸¦ or·Î ¿¬°áÇÏ¿© Ãâ·ÂÇÏ´Â È¿°ú¸¦ °¡Áü
*/
select empno, ename, deptno
from emp
where deptno in (select deptno from emp where ename like '%K%');


--12.ºÎ¼­ À§Ä¡°¡ DALLASÀÎ »ç¿øÀÇ ÀÌ¸§°ú ºÎ¼­¹øÈ£ ¹× ´ã´ç ¾÷¹«¸¦ Ç¥½ÃÇÏ½Ã¿À.
select
    ename, e.deptno, job
from emp e, dept d
where e.deptno = d.deptno
      and LOC='DALLAS';

--13.KING¿¡°Ô º¸°íÇÏ´Â »ç¿øÀÇ ÀÌ¸§°ú ±Ş¿©¸¦ Ç¥½ÃÇÏ½Ã¿À.
--1. KINGÀÇ empno
select
    empno
from emp
where ename='KING';

--2.
select
    ename, sal
from emp
where MGR=(select empno from emp where ename='KING');


--14.RESEARCH ºÎ¼­ÀÇ »ç¿ø¿¡ ´ëÇÑ ºÎ¼­¹øÈ£ »ç¿øÀÌ¸§ ¹× ´ã´ç ¾÷¹«¸¦ Ç¥½ÃÇÏ½Ã¿À.
--1. RESEARCH ºÎ¼­ÀÇ ºÎ¼­¹øÈ£
select
    deptno
from dept
where dname='RESEARCH';

select
    e.deptno, ename, job
from emp e, dept d
where
    e.deptno = d.deptno
    and dname='RESEARCH';


--15.Æò±Õ ±Ş¿©º¸´Ù ¸¹Àº ±Ş¿©¸¦ ¹Ş°í ÀÌ¸§¿¡ k°¡ Æ÷ÇÔµÈ »ç¿ø°ú
--   °°Àº ºÎ¼­¿¡¼­ ±Ù¹«ÇÏ´Â »ç¿øÀÇ »ç¿ø¹øÈ£, ÀÌ¸§, ±Ş¿©¸¦ Ç¥½ÃÇÏ½Ã¿À.    ¡Ú¡Ú¡Ú
--1. Æò±Õ±Ş¿© (ÀÓÀÇ·Î ¼Ò¼ıÁ¡ 2ÀÚ¸®·Î Ç¥½ÃÇßÀ½)
select
    trunc(avg(sal),2)
from emp;

--2. ÀÌ¸§¿¡ K°¡ Æ÷ÇÔµÈ »ç¿ø ¹× ºÎ¼­(¹øÈ£)
select
    ename, deptno
from emp
where ename like '%K%';

--3. 
select
    empno, ename, sal
from emp
where (ename like '%K%')            --havingÀÌ ¾Æ´Ô... salÀº ¹°¸®ÀûÀ¸·Î Á¸ÀçÇÏ´Â ÄÃ·³
      and sal>(trunc(avg(sal),2));

/*¼±»ı´Ô Ç®ÀÌ*/
select
    empno, ename, sal
from emp
where sal>2077
      and deptno in (10, 30);
--¼­ºêÄõ¸®·Î ÀÛ¼º
select
    empno, ename, sal
from emp
where sal>(select round(avg(sal)) from emp)
      and deptno in (select deptno from emp where ename like '%K%');


--16.Æò±Õ ±Ş¿©°¡ °¡Àå ÀûÀº ¾÷¹«¸¦ Ã£À¸½Ã¿À.
--1. ¾÷¹«º° Æò±Õ±Ş¿©
select
    job, trunc(avg(sal),2)
from emp
group by job;

--2.


--17.´ã´ç ¾÷¹«°¡ MANAGERÀÎ »ç¿øÀÌ ¼Ò¼ÓµÈ ºÎ¼­¿Í µ¿ÀÏÇÑ ºÎ¼­ÀÇ »ç¿øÀ» Ç¥½ÃÇÏ½Ã¿À.
--1. ´ã´ç¾÷¹«°¡ MANAGERÀÎ »ç¿ø
select
    ename, deptno
from emp
where job='MANAGER';

--2.ºÎ¼­¸í È®ÀÎ
select
    ename, d.dname
from emp e, dept d
where
    e.deptno=d.deptno;

--3. ´ã´ç¾÷¹«(job)°¡ MANAGERÀÎ »ç¿øµéÀÇ ºÎ¼­¸í È®ÀÎ    >> µ¿ÀÏºÎ¼­ ¾øÀ½
select
    ename, job, d.dname
from emp e, dept d
where
    e.deptno=d.deptno
    and job='MANAGER';
