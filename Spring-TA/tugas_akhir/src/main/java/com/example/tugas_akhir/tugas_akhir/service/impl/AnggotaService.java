package com.example.tugas_akhir.tugas_akhir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tugas_akhir.tugas_akhir.model.Anggota;
import com.example.tugas_akhir.tugas_akhir.repository.IAnggotaRepository;
import com.example.tugas_akhir.tugas_akhir.service.IAnggotaService;

@Service
public class AnggotaService implements IAnggotaService {

    @Autowired
    IAnggotaRepository AnggotaRepository;

    @Override
    public Anggota insertAnggota(Anggota anggota) {
        // TODO Auto-generated method stub
        return AnggotaRepository.insertAnggota(anggota);
    }

    @Override
    public List<Anggota> getAllAnggota() {
        // TODO Auto-generated method stub
        return AnggotaRepository.getAllAnggota();
    }

    @Override
    public Anggota updateAnggota(int id, Anggota anggota) {
        // TODO Auto-generated method stub
        return AnggotaRepository.updateAnggota(id, anggota);
    }

    @Override
    public Anggota deleteAnggota(int id) {
        // TODO Auto-generated method stub
        return AnggotaRepository.deleteAnggota(id);
    }

    @Override
    public Anggota getAnggotaId(int id) {
        // TODO Auto-generated method stub
        return AnggotaRepository.getAnggotaId(id);
    }

}
