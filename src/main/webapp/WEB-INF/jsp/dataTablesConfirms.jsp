<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2017/5/27
  Time: 7:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>DataTablesConfirm</title>
    <!-- DataTables CSS -->
    <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">
    <!-- jQuery -->
    <script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <!-- DataTables -->
    <script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
</head>
<body>
<h1 align="center">员工管理系统</h1>
<table id="example" class="display">
    <thead>
    <tr>
        <th>选择</th>
        <th>员工编号</th>
        <th>员工姓名</th>
        <th>员工职位</th>
        <th>员工薪资</th>
        <th>员工佣金</th>
        <th>入职时间</th>
        <th>详情页面</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
  <%--  <tr>
        <td>Row 1 Data 1</td>
        <td>Row 1 Data 2</td>
        <td>Row 1 Data 1</td>
        <td>Row 1 Data 2</td>
        <td>Row 1 Data 1</td>
        <td>Row 1 Data 2</td>
        <td>Row 1 Data 1</td>
        <td>Row 1 Data 2</td>
    </tr>
    <tr>
        <td>Row 2 Data 1</td>
        <td>Row 2 Data 2</td>
        <td>Row 2 Data 1</td>
        <td>Row 2 Data 2</td>
        <td>Row 2 Data 1</td>
        <td>Row 2 Data 2</td>
        <td>Row 2 Data 1</td>
        <td>Row 2 Data 2</td>
    </tr>
    <tr>
        <td>Row 2 Data 1</td>
        <td>Row 2 Data 2</td>
        <td>Row 2 Data 1</td>
        <td>Row 2 Data 2</td>
        <td>Row 2 Data 1</td>
        <td>Row 2 Data 2</td>
        <td>Row 2 Data 1</td>
        <td>Row 2 Data 2</td>
    </tr>--%>
    </tbody>
    <tfoot></tfoot>
</table>
</body>
<script type="text/javascript">
    $(function(){
        $("#example").DataTable({
            //dataTables属性设置
            "sScrollX"      :   "100%", //表格的宽度
            "sScrollXInner" :   "100%", //表格的内容宽度
            "searching"     :   true,          //取消搜索框 == bFilter
            "ordering"      :   false,           //禁止排序 ，就是禁止标头上的排序箭头
            //"aaSorting"   :   [[0,"asc"]], //给列表排序 ，第一个参数表示数组 (由0开始)。1 表示Browser列。第二个参数为 desc或是asc
            "bLengthChange" :   true,    //每页显示的记录数,禁用左上角的每页显示数的下拉列表
            "bInfo"         :   true,              //禁启左下角的页面数据信息
            //"paging"        :   true,              //禁启右下角的分页功能
            "bPaginate" : true, //是否显示分页
            //"bStateSave"    : true, //保存状态到cookie *************** 很重要 ， 当搜索的时候页面一刷新会导致搜索的消失。使用这个属性就可避免了
            //"sPaginationType" : "two_button", //分页，一共两种样式，full_numbers和two_button(默认)
            //"bAutoWidth"  :   true,   //自适应宽度***不知道怎么回事，没啥明显的效果***
            "processing"    :   true,   //是否显示加载进度
            "serverSide"    :   true,   //启用服务端


            //ajax请求配置
            //ajax请求的相关参数
            "ajax": {
                "url":"/emp/queryEmp",   //请求URL路径
                "type":"GET",       //请求方式
                //"data":[{"dd","mm"},{"",""}],          //传入后台的参数

                "dataSrc":""    //指定json的名称
            },//ajax请求配置的标签结束为止
            //ajax请求返回的数据所对应表格的位置
            "columns" : [
                {
                    "data" : 'EMPNO'
                },
                {
                    "data" : 'EMPNO'
                },
                {
                    "data" : 'ENAME'
                },
                {
                    "data" : 'JOB'
                },
                {
                    "data" : 'SAL'
                },
                {
                    "data" : 'COMM'
                },
                {
                    "data" : 'HIREDATE'
                },
                {
                    "class"     :  'details-control',
                    "orderable" :  false,
                    "data"      :  null,
                    "defaultContent": '+'
                },
                {
                    "data" : 'EMPNO'
                }
            ],//columns配置结束便签位置

            //这里是对表格的渲染，例如：为表格添加一些按钮或超链接等
            columnDefs:[
                {
                    'targets':"",//指定表格的哪一列:从0开始表示列，数字表示第几列，-号表示逆序
                    'searchable':false,//是否可搜索
                    'render': function (data, type, full, meta){
                        return '<input name="items"  type="checkbox" value="'+data+'"  >';
                    }//如何渲染，渲染成什么样子
                },
                {
                    'targets': "",
                    'searchable':false,
                    'render': function (data, type, full, meta){
                        return '<a class="abc" href="javascript:;" onclick="edit(this);return false;">编辑</a>';
                    }
                }
            ],

            //多语言配置
            "oLanguage" : {
                "sLengthMenu" : "每页显示 _MENU_ 条记录",
                "sZeroRecords" : "对不起，查询不到任何相关数据",
                "sInfo" : "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
                "sInfoEmtpy" : "找不到相关数据",
                "sInfoFiltered" : "数据表中共为 _MAX_ 条记录)",
                "sInfoPostFix" : "",
                "sProcessing" : "正在加载中...",
                "sSearch" : "搜索",
                "sUrl" : "", //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
                "sEmptyTable" : "表中数据为空",
                "sLoadingRecords" : "载入中...",
                "sInfoThousands" : ",",
                "oPaginate" : {
                    "sFirst" : "首页",
                    "sPrevious" : " 上一页 ",
                    "sNext" : " 下一页 ",
                    "sLast" : " 尾页 "
                },
                "oAria" : {
                    "sSortAscending" : ": 以升序排列此列",
                    "sSortDescending" : ": 以降序排列此列"
                }
            },
            "bJQueryUI" : false, //可以添加 jqury的ui theme 需要添加css
            //设置每页显示记录的下拉菜单
            "aLengthMenu" : [
                [ 3, 25, 50, -1, 0 ],
                [ "每页3条", "每页25条", "每页50条","显示所有数据", "不显示数据" ]
            ]

        });//DataTables初始化
    });//匿名函数

</script>
</html>