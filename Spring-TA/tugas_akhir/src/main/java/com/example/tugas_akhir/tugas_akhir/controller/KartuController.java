package com.example.tugas_akhir.tugas_akhir.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tugas_akhir.tugas_akhir.model.Kartu;
import com.example.tugas_akhir.tugas_akhir.service.IKartuService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/kartu")

public class KartuController {

    

    @Autowired IKartuService kartuService;

    @PostMapping("/insert")
    public Kartu insertKartu(@RequestBody Kartu kartu ){
        return kartuService.insertKartu(kartu);
    }
    @GetMapping("/getAll")
    public List<Kartu> getAllkartu(){
        return kartuService.getAllKartu();
    }
    @DeleteMapping("/delete/{id}")
    public Kartu deleteKartu(@PathVariable int  id){
        return kartuService.deleteKartu(id);
    }

    @PutMapping("/update/{id}")
    public Kartu updateKartu(@PathVariable int id , @RequestBody Kartu kartu){
        return kartuService.updateKartu(id, kartu);
    }

    
}
