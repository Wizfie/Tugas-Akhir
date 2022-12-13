import Login from "./Pages/Login.vue"
import Register from "./Pages/Register.vue"
import Home from "./Pages/Home.vue";

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
		path: "/home",
		component: Home,
	},
];