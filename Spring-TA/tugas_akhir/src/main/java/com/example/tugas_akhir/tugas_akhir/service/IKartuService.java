package com.example.tugas_akhir.tugas_akhir.service;

import java.util.List;

import com.example.tugas_akhir.tugas_akhir.model.Kartu;

public interface IKartuService {
    public Kartu insertKartu(Kartu kartu);
    public List<Kartu> getAllKartu();
    public Kartu updateKartu(int id ,Kartu kartu);
    public Kartu deleteKartu(int id);
    
}
