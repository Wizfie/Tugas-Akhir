<template>
	<div class="">
		<section class="vh-100">
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-6 px-0 d-sm-block">
						<img
							src="../assets/ktp.png"
							alt="Login image"
							class="w-100 vh-25 p-5"
						/>
					</div>
					<div class="col-sm-6 text-black">
						<div class="px-5 ms-xl-4">
							<i
								class="fas fa-crow fa-2x me-3 pt-5 mt-xl-4"
								style="color: #709085"
							></i>
							<h1 class="mt-5">Selamat Datang</h1>
						</div>

						<div
							class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5"
						>
							<form @submit.prevent="login" style="width: 30rem">
								<h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px">
									Log in
								</h3>

								<div class="form-outline mb-4">
									<input
										v-model="datalogin.email"
										type="email"
										id="form2Example18"
										placeholder="Email"
										class="form-control form-control-lg"
									/>
									<label class="form-label" for="form2Example18"
										>Email address</label
									>
								</div>

								<div class="form-outline mb-4">
									<input
										v-model="datalogin.password"
										type="password"
										id="form2Example28"
										placeholder="Password"
										class="form-control form-control-lg"
									/>
									<label class="form-label" for="form2Example28"
										>Password</label
									>
								</div>

								<div class="pt-1 mb-4">
									<!-- <router-link to="/home"> -->
									<button class="btn btn-info btn-lg btn-block" type="submit">
										Login
									</button>
									<!-- </router-link> -->
								</div>

								<p>
									Belum Punya Akun?
									<router-link to="/Register" class="link-info ml-1"
										>Daftar disini</router-link
									>
								</p>
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</template>

<script>
	import userService from "@/Services/userService";
	export default {
		name: "LoginComponent",

		data() {
			return {
				datalogin: {
					email: null,
					password: null,
				},
			};
		},
		methods: {
			login() {
				let data = this.datalogin;
				userService
					.login(data)
					.then((response) => {
						console.log(response);
						alert("masuk");
						this.$router.push("/Home");
					})
					.catch((e) => {
						console.log(e);
						// this.message = true;
					});
			},
		},
	};
</script>

<style>
	.bg-image-vertical {
		position: relative;
		overflow: hidden;
		background-repeat: no-repeat;
		background-position: right center;
		background-size: auto 100%;
	}

	@media (min-width: 1025px) {
		.h-custom-2 {
			height: 100%;
		}
	}
</style>
