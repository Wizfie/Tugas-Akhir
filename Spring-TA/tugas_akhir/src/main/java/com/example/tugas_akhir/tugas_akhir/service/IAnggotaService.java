package com.example.tugas_akhir.tugas_akhir.service;

import java.util.List;

import com.example.tugas_akhir.tugas_akhir.model.Anggota;

public interface IAnggotaService {
    public Anggota insertAnggota(Anggota anggota);

    public List<Anggota> getAllAnggota();

    public Anggota updateAnggota(int id, Anggota anggota);

    public Anggota deleteAnggota(int id);

    public Anggota getAnggotaId(int id);

    public List<Anggota> getwarga(String id_kk);

    public List<Anggota> deleteAll(int id_kk);
}
