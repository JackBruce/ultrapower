<%@ page language="java" pageEncoding="UTF-8"	contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Highcharts Example</title>

<!-- 
	<script type="text/javascript" src="../../lib/jquery-1.12.1.min.js"></script>
	<script type="text/javascript" src="../../lib/highCharts/highcharts.js" charset="utf-8"></script>
	<script type="text/javascript" src="../../lib/highCharts/modules/funnel.js"></script>
	<script type="text/javascript" src="../../lib/highCharts/highcharts-more.js"></script>
	<script type="text/javascript" src="../../lib/highCharts/themes/dark-blue.js"></script>这个是主题 
-->
	<!-- jQuery -->
	<script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
	<script src="http://cdn.hcharts.cn/highcharts/modules/funnel.js"></script>
	<script src="http://cdn.hcharts.cn/highcharts/highcharts-more.js"></script>
	<script src="http://cdn.hcharts.cn/highcharts/themes/dark-blue.js"></script>
	
	

</head>
<body>
	<div id="container"  style="width:80%;height:300px;border:1px solid green;"></div>
	<div id="container1" style="width:80%;height:300px;border:1px solid blue;"></div>
	
	
	<script type="text/javascript">

	var categories="";
	var data = "";
	//创建图表
	var chart;
	$(document).ready(function() {
		chart = new Highcharts.Chart({
			chart : {
				renderTo : 'container', // 注意这里一定是 ID 选择器,指定图表创建的位置
				type : 'bar',
				events : {
					load : st
				// 定时器
				}
			},
			//标题的设置
			title : {
				text : '生物生存数量统计',//标题
				align:"center",  //文字水平对齐方式，left,center,right
				verticalAlign:"",//文字垂直对齐方式，有top、middle、bottom可选
				useHTML:false,//是否解析html标签，设置解析后，可以使用例如a等html标签			
				floating:false,//是否浮动，设置浮动后，标题将不占用图表区位置			
				margin:30,//标题和图表区的间隔，当有副标题时，表示标题和副标题之间的间隔		
				//文字样式，可以设置文字颜色、字体、字号，注意和css有略微的不同，例如font-size用fontSize、font-family用fontFamily表示
			/* 	style{
				  color: '#4532sd',
				  fontSize: '16px'
				},  */
				//x:0,//相对于水平对齐的偏移量，可以是负数，单位是px				
				//y:0//相对于垂直对齐的偏移量，可以使负数，单位是px				
			},
			//副标标题的设置,属性和主标题相同
			subtitle : {
				text : '动物数量统计'
			},
			//设置图表的横纵坐标			
			xAxis : {
				categories : categories,
				title : {
					text : '动物种类'
				}

			},
			yAxis : {
				min : 0,
				title : {
					text : '动物存活的数量'
				},
				//坐标轴标签（分类）。Labels常用属性有enabled、formatter（标签格式化）、step、staggerLines
			 	labels: {
				    formatter:function(){
				      //this.value代码坐标轴上当前点的值（也就是x轴当前点的x值，y轴上当前点的y值），除了value变量外，还有axis、chart、isFirst、isLast可用
				      if(this.value <=20) { 
				        return "第一等级("+this.value+")";
				      }else if(this.value >20 && this.value <=40) { 
				        return "第二等级("+this.value+")"; 
				      }else { 
				        return "第三等级("+this.value+")";
				      }
				   },
				  //Labels显示间隔，数据类型为number（或int）
				  step:2,
				  gridLineWidth:"2px",
				  gridLineColor:"#c0c0c0",
				  gridLineDashStyle:"Dot"
				},
				
				
			},
			//是否启用坐标轴，默认为true，如果不想启用，设为false
			legend : {
				enabled : false
			},
			//数据提示框
			tooltip : {
				formatter : function() {
					return '' + this.series.name + ': ' + this.y + '';
				}
			},
			//版权标签
			credits : {
				enabled : false
			},
			plotOptions : {
				series : {
					stacking : 'normal'
				}
			},
			//数据列，核心部位
			series : [ {
				name : '个',
				data : data,
				//color:"#ff0000",//设置柱状图的颜色
				zoneAxis: 'x',
				//zones 默认的是针对 Y 轴，可以通过 zoneAxis = x 来指定当前配置是针对 x 轴
	            zones: [{
	                value:8 ,//表示对小于这个值的区域有效（或区域上界）
	                //color: //对当前范围设置颜色
	                //dashStyle: //对当前范围设置线条样式
	                //fillColor: //对当前范围设置填充颜色（针对面积图）
	            }, {
	                dashStyle: 'dot'//对当前范围设置线条样式
	            }]
			} ],
			//我们可以通过colorByPoint,很重要的参数，好好利用
		/* 	plotOptions:{
				column:{
					colorByPoint:true
				}
			}, */
			style: {
			    color: '#ffcc00',
			    fontSize: "12px",
			    fontWeight: "blod",
			    fontFamily: "Courier new"
			}
		});

	});

	//1秒钟刷新一次数据
	function st() {
		setInterval("getData()", 1000);
	}

	//动态更新图表数据
	function getData() {

		var categories = [];
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/highCharts/requestJson",

			dataType : "json",
			success : function(data) {
				var d = [];
				$(data).each(function(n, item) {
					d.push(item.data);
					categories.push(item.categories);
				})
				chart.series[0].setData(d);
				chart.xAxis[0].setCategories(categories);
			}
		});
	}
