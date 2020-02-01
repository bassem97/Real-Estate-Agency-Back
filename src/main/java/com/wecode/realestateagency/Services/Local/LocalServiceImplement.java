package com.wecode.realestateagency.Services.Local;

import com.wecode.realestateagency.Models.Local;
import com.wecode.realestateagency.Repositories.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value="localService")
public class LocalServiceImplement implements LocalService {

    @Autowired
    private LocalRepository localRepository;

    @Override
    public List<Local> getAllLocals() { return localRepository.findAll();}

    @Override
    public Local addLocal(Local local) { return localRepository.saveAndFlush(local);}

    @Override
    public Local updateLocal(Local local, Long id) {
        if(localRepository.findById(id).isPresent()){
            Local lc= localRepository.findById(id).get();
            lc.setDescription(local.getDescription());
            lc.setAddress(local.getAddress());
            lc.setArea(local.getArea());
            lc.setPrice(local.getPrice());
            lc.setRoomsNumber(local.getRoomsNumber());
            lc.setTransactionType(local.getTransactionType());
            lc.setType(local.getType());
            return localRepository.saveAndFlush(lc);
        }else return null;
    }

    @Override
    public void deleteLocal(Long id) { localRepository.deleteById(id);}

    @Override
    public Local getLocalById(Long id) { return localRepository.findById(id).isPresent() ? localRepository.findById(id).get() : null;}

    @Override
    public List<Local> find(String criteria) {
        return localRepository.find(criteria);
    }

    @Override
    public List<Local> findByAdress(String address) {
        return localRepository.findByAddress(address);
    }
}
