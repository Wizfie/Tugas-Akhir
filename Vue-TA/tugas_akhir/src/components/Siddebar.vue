<template>
	<div>
		<header class="header" role="banner">
			<h1 class="logo">
				<a href="#">Terence <span>Devine</span></a>
			</h1>
			<div class="nav-wrap">
				<nav class="main-nav" role="navigation">
					<ul class="unstyled list-hover-slide">
						<li><a href="#">About</a></li>
						<li><a href="#">Work</a></li>
						<li><a href="#">Contact</a></li>
						<li><a href="#">Blog</a></li>
					</ul>
				</nav>
				<ul class="social-links list-inline unstyled list-hover-slide">
					<li><a href="#">Twitter</a></li>
					<li><a href="#">Google+</a></li>
					<li><a href="#">GitHub</a></li>
					<li><a href="#">CodePen</a></li>
				</ul>
			</div>
		</header>
	</div>
</template>

<script>
	export default {
		name: "CompSide",
	};
</script>

<style scoped>
	*,
	:before,
	:after {
		box-sizing: border-box;
	}

	.unstyled {
		list-style: none;
		padding: 0;
		margin: 0;
	}
	.unstyled a {
		text-decoration: none;
	}

	.list-inline {
		overflow: hidden;
	}
	.list-inline li {
		float: left;
	}

	.header {
		position: fixed;
		left: 0;
		top: 0;
		bottom: 0;
		width: 17.5em;
		background: #35302d;
	}

	.logo {
		text-transform: lowercase;
		font: 300 2em "Source Sans Pro", Helvetica, Arial, sans-serif;
		text-align: center;
		padding: 0;
		margin: 0;
	}
	.logo a {
		display: block;
		padding: 1em 0;
		color: #dfdbd9;
		text-decoration: none;
		transition: 0.15s linear color;
	}
	.logo a:hover {
		color: #fff;
	}
	.logo a:hover span {
		color: #df4500;
	}
	.logo span {
		font-weight: 700;
		transition: 0.15s linear color;
	}

	.main-nav ul {
		border-top: solid 1px #3c3735;
	}
	.main-nav li {
		border-bottom: solid 1px #3c3735;
	}
	.main-nav a {
		padding: 1.1em 0;
		color: #dfdbd9;
		font: 400 1.125em "Source Sans Pro", Helvetica, Arial, sans-serif;
		text-align: center;
		text-transform: lowercase;
	}
	.main-nav a:hover {
		color: #fff;
	}

	.social-links {
		border-bottom: solid 1px #3c3735;
	}
	.social-links li {
		width: 25%;
		border-left: solid 1px #3c3735;
	}
	.social-links li:first-child {
		border: none;
	}
	.social-links a {
		display: block;
		height: 5.5em;
		text-align: center;
		color: #3c3735;
		font: 0.75em/5.5em "Source Sans Pro", Helvetica, Arial, sans-serif;
	}
	.social-links a:hover {
		color: #dfdbd9;
	}

	.list-hover-slide li {
		position: relative;
		overflow: hidden;
	}
	.list-hover-slide a {
		display: block;
		position: relative;
		z-index: 1;
		transition: 0.35s ease color;
	}
	.list-hover-slide a:before {
		content: "";
		display: block;
		z-index: -1;
		position: absolute;
		left: -100%;
		top: 0;
		width: 100%;
		height: 100%;
		border-right: solid 5px #df4500;
		background: #3c3735;
		transition: 0.35s ease left;
	}
	.list-hover-slide a.is-current:before,
	.list-hover-slide a:hover:before {
		left: 0;
	}
</style>
