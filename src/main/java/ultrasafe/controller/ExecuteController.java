package ultrasafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ultrasafe.service.ExecuteService;

/**
 * Created by root on 2017/6/1.
 */
@Controller
@RequestMapping("/execute")
public class ExecuteController {
    @Autowired
    private ExecuteService executeService;

    @RequestMapping("/execute1")
    @ResponseBody
    public void execute(){
        executeService.execute();
    }

    @RequestMapping("/preparedStatement")
    @ResponseBody
    public int preparedStatement(){
        return executeService.preparedStatement();
    }


    @RequestMapping("/preparedStatementCallBacker/{deptno}")
    @ResponseBody
    public Integer preparedStatementCallBacker(@PathVariable String deptno){
        return executeService.preparedStatementCallBacker(deptno);
    }

    @RequestMapping("/statement")
    @ResponseBody
    public  void testpreparedStatementCallbacker(){
        executeService.preparedStatement();
    }

    @RequestMapping("/test")
    @ResponseBody
    public void test(){
        executeService.test();
    }
}
