<template>
  <div id="container">
    <!-- Title -->
    <br />
    <div class="ml-5">
      <h1>Homepage</h1>
    </div>
    <!-- Title -->
    <!-- Card Info -->
    <div id="card">
      <div class="card ml-5 mt-5" style="width: 18rem">
        <div class="card-body">
          <h5 class="card-title">Jumlah Kartu Keluarga</h5>
          <hr />
          <h4>{{ kartuData.length }}</h4>
        </div>
      </div>
      <div class="card ml-5 mt-5" style="width: 18rem">
        <div class="card-body">
          <h5 class="card-title">Jumlah Seluruh Warga</h5>
          <hr />
          <h4>{{ anggotaData.length }}</h4>
        </div>
      </div>
    </div>
    <!-- Card Info -->

    <!-- Table View Data -->
    <div>
      <center>
        <h1 id="table-kk" class="m-5 mt-5">Data Kartu Keluarga</h1>
      </center>
      <table class="table table-bordered m-5">
        <thead id="table-head" class="thead-dark">
          <tr>
            <th scope="col">No</th>
            <th scope="col">Nomor KK</th>
            <th scope="col">Alamat</th>
            <th scope="col">Kota</th>
            <th scope="col">Provinsi</th>
            <th scope="col">Kode Pos</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody id="table-body">
          <tr v-for="(item, index) in kartuData" :key="item.id">
            <th scope="row">{{ index + 1 }}</th>
            <td>{{ item.nomor_kk }}</td>
            <td>{{ item.alamat }}</td>
            <td>{{ item.kabupaten_kota }}</td>
            <td>{{ item.provinsi }}</td>
            <td>{{ item.kode_pos }}</td>
            <td>
              <router-link :to="{ name: `detail`, params: { id: item.id } }">
                <button class="btn btn-info w-auto m-1">
                  <img src="../assets/file.png" style="width: 20px" alt="" />
                </button>
              </router-link>
              <button
                type="button"
                @click="deleteKK(item.id, index)"
                class="btn btn-danger w-auto m-1"
              >
                <img src="../assets/delete.png" style="width: 20px" alt="" />
              </button>
            </td>
          </tr>
        </tbody>
      </table>
      <center v-if="this.kartuData.length === 0">
        <h2>Data tidak ada</h2>
      </center>
    </div>
    <!-- Table View Data -->
  </div>
</template>

<script>
import kartuService from "@/Services/kartuService";
import anggotaService from "@/Services/anggotaService";
import Swal from "sweetalert2";
export default {
  name: "ContentCop",

  data() {
    return {
      kartuData: [],
      anggotaData: [],
    };
  },
  methods: {
    getKartu() {
      kartuService
        .getAll()
        .then((response) => {
          this.kartuData = response.data;
          console.log(this.kartuData);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    getAnggota() {
      anggotaService
        .getAll()
        .then((response) => {
          this.anggotaData = response.data;
          console.log(this.anggotaData);
        })
        .catch((e) => {
          console.log(e);
        });
    },

    deleteKK(id) {
      const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
          confirmButton: "btn btn-success ",
          cancelButton: "btn btn-danger ",
        },
        buttonsStyling: true,
      });
      swalWithBootstrapButtons
        .fire({
          title: "Apakah Kamu Yakin?",
          text: "Data kamu akan terhapus !",
          icon: "warning",
          showCancelButton: true,
          confirmButtonText: "Ya, Hapus!",
          cancelButtonText: "Tidak, Batalkan!",
          reverseButtons: true,
        })
        .then((result) => {
          if (result.isConfirmed) {
            kartuService.deleteKartu(id).then((response) => {
              console.log(response.data);
              anggotaService.deleteAll(id).then((response) => {
                console.log(response.data);
                this.getKartu();
                this.getAnggota();
              });
            });
            // .catch((e) => {
            // 	console.log(e);
            // });
            swalWithBootstrapButtons.fire(
              "Terhapus!",
              "Data Kamu Telah Terhapus!.",
              "success"
            );
          } else if (result.dismiss === Swal.DismissReason.cancel) {
            swalWithBootstrapButtons.fire(
              "Dibatalkan",
              "Data Kamu Aman :)",
              "error"
            );
          }
        });
    },
  },
  mounted() {
    this.getKartu();
    this.getAnggota();
  },
};
</script>

<style scoped>
#table-head tr th {
  text-align: center;
}

#table-body {
  text-align: center;
}
.card {
  background-color: rgb(119, 121, 121);
  padding: auto;
  border-radius: 20px;
}
#card {
  display: flex;
  justify-content: center;
}
.card-title,
h5,
h4 {
  color: aliceblue;
  text-align: center;
}

#container {
  max-width: 80%;
  margin-left: 250px;
}
/* button {
  width: 20%;
} */
#tabel-kk {
  text-align: center;
}
</style>
