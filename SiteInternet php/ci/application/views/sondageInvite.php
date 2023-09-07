<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<?= base_url('asset/styles.css') ?>">
    <link rel="stylesheet" type="text/css" href="<?= base_url('asset/sondageEdit.css') ?>">
    <title>SondageFacile</title>
</head>

<body>
    <?php $this->load->view('header'); ?>
    <?= validation_errors(); ?>
    <?= form_open('sondage/sondageInvite?cle=' . $this->input->get('cle')) ?>
    <main>
        <div class="upper-sondageEdit-white-space"></div>
        <div class="sondageEdit-container">
        <div class="sondageEdit-titre">
                <h1 class="sondageEdit-h1"><?php echo $sondage['titre'] ; ?></h1>
                <h2>Localisation</h2>
                <h3><?php echo $sondage['localisation']; ?></h3>
                <h2>Description</h2>
                <h3><?php echo $sondage['description']; ?></h3>
            </div>
        </div>
        <div class="between-sondageEdit-white-space"></div>
        <div class="sondageEdit-container">
            <div class="sondageEdit-titre">
            <label for="login">
    Pseudonyme
    <?php echo $pseudo['pseudo']; ?>
</label>
            </div>
        </div>
        <div class="between-sondageEdit-white-space"></div>
        <div class="sondageEdit-container">
            <div class="sondageEdit-titre">
            <div>
                    <h1 class="sondageEdit-h1">Dates</h1>
                    
                    <h4>Jours :</h4>
                    <form method="post" action="controller/action">
                    <ul>
    <?php foreach ($option as $jour): ?>
        <li>
            <?php echo $jour['jour']['jour']; ?>
            <?php echo form_checkbox('checkboxes['.$jour['jour']['jour'].']', '1', FALSE); ?>
        </li>
    <?php endforeach; ?>
</ul>
</form>


               
                </div>
            </div>
        </div>
        <div class="between-sondageEdit-white-space"></div>
        <?php if (isset($error)) {
					echo $error;} ?>
      
        <div class="sondageEdit-container">
            <div class="sondageEdit-titre">
                <!-- Button -->
                <button type="submit" class="btn">Envoyer</button>
            </div>
        </div>
        

        <div class="lower-sondageEdit-white-space"></div>
    </main>
    <?php $this->load->view('footer'); ?>
</body>
<script>
    function toggleButton(button) {
        button.classList.toggle('active');

        if (button.classList.contains('active')) {
            button.innerHTML = 'No';
        } else {
            button.innerHTML = 'Yes';
        }
    }
</script>

</html>