<template>
	<div id="Home">
		<!-- Title -->
		<h1 class="ml-5 mt-3">Homepage</h1>
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
		<table class="table table-active m-5">
			<thead>
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
				<tr>
					<th scope="row">1</th>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>@mdo</td>
					<button class="btn btn-info btn-sm m-1">
						<img src="../assets/file.png" style="width: 20px" alt="" />
					</button>
					<button class="btn btn-danger btn-sm m-1">
						<img src="../assets/delete.png" style="width: 20px" alt="" />
					</button>
				</tr>
			</tbody>
		</table>
		<!-- Table View Data -->
	</div>
</template>

<script>
	export default {
		name: "ContentCop",
	};
</script>

<style>
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
	}
	button {
		width: 20%;
	}
</style>
