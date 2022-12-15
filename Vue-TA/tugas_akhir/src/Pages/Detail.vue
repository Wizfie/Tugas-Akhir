<template>
	<div class="d-flex">
		<Sidebar></Sidebar>
		<Formdetail :Detail="kartuData"></Formdetail>
	</div>
</template>

<script>
	import Sidebar from "@/components/SideBar.vue";
	import Formdetail from "@/components/Form.vue";
	export default {
		name: "DetailPage",

		components: {
			Sidebar,
			Formdetail,
		},
		data() {
			return {
				kartuData: null,
			};
		},
	};
</script>

<style></style>
