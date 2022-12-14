<template>
	<div>
		<Sidebar></Sidebar>
		<Dasboard></Dasboard>
	</div>
</template>

<script>
	import Sidebar from "../components/SideBar.vue";
	import Dasboard from "../components/Dasboard.vue";

	export default {
		name: "HomePage",
		components: {
			Sidebar,
			Dasboard,
		},
	};
</script>

<style></style>
