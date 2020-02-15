package com.wecode.realestateagency.Controllers;

import com.wecode.realestateagency.Models.Local;
import com.wecode.realestateagency.Services.Client.ClientServiceImplement;
import com.wecode.realestateagency.Services.Local.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/local/")
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping("list")
    public List<Local> getAllLocals() { return localService.getAllLocals();}

    @PostMapping("add")
    public  Local addLocal(@RequestBody Local local) { return localService.addLocal(local);}

    @PutMapping("update/{id}")
    public Local updateLocal(@Valid @RequestBody Local local, @PathVariable("id") long id){ return localService.updateLocal(local, id); }

    @DeleteMapping("delete/{id}")
    public void deleteLocal(@PathVariable("id") long id){
        localService.deleteLocal(id);
    }

    @GetMapping("localById/{id}")
    public Local getClientById(@PathVariable("id") Long id){ return localService.getLocalById(id); }

    @GetMapping("find/{criteria}")
    public List<Local> find(@PathVariable("criteria")String criteria) {
        return localService.find(criteria);
    }

    @GetMapping("findByAddress/{address}")
    public List<Local> findByAddress(@PathVariable("address")String address) {
        return localService.findByAdress(address);
    }

    @RequestMapping(value="upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        File convertFile = new File("C:\\Users\\Bassem's PC\\Desktop\\DSI3\\stage perfectionnement\\real estate agency back\\src\\main\\resources\\Images"+ file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<>("File is uploaded ", HttpStatus.OK) ;
    }




}
