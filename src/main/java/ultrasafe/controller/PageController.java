package ultrasafe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by root on 2017/5/24.
 */@Controller
public class PageController {

    @RequestMapping("/goDataTables")
    public String goDataTables(){
         return "datatables";
     }
    @RequestMapping("/goHighCharts")
    public String goHighCharts(){
         return "highcharts";
     }
    @RequestMapping("/dtConfirm")
    public String goDtConfirm(){
        return "dataTablesConfirm";
    }
}
