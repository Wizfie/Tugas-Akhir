<template>
  <div id="List">
    <div>
      <div>
        <h1 class="Judul">{{ Judul }}</h1>
      </div>
      <div class="btn-group">
        <button
          v-show="backAdd"
          class="btn btn-dark mr-2 ml-5"
          @click="toListAnggota"
        >
          Back
        </button>

        <button
          @click="backtoDetail"
          v-show="backlist"
          class="btn btn-dark mr-2 ml-5"
        >
          Back
        </button>
        <!-- <router-link to="backtoDetail">
        </router-link> -->

        <button
          @click="addAnggotaKeluarga"
          v-show="btnTambah"
          type="button"
          class="btn btn-info"
        >
          Tambah Anggota Keluarga
        </button>
        <button
          @click="toUpdate"
          v-show="btnUpdateAnggota"
          class="btn btn-success ml-2"
        >
          Update
        </button>
      </div>
    </div>
    <div id="tabel" v-show="tableData">
      <table class="table table-bordered mt-5 ml-5">
        <thead class="thead-dark mr-5">
          <tr>
            <th scope="col">No</th>
            <th scope="col">NIK</th>
            <th scope="col">Nama</th>
            <th scope="col">Tempat Lahir</th>
            <th scope="col">Tanggal lahir</th>
            <th scope="col">Status</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item, index) in anggotaData" :key="item.id">
            <th scope="row">{{ index + 1 }}</th>
            <td>{{ item.nik }}</td>
            <td>{{ item.nama }}</td>
            <td>{{ item.tempat_lahir }}</td>
            <td>{{ item.tanggal_lahir }}</td>
            <td>{{ item.kepala_keluarga }}</td>
            <td>
              <button class="btn btn-info w-auto m-1" @click="update(item.id)">
                <img src="../assets/file.png" style="width: 20px" alt="" />
              </button>
              <button
                type="button"
                @click="deleteAnggota(item.id, index)"
                class="btn btn-danger"
              >
                <img src="../assets/delete.png" style="width: 20px" alt="" />
              </button>
            </td>
          </tr>
        </tbody>
      </table>
      <center v-if="this.anggotaData == 0">
        <h2>Data tidak ada</h2>
      </center>
    </div>
    <div v-show="!tableData" class="fom">
      <form
        @submit.prevent="tambahAnggota"
        class="border border-secondary p-4 mt-3"
      >
        <div class="row">
          <div class="col-6">
            <label for="nik">NIK</label>
            <input
              id="nik"
              :disabled="read"
              v-model="anggotaData2.nik"
              type="number"
              class="form-control"
              placeholder="NIK"
              onKeyPress="if(this.value.length==20) return false;"
              required
            />
          </div>
          <div class="col-6">
            <label for="tanggalLahir">Tanggal Lahir</label>
            <input
              id="tanggalLahir"
              :disabled="read"
              v-model="anggotaData2.tanggal_lahir"
              type="date"
              class="form-control mb-3"
              required
            />
          </div>
        </div>
        <div class="row">
          <div class="col-6">
            <label for="nama">Nama</label>
            <input
              id="nama"
              :disabled="read"
              v-model="anggotaData2.nama"
              type="text"
              class="form-control"
              placeholder="Nama"
              onKeyPress="if(this.value.length==30) return false;"
              required
            />
          </div>
          <div class="col-6">
            <label for="agama">Agama</label>
            <input
              id="agama"
              :disabled="read"
              v-model="anggotaData2.agama"
              type="text"
              class="form-control mb-3"
              placeholder="Agama"
              onKeyPress="if(this.value.length==20) return false;"
              required
            />
          </div>
        </div>
        <div class="row">
          <div class="col-6">
            <label for="jeniskelamin">Jenis Kelamin</label>
            <select
              id="jeniskelamin"
              class="custom-select"
              :disabled="read"
              v-model="anggotaData2.jenis_kelamin"
              required
            >
              <option value="Pria">Pria</option>
              <option value="Wanita">Wanita</option>
            </select>
          </div>
          <div class="col-6">
            <label for="pendidikan">Pendidikan</label>
            <input
              id="pendidikan"
              :disabled="read"
              v-model="anggotaData2.pendidikan"
              type="text"
              class="form-control mb-3"
              placeholder="Pendidikan"
              onKeyPress="if(this.value.length==20) return false;"
              required
            />
          </div>
        </div>
        <div class="row">
          <div class="col-6">
            <label for="tempatLahir">Tempat Lahir</label>
            <input
              id="tempatLahir"
              :disabled="read"
              v-model="anggotaData2.tempat_lahir"
              type="text"
              class="form-control"
              placeholder="Tempat Lahir"
              onKeyPress="if(this.value.length==20) return false;"
              required
            />
          </div>
          <div class="col-6">
            <label for="Status"> Status</label>
            <select
              id="Status"
              :disabled="read"
              v-model="anggotaData2.kepala_keluarga"
              class="custom-select"
              required
            >
              <option value="kepala keluarga">Kepala keluarga</option>
              <option value="istri">Istri</option>
              <option value="anak pertama">Anak Pertama</option>
              <option value="anak kedua">Anak Kedua</option>
              <option value="anak ketiga">Anak ketiga</option>
              <option value="anak keempat">Anak keempat</option>
              <option value="anak kelima">Anak kelima</option>
            </select>
          </div>
        </div>
        <div class="d-flex justify-content-center p-2">
          <button v-show="btnUpdate" type="submit" class="btn btn-info mt-4">
            {{ Button }}
          </button>

          <button
            v-show="btnCancel"
            type="button"
            class="btn btn-danger mt-4 ml-2"
            @click="toListAnggota"
          >
            Cancel
          </button>
          <!-- <router-link to="/Home"> </router-link> -->
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import anggotaService from "@/Services/anggotaService";
import Swal from "sweetalert2";
export default {
  name: "ListComp",

  data() {
    return {
      anggotaData: [],
      anggotaData2: {
        agama: null,
        id_kk: null,
        jenis_kelamin: null,
        kepala_keluarga: null,
        nama: null,
        nik: null,
        pendidikan: null,
        tanggal_lahir: null,
        tempat_lahir: null,
      },
      Judul: "List Anggota",
      // IForm: false,
      btnTambah: true,
      tableData: true,
      Button: "",
      read: false,
      btnUpdateAnggota: false,
      btnUpdate: true,
      btnCancel: true,
      backlist: true,
    };
  },

  methods: {
    update(id) {
      this.Judul = "Update Anggota";
      this.btnUpdateAnggota = true;
      this.read = true;
      this.btnTambah = false;
      this.tableData = !this.tableData;
      this.getDataAnggota(id);
      this.btnUpdate = false;
      this.btnCancel = false;
      this.backlist = false;
      this.backAdd = true;
    },
    addAnggotaKeluarga() {
      this.Judul = "Tambah Data";
      this.tableData = false;
      this.Button = "Submit";
      this.backlist = false;
      this.backAdd = true;
      this.btnTambah = false;
      this.resetForm();
    },
    toUpdate() {
      this.read = false;
      this.btnUpdate = true;
      this.btnCancel = true;
      this.Button = "Update";
    },
    toListAnggota() {
      this.Judul = "List Anggota";
      this.tableData = true;
      this.backlist = true;
      this.backAdd = false;
      this.btnTambah = true;
      this.btnUpdateAnggota = false;
    },
    backtoDetail() {
      this.$router.go(-1);
    },
    resetForm() {
      this.anggotaData2.agama = "";
      this.anggotaData2.id_kk = "";
      this.anggotaData2.jenis_kelamin = "";
      this.anggotaData2.kepala_keluarga = "";
      this.anggotaData2.nama = "";
      this.anggotaData2.nik = "";
      this.anggotaData2.pendidikan = "";
      this.anggotaData2.tanggal_lahir = "";
      this.anggotaData2.tempat_lahir = "";
    },
    // getAnggota() {
    //   anggotaService
    //     .getAll()
    //     .then((response) => {
    //       this.anggotaData2 = response.data;
    //       console.log(this.anggotaData2);
    //     })
    //     .catch((e) => {
    //       console.log(e);
    //     });
    // },

    // inputAnggota
    tambahAnggota() {
      let data = this.anggotaData2;
      if (this.Button == "Submit") {
        this.anggotaData2.id_kk = this.$route.params.id;
        anggotaService
          .create(data)
          .then((response) => {
            console.log(response.data);
            Swal.fire({
              position: "center",
              icon: "success",
              title: "Data Telah Tersimpan",
              showConfirmButton: true,
              timer: 1500,
            }).then(() => {
              this.getwarga(this.$route.params.id);
              this.resetForm();
              this.toListAnggota();
            });
          })
          .catch((e) => {
            console.log(e);
            if (e.response.status == 500) {
              Swal.fire({
                position: "center",
                icon: "error",
                title: "Terjadi Kesalahan , Ulangi kembali",
                // timer: 2000,
                showConfirmButton: true,
                timerProgressBar: true,
              });
            }
          });
      } else {
        // update anggota
        anggotaService
          .updateAnggota(data.id, data)
          .then((response) => {
            console.log(response.data);
            Swal.fire({
              position: "center",
              icon: "success",
              title: "Data Telah Tersimpan",
              // timer: 2000,
              showConfirmButton: true,
              timerProgressBar: true,
            }).then(() => {
              this.getwarga(this.$route.params.id);
              this.toListAnggota();
            });
          })
          .catch((e) => {
            console.log(e);
            if (e.response.status == 500) {
              Swal.fire({
                position: "center",
                icon: "info",
                title: "Terjadi Kesalahan , Ulangi kembali",
                // timer: 2000,
                showConfirmButton: true,
                timerProgressBar: true,
              });
            }
          });
      }
    },
    //  Hapus Data Anggota
    deleteAnggota(id, index) {
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
          text: "Data kamu akan terhapus permanen!",
          icon: "warning",
          showCancelButton: true,
          confirmButtonText: "Ya, Hapus!",
          cancelButtonText: "Tidak, Batalkan!",
          reverseButtons: true,
        })
        .then((result) => {
          if (result.isConfirmed) {
            anggotaService
              .deleteAnggota(id)
              .then((response) => {
                console.log(response.data);
                this.anggotaData.splice(index, 1);
              })
              // .then(() => {
              //   this.$router.push("/home");
              // })
              .catch((e) => {
                console.log(e);
              });
            swalWithBootstrapButtons.fire(
              "Terhapus!",
              "Data Kamu Telah Terhapus!.",
              "success"
            );
          } else if (result.dismiss === Swal.DismissReason.cancel) {
            swalWithBootstrapButtons.fire(
              "Dibatalkan",
              "Data Kamu Aman:)",
              "error"
            );
          }
        });
    },
    // tampil Data by id saat update
    getDataAnggota(id) {
      anggotaService.getanggotaId(id).then((response) => {
        this.anggotaData2 = response.data;
        console.log(this.anggotaData2);
      });
    },

    getwarga(id_kk) {
      anggotaService.getwarga(id_kk).then((response) => {
        this.anggotaData = response.data;
        // console.log(this.anggotaData);
      });
    },
  },

  mounted() {
    this.getwarga(this.$route.params.id);
  },
};
</script>

<style scoped>
#List {
  margin-left: 250px;
  width: 85%;
}
.Judul {
  margin-left: 50px;
  margin-top: 1em;
  margin-bottom: 20px;
}
/* .backAdd {
  margin-left: 50px;
} */
.fom {
  margin-left: 50px;
}
form {
  width: 85%;
  border-radius: 10px;
}
#tabel {
  max-width: 90%;
  text-align: center;
}
</style>
