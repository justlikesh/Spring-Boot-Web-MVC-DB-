package hello8._hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){  //Model에 담으면 view에 렌더링 할때 쓴다
        model.addAttribute("name", name);

        return "hello-template";
    }

    @GetMapping("hello-string")          // template engine은 화면을 가지고 view 라는 템플릿이 있는 상황에서 거기서 조작하는방식
    @ResponseBody                          //얘는 데이터를 그대로 내려준다 view 따위는 없다
    public String helloString (@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")             //이건 JSON 방식  key : value 로 이루어졌다.
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
