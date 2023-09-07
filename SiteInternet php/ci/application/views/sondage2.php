<html lang="en">

<head>
	<meta charset="utf-8">
	<title>Sondage</title>
	<link rel="stylesheet" type="text/css" href="<?= base_url('asset/styles.css') ?>">
	<link rel="stylesheet" type="text/css" href="<?= base_url('asset/sondage.css') ?>">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
	<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
</head>

<body>
	<?php $this->load->view('header'); ?>
	<?= validation_errors(); ?>
	<?= form_open('sondage/sondage2') ?>

	<main>
		<div class="container">
			<div>
				<h1>Nouveau</h1>
				<div class="etape">étape 2 sur 2</div>
				</div>
			<div class="container-choix-date-parent">
				<div class="choix-date-container">
					<div class="choix-date-div1">
						<label for="date">Choisissez vos dates et vos horaires</label>
					</div>
					<div class="choix-date-horaire choix-date-div4">
						<div class="choix-date-input">
							<div class="input-delete-date-container">
								<div id="input-delete-date-for-js-1">
									
								</div>
							</div>
							<div class="ajouter-date">
								<button type="button" onclick="addDate()">+ Ajouter une date</button>
							</div>
						</div>
					</div>
				</div>
				<?php if (isset($error)) {
					echo $error;
				} ?>
				<div class="btn-suivant-container">
					<!-- Button -->
					<button type="submit" class="btn btn-suivant">Suivant</button>
				</div>
			</div>
		</div>
	</main>
	<?php $this->load->view('footer'); ?>
	<script src="<?= base_url('asset/sondage2.js') ?>"></script>
</body>

</html>
