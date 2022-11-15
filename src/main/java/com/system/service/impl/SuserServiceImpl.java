package com.system.service.impl;

import com.system.mapper.SuserMapper;
import com.system.pojo.Suser;
import com.system.pojo.SuserExample;
import com.system.service.SuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class SuserServiceImpl implements SuserService {

    @Autowired
    private SuserMapper suserMapper;

    @Override
    public void updatePassword(String No, String firstPass) {
        Suser suser = new Suser(No, firstPass, null);
        SuserExample suserExample = new SuserExample();
        suserExample.createCriteria().andUsernameEqualTo(No);
        suserMapper.updateByExampleSelective(suser, suserExample);
    }

    @Override
    public Integer checkExists(SuserExample suserExample) {
//        List<Suser> list = suserService.selectByExample(suserExample);
//        return Integer.parseInt(list.get(0).getType());
        return 0;
    }

    @Override
    public Suser GetUser(SuserExample suserExample) {
        List<Suser> list = suserMapper.selectByExample(suserExample);
        return list.get(0);
    }
}
