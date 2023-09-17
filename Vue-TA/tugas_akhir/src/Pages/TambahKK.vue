<template>
  <div class="d-flex">
    <Sidebar></Sidebar>
    <Form></Form>
  </div>
</template>

<script>
import Form from "@/components/FormAddKk.vue";
import Sidebar from "../components/SideBar.vue";
export default {
  components: {
    Form,
    Sidebar,
  },
};
</script>

<style></style>
