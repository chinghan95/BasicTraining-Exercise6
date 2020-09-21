package com.pegatron.exercise6.controller;

import com.pegatron.exercise6.model.Bookstore;
import com.pegatron.exercise6.service.ExerciseService;

import com.pegatron.exercise6.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bookstore")
public class BookstoreController {

    @Autowired
    private ExerciseService service;

    /*
     * This method will list all existing bookstores.
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listBookstore(ModelMap model) {
        List<Bookstore> bookstoreList = service.findAllBookstores(Bookstore.class);
        model.addAttribute("bookstoreList", bookstoreList);
        return "bookstore/list";
    }

    /*
     * This method will provide the medium to add a new bookstore
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showBookstoreForm(ModelMap model) {
        Bookstore bookstore = new Bookstore();
        model.addAttribute("bookstore", bookstore);
        return "bookstore/form";
    }

    /*
     * This method will provide the medium to update an existing bookstore.
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editBookstore(HttpServletRequest request, ModelMap model) {
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        Bookstore bookstore = service.getBookstore(storeId);
        model.addAttribute("bookstore", bookstore);
        return "bookstore/form";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * saving bookstore in database.
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBookstore(@ModelAttribute Bookstore bookstore) {
        service.saveOrUpdate(bookstore);
        return "redirect:/bookstore/list";
    }

    /*
     * This method will delete a bookstore.
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteBookstore(HttpServletRequest request) {
        int storeId = Integer.parseInt(request.getParameter("storeId"));
        Bookstore bookstore = new Bookstore(storeId);
        service.delete(bookstore);
        return "redirect:/bookstore/list";
    }




    private static List<Person> persons = new ArrayList<Person>();

    static {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        String message = "Hello Spring Boot + JSP";

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        model.addAttribute("persons", persons);

        return "personList";
    }

}
