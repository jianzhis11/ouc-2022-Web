package com.system.service;

import com.system.pojo.SC;

import java.util.List;

public interface SCService {
    List<SC> getStuSC(String sno);

    void insertSCInfo(String sno, String cno);
}