</script>
<script type="text/javascript">  
    function chart1(){  
        $('#container1').highcharts({  
            chart: {  
                type: 'column'  
            },  
            title: {  
                text: 'Fruit Consumption'  
            },  
            xAxis: {  
                categories: ['Apples', 'Bananas', 'Oranges']  
            },  
            yAxis: {  
                title: {  
                    text: 'Fruit eaten'  
                }  
            },  
            series: [{  
                name: 'Jane',  
                data: [1, 0, 4]  
            }, {  
                name: 'John',  
                data: [5, 7, 3]  
            }]  
        });  
    }  
      
    function chart2(){  
        var chart = new Highcharts.Chart({  
            chart: {  
                renderTo:'container1',//目标容器  
                type: 'column'  
            },  
            title: {  
                text: 'Fruit Consumption'  
            },  
            xAxis: {  
                categories: ['Apples', 'Bananas', 'Oranges']  
            },  
            yAxis: {  
                title: {  
                    text: 'Fruit eaten'  
                }  
            },  
            series: [{  
                name: 'Jane',  
                data: [1, 0, 4]  
            }, {  
                name: 'John',  
                data: [5, 7, 3]  
            }]  
        });  
    }  
      
      
    function chart3(){  
        var option = new Object();  
        option.chart = new Object();  
        option.chart.type="column";  
        option.chart.renderTo="container1";
        option.chart.events="st1";
          
        option.title={title:"水果的摄入"};  
          
        option.xAxis={categories:['苹果','香蕉','桔子'],gridLineWidth:1};  
        option.yAxis={title:{text:"吃水果的量"},tickInterval:1};  
          
        option.series = new Array();  
        option.series[0] = new Object();  
        option.series[0].name="张三";  
        option.series[0].data=[1,3,5];  
          
        option.series[1] = new Object();  
        option.series[1].name="李四";  
        option.series[1].data=[6,1,5.5];  
          
        option.series[2] = new Object();  
        option.series[2].name="刘能";  
        option.series[2].data=[3,1,0.3];  
          
        var chart = new Highcharts.Chart(option);  
    }  
    $(function () {   
        //chart1();  
        //chart2();  
        chart3();
      //1秒钟刷新一次数据
    	function st1() {
    		setInterval("getData()", 1000);
    	}

    	//动态更新图表数据
    	function getData1() {

    		var categories = [];
    		$.ajax({
    			type : "post",
    			url : "${pageContext.request.contextPath}/FruitServlet",

    			dataType : "json",
    			success : function(data) {
    				/* var d = [];
    				$(data).each(function(n, item) {
    					d.push(item.data);
    					categories.push(item.categories);
    				})
    				chart.series[0].setData(d);
    				chart.xAxis[0].setCategories(categories); */
    			}
    		});
    	}
    });  
</script>  
</body>
</html>