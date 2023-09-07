<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<?= base_url('asset/styles.css') ?>">
    <link rel="stylesheet" type="text/css" href="<?= base_url('asset/dashboard.css') ?>">
    <title>SondageFacile</title>
</head>

<body>
    <?php $this->load->view('header'); ?>
    <main>
        <div class="upper-dashboard-white-space"></div>
        <div class="container">
            <div class="dashboard-titre">
                <h1 class="dashboard-h1">Tableau de bord des sondages</h1>
                <!-- ajouter dynamiquement le nom de l'utilisateur connecté -->
                <h1 class="dashboard-h1">Bonjour
                    <?php echo $user['name']; ?>
                </h1>
            </div>

            <!-- Liste des sondages existants -->
            <h2 class="dashboard-liste-sondage">Liste des sondages</h2>
            <ul class="liste-sondage">
                <?php foreach ($ids as $id): ?>
                    <div class="dashboard-single-sondage">
                        
                        <?php $className = "dashboard-liste-sondage";
                        echo '<div class="' . $className . '">' . $id['titre'] . '</div>';
                        ?>
                        <?php $className = "dashboard-localisation";
                        echo '<div class="' . $className . '">' . " " . $id['localisation'] . '</div>';
                        ?>
                        <?php $className = "dashboard-description";
                        echo '<div class="' . $className . '">' . $id['description'] . '</div>';
                        ?>

                        <?php if (!empty($id['urlinvite'])): ?>
                            <div class="invite-edition-container">
                                <a class="btn" href="<?php echo $id['urlinvite']; ?>">Invitation</a>
                            <?php endif; ?>
                            <?php if (!empty($id['urledit'])): ?>
                                <a class="btn" href="<?php echo $id['urledit']; ?>">Édition</a>
                            </div>
                        <?php endif; ?>



                    </div>
                <?php endforeach; ?>
            </ul>



        </div>
        <div class="lower-dashboard-white-space"></div>
    </main>
    <?php $this->load->view('footer'); ?>
</body>

</html>