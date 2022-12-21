<template>
	<div id="DetCom">
		<div id="title">
			<h1>{{ title }}</h1>
		</div>
		<div id="button">
			<router-link to="/Home">
				<button class="btn btn-dark mr-2">Back</button>
			</router-link>

			<button
				@click="buttonChange"
				class="btn btn-success mr-2"
				v-show="tombolUp"
			>
				Update
			</button>
			<router-link :to="{ name: 'satu' }">
				<button v-show="tombolList" type="button" class="btn btn-info">
					Lihat Anggota Keluarga
				</button>
			</router-link>

			<div>
				<form
					@submit.prevent="inputKartu"
					class="border border-secondary p-4 mb-5 mt-4"
				>
					<div class="row">
						<div class="col-6">
							<label for="">Nomor Kartu Keluarga</label>
							<input
								:disabled="Read"
								v-model="kartuData.nomor_kk"
								type="number"
								class="form-control"
								placeholder="Nomor Kartu Keluarga"
								onKeyPress="if(this.value.length==20) return false;"
							/>
						</div>
						<div class="col-6">
							<label for="">Desa / Kelurahan</label>
							<input
								:disabled="Read"
								v-model="kartuData.desa_kelurahan"
								type="text"
								class="form-control mb-3"
								placeholder="Desa / Kelurahan"
								onKeyPress="if(this.value.length==15) return false;"
							/>
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label for="">Kecamatan</label>
							<input
								:disabled="Read"
								v-model="kartuData.kecamatan"
								type="text"
								class="form-control"
								placeholder="Kecamatan"
								onKeyPress="if(this.value.length==15) return false;"
							/>
						</div>
						<div class="col-6">
							<label for="">Kabupaten / Kota</label>
							<input
								:disabled="Read"
								v-model="kartuData.kabupaten_kota"
								type="text"
								class="form-control mb-3"
								placeholder="kabupaten / Kota"
								onKeyPress="if(this.value.length==15) return false;"
							/>
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label for="">Provinsi</label>
							<input
								:disabled="Read"
								v-model="kartuData.provinsi"
								type="text"
								class="form-control"
								placeholder="Provinsi"
								onKeyPress="if(this.value.length==15) return false;"
							/>
						</div>
						<div class="col-6">
							<label for="">Kode Pos</label>
							<input
								:disabled="Read"
								v-model="kartuData.kode_pos"
								type="number"
								class="form-control mb-3"
								placeholder="Kode Pos"
								onKeyPress="if(this.value.length==10) return false;"
							/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col">
							<div>
								<label for="">Alamat</label>
							</div>
							<textarea
								:disabled="Read"
								v-model="kartuData.alamat"
								name=""
								id=""
								cols="55	"
								rows="6"
								onKeyPress="if(this.value.length==100) return false;"
							></textarea>
						</div>
						<div class="col-3">
							<label for="">RT</label>
							<input
								:disabled="Read"
								v-model="kartuData.rt"
								type="number"
								class="form-control mb-3"
								placeholder="RT"
								onKeyPress="if(this.value.length==3) return false;"
							/>
						</div>
						<div class="col-3">
							<label for="">RW</label>
							<input
								onKeyPress="if(this.value.length==5) return false;"
								:disabled="Read"
								v-model="kartuData.rw"
								type="number"
								class="form-control mb-3"
								placeholder="RW"
							/>
							<div class="d-flex justify-content-end">
								<button
									v-show="Submit"
									type="submit"
									class="btn btn-primary mt-5"
								>
									{{ buttonValue }}
								</button>
								<button
									@click="cancelBtn"
									v-show="cancelShow"
									type="button"
									class="btn btn-danger mt-5 ml-2"
								>
									Cancel
								</button>
							</div>
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
				title: "Tambah Data Kartu keluarga ",
				buttonValue: "Submit",
				Submit: true,
				lalala: true,
				tombolUp: false,
				tombolList: false,
				Read: false,
				cancelShow: false,
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
								title: "Data Telah Tersimpan",
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
						title: "Data Telah Tersimpan",
						// timer: 2000,
						showConfirmButton: true,
						timerProgressBar: true,
					}).then(() => {
						this.$router.push("/home");
					});
				}
			},

			// Tampil Data By id
			getDataKartu(id) {
				kartuService.getkartuId(id).then((response) => {
					this.kartuData = response.data;
					console.log(this.kartuData);
				});
			},

			// Buat Ketentuan v-show
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
	form {
		width: fit-content;
		border-radius: 20px;
	}
</style>
