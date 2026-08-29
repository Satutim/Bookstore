package week2.harjoitukset.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import week2.harjoitukset.domain.Student;

@Controller
public class StudentController {

    public static final List<Student> oppilaat = new ArrayList<>();

    static {
        oppilaat.add(new Student("Aku", "Ankka"));
        oppilaat.add(new Student("Hannu", "Hanhi"));
    }

    @GetMapping("/hello2")
    public String showStudents(Model model) {
        model.addAttribute("students", oppilaat);
        return "studentList";
    }

}
