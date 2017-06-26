<h1>freemarker接收到的数据</h1>
<table border="1px">
    <thead>
    <th colspan="2">员工列表</th>
    </thead>>
    <tbody>
        <#list empList as emp>
            <tr>
                <td><b>${emp.ENAME}</b></td>
                <td><b>${emp.SAL}</b></td>
            </tr>
        </#list>
    </tbody>
</table>