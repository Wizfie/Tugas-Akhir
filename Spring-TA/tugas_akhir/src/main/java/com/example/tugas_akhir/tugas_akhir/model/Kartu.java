package com.example.tugas_akhir.tugas_akhir.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_kartu_keluarga")

public class Kartu {

    @Id 

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private byte id;
    private String alamat;
    private String desa_kelurahan;
    private String kabupaten_kota;
    private String kecamatan;
    private String kode_pos;
    private String nomor_kk;
    private String privinsi;
    private byte rt;
    private byte rw;
    public byte getId() {
        return id;
    }
    public void setId(byte id) {
        this.id = id;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getDesa_kelurahan() {
        return desa_kelurahan;
    }
    public void setDesa_kelurahan(String desa_kelurahan) {
        this.desa_kelurahan = desa_kelurahan;
    }
    public String getKabupaten_kota() {
        return kabupaten_kota;
    }
    public void setKabupaten_kota(String kabupaten_kota) {
        this.kabupaten_kota = kabupaten_kota;
    }
    public String getKecamatan() {
        return kecamatan;
    }
    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }
    public String getKode_pos() {
        return kode_pos;
    }
    public void setKode_pos(String kode_pos) {
        this.kode_pos = kode_pos;
    }
    public String getNomor_kk() {
        return nomor_kk;
    }
    public void setNomor_kk(String nomor_kk) {
        this.nomor_kk = nomor_kk;
    }
    public String getPrivinsi() {
        return privinsi;
    }
    public void setPrivinsi(String privinsi) {
        this.privinsi = privinsi;
    }
    public byte getRt() {
        return rt;
    }
    public void setRt(byte rt) {
        this.rt = rt;
    }
    public byte getRw() {
        return rw;
    }
    public void setRw(byte rw) {
        this.rw = rw;
    }

    


    

    


    
    
}
