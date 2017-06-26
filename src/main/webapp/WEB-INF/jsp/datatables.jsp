<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <!-- DataTables CSS -->
   <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.css">
    <!-- jQuery -->
    <script type="text/javascript" charset="utf8"	src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
    <!-- DataTables -->
    <script type="text/javascript" charset="utf8"	src="http://cdn.datatables.net/1.10.15/js/jquery.dataTables.js"></script>
    <link	href="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"	rel="stylesheet">
    <script	src="https://cdn.bootcss.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
    <title>Insert title here</title>

</head>
<body>
<center>
    <h1>DataTables案例</h1>
</center>

<%--<table id="tab1" class="display text-center">
    <thead>
        <tr>
            <th><input type="checkbox" value="反选" class="btn" id="reverse"> </th>
            <th>用户名</th>
            <th>密码</th>
            <!-- <th>EMPNO</th>
            <th>ENAME</th>
            <th>JOB</th>
            <th>MGR</th>
            <th>SAL</th>
            <th>COMN</th>
            <th>DEPTNO</th>
            <th>HIREDATE</th> -->
            <th>操作</th>
        </tr>
    </thead>
    <tbody></tbody>
</table>--%>
<table id="example" class="display text-center">
    <thead>
    <tr>
        <th><input type="checkbox" value="反选" class="btn" id="reverse"> </th>
        <th>详情</th>
        <th>用户名</th>
        <th>密码</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody></tbody>
</table>
<script type="text/javascript">
    $(document).ready(function() {
        $('#example').dataTable( {
            "sScrollX" : "100%", //表格的宽度
            "sScrollXInner" : "100%", //表格的内容宽度
            "bScrollCollapse" : true, //当显示的数据不足以支撑表格的默认的高度时，依然显示纵向的滚动条。(默认是false)
            //"bPaginate" : true, //是否显示分页
            "bLengthChange" : false, //每页显示的记录数
            "bFilter" : false, //搜索栏
            "bSort" : false, //是否支持排序功能
            "bInfo" : true, //显示表格数据信息
            "bAutoWidth" : true, //自适应宽度
            "aaSorting" : [ [ 1, "asc" ] ], //给列表排序 ，第一个参数表示数组 (由0开始)。1 表示Browser列。第二个参数为 desc或是asc
            // "aoColumns": [{data:'username'},{data:'password'}], //列设置，表有几列，数组就有几项
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url":"${pageContext.request.contextPath }/getJson",
                "type":"GET",
                "dataSrc":""
            },
            "columns" : [{
                "data" : 'USERNAME'
            },{
                "class":          'details-control',
                "orderable":      false,
                "data":           null,
                "defaultContent": '+'
            },{
                "data" : 'USERNAME'
            },{
                "data" : 'PASSWORD'
            }, {
                "data" : 'PASSWORD'
            }],
            columnDefs:[
                {
                    'targets':0,
                    'searchable':false,
                    'render': function (data, type, full, meta){
                        return '<input name="items"  type="checkbox" value="'+data+'"  >';
                    }
                },
                {
                    'targets': -1,
                    'searchable':false,
                    'render': function (data, type, full, meta){
                        return '<a class="abc" href="javascript:;" onclick="edit(this);return false;">编辑</a>';
                    }
                }
            ],
            "bStateSave" : true, //保存状态到cookie *************** 很重要 ， 当搜索的时候页面一刷新会导致搜索的消失。使用这个属性就可避免了
            "sPaginationType" : "full_numbers", //分页，一共两种样式，full_numbers和two_button(默认)
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
                    "sFirst" : "第一页",
                    "sPrevious" : " 上一页 ",
                    "sNext" : " 下一页 ",
                    "sLast" : " 最后一页 "
                },
                "oAria" : {
                    "sSortAscending" : ": 以升序排列此列",
                    "sSortDescending" : ": 以降序排列此列"
                }
            },
            "bJQueryUI" : false, //可以添加 jqury的ui theme 需要添加css
            //设置每页显示记录的下拉菜单
//            "aLengthMenu" : [
//                [ 3, 25, 50, -1, 0 ],
//                [ "每页3条", "每页25条", "每页50条","显示所有数据", "不显示数据" ]
//            ]
            //给每行添加ID用于删除
            "fnRowCallback": function (nRow, aData, iDataIndex) {
                $(nRow).attr("USERNAME", aData['USERNAME']);
                return nRow;
            }

        } );
    } );
