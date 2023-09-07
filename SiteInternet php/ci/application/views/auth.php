<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Se connecter</title>
	<link rel="stylesheet" type="text/css" href="<?= base_url('asset/styles.css') ?>">
	<link rel="stylesheet" type="text/css" href="<?= base_url('asset/auth.css') ?>">
</head>

<body>
	<?php $this->load->view('header'); ?>
	<div class="upper-sondageEdit-white-space"></div>
	<div class="auth-container">
		<h1>Se connecter</h1>
		<?= validation_errors(); ?>
		<?= form_open('User/auth') ?>
		<label for="email">Adresse mail</label>
		<input type="email" id="email" name="email" placeholder="Email" value="<?= set_value('email') ?>" required>
		<div class="grid">
			<label for="password">Password
				<input type="password" id="password" name="password" placeholder="Password"
					value="<?= set_value('password') ?>" required>
			</label>
		</div>
		<br>
		<?php if (isset($error)) {
			echo $error;
		} ?>
		<br>
		<!-- Button -->
		<button type="submit">Se connecter</button>
		<p>Vous n'avez pas encore de compte ? <a
				href="<?= site_url('User/inscription') ?>"><strong>S'inscrire</strong></a></p>
		</form>
	</div>
	<div class="lower-sondageEdit-white-space"></div>
	<?php $this->load->view('footer'); ?>

</body>

</html>