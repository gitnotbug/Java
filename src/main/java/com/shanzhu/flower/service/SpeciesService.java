package com.shanzhu.flower.service;

import com.shanzhu.flower.entity.Species;

import java.util.List;

public interface SpeciesService {

    int add(Species species);
    int delete(int id);
    int update(Species species);
    List<Species> find(String searchKey);
    List<Species> findAll();
}
