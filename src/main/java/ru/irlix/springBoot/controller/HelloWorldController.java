package ru.irlix.springBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*@Controller - говорит о том, что данный класс является контроллером.
Контроллеры в Spring обрабатывают HTTP запросы на определенный адреса*/
@Controller
public class HelloWorldController {
    /*Данный метод сработает, если кто-то перейдет по адресу /greeting.*/
    @RequestMapping(value = "/greeting")
    /*@RequestParam говорит о том, что параметр String name - является параметром url.
    В скобках аннотации указано, что данный параметр в url является не обязательным (required = false),
    в случае его отсутствия, значением параметра String name будет World (defaultValue = "World")*/
    public String helloWorldController(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                                       Model model) {
        /*Здесь мы создаем новый атрибут с именем name и присваиваем ему значение параметра name*/
        model.addAttribute("name", name);
        return "greeting";
    }

}
