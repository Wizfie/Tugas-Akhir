<template>
	<div id="DetCom">
		<div id="title">
			<h1>{{ title }}</h1>
		</div>
		<div id="button">
			<router-link to="/home">
				<button class="btn btn-dark mr-2">Back</button>
			</router-link>

			<button
				@click="buttonChange"
				class="btn btn-success mr-2"
				v-show="tombolUp"
			>
				Update
			</button>
			<router-link to="/ListAnggota">
				<button v-show="tombolList" type="button" class="btn btn-info">
					Lihat Anggota Keluarga
				</button>
			</router-link>

			<div>
				<form
					@submit.prevent="inputKartu"
					id="form"
					class="d-flex border border-secondary mt-5 p-4 mb-5"
				>
					<div id="kiri">
						<div class="form-group col">
							<label for="formGroupExampleInput">Nomor kartu Keluarga</label>
							<input
								:disabled="Read"
								v-model="kartuData.nomor_kk"
								type="text"
								class="form-control col"
								id="formGroupExampleInput"
								placeholder="Nomor kartu Keluarga"
							/>
						</div>
						<div class="form-group col">
							<label for="formGroupExampleInput">Alamat</label>
							<textarea
								:disabled="Read"
								v-model="kartuData.alamat"
								class="form-control"
								name=""
								placeholder="Alamat"
								cols="30"
								rows="5"
							></textarea>
						</div>
						<div class="form-group col">
							<label for="formGroupExampleInput">RT</label>
							<input
								:disabled="Read"
								v-model="kartuData.rt"
								type="text"
								class="form-control"
								id="formGroupExampleInput"
								placeholder="RT"
							/>
						</div>
						<div class="form-group col">
							<label for="formGroupExampleInput">RW</label>
							<input
								:disabled="Read"
								v-model="kartuData.rw"
								type="text"
								class="form-control"
								id="formGroupExampleInput"
								placeholder="RW"
							/>
						</div>
						<button v-show="Submit" class="btn btn-primary m-3" type="submit">
							{{ buttonValue }}
						</button>
						<button
							@click="cancelBtn"
							v-show="cancelShow"
							class="btn btn-danger m-3"
							type="button"
						>
							Cancel
						</button>
					</div>
					<div id="kanan">
						<div class="form-group col">
							<label for="formGroupExampleInput">Desa / Kelurahan</label>
							<input
								:disabled="Read"
								v-model="kartuData.desa_kelurahan"
								type="text"
								class="form-control"
								id="formGroupExampleInput"
								placeholder="Desa / kelurahan"
							/>
						</div>
						<div class="form-group col">
							<label for="formGroupExampleInput">Kecamatan</label>

							<input
								:disabled="Read"
								v-model="kartuData.kecamatan"
								type="text"
								class="form-control"
								placeholder="Kecamatan"
							/>
						</div>
						<div class="form-group col mt-4">
							<label for="formGroupExampleInput">Kabupaten / Kota</label>
							<input
								:disabled="Read"
								v-model="kartuData.kabupaten_kota"
								type="text"
								class="form-control"
								id="formGroupExampleInput"
								placeholder="Kabupaen / Kota"
							/>
						</div>
						<div class="form-group col-12">
							<label for="formGroupExampleInput">Provinsi</label>
							<input
								:disabled="Read"
								v-model="kartuData.provinsi"
								type="text"
								class="form-control"
								id="formGroupExampleInput"
								placeholder="Provinsi"
							/>
						</div>
						<div class="form-group col">
							<label for="formGroupExampleInput">Kode Pos</label>
							<input
								:disabled="Read"
								v-model="kartuData.kode_pos"
								type="text"
								class="form-control"
								id="formGroupExampleInput"
								placeholder="Kode Post"
							/>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</template>

<script>
	import kartuService from "@/Services/kartuService";
	import Swal from "sweetalert2";

	export default {
		name: "DeCom",

		data() {
			return {
				kartuData: {
					alamat: null,
					desa_kelurahan: null,
					kabupaten_kota: null,
					kecamatan: null,
					kode_pos: null,
					nomor_kk: null,
					provinsi: null,
					rt: null,
					rw: null,
				},
				// data1() {
				// 	return {
				// 		List: {
				// 			agama: null,
				// 			id_kk: null,
				// 			jenis_kelamin: null,
				// 			kepala_keluarga: null,
				// 			nama: null,
				// 			nik: null,
				// 			pendidikan: null,
				// 			tanggal_lahir: null,
				// 			tempat_lahir: null,
				// 		},
				// 	};
				// },
				title: "Tambah Data Kartu keluarga ",
				buttonValue: "Submit",
				Submit: true,
			};
		},

		methods: {
			// Input Data
			inputKartu() {
				let data = this.kartuData;
				if (this.buttonValue == "Submit") {
					kartuService
						.create(data)
						.then((response) => {
							console.log(response.data);
							Swal.fire({
								position: "center",
								icon: "success",
								title: "Your work has been saved",
								showConfirmButton: true,
								timer: 1500,
							}).then(() => {
								this.$router.push("/home");
							});
						})
						.catch((e) => {
							console.log(e);
						});
				} else {
					// Update Data
					kartuService.updateKartu(data.id, data).then((response) => {
						console.log(response.data);
					});
					Swal.fire({
						position: "center",
						icon: "success",
						title: "Your work has been saved",
						// timer: 2000,
						showConfirmButton: true,
						timerProgressBar: true,
					}).then(() => {
						this.$router.push("/home");
					});
				}
			},
			// Update Data

			// Tampil Data By id
			getDataKartu(id) {
				kartuService.getkartuId(id).then((response) => {
					this.kartuData = response.data;
					console.log(this.kartuData);
				});
			},
			buttonChange() {
				this.Read = false;
				this.Submit = true;
				this.cancelShow = true;
			},
			cancelBtn() {
				this.Read = true;
				this.Submit = false;
				this.cancelShow = false;
			},
		},

		// props: ["Detail"],
		mounted() {
			if (this.$route.name == `lala`) {
				this.getDataKartu(this.$route.params.id);
				this.title = "Detail Kartu Keluarga";
				this.buttonValue = "Update";
				this.Read = true;
				this.tombolUp = true;
				this.tombolList = true;
				this.Submit = false;
			}
			//  else if (this.title == "Tambah Data keluarga") {
			//   this.Read = false;
			// }
		},
	};
</script>

<style scoped>
	#DetCom {
		margin-left: 250px;
		margin-top: 50px;
	}
	#title {
		margin-left: 50px;
		margin-bottom: 25px;
	}
	#button {
		margin-left: 50px;
	}
	#form {
		background-color: rgb(180, 180, 180);
		width: fit-content;
		border-radius: 20px;
	}
</style>
