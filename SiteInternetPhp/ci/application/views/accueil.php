<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="<?= base_url('asset/styles.css') ?>">
    <title>SondageFacile</title>
</head>

<body>
    <?php $this->load->view('header'); ?>
    <main>
        <div class="planification-pro">
            <div class="planification-pro-text">
                <h1 class="planification-pro-text-title">La planification professionnelle facilitée</h1>
                <p class="planification-pro-text-content">SondageFacile est le moyen le plus rapide et le plus facile
                    pour tout planifier, des réunions à la
                    prochaine grande collaboration.</p>
            </div>
            <img src="<?= base_url('img/sondage.jpg') ?>" alt="sondage" class="sondage-img"></img>
        </div>
        <div class="arguments">
            <div class="argument">
                <img src="https://images.ctfassets.net/p24lh3qexxeo/4peisM5Yz9WmMjIKstNUCX/6a4b7a01d6c57dea73fff9c78f81d3d7/first-icon.png?w=1280&q=80&fm=webp"
                    alt="argument">
                <p>Approuvé par plus de 70 000 entreprises dans le monde</p>
            </div>
            <div class="argument">
                <img src="https://images.ctfassets.net/p24lh3qexxeo/6F6MxkkpIbU1W3HXRUGgsz/3c02c9d21ce0f089345553b3dee0b21e/second-icon.png?w=1280&q=80&fm=webp"
                    alt="argument">
                <p>2 millions de réunions programmées le mois dernier</p>
            </div>
            <div class="argument">
                <img src="https://images.ctfassets.net/p24lh3qexxeo/IwWmCELvQNRwAoTUcBwgS/be349b966f36d1bc2a7ab6921198f4ad/third-icon.png?w=1280&q=80&fm=webp"
                    alt="argument">
                <p>Sécurité au niveau de l’entreprise</p>
            </div>
            <div class="argument">
                <img src="https://images.ctfassets.net/p24lh3qexxeo/5r5Sg3iLExDQHxaspciFSx/b7c0fac70479943da5724be343eb84d6/fourth-icon.png?w=1280&q=80&fm=webp"
                    alt="argument">
                <p>Commence à prendre des rendez-vous en 5 minutes</p>
            </div>
        </div>
    </main>
    <?php $this->load->view('footer'); ?>
</body>

</html>