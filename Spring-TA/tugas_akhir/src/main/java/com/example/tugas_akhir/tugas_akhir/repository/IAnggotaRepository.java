package com.example.tugas_akhir.tugas_akhir.repository;

import java.util.List;

import com.example.tugas_akhir.tugas_akhir.model.Anggota;

public interface IAnggotaRepository {

    public Anggota insertAnggota(Anggota anggota);

    public List<Anggota> getAllAnggota();

    public Anggota updateAnggota(int id, Anggota anggota);

    public Anggota deleteAnggota(int id);

    public Anggota getAnggotaId(int id);

}
