package ru;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class Service {
    List<AllFunc> a = new ArrayList<AllFunc>();

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getTestPage() {
        return "test.html";
    }

    /**
     * creating patient
     * @param w is an Patient object
     */
    @RequestMapping(value = "/home/createpatient", method = RequestMethod.POST)
    @ResponseBody
    public void createpatient(@RequestBody Patient w) {
        a.add(w);
    }

    /**
     * creating patient1
     * @param w is an Patient1 object
     */
    @RequestMapping(value = "/home/createpatient1", method = RequestMethod.POST)
    @ResponseBody
    public void createpatient1(@RequestBody Patient1 w) {
        a.add(w);
    }

    /**
     * deleting all patients
     */
    @RequestMapping(value = "/home/delete", method = RequestMethod.GET)
    public void del() {
        a = new ArrayList<AllFunc>();
    }

    /**
     * shows all existing patients
     */
    @RequestMapping(value = "/home/out", method = RequestMethod.GET)
    @ResponseBody
    public List<AllFunc> out() {
        return a;
    }

}
