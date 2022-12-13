<template>
  <section class="vh-100" style="background-color: #eee">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-lg-12 col-xl-11">
          <div class="card text-black" style="border-radius: 25px">
            <div class="card-body p-md-5">
              <div class="row justify-content-center">
                <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                  <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">
                    Daftar
                  </p>

                  <form @submit.prevent="inputUser" class="mx-1 mx-md-4">
                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <input
                          v-model="userData.nama"
                          type="text"
                          id="form3Example1c"
                          placeholder="Nama Lengkap"
                          class="form-control"
                        />
                        <label class="form-label" for="form3Example1c"
                          >Your Name</label
                        >
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <input
                          v-model="userData.email"
                          type="email"
                          id="form3Example3c"
                          placeholder="Email"
                          class="form-control"
                        />
                        <label class="form-label" for="form3Example3c"
                          >Your Email</label
                        >
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <input
                          v-model="userData.password"
                          type="password"
                          id="form3Example4c"
                          placeholder="Password"
                          class="form-control"
                        />
                        <label class="form-label" for="form3Example4c"
                          >Password</label
                        >
                      </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">
                      <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                      <div class="form-outline flex-fill mb-0">
                        <input
                          type="password"
                          id="form3Example4cd"
                          placeholder="Password"
                          class="form-control"
                        />
                        <label class="form-label" for="form3Example4cd"
                          >Repeat your password</label
                        >
                      </div>
                    </div>

                    <div
                      class="d-flex justify-content-center mx-4 mb-3 mb-lg-4"
                    >
                      <button type="submit" class="btn btn-primary btn-lg mr-2">
                        Daftar
                      </button>
                    </div>

                    <p>
                      Sudah Punya Akun?
                      <router-link to="/" class="link-info">Login</router-link>
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
      userData: {
        email: null,
        nama: null,
        password: null,
      },
      buttonValue: "submit",
    };
  },

  methods: {
    inputUser() {
      let data = this.userData;
      userService
        .create(data)
        .then((response) => {
          console.log(response.data);
          Swal.fire({
            position: "center",
            icon: "success",
            title: "Your work has been saved",
            showConfirmButton: false,
            // timer: 2000,
          }).then(() => {
            this.$router.push("/");
          });
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },
};
</script>

<style></style>
