package com.example.exempmanagementagena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exempmanagementagena.domain.Administrator;
import com.example.exempmanagementagena.form.InsertAdministratorForm;
import com.example.exempmanagementagena.form.LoginForm;
import com.example.exempmanagementagena.service.AdministratorService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    // @Autowired
    // private HttpSession session;

    @RequestMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form) {

        return "administrator/insert";
    }

    @PostMapping("/insert")
    public String insert(InsertAdministratorForm form) {
        Administrator administrator = new Administrator();

        administrator.setName(form.getName());
        administrator.setMailAddress(form.getMailAddress());
        administrator.setPassword(form.getPassword());

        administratorService.insert(administrator);

        return "redirect:/toInsert/";
    }

    // @PostMapping("/login")
    // public String login(LoginForm form, Model model) {
    // return null;
    // }
}
