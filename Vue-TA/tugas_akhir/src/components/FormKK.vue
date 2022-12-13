<template>
  <div class="bg w-100">
    <div>
      <h1 class="m-5">Tambah Kartu Keluarga</h1>
    </div>
    <div>
      <router-link to="/" class="btn btn-primary ml-5">Back</router-link>
    </div>
    <div id="FormBg">
      <form class="d-flex">
        <div id="kiri">
          <div class="form-group col">
            <label for="formGroupExampleInput">Nomor kartu Keluarga</label>
            <input
              type="text"
              class="form-control col-12"
              id="formGroupExampleInput"
              placeholder="Nomor kartu Keluarga"
            />
          </div>
          <div class="form-group col">
            <label for="formGroupExampleInput">Alamat</label>
            <textarea
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
              type="text"
              class="form-control"
              id="formGroupExampleInput"
              placeholder="RT"
            />
          </div>
          <div class="form-group col">
            <label for="formGroupExampleInput">RW</label>
            <input
              type="text"
              class="form-control"
              id="formGroupExampleInput"
              placeholder="RW"
            />
          </div>
        </div>
        <div id="kanan">
          <div>
            <div class="form-group col">
              <label for="formGroupExampleInput">Desa / Kelurahan</label>
              <input
                type="text"
                class="form-control"
                id="formGroupExampleInput"
                placeholder="Desa / kelurahan"
              />
            </div>
            <div class="form-group col">
              <label for="formGroupExampleInput">Kecamatan</label>
              <input type="text" class="form-control" placeholder="Kecamatan" />
            </div>
            <div class="form-group col mt-4">
              <label for="formGroupExampleInput">Kabupaten / Kota</label>
              <input
                type="text"
                class="form-control"
                id="formGroupExampleInput"
                placeholder="Kabupaen / Kota"
              />
            </div>
            <div class="form-group col-12">
              <label for="formGroupExampleInput">Provinsi</label>
              <input
                type="text"
                class="form-control"
                id="formGroupExampleInput"
                placeholder="Provinsi"
              />
            </div>
            <div class="form-group col">
              <label for="formGroupExampleInput">Kode Post</label>
              <input
                type="text"
                class="form-control"
                id="formGroupExampleInput"
                placeholder="Kode Post"
              />
            </div>
          </div>
        </div>
      </form>
      <button class="btn btn-primary m-3" type="submit">Submit</button>
    </div>
  </div>
</template>

<script>
export default {
  name: "FormkkComp",
};
</script>

<style>
#FormBg {
  background-color: rgb(189, 201, 198);
  border-radius: 20px;
  margin: 5%;
  padding: 20px;
  width: fit-content;
}
</style>
