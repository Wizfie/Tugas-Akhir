package com.example.tugas_akhir.tugas_akhir.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.tugas_akhir.tugas_akhir.model.Kartu;
import com.example.tugas_akhir.tugas_akhir.repository.IKartuRepository;

@Repository
public class KartuRepository implements IKartuRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Kartu insertKartu(Kartu kartu) {
        // TODO Auto-generated method stub
        String query = "INSERT INTO tb_kartu_keluarga(alamat,desa_kelurahan,kecamatan,kabupaten_kota,kode_pos,nomor_kk,provinsi,rt,rw) VALUES(?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,
                new Object[] { kartu.getAlamat(), kartu.getDesa_kelurahan(), kartu.getKabupaten_kota(),
                        kartu.getKecamatan(), kartu.getKode_pos(), kartu.getNomor_kk(), kartu.getPrivinsi(),
                        kartu.getRt(), kartu.getRw() });
        return kartu;
    }
}