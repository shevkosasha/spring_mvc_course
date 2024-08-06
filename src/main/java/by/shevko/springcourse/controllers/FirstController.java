package by.shevko.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello_old")
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println(String.format("Hello, %s %s", name, surname));
        return "first/hello";
    }

    @GetMapping("/hello")
    public String helloPage1(@RequestParam("name") String name,
                             @RequestParam(value = "surname", required = false) String surname,
                             Model model){
        String msg = String.format("Hello, %s %s! It's a Spring area!", name, surname);
        System.out.println(msg);
        model.addAttribute("msg", msg);

        return "first/hello";
    }

    @GetMapping("/calc")
    public String calc(@RequestParam("a") String a, @RequestParam("b") String b, @RequestParam("action") String action,
                             Model model){
        double res = doCalc(Double.valueOf(a), Double.valueOf(b), action);
        System.out.println(res);
        model.addAttribute("msg", res);
        return "first/calc";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    private double doCalc(double a, double b, String action){
        switch (action){
            case "m": return a * b;
            case "a": return a + b;
            case "s": return a - b;
            case "d": {
                if (b == 0) {
                    return 0;
                }
                return a / b;
            }
        }
        return 0;
    }
}
