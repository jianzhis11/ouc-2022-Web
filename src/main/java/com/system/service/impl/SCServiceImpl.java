package com.system.service.impl;

import com.system.mapper.SCMapper;
import com.system.pojo.SC;
import com.system.pojo.SCExample;
import com.system.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SCService")
public class SCServiceImpl implements SCService {

    @Autowired
    private SCMapper scMapper;

    @Override
    public List<SC> getStuSC(String sno) {
        SCExample scExample = new SCExample();
        scExample.createCriteria().andSnoEqualTo(sno);
        List<SC> list = scMapper.selectByExample(scExample);
        return list;
    }

    @Override
    public void insertSCInfo(String sno, String cno) {
        SC sc = new SC(sno, cno, null);
        scMapper.insert(sc);
    }
}