</script>

<script type="text/javascript">

    /* Formatting function for row details - modify as you need */
//    function format ( d ) {
//        // `d` is the original data object for the row
//        //return "<span>"+d.USERNAME+"</span>";
//        return '<table id="example" cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
//            '<tr>'+
//            '<td>Full name:</td>'+
//            '<td>'+d.USERNAME+'</td>'+
//            '</tr>'+
//            '<tr>'+
//            '<td>Extension number:</td>'+
//            '<td>'+d.PASSWORD+'</td>'+
//            '</tr>'+
//            '</table>';
//    };
    $(document).ready(function() {
       var table = $('#example').DataTable( {
            "ajax": "${pageContext.request.contextPath }/showDetails",
            "columns": [
                { "data": "USERNAME" },
                { "data": "PASSWORD" }
            ],
            //"dataSrc":"",
            "order": [[1, 'asc']]
        } );
        // Add event listener for opening and closing details
        $('#example tbody').on('click', 'td.details-control', function () {
            var tr = $(this).closest('tr');
            var row = table.row(tr);
            if ( row.child.isShown() ) {
                // This row is already open - close it
                row.child.hide();
                tr.removeClass('shown');
                this.innerText="+";
            }
            else {
                // Open this row
                //var d=row.data.USERNAME;
                $.ajax({
                    type: "GET",
                    url: "${pageContext.request.contextPath }/showDetails",
                    data: {"language":d},
                    dataType: "json",
                    success: function(data){
                        //alert(data[0]);
                        row.child(data[0].desc).show();
                        //row.child(data).show();
                        tr.addClass('shown');
                        this.innerText="-";
//                        $('#resText').empty();   //清空resText里面的所有内容
//                        var html = '';
//                        $.each(data, function(commentIndex, comment){
//                            html += '<div class="comment"><h6>' + comment['username']
//                                + ':</h6><p class="para"' + comment['content']
//                                + '</p></div>';
//                        });
//                        $('#resText').html(html);
                    }
                });
//                row.child(format(row.data())).show();
//                //row.child(data).show();
//                tr.addClass('shown');
//                this.innerText="-";
            }
        } );
    } );


    //反选
    $("#reverse").click(function(){
        $("[name=items]:checkbox").each(function(){ //遍历每一个复选框
            //$(this).attr("checked",!$(this).attr("checked")); //jQuery方法取复选框的反向值
            this.checked=!this.checked; //js方法
        });
    });

    function edit(a){
        //得到当前行对象
        var oTr = a.parentElement.parentElement;
        var aTd = oTr.cells;
        var oTd1 = aTd[2].innerText;
        var oTd2 = aTd[3].innerText;
        if(a.innerText == "编辑"){
            aTd[2].innerHTML="<input id='name' value='"+oTd1+"'>";
            aTd[3].innerHTML="<input id='pass' value='"+oTd2+"'>";
            aTd[4].innerHTML="<a href='javascript:;'  onclick='edit(this);return false;'>保存</a><a href='javascript:;'  onclick='edit(this);return false;'>取消</a>";
        }else if(a.innerText == "取消"){
            aTd[2].innerText=$("#name").val();
            aTd[3].innerText=$("#pass").val();
            aTd[4].innerHTML='<a class="abc" href="javascript:;" onclick="edit(this);return false;">编辑</a>';
        }else{
            aTd[2].innerText=$("#name").val();
            aTd[3].innerText=$("#pass").val();
            aTd[4].innerHTML='<a class="abc" href="javascript:;" onclick="edit(this);return false;">编辑</a>';
        }
    }
</script>

</body>
</html>