import http from "@/http-common";

class userService {
	create(data) {
		return http.post("/user/insert", data);
	}

	login(data) {
		return http.post("/user/Login", data);
	}
}

export default new userService();
