package com.system.service;

import com.system.pojo.TC;

import java.util.List;

public interface TCService {
    List<TC> getTeacherTC(String tno);

    void insertTCInfo(String tno, String cno);
}
