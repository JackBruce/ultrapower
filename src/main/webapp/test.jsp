<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2017/5/27
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Generator" content="EditPlus®">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>Document</title>
    <!-- 本地 -->

    <link rel="stylesheet" type="text/css" href="DataTables-1.10.15/media/css/jquery.dataTables.css">

    <script type="text/javascript" charset="utf8" src="DataTables-1.10.15/media/js/jquery.js"></script>


    <script type="text/javascript" charset="utf8" src="DataTables-1.10.15/media/js/jquery.dataTables.js"></script>
    <!-- ***************************************** -->
    <style type="text/css">
        td.details-control {
            background: url('uof.ico') no-repeat center center;
            cursor: pointer;
        }
        tr.shown td.details-control {
            background: url('wpp.ico') no-repeat center center;
        }
    </style>
</head>
<body>
<table id="example" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th></th>
        <th>Name</th>
        <th>Position</th>
        <th>Office</th>
        <th>Salary</th>
    </tr>
    </thead>
    <tbody></tbody>
    <tfoot>
    <tr>
        <th></th>
        <th>Name</th>
        <th>Position</th>
        <th>Office</th>
        <th>Salary</th>
    </tr>
    </tfoot>
</table>
<script type="text/javascript">
    /* Formatting function for row details - modify as you need */
    function format ( d ) {
        // `d` is the original data object for the row
        return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
            '<tr>'+
            '<td>Full name:</td>'+
            '<td>'+d.name+'</td>'+
            '</tr>'+
            '<tr>'+
            '<td>Extension number:</td>'+
            '<td>'+d.position+'</td>'+
            '</tr>'+
            '<tr>'+
            '<td>Extra info:</td>'+
            '<td>And any further details here (images etc)...</td>'+
            '</tr>'+
            '</table>';
    }
    $(document).ready(function() {
        var table = $('#example').DataTable( {
            "ajax": "source.txt",
            "columns": [
                {
                    "class":          'details-control',
                    "orderable":      false,
                    "data":           null,
                    "defaultContent": ''
                },
                { "data": "name" },
                { "data": "position" },
                { "data": "office" },
                { "data": "salary" }
            ],
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
            }
            else {
                //根据配置Id 异步查询数据
                $.get("detail.txt",
                    function(json) {
                        //var array = json.data;
                        //alert(json);
                        //format(json);
                        row.child(json).show();
                        tr.addClass('shown');
                    }
                );
            }
        } );
    } );
</script>
</body>
</html>

