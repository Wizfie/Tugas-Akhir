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

import com.example.tugas_akhir.tugas_akhir.model.Anggota;
import com.example.tugas_akhir.tugas_akhir.service.IAnggotaService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/anggota")
public class AnggotaController {

    @Autowired
    IAnggotaService anggotaService;

    @PostMapping("/insert")
    public Anggota insertAnggota(@RequestBody Anggota anggota) {
        return anggotaService.insertAnggota(anggota);
    }

    @GetMapping("/getAll")
    public List<Anggota> getAllAnggota() {
        return anggotaService.getAllAnggota();

    }

    @DeleteMapping("delete/{id}")
    public Anggota deleteAnggota(@PathVariable int id ) {
        return anggotaService.deleteAnggota(id);
    }

    @PutMapping("/update/{id}")
    public Anggota updateAnggota(@PathVariable int id, @RequestBody Anggota anggota) {
        return anggotaService.updateAnggota(id, anggota);
    }

    @GetMapping("/getanggota/{id}")
    public Anggota getAnggotaId(@PathVariable int id) {
        return anggotaService.getAnggotaId(id);
    }

    @GetMapping("/getwarga/{id_kk}")
    public List<Anggota> getwarga(@PathVariable String id_kk){
        return anggotaService.getwarga(id_kk);
    }

     @DeleteMapping("deleteAll/{id_kk}")
    public List<Anggota> deleteAll(@PathVariable int id_kk ) {
        return anggotaService.deleteAll(id_kk);
    }
}
