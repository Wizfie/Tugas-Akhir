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
	deleteAll(id_kk) {
		return http.delete(`/anggota/deleteAll/${id_kk}`);
	}

	updateAnggota(id, data) {
		return http.put(`/anggota/update/${id}`, data);
	}
	getanggotaId(id) {
		return http.get(`/anggota/getanggota/${id}`);
	}
	getwarga(id_kk) {
		return http.get(`/anggota/getwarga/${id_kk}`);
	}
}
export default new anggotaService();
