<template>
	<div id="Home">
		<!-- Title -->
		<br />
		<div class="ml-5">
			<h1>Homepage</h1>
		</div>
		<!-- Title -->
		<!-- Card Info -->
		<div class="d-flex">
			<div class="card ml-5 mt-5" style="width: 18rem">
				<div class="card-body">
					<h5 class="card-title">Jumlah Kartu Keluarga</h5>
					<hr />
					<h4>2</h4>
				</div>
			</div>
			<div class="card ml-5 mt-5" style="width: 18rem">
				<div class="card-body">
					<h5 class="card-title">Jumlah Seluruh Warga</h5>
					<hr />
					<h4>10</h4>
				</div>
			</div>
		</div>
		<!-- Card Info -->

		<!-- Table View Data -->
		<div>
			<h1 id="kk" class="m-5 mt-5">Data Kartu Keluarga</h1>
			<table class="table table-bordered m-5">
				<thead class="thead-dark">
					<tr>
						<th scope="col">No</th>
						<th scope="col">Nomor KK</th>
						<th scope="col">Alamat</th>
						<th scope="col">Kota</th>
						<th scope="col">Kode Pos</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<tr v-for="(item, index) in kartuData" :key="item.id">
						<th scope="row">{{ index + 1 }}</th>
						<td>{{ item.nomor_kk }}</td>
						<td>{{ item.alamat }}</td>
						<td>{{ item.kabupaten_kota }}</td>
						<td>{{ item.kode_pos }}</td>
						<td>
							<router-link :to="{ name: `lala`, params: { id: item.id } }">
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
		</div>
		<!-- Table View Data -->
	</div>
</template>

<script>
	import kartuService from "@/Services/kartuService";
	import Swal from "sweetalert2";
	export default {
		name: "ContentCop",

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

			deleteKK(id, index) {
				const swalWithBootstrapButtons = Swal.mixin({
					customClass: {
						confirmButton: "btn btn-success ",
						cancelButton: "btn btn-danger ",
					},
					buttonsStyling: true,
				});
				swalWithBootstrapButtons
					.fire({
						title: "Are you sure?",
						text: "You won't be able to revert this!",
						icon: "warning",
						showCancelButton: true,
						confirmButtonText: "Yes, delete it!",
						cancelButtonText: "No, cancel!",
						reverseButtons: true,
					})
					.then((result) => {
						if (result.isConfirmed) {
							kartuService
								.deleteKartu(id)
								.then((response) => {
									console.log(response.data);
									this.kartuData.splice(index, 1);
								})
								.catch((e) => {
									console.log(e);
								});
							swalWithBootstrapButtons.fire(
								"Deleted!",
								"Your file has been deleted.",
								"success"
							);
						} else if (
							/* Read more about handling dismissals below */
							result.dismiss === Swal.DismissReason.cancel
						) {
							swalWithBootstrapButtons.fire(
								"Cancelled",
								"Your imaginary file is safe :)",
								"error"
							);
						}
					});
			},
		},
		mounted() {
			this.getKartu();
		},
		data() {
			return {
				kartuData: null,
			};
		},
	};
</script>

<style scoped>
	.card {
		background-color: rgb(119, 121, 121);
		padding: auto;
		border-radius: 20px;
	}
	.card-title,
	h5,
	h4 {
		color: aliceblue;
	}
	#Home {
		width: 60%;
		margin-left: 250px;
	}
	button {
		width: 20%;
	}
	#kk {
		text-align: center;
	}
</style>
