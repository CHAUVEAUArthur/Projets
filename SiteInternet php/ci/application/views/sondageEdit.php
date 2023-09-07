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
    <main>
        <div class="upper-sondageEdit-white-space"></div>
        <div class="sondageEdit-container">
        <div class="sondageEdit-titre">
    <h1 class="sondageEdit-h1">Partager via un lien</h1>
    <h2>Envoyez ce lien à vos participants <a href="<?php echo $sondage['urlinvite']; ?>"><?php echo $sondage['urlinvite']; ?></a></h2>
</div>
            <div class="lower-sondageEdit-white-space"></div>
        </div>
                <div class="between-sondageEdit-white-space"></div>
        <div class="sondageEdit-container">
            <div class="sondageEdit-titre">
                <h1 class="sondageEdit-h1"><?php echo $sondage['titre']; ?></h1>
                <h2>Localisation</h2>
                <h3><?php echo $sondage['localisation'] ; ?></h3>
                <h2>Description</h2>
                <h3><?php echo $sondage['description']; ?></h3>
            </div>
        </div>
        <div class="between-sondageEdit-white-space"></div>
        <div class="sondageEdit-container">
            <div class="sondageEdit-titre">
            <div>
    <h1 class="sondageEdit-h1">Dates</h1>
    <h4>Jours :</h4>
    <?php if (!empty($option)) : ?>
        <ul>
            <?php foreach($option as $p): ?>
                <li><?php echo $p['jour']['jour']; ?> <p>validé</p><?php echo $p['validation']; ?></li>
            <?php endforeach; ?>
        </ul>
    <?php else : ?>
        <p>Aucun jour disponible.</p>
    <?php endif; ?>
</div>




            </div>
        </div>
        <div class="between-sondageEdit-white-space"></div>
        <div class="sondageEdit-container">
    <div class="sondageEdit-titre">
        <h1>Clôturer le sondage</h1>
        <?php if ($cloture) : ?>
            <form method="post" action="<?php echo site_url('sondage/cloturer?cle=' . $id ); ?>">
    <input type="hidden" name="idsondage" value="<?php echo $id; ?>">
    <button type="submit" name="cloturer" class="btn">Clôturer</button>
</form>

        <?php else : ?>
            <button type="submit" class="btn" disabled>Clôturé</button>
        <?php endif; ?>
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