package ultrasafe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ultrasafe.pojo.AnimalGridResult;
import ultrasafe.pojo.Emp;

/**
 * Created by root on 2017/5/21.
 */
@Controller
@RequestMapping("/highCharts")
public class HighChartsController {

//    @Autowired
//    private EmpService empService;

    //测试请求的是json串(雇员信息)，输出json(雇员信息)
    //@RequestBody将请求的雇员信息的json串转成emp对象
    //@ResponseBody将emp对象转成json输出
    @RequestMapping("/requestJson")
    @ResponseBody
    public List<AnimalGridResult> requestJson() {

		/* 
		 * series : [ { //指定数据列   
		              name : 'Jane', //数据列名   
		              data : [ 1, 0, 4 ] //数据   
		          }, {   
		              name : 'John',   
		              data : [ 5, 7, 3 ]   
		          } ]  
		 */  
		//模拟数据
//		String categories = "[ '狗', '猫', '兔子', '老虎', '大象']";
//		String data = "[10,13,15,17,19]";
		AnimalGridResult animal1 = new AnimalGridResult("狗",(int)(Math.random()*50));
		AnimalGridResult animal2 = new AnimalGridResult("猫",(int)(Math.random()*50));
		AnimalGridResult animal3 = new AnimalGridResult("兔子",(int)(Math.random()*50));
		AnimalGridResult animal4 = new AnimalGridResult("老虎",(int)(Math.random()*50));
		AnimalGridResult animal5 = new AnimalGridResult("大象",(int)(Math.random()*50));
		
		
		//System.out.println("your are the best");
		//初始化数据  
		List<AnimalGridResult> list = new ArrayList<>();
		list.add(animal1);
		list.add(animal2);
		list.add(animal3);
		list.add(animal4);
		list.add(animal5);
    	
        return list; //由于@ResponseBody注解，将itemsCustom转成json格式返回
    }
}
