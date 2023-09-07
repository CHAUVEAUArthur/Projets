<header>
    <nav>
        <section class="right-nav">
            <div>
                <a href="<?= site_url('accueil') ?>">
                    <img class="logo" src="<?= base_url('img/logo-SondageFacile.png') ?>" alt="logo"></img>
                </a> SondageFacile
            </div>
            <div><a class="rubrique">Tarification</a></div>
            <div><a class="rubrique">Contact</a></div>
        </section>
        <section class="left-nav">
            <?php if (!$this->session->userdata('user_email')) : ?>
                <div><a class="btn" href="<?= site_url('User/auth') ?>">Connexion</a></div>
                <div><a class="btn" href="<?= site_url('User/inscription') ?>">Inscription</a></div>
            <?php else : ?>
                <div><a class="btn" href="<?= site_url('User/deconnexion') ?>">Déconnexion</a></div>
                <div><a class="btn" href="<?= site_url('dashboard') ?>">Tableau de bord</a></div>  
            <?php endif; ?>

            <div><a class="btn" href="<?= site_url('sondage') ?>"><span class="right-nav-plus">+</span>Créer un sondage</a></div>
        </section>
    </nav>
</header>
