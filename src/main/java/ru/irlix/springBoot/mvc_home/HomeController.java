package ru.irlix.springBoot.mvc_home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/hello")
    /*@RequestParam используется для установки параметров метода.
    * value = "name": Имя параметра запроса, который ожидается в URL
    * required = false: Указывает, что этот параметр не является обязательным.
    * defaultValue = "Alexandr": Значение по умолчанию для параметра name
    * для установки имени необходимо использовать http://localhost:8080/home?name=Vasya
    * String name: Параметр метода, который будет содержать значение параметра
    * Model model: Объект Model используется для передачи данных в представление*/
    public String home(@RequestParam(value = "name", required = false, defaultValue = "Alexandr")
                                   String name, Model model) {
        /*"message": Имя атрибута
        * "Hello " + name + ", you're home": Значение атрибута.
        * В данном случае создается строка, которая включает значение параметра name.*/
        model.addAttribute("message", "Hello " + name + ", you're home");
        return "home";
    }

}
