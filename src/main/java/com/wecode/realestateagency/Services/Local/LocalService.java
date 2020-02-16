package com.wecode.realestateagency.Services.Local;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wecode.realestateagency.Models.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Observable;


public interface LocalService {

     List<Local> getAllLocals();
     Local addLocal(Local local);
     String[] uploadFile(MultipartFile file) throws IOException;
     Local updateLocal(Local local, Long id);
     void deleteLocal(Long id);
     Local getLocalById(Long id);
     List<Local> find(String criteria );
     List<Local> findByAdress(String adress );


}
