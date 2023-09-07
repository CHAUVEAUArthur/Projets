<html lang="en">

<head>
	<meta charset="utf-8">
	<title>S'inscrire</title>
	<link rel="stylesheet" type="text/css" href="<?= base_url('asset/styles.css') ?>">
	<link rel="stylesheet" type="text/css" href="<?= base_url('asset/stylesInscription.css') ?>">
</head>

<body>
	<?php $this->load->view('header'); ?>
	<?= validation_errors(); ?>
	<?= form_open('User/inscription') ?>
	<div class="form-inscription">
		<div class="form-elt-inscription">
			<label for="login">
				Pseudonyme
				<input class="input-form" type="text" id="login" name="login" placeholder="Pseudonyme"
					value="<?= set_value('login') ?>" required>
			</label>
		</div>
		<div class="form-elt-inscription">
			<label for="prénom">
				Prénom
				<input class="input-form" type="text" id="prénom" name="prénom" placeholder="Prénom"
					value="<?= set_value('prénom') ?>" required>
			</label>
		</div>
		<div class="form-elt-inscription">
			<label for="nom">
				Nom
				<input class="input-form" type="text" id="nom" name="nom" placeholder="Nom"
					value="<?= set_value('nom') ?>" required>
			</label>
		</div>
		<div class="form-elt-inscription">
			<label for="email">Adresse mail</label>
			<input class="input-form" type="email" id="email" name="email" placeholder="Email"
				value="<?= set_value('email') ?>" required>
		</div>

		<div class="form-elt-inscription">
			<label for="password">Password
				<input class="input-form" type="password" id="password" name="password" placeholder="Password"
					value="<?= set_value('password') ?>" required>
			</label>
		</div>
		<div class="form-elt-inscription">
			<label for="password">Confirmation password
				<input class="input-form" type="password" id="cpassword" name="cpassword" placeholder="Password"
					value="<?= set_value('cpassword') ?>" required>
			</label>
		</div>
		
		<div class="form-elt-inscription">
			<button class="btn-inscription" type="submit">S'inscrire<button>
		</div>
		<p>Vous avez déjà un compte ? <a  href="<?= site_url('User/auth') ?>"><strong>Se connecter</strong></a></p>
	</div>
	</form>
	<?php $this->load->view('footer'); ?>
</body>

</html>