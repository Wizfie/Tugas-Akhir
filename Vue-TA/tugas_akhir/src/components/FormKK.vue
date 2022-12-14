<template>
	<div class="bg">
		<!-- <div>
			<router-link to="/" class="btn btn-primary ml-5">Back</router-link>
		</div> -->
		<div id="FormBg">
			<div>
				<h1 class="m-5">Tambah Kartu Keluarga</h1>
			</div>
			<hr />
			<form @submit.prevent="inputKartu" class="d-flex">
				<div id="kiri">
					<div class="form-group col">
						<label for="formGroupExampleInput">Nomor kartu Keluarga</label>
						<input
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
							v-model="kartuData.rw"
							type="text"
							class="form-control"
							id="formGroupExampleInput"
							placeholder="RW"
						/>
					</div>
					<button class="btn btn-primary m-3" type="submit">Submit</button>
				</div>
				<div id="kanan">
					<div class="form-group col">
						<label for="formGroupExampleInput">Desa / Kelurahan</label>
						<input
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
							v-model="kartuData.kecamatan"
							type="text"
							class="form-control"
							placeholder="Kecamatan"
						/>
					</div>
					<div class="form-group col mt-4">
						<label for="formGroupExampleInput">Kabupaten / Kota</label>
						<input
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
</template>

<script>
	import kartuService from "@/Services/kartuService";
	import Swal from "sweetalert2";
	export default {
		name: "FormkkComp",

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
			};
		},

		methods: {
			inputKartu() {
				let data = this.kartuData;
				kartuService
					.create(data)
					.then((response) => {
						console.log(response.data);
						Swal.fire({
							position: "center",
							icon: "success",
							title: "Your work has been saved",
							showConfirmButton: false,
							timer: 2000,
						});
						// .then(() => {
						// 	this.$router.push("/");
						// });
					})
					.catch((e) => {
						console.log(e);
					});
			},
		},
	};
</script>

<style scoped>
	#FormBg {
		background-color: rgb(189, 201, 198);
		border-radius: 20px;
		margin: 4%;
		padding: 20px;
		width: fit-content;
	}
	.bg {
		width: 100%;
		margin-left: 250px;
	}
</style>
