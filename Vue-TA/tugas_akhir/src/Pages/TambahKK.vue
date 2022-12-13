<template>
  <div class="d-flex">
    <Sidebar></Sidebar>
    <FormKK></FormKK>
  </div>
</template>

<script>
import FormKK from "../components/FormKK.vue";
import Sidebar from "../components/SideBar.vue";
export default {
  components: {
    FormKK,
    Sidebar,
  },
};
</script>

<style></style>
