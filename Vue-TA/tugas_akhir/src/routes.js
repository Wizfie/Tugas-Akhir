import Login from "./Pages/Login.vue";
import Register from "./Pages/Register.vue";
import Home from "./Pages/Home.vue";
import TambahKK from "./Pages/TambahKK.vue";
import Detail from "./Pages/Detail.vue";
import List from "./Pages/ListAnggota.vue";
import Update from "./Pages/Update.vue";

export default [
	{
		path: "/",
		component: Login,
	},
	{
		path: "/Register",
		component: Register,
	},
	{
		path: "/Home",
		component: Home,
	},
	{
		path: "/TambahKK",
		component: TambahKK,
	},
	{
		path: "/Detail/:id",
		name: "lala",
		component: Detail,
	},

	{
		path: "/ListAnggota",
		name: "hehe",
		component: List,
	},

	{
		path: "/ListAnggota/:id",
		name: "gege",
		component: Update,
	},
];
