<template>
  <div class="d-flex">
    <Sidebar></Sidebar>
    <Formdetail></Formdetail>
  </div>
</template>

<script>
import Sidebar from "@/components/SideBar.vue";
import Formdetail from "@/components/FormDetail.vue";
export default {
  name: "DetailPage",

  components: {
    Sidebar,
    Formdetail,
  },
};
</script>

<style></style>
