<template>
  <div>
    <div>
      <div class="sidebar">
        <h1>E-KTP</h1>
        <hr color="white" width="75%" size="10px" />
        <router-link to="/Home">
          <a href="">Home</a>
        </router-link>
        <router-link to="TambahKK">
          <a href="">Tambah KK</a>
        </router-link>
        <br />
        <br />
        <router-link to="/">
          <a href="">Sign Out</a>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "SideComp",
};
</script>

<style>
@import url("https://fonts.googleapis.com/css?family=Rubik&display=swap");

body {
  margin: 0;
  background-color: rgb(226, 239, 239);
}

.sidebar {
  display: block;
  margin-left: 5px;
  margin-block: 5px;
  position: relative;
  width: 250px;
  height: 100vh;
  background: rgb(12, 11, 11);
  padding-top: 50px;
  border-radius: 20px;
}

.sidebar h1 {
  display: block;
  padding: 10px 20px;
  color: rgb(252, 241, 241);
  text-decoration: none;
  font-family: "Rubik";
  letter-spacing: 2px;
  font-weight: 400;
  text-align: center;
  margin: 0;
  font-size: 30px;
  text-transform: uppercase;
}

.sidebar a {
  display: block;
  padding: 10px 20px;
  color: #bbb;
  text-decoration: none;
  font-family: "Rubik";
  letter-spacing: 2px;
}

.sidebar a:hover {
  color: #fff;
  margin-left: 20px;
  transition: 0.5s;
}
</style>
