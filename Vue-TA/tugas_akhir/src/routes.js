import Login from "./Pages/Login.vue";
import Register from "./Pages/Register.vue";
import Home from "./Pages/Home.vue";
import TambahKK from "./Pages/TambahKK.vue";
import Detail from "./Pages/Detail.vue";
import List from "./Pages/ListAnggota.vue";
import NotFound from "@/Pages/PageNotFound.vue";
// import Update from "./Pages/Update.vue";

export default [
  {
    path: "*",
    component: NotFound,
  },
  {
    path: "/",
    component: Login,
  },
  {
    path: "/register",
    component: Register,
  },
  {
    path: "/home",
    component: Home,
    beforeEnter: checkAuthorization,
  },
  {
    path: "/tambahKK",
    component: TambahKK,
    beforeEnter: checkAuthorization,
  },
  {
    path: "/detail/:id",
    name: "detail",
    component: Detail,
    beforeEnter: checkAuthorization,
  },

  {
    path: "/detail/:id/listAnggota",
    name: "listAnggota",
    component: List,
    beforeEnter: checkAuthorization,
  },

  // {
  //   path: "/:id/ListAnggota/:ide",
  //   name: "update",
  //   component: Update,
  // },
];
function checkAuthorization(to, from, next) {
  if (sessionStorage.getItem("email") && sessionStorage.getItem("password")) {
    next();
  } else {
    next("*");
  }
}
