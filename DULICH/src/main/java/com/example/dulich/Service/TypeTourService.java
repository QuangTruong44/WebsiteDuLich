package com.example.dulich.Service;

import com.example.qldl.Entity.TypeTourE;

import java.util.List;

public interface TypeTourService {
    List<TypeTourE> getAllTypeTourE();
    List<TypeTourE> getTypeTourEByTypeName(String type_Name);

}
