<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Sondage</title>
	<link rel="stylesheet" type="text/css" href="<?= base_url('asset/styles.css') ?>">
	<link rel="stylesheet" type="text/css" href="<?= base_url('asset/sondage.css') ?>">
</head>

<body>
	<?php $this->load->view('header'); ?>
	<?= validation_errors(); ?>
	<?= form_open('sondage') ?>
	<main>
		<div class="container">
			<div>
				<h1>Nouveau</h1>
				<div class="etape">étape 1 sur 2</div>
			</div>
			<form>
				<div>
					<h2>Titre à choisir</h2>
					<input type="text" name="titre" placeholder="Titre">
				</div>
				<div>

					<h2>Localisation</h2>
					<input type="text" name="localisation" placeholder="Localisation">
				</div>
				<div>
					<h2>Description</h2>
					<textarea class="description" rows="5" cols="33" name="description"
						placeholder="Description"></textarea>
				</div>

				<?php if (isset($error)) {
					echo $error;
				} ?>

				<div>
					<!-- Button -->
					<button type="submit" class="btn">Suivant</button>

				</div>
			</form>
		</div>
	</main>

	<?php $this->load->view('footer'); ?>
</body>

</html>