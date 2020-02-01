package com.wecode.realestateagency.Controllers;

import com.wecode.realestateagency.Models.Local;
import com.wecode.realestateagency.Services.Client.ClientServiceImplement;
import com.wecode.realestateagency.Services.Local.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Local/")
public class LocalController {

    @Autowired
    private LocalService localService;

    @GetMapping("list")
    public List<Local> getAllLocals() { return localService.getAllLocals();}

    @PostMapping("add")
    public Local addLocal(Local local) { return localService.addLocal(local);}

    @PutMapping("update/{id}")
    public Local updateLocal(@Valid @RequestBody Local local, @PathVariable("id") long id){ return localService.updateLocal(local, id); }

    @DeleteMapping("delete/{id}")
    public void deleteLocal(@PathVariable("id") long id){
        localService.deleteLocal(id);
    }

    @GetMapping("LocalById/{id}")
    public Local getClientById(@PathVariable("id") Long id){ return localService.getLocalById(id); }

    @GetMapping("find/{criteria}")
    public List<Local> find(@PathVariable("criteria")String criteria) {
        return localService.find(criteria);
    }

    @GetMapping("findByAddress/{address}")
    public List<Local> findByAddress(@PathVariable("address")String address) {
        return localService.findByAdress(address);
    }




}
