package com.example.tugas_akhir.tugas_akhir.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
        String query = "INSERT INTO tb_kartu_keluarga(alamat,desa_kelurahan,kabupaten_kota,kecamatan,kode_pos,nomor_kk,provinsi,rt,rw) VALUES(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,
                new Object[] { kartu.getAlamat(), kartu.getDesa_kelurahan(), kartu.getKabupaten_kota(),
                        kartu.getKecamatan(), kartu.getKode_pos(), kartu.getNomor_kk(), kartu.getProvinsi(),
                        kartu.getRt(), kartu.getRw() });
        return kartu;
    }

    @Override
    public List<Kartu> getAllKartu() {
        // TODO Auto-generated method stub
        String query = "SELECT * FROM tb_kartu_keluarga";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Kartu.class));
    }

    @Override
    public Kartu updateKartu(int id, Kartu kartu) {
        // TODO Auto-generated method stub
        String query = "UPDATE tb_kartu_keluarga SET alamat = ?,desa_kelurahan =? , kabupaten_kota =?, kecamatan=?,kode_pos=?,nomor_kk=?,provinsi=?,rt=?,rw=? WHERE id=?";

        jdbcTemplate.update(query,
                new Object[] { kartu.getAlamat(), kartu.getDesa_kelurahan(), kartu.getKabupaten_kota(),
                        kartu.getKecamatan(), kartu.getKode_pos(), kartu.getNomor_kk(), kartu.getProvinsi(),
                        kartu.getRt(), kartu.getRw(), id });

        return kartu;
    }

    @Override 
    public Kartu deleteKartu(int id) {
        // TODO Auto-generated method stub
        String query = "SELECT * FROM tb_kartu_keluarga WHERE id=?";
        var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Kartu.class), id);

        query = "DELETE FROM tb_kartu_keluarga WHERE id= ?";
        jdbcTemplate.update(query, id);

        return result;
    }

    @Override
    public Kartu getKartuId(int id) {
        // TODO Auto-generated method stub
        String query = "SELECT * FROM tb_kartu_keluarga WHERE id = ?";

        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Kartu.class), id);
    }
}