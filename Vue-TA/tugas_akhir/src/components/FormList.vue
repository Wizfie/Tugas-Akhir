<template>
	<div id="List">
		<div>
			<div>
				<h1 class="Judul">{{ Judul }}</h1>
			</div>
			<div class="buton">
				<router-link to="/Home">
					<button class="btn btn-dark mr-2">Back</button>
				</router-link>

				<button
					@click="KTambah"
					v-show="TTambah"
					type="button"
					class="btn btn-info"
				>
					Tambah Anggota Keluarga
				</button>
				<button @click="FUpdate" v-show="TUpdate" class="btn btn-success ml-2">
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
						<th scope="col">Jenis Kelamin</th>
						<th scope="col">Kepala Keluarga</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="(item, index) in anggotaData" :key="item.id">
						<th scope="row">{{ index + 1 }}</th>
						<td>{{ item.nik }}</td>
						<td>{{ item.nama }}</td>
						<td>{{ item.jenis_kelamin }}</td>
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
		</div>
		<div v-show="!tableData" class="fom">
			<form
				@submit.prevent="tambahAnggota"
				class="border border-secondary p-4 mt-3"
			>
				<div class="row">
					<div class="col-6">
						<label for="">NIK</label>
						<input
							:disabled="read"
							v-model="anggotaData2.nik"
							type="number"
							class="form-control"
							placeholder="NIK"
							onKeyPress="if(this.value.length==20) return false;"
						/>
					</div>
					<div class="col-6">
						<label for="">Tanggal Lahir</label>
						<input
							:disabled="read"
							v-model="anggotaData2.tanggal_lahir"
							type="date"
							class="form-control mb-3"
						/>
					</div>
				</div>
				<div class="row">
					<div class="col-6">
						<label for="">Nama</label>
						<input
							:disabled="read"
							v-model="anggotaData2.nama"
							type="text"
							class="form-control"
							placeholder="Nama"
							onKeyPress="if(this.value.length==30) return false;"
						/>
					</div>
					<div class="col-6">
						<label for="">Agama</label>
						<input
							:disabled="read"
							v-model="anggotaData2.agama"
							type="text"
							class="form-control mb-3"
							placeholder="Agama"
							onKeyPress="if(this.value.length==20) return false;"
						/>
					</div>
				</div>
				<div class="row">
					<div class="col-6">
						<label for="">Jenis Kelamin</label>
						<select
							:disabled="read"
							v-model="anggotaData2.jenis_kelamin"
							class="custom-select"
						>
							<option value="Pria">Pria</option>
							<option value="Wanita">Wanita</option>
						</select>
					</div>
					<div class="col-6">
						<label for="">Pedidikan</label>
						<input
							:disabled="read"
							v-model="anggotaData2.pendidikan"
							type="text"
							class="form-control mb-3"
							placeholder="Pendidikan"
							onKeyPress="if(this.value.length==20) return false;"
						/>
					</div>
				</div>
				<div class="row">
					<div class="col-6">
						<label for="">Tempat Lahir</label>
						<input
							:disabled="read"
							v-model="anggotaData2.tempat_lahir"
							type="text"
							class="form-control"
							placeholder="Tempat Lahir"
							onKeyPress="if(this.value.length==20) return false;"
						/>
					</div>
					<div class="col-6">
						<label for="">Kepala Keluarga</label>
						<select
							:disabled="read"
							v-model="anggotaData2.kepala_keluarga"
							class="custom-select"
						>
							<option value="Yes">Yes</option>
							<option value="No">No</option>
						</select>
					</div>
				</div>
				<div class="d-flex justify-content-center p-2">
					<button v-show="SU" type="submit" class="btn btn-success mt-4">
						{{ Button }}
					</button>

					<router-link to="/Home">
						<button v-show="CC" type="button" class="btn btn-danger mt-4 ml-2">
							Cancel
						</button>
					</router-link>
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
				IForm: false,
				TTambah: true,
				tableData: true,
				Button: "",
				read: false,
				TUpdate: false,
				SU: true,
				CC: true,
			};
		},

		methods: {
			update(id) {
				this.Judul = "Update Anggota";
				this.TUpdate = true;
				this.read = true;
				this.TTambah = false;
				this.tableData = !this.tableData;
				this.getDataAnggota(id);
				this.SU = false;
				this.CC = false;
			},
			// Buat Ketentuan v-show
			KTambah() {
				this.Judul = "Tambah Data";
				this.tableData = false;
				this.Button = "Submit";
			},
			FUpdate() {
				this.read = false;
				this.SU = true;
				this.CC = true;
				this.Button = "Update";
			},

			getAnggota() {
				anggotaService
					.getAll()
					.then((response) => {
						this.anggotaData2 = response.data;
						console.log(this.anggotaData2);
					})
					.catch((e) => {
						console.log(e);
					});
			},

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
							});
							// .then(() => {
							//   this.$router.push("/ListAnggota");
							// });
						})
						.catch((e) => {
							console.log(e);
						});
				} else {
					// console.log("ok");
					// update anggota
					anggotaService.updateAnggota(data.id, data).then((response) => {
						console.log(response.data);
					});
					Swal.fire({
						position: "center",
						icon: "success",
						title: "Data Telah Tersimpan",
						// timer: 2000,
						showConfirmButton: true,
						timerProgressBar: true,
					}).then(() => {
						this.$router.push("/home");
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
								.then(() => {
									this.$router.push("/home");
								})
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
			// tampil Data by id
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
			console.log("mounted");
			console.log(this.anggotaData);
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
	.buton {
		margin-left: 50px;
	}
	.fom {
		margin-left: 50px;
	}
	form {
		width: 85%;
		border-radius: 10px;
	}
	#tabel {
		width: 92%;
	}
</style>
