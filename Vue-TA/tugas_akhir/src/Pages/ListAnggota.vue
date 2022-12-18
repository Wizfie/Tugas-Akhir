<template>
  <div>
    <Sidebar></Sidebar>
    <div class="d-flex">
      <Formlist></Formlist>
    </div>
  </div>
</template>

<script>
import Sidebar from "@/components/SideBar.vue";
import Formlist from "@/components/FormList.vue";
export default {
  components: {
    Sidebar,
    Formlist,
  },
};
</script>

<style></style>
