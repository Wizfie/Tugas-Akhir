<template>
  <div>
    <div class="container">
      <div class="image">
        <center><h1>Selamat Datang</h1></center>
        <img src="../assets/ktp.png" alt=" image" />
      </div>

      <form @submit.prevent="login">
        <div class="form-outline mb-4 mt-5">
          <input
            v-model="datalogin.email"
            type="email"
            id="form2Example18"
            placeholder="Email"
            class="form-control form-control-lg"
            required
          />
        </div>

        <div class="form-outline mb-4">
          <input
            v-model="datalogin.password"
            type="password"
            id="password"
            placeholder="Password"
            class="form-control form-control-lg"
            required
          />
        </div>

        <div class="pt-1 mb-4">
          <!-- <router-link to="/home"> -->
          <button class="btn btn-info btn-lg btn-block" type="submit">
            Login
          </button>
          <!-- </router-link> -->
        </div>

        <p>
          Belum Punya Akun?
          <router-link to="/Register" class="link-info ml-1"
            >Daftar disini</router-link
          >
        </p>
      </form>
    </div>
  </div>
</template>

<script>
import userService from "@/Services/userService";
import Swal from "sweetalert2";
export default {
  name: "LoginComponent",

  data() {
    return {
      datalogin: {
        email: null,
        password: null,
      },
    };
  },
  methods: {
    login() {
      let data = this.datalogin;
      userService
        .login(data)
        .then((response) => {
          console.log(response);
          sessionStorage.setItem("email", data.email);
          sessionStorage.setItem("password", data.password);

          const Toast = Swal.mixin({
            toast: true,
            position: "top-end",
            showConfirmButton: false,
            timer: 1500,
            timerProgressBar: true,
            didOpen: (toast) => {
              toast.addEventListener("mouseenter", Swal.stopTimer);
              toast.addEventListener("mouseleave", Swal.resumeTimer);
            },
          });

          Toast.fire({
            icon: "success",
            title: "Signed in successfully",
          });
          const email = sessionStorage.getItem("email");
          const password = sessionStorage.getItem("password");
          if (email && password) {
            setTimeout(() => {
              this.$router.push("/home");
            }, 1000);
          }
        })
        .catch((e) => {
          console.log(e);
          if (e.response.status == 500) {
            Swal.fire({
              position: "center",
              icon: "error",
              title: "Email atau Password salah",
              showConfirmButton: false,
              timer: 1500,
            });
          }
        });
    },
  },
};
</script>

<style scoped>
.container {
  margin: 0 auto;
  margin-top: 50px;
  width: 40rem;
  height: auto;
  padding: 5rem;
  background-color: rgb(245, 245, 245);
  border-radius: 12px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
.image img {
  width: 400px;
  height: auto;
  margin: 0 auto;
  margin-left: 2rem;
}
center h1 {
  margin-bottom: 2rem;
}
</style>
