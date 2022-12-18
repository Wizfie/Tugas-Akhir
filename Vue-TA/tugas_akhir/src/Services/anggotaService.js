import http from "@/http-common";

class anggotaService {
  create(data) {
    return http.post("/anggota/insert", data);
  }
  getAll() {
    return http.get("/anggota/getAll");
  }
  deleteAnggota(id) {
    return http.delete(`/anggota/delete/${id}`);
  }

  updateAnggota(id, data) {
    return http.put(`/anggota/update/${id}`, data);
  }
  getanggotaId(id) {
    return http.get(`/anggota/getanggota/${id}`);
  }
}
export default new anggotaService();
