package com.company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.concurrent.atomic.AtomicLong;
import java.util.LinkedList;
@RestController
@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
public class helloController {

    @Autowired
    private CustomerRepository repository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
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

    @RequestMapping("/getCustomer")
    public String dataCustomer()
    {
        LinkedList<Customer> customerList = new LinkedList<Customer>();
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            customerList.add(customer);
        }
        return customerList.toString();
    }

    @RequestMapping("/addCustomer")
    public String addCustomer(String firstName, String secondName)
    {
//localhost80880/addCustomer
        // save a couple of customers
        repository.save(new Customer(firstName, secondName));

        return firstName+secondName+" customer added sucsessfully";
    }
/*
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


*/

}//how to send ajax request via jquery
