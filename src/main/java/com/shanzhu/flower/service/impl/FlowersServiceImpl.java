package com.shanzhu.flower.service.impl;

import com.shanzhu.flower.dao.FlowersDao;
import com.shanzhu.flower.entity.Flower;
import com.shanzhu.flower.service.FlowersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FlowersServiceImpl implements FlowersService {

    @Resource
    private FlowersDao flowersDao;

    @Override
    public int add(Flower flower) {
        return flowersDao.add(flower);
    }

    @Override
    public int delete(int id) {
        return flowersDao.delete(id);
    }

    @Override
    public int update(Flower flower) {
        return flowersDao.update(flower);
    }

    @Override
    public List<Flower> find(String searchKey,String searchType) {
        return flowersDao.find(searchKey,searchType);
    }

    @Override
    public List<Flower> findAll(String searchKey) {
        return flowersDao.findAll(searchKey);
    }

    @Override
    public int updateImg(String img_guid,Integer id) {
        return flowersDao.updateImg(img_guid,id);
    }
}
