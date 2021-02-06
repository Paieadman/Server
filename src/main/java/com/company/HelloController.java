package com.company;
import com.company.entity.DishEntity;
import com.company.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class HelloController {

    @Autowired
    private DishRepository dishRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/heyhey")
    public Iterable<DishEntity> index() {
        return dishRepository.findAll();
    }

    @RequestMapping("/hi")
    public String hi(){
        return "greeting traer";
    }

    @RequestMapping("/smth")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "great";
    }


    @RequestMapping("/menu")
    public String menu()
    {
        return "menu";
    }

    @RequestMapping("/menu/accept")
    public String accept()
    {
        return "accept";
    }

    @RequestMapping("/orders")
    public String getOrders(){
        return "order";
    }

    @RequestMapping("/orders/{id}/edit")
    public String changeOrder()
    {
        return "changeOrder";
    }

    @RequestMapping("/orders/{id}/delete")
    public String deleteOrder()
    {
        return "deleteOrder";
    }

    @PostMapping("/orders/create")
    public String create()
    {
        return "deleteOrder";
    }

    @PostMapping("/login")
    public String login(){
        return "success";
    }

    @RequestMapping("/logOut")
    public String logOut(){
        return "logOut";
    }

    @PostMapping("/info")
    public String info()
    {
        return "info";
    }

    @RequestMapping("/menu/edit")
    public String changeMenu() {return "changeMenu"; }

    @PostMapping("/info/all")
    public String infoAboutAll()
    {
        return "infoAboutAll";
    }



}//how to send ajax request via jquery
