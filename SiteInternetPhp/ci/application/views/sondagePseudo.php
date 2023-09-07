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
    <?= form_open('sondage/sondagePseudo?cle=' . $this->input->get('cle')) ?>

    <main>
        
        <div class="between-sondageEdit-white-space"></div>
        <div class="sondageEdit-container">
            <div class="sondageEdit-titre">
            <label for="login">
    Pseudonyme
    <?php echo form_input('login', set_value('login'), 'id="login" class="input-for"'); ?>
    <?php if (isset($error)) {
        echo '<p class="error">' . $error . '</p>';
    } ?>
    </label>
    
    <!-- Button -->
    <div class="btn-suivant-container">
    <button type="submit" class="btn">suivant</button>
    </div>

        
        


       
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