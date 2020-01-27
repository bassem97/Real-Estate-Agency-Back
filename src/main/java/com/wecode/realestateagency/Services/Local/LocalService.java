package com.wecode.realestateagency.Services.Local;

import com.wecode.realestateagency.Models.Client.Client;
import com.wecode.realestateagency.Models.Local;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LocalService {

    public List<Local> getAllLocals();
    public Local addLocal(Local local);
    public Local updateLocal(Local local, Long id);
    public void deleteLocal(Long id);
    public Local getLocalById(Long id);

}
