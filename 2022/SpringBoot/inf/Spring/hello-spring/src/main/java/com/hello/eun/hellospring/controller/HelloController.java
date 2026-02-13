package com.hello.eun.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name="name") String name, Model model){
//    public String helloMvc(@RequestParam(name="name", required = true) String name, Model model){

            model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // HTTP의 Body에 이 내용들을 직접 넣겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello "+name; // 이 문자 그대로 내려감.
    }


    // JSON 방식 (key, value)
    @GetMapping("hello-api")
    @ResponseBody // 이 애너테이션을 만나면 HTTP 응답에 이것들을 그냥 넘겨야한다고 인식. => 객체로 왔다. <HttpMessageConverter - JsonConverter / StringConverter 중에서 JsonConverter가 동작> => JSON으로 만들어서 HTTP에 반환하겠다.라고 생각
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();

        hello.setName(name);
        return hello;
    }

    // [Java bean 표준규약]
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
