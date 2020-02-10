package com.wecode.realestateagency.Services.Local;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wecode.realestateagency.Models.Local;

import java.util.List;
import java.util.Observable;


public interface LocalService {

     List<Local> getAllLocals();
     Local addLocal(Local local);
     Local updateLocal(Local local, Long id);
     void deleteLocal(Long id);
     Local getLocalById(Long id);
     List<Local> find(String criteria );
     List<Local> findByAdress(String adress );


}
