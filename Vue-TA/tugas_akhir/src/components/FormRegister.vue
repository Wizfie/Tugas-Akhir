<template>
  <section class="vh-100" style="background-color: #eee">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-lg-12 col-xl-11">
          <div class="card text-white" style="border-radius: 25px">
            <div class="card-body p-md-5">
              <div class="row justify-content-center">
                <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                  <p
                    id="Title"
                    class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4"
                  >
                    Sign Up
                  </p>

                  <form @submit.prevent="inputUser" class="mx-1 mx-md-4">
                    <div class="d-flex flex-row align-items-center mb-4">
                      <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="nama">Name</label>
                        <input
                          required
                          v-model="dataRegis.nama"
                          type="text"
                          id="nama"
                          placeholder="Nama"
                          class="form-control"
                        />
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="email">Email</label>
                        <input
                          required
                          v-model="dataRegis.email"
                          type="email"
                          id="email"
                          placeholder="Email"
                          class="form-control"
                        />
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="password"
                          >Password</label
                        >
                        <input
                          required
                          v-model="dataRegis.password"
                          type="password"
                          id="password"
                          placeholder="Password"
                          class="form-control"
                        />
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <label class="form-label" for="password2"
                          >Ulangi password</label
                        >
                        <input
                          v-model="dataRegis.password2"
                          required
                          type="password"
                          id="password2"
                          placeholder="Password"
                          class="form-control"
                        />
                      </div>
                    </div>

                    <div
                      class="d-flex justify-content-center mx-4 mb-3 mb-lg-4"
                    >
                      <button type="submit" class="btn btn-info w-50">
                        Daftar
                      </button>
                    </div>

                    <p class="text-center">
                      Sudah Punya Akun?
                      <br />
                    </p>
                    <p class="text-center">
                      <router-link to="/"> Login Disini </router-link>
                    </p>
                  </form>
                </div>
                <div
                  class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2"
                >
                  <img
                    src="../assets/Register.png"
                    class="img-fluid w-100"
                    alt="Sample image"
                  />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import userService from "../Services/userService";
import Swal from "sweetalert2";
export default {
  name: "FormRegister",

  data() {
    return {
      dataRegis: {
        email: null,
        nama: null,
        password: null,
        password2: null,
      },
      // buttonValue: "submit",
    };
  },

  methods: {
    inputUser() {
      let data = this.dataRegis;

      if (this.dataRegis.password != this.dataRegis.password2) {
        Swal.fire({
          position: "center",
          icon: "info",
          title: "Password tidak sama",
          showConfirmButton: true,
          timer: 2000,
        });
      } else {
        userService
          .create(data)
          .then((response) => {
            console.log(response.data);
            Swal.fire({
              position: "center",
              icon: "success",
              title: "Akun Berhasil di Buat",
              showConfirmButton: true,
              timer: 2000,
            }).then(() => {
              this.$router.push("/");
            });
          })
          .catch((e) => {
            console.log(e);
            if (e.response.data.status === 500) {
              Swal.fire({
                position: "center",
                icon: "info",
                title: "Email telah digunakan",
                showConfirmButton: true,
                timer: 2000,
              });
            }
          });
      }
    },
  },
};
</script>

<style>
label {
  color: black;
}
#title {
  color: black;
}
p {
  color: black;
}
</style>
