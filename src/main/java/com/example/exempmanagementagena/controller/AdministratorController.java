package com.example.exempmanagementagena.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exempmanagementagena.form.InsertAdministratorForm;
import com.example.exempmanagementagena.service.AdministratorService;

@Controller
@RequestMapping("/")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @RequestMapping("/toInsert")
    public String toInsert(InsertAdministratorForm form) {

        return "administrator/insert";
    }
}
