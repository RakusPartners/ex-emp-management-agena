package com.example.exempmanagementagena.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exempmanagementagena.repository.AdministratorRepository;

@Service
@Transactional
public class AdministratorService {

    /**
     * 管理者情報を操作するサービス
     */

    @Autowired
    private AdministratorRepository administratorRepository;
}
