<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>freemarker案例</title>
</head>

<body>
    <h1>${username}</h1>


    <h3>-----------------------时间对象的处理--------------------------</h3>
    ${date?string("yyyy-MM-dd HH:mm:ss")}<br>
    ${date?string("yyyy-MM-dd HH:mm:ss zzzz")} <br>
    ${date?string("EEE, MMM d, ''yy")} <br>
    ${date?string("EEEE, MMMM dd, yyyy, hh:mm:ss a '('zzz')'")} <br>



    <h1>-------------------------字符串截取操作------------------------</h1>
    <#assign number="01234">
    ${number[0]} <#-- 输出字符0 -->
    ${number[0..3]} <#-- 输出子串“0123” -->

    <br>
    <h1>------------------------ 字符串拼接 -------------------------</h1>
    ${"Hello, ${username}"}
    ${"Hello, " + username + "!"}                  




    <h5>-------------------------ifelse操作------------------------</h5>
    <#assign num = 18>
    <#if num gt 18>
        你是成人了，应该长大了。
    <#else >
        你还是孩子，这次原谅你了
    </#if><br>



    <#assign score = 60>
    <#if score gte 90>
        优秀！
    <#elseif score gte 80 >
        良好！
    <#elseif score gte 70 >
        挺好！
    <#elseif score gte 60 >
        及格！
    <#else >
        你也太差劲了！
    </#if><br>






    <hr>
    <h5>-------------------------内建函数------------------------</h5>
    ${html2}原型<br>
    ${html2?cap_first}----首字母大写<br>
    ${html2?lower_case}---全小写<br>
    ${html2?upper_case}---全大写<br>
    ${list?size}---获取集合的长度<br>



    <hr>
    <h5>-------------------------输出map元素------------------------</h5>
<#--    ${user.address.country}<br>
    ${user.address["country"]}<br>
    ${user["address"].country}<br>
    ${user["address"]["country"]}<br>-->



    <hr>
    <h5>-------------------------空值的处理------------------------</h5>
    <#--${null} 没有定义这个变量，会报异常！-->
    ${null!} <#--没有定义这个变量，默认值是空字符串！ -->
    ${null!"undefined"} <#--没有定义这个变量，默认值是字符串abc！ -->

    <#-- 判断是否有变量返回boolean类型,??运算符返回布尔值，如：variable??，如果变量存在，返回true，否则返回false。 -->
    <#assign user="小先生"><br>
    <#if user??>Welcome ${user}</#if>





    <h5>-------------------------list标签------------------------</h5>
    <#list list as list >
        ${list_index}--${list.country}---${list.city}<#if list_has_next>---我下边有人</#if><br>
    </#list>

    <#list ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天"] as x> 
     ${x} 
    </#list> 

    <h5>-------------------------include标签------------------------</h5>
    <#include "include.txt">



    <h5>---------自定义指令(macro指令)自定义指令(macro指令)---------</h5>
    <#macro test>
        <b>BruceLee</b><br>
        <b>freemarker</b>
    </#macro>
    <#-- 调用自定义指令 -->
    <@test></@test><br>
    <#macro person name age sex>
        ${name} -- ${age} -- ${sex}
    </#macro>
    <@person name="小先生" age="15" sex="男" />

    <#macro nest>
        <table border=4 cellspacing=0 cellpadding=4><tr><td>
            <#nested>
        </td></tr></table>
    </#macro>
    <@nest >表格中的内容！</@nest>






    <h5>-------------------------命名空间-------------------------</h5>
    <#import "copyright.ftl" as bb  />
    <@bb.copyright date="2009-2017" />
    ${bb.mail}<br>
    <#assign mail="my@163.com"  />
    ${mail}<br>
    <#assign mail="my@163.com" in bb  />
    ${bb.mail}<br>





    <h5>-------------------------算术运算-------------------------</h5>
    <#assign x = 5> 
    ${ x * x - 100 } 
    ${ x / 2 } 
    ${ 12 % 10 } 

    <br>
    <#assign x=5> 
    ${ (x/2)?int } 
    ${ 1.1?int } 
    ${ 1.999?int } 
    ${ -1.1?int } 
    ${ -1.999?int } 


    <h5>-------------------------逻辑运算-------------------------</h5>



</body>
</html>