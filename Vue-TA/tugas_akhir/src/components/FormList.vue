<template>
  <div id="List">
    <div>
      <h1 class="Judul">Daftar Anggota Keluarga</h1>
    </div>
    <div class="buton">
      <router-link :to="{ name: `lala`, params: { id: item.id } }">
        <button class="btn btn-primary">Back</button>
      </router-link>
    </div>
    <div>
      <table class="table table-bordered">
        <thead class="thead-dark">
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
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Larry</td>
            <td>the Bird</td>
            <td>@twitter</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: "ListComp",
};
</script>

<style scoped>
#List {
  margin-left: 250px;
  margin-top: 50px;
}
.Judul {
  margin-left: 50px;
  margin-bottom: 25px;
}
.buton {
  margin: 50px;
}
.table {
  margin: 50px;
}
</style>
