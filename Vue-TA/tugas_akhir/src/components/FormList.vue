<template>
	<div id="List">
		<div>
			<h1 class="Judul">Daftar Anggota Keluarga</h1>
		</div>
		<div class="buton">
			<!-- to="{ name: `lala`, params: { id: item.id } }" -->

			<button class="btn btn-dark mr-2">Back</button>
			<button @click="Update" type="button" class="btn btn-info">
				Tambah Anggota Keluarga
			</button>
		</div>
		<div id="tabel" v-show="ListData">
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
					<tr v-if="(List = 0)">
						<h1>Data Tidak tersedia</h1>
						<th scope="row">1</th>
						<td>Mark</td>
						<td>Otto</td>
						<td>@mdo</td>
					</tr>
					<tr>
						<th scope="row">2</th>
						<td>Jacob</td>
						<td>Thornton</td>
						<td>@fat</td>
						<td>dadaw</td>
						<td>
							<button class="btn btn-info w-auto m-1">
								<img src="../assets/file.png" style="width: 20px" alt="" />
							</button>
							<button
								type="button"
								@click="deleteKK(item.id, index)"
								class="btn btn-danger"
							>
								<img src="../assets/delete.png" style="width: 20px" alt="" />
							</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div v-show="fom" class="fom">
			<form class="border border-secondary p-4 mt-3">
				<div class="row">
					<div class="col-6">
						<label for="">NIK</label>
						<input type="text" class="form-control" placeholder="First name" />
					</div>
					<div class="col-6">
						<label for="">Tanggal Lahir</label>
						<input
							type="date"
							class="form-control mb-3"
							placeholder="Last name"
						/>
					</div>
				</div>
				<div class="row">
					<div class="col-6">
						<label for="">Nama</label>
						<input type="text" class="form-control" placeholder="First name" />
					</div>
					<div class="col-6">
						<label for="">Agama</label>
						<input
							type="text"
							class="form-control mb-3"
							placeholder="Last name"
						/>
					</div>
				</div>
				<div class="row">
					<div class="col-6">
						<label for="">Jenis Kelamin</label>
						<select class="custom-select">
							<option value="Pria">Pria</option>
							<option value="Wanita">Wanita</option>
						</select>
					</div>
					<div class="col-6">
						<label for="">Pedidikan</label>
						<input
							type="text"
							class="form-control mb-3"
							placeholder="Last name"
						/>
					</div>
				</div>
				<div class="row">
					<div class="col-6">
						<label for="">Tempat Lahir</label>
						<input type="text" class="form-control" placeholder="First name" />
					</div>
					<div class="col-6">
						<label for="">Kepala Keluarga</label>
						<select class="custom-select">
							<option value="Yes">Yes</option>
							<option value="No">No</option>
						</select>
					</div>
				</div>
				<button class="btn btn-danger mt-4">Cancel</button>
				<button class="btn btn-success mt-4 ml-2">Update</button>
			</form>
		</div>
	</div>
</template>

<script>
	export default {
		name: "ListComp",

		data() {
			return {
				ListData: true,
				fom: false,
			};
		},

		methods: {
			Update() {
				this.ListData = false;
				this.fom = true;
			},
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
	}
	#tabel {
		width: 92%;
	}
</style>
