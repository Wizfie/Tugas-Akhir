import http from "@/http-common";

class kartuService {
	create(data) {
		return http.post("/kartu/insert", data);
	}
	getAll() {
		return http.get("/kartu/getAll");
	}
	deleteKartu(id) {
		return http.delete(`kartu/delete/${id}`);
	}
	updateKartu(id, data) {
		return http.put(`student/update/${id}`, data);
	}
}

export default new kartuService();
