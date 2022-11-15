package com.system.service;

import com.system.pojo.Suser;
import com.system.pojo.SuserExample;

import java.util.List;

public interface SuserService {

    Integer checkExists(SuserExample suserExample);

    Suser GetUser(SuserExample suserExample);

    void updatePassword(String No, String fristPass);
}
