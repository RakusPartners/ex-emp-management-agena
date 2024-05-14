package com.example.exempmanagementagena.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exempmanagementagena.domain.Administrator;
import com.example.exempmanagementagena.repository.AdministratorRepository;

@Service
@Transactional
public class AdministratorService {

    /**
     * 管理者情報を操作するサービス
     */

    @Autowired
    private AdministratorRepository administratorRepository;

    public void insert(Administrator administrator) {
        administratorRepository.insert(administrator);
    }

    public Administrator login(String mailAddress, String password) {
        return administratorRepository.findByMailAddressAndPassword(mailAddress, password);
    }
}
