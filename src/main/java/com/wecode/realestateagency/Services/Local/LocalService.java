package com.wecode.realestateagency.Services.Local;

import com.wecode.realestateagency.Models.Client.Client;
import com.wecode.realestateagency.Models.Local;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LocalService {

     List<Local> getAllLocals();
     Local addLocal(Local local);
     Local updateLocal(Local local, Long id);
     void deleteLocal(Long id);
     Local getLocalById(Long id);
     List<Local> find(String criteria );
     List<Local> findByAdress(String adress );


}
