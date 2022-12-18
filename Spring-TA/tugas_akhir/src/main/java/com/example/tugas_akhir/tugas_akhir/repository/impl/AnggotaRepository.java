package com.example.tugas_akhir.tugas_akhir.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.tugas_akhir.tugas_akhir.model.Anggota;
import com.example.tugas_akhir.tugas_akhir.repository.IAnggotaRepository;

@Repository
public class AnggotaRepository implements IAnggotaRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Anggota insertAnggota(Anggota anggota) {
        String query = "INSERT INTO tb_anggota_keluarga(agama,id_kk,jenis_kelamin,kepala_keluarga,nama,nik,pendidikan,tanggal_lahir,tempat_lahir) VALUE(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,
                new Object[] { anggota.getAgama(), anggota.getId_kk(), anggota.getJenis_kelamin(),
                        anggota.getKepala_keluarga(), anggota.getNama(), anggota.getNik(), anggota.getPendidikan(),
                        anggota.getTanggal_lahir(), anggota.getTempat_lahir() });
        return anggota;
    }

    @Override
    public List<Anggota> getAllAnggota() {
        String query = "SELECT * FROM tb_anggota_keluarga";

        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Anggota.class));
    }

    @Override
    public Anggota updateAnggota(int id, Anggota anggota) {
        String query = "UPDATE tb_anggota_keluarga SET agama=?,id_kk=?,jenis_kelamin=?,kepala_keluarga=?,nama=?,nik=?,pendidikan=?,tanggal_lahir=?,tempat_lahir=?";
        jdbcTemplate.update(query,
                new Object[] {
                        anggota.getAgama(), anggota.getId_kk(), anggota.getJenis_kelamin(),
                        anggota.getKepala_keluarga(),
                        anggota.getNama(), anggota.getNik(), anggota.getPendidikan(), anggota.getTanggal_lahir(),
                        anggota.getTempat_lahir()
                });
        return anggota;
    }

    @Override
    public Anggota deleteAnggota(int id) {
        String query = "SELECT * FROM tb_anggota_keluarga WHERE id=?";

        var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Anggota.class), id);

        query = "DELETE FROM tb_anggota_keluarga WHERE id=?";
        jdbcTemplate.update(query, id);

        return result;
    }

    @Override
    public Anggota getAnggotaId(int id) {
        String query = " SELECT * FROM tb_anggota_keluarga WHERE id=?";

        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Anggota.class), id);
    }

}
