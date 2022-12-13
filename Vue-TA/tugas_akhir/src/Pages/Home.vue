<template>
	<div class="d-flex">
		<Sidebar></Sidebar>
		<Content></Content>
	</div>
</template>

<script>
	//    import Navbar from "../components/Navbar.vue"
	import Sidebar from "../components/SideBar.vue";
	import Content from "../components/Content.vue";

	export default {
		name: "HomePage",
		components: {
			Sidebar,
			Content,
		},
	};
</script>

<style></style>
