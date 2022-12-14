package com.example.tugas_akhir.tugas_akhir.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tugas_akhir.tugas_akhir.model.Kartu;
import com.example.tugas_akhir.tugas_akhir.repository.IKartuRepository;
import com.example.tugas_akhir.tugas_akhir.service.IKartuService;

@Service
public class KartuService  implements IKartuService{
    @Autowired
    IKartuRepository kartuRepository;

    @Override
    public Kartu insertKartu(Kartu kartu) {
        // TODO Auto-generated method stub
        return kartuRepository.insertKartu(kartu);
    }

    @Override
    public List<Kartu> getAllKartu() {
        // TODO Auto-generated method stub
        return kartuRepository.getAllKartu();
    }

    @Override
    public Kartu updateKartu(int id, Kartu kartu) {
        // TODO Auto-generated method stub
        return kartuRepository.updateKartu(id, kartu);
    }

    @Override
    public Kartu deleteKartu(int id) {
        // TODO Auto-generated method stub
        return kartuRepository.deleteKartu(id);
    }


}
