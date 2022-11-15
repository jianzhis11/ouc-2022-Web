package com.system.service.impl;

import com.system.mapper.TCMapper;
import com.system.pojo.SC;
import com.system.pojo.TC;
import com.system.pojo.TCExample;
import com.system.service.TCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TCService")
public class TCServiceImpl implements TCService {

    @Autowired
    private TCMapper tcMapper;
    @Override
    public List<TC> getTeacherTC(String tno) {
        TCExample tcExample = new TCExample();
        tcExample.createCriteria().andTnoEqualTo(tno);
        List<TC> list = tcMapper.selectByExample(tcExample);
        return list;
    }

    @Override
    public void insertTCInfo(String tno, String cno) {
        TC tc = new TC(tno, cno);
        tcMapper.insert(tc);
    }
}
