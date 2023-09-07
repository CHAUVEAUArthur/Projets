<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Sondage extends CI_Controller
{

	public function __construct()
	{
		parent::__construct();
		$this->load->library('form_validation');
		$this->load->helper('url');
		$this->load->helper(array('cookie', 'url'));
		$this->load->helper('form');



	}
	public function index()
	{

		$this->form_validation->set_rules('titre', 'Titre', 'required');
		$this->form_validation->set_rules('localisation', 'Localisation', 'required');

		$this->load->model('Model_sondage');
		$this->load->model('Model_compte');
		$owner = $this->Model_compte->getemail();
		if (!$this->session->userdata('user_email')) {
			redirect('/User/auth');
		} else {
			https://dwarves.iut-fbleau.fr/~chauveau/SAE_S2.02/ci/index.php/sondage/sondageEdit?cle=44df2624112979bb9a832b1034040b62eb8bdfbc11a71487a4906036eed54b57
			if ($this->form_validation->run() === FALSE) {
				$this->load->view('sondage');
			} else {

				$titre = $this->input->post('titre');
				$localisation = $this->input->post('localisation');
				$description = $this->input->post('description');
				$owner = $this->Model_compte->getemail();
				$idsondage = $this->Model_sondage->createSondage($titre, $description, $localisation, $owner);
				$expiration_cookie = 3600;
				set_cookie('idsondage', $idsondage, $expiration_cookie);

				redirect('sondage/sondage2');
			}
		}

	}

	https://dwarves.iut-fbleau.fr/~chauveau/SAE_S2.02/ci/index.php/sondage/sondageEdit?cle=44df2624112979bb9a832b1034040b62eb8bdfbc11a71487a4906036eed54b57
	public function sondage2()
	{
		$this->load->model('Model_sondage');
		$this->load->helper(array('cookie', 'url'));

		$this->form_validation->set_rules('date[]', 'Date', 'required');

		if ($this->form_validation->run() === FALSE) {
			$this->load->view('sondage2');
		} else {
			$dates = $this->input->post('date');


			// Boucle pour traiter toutes les dates soumises
			foreach ($dates as $date) {
				// Traitez chaque date ici selon vos besoins
				$idsondage2 = $this->Model_sondage->createjour(get_cookie('idsondage'), $date);
			}

			redirect('/sondage/sondageEdit');
		}
	}
	public function sondageEdit()
	{
		$this->load->model('Model_sondage');
		if ($this->input->get('cle')) {
			$idsondage = $this->input->get('cle');
			set_cookie('id', $idsondage, 3600);
		} else {
			$idsondage = get_cookie('idsondage');
		}



		$sondage = $this->Model_sondage->getSondage($idsondage);
		$datasondage = array(
			'titre' => $sondage['titre'],
			'localisation' => $sondage['localisation'],
			'description' => $sondage['description'],
			'urlinvite' => $sondage['urlinvite']
		);
		$jours_tableau = $this->Model_sondage->getjour($idsondage);

		for($i=0;$i<count($jours_tableau);$i++){
		$dataoption[$i] = array('jour' => $jours_tableau[$i], 'validation' => $this->Model_sondage->getvalidationjours($jours_tableau[$i]['id']));
		}
	
		//$datajour = array('jour '=>$jours_tableau['jour']);

		//$data['jour'] = $datajour;
		$data['sondage'] = $datasondage;
		$data['id']=$idsondage;
		$data['option'] = $dataoption;
		$data['cloture'] = true;

		if ($this->input->post('cloturer')) {
			$this->cloturer();
		}


		$this->load->view('sondageEdit', $data);

	}
	public function cloturer()
	{
		$idsondage = $this->input->post('idsondage');
		$this->load->model('Model_sondage');

		$idsondage = $this->input->get('cle');
		$this->Model_sondage->deleteinvite($idsondage);
		$this->Model_sondage->deletejour($idsondage);
		$this->Model_sondage->deleteSondage($idsondage);



		redirect('/dashboard');
	}

	public function sondagePseudo()
	{

		$this->load->model('Model_sondage');
		$this->form_validation->set_rules('login', 'Login', 'required');
		;

		if ($this->form_validation->run() === FALSE) {
			$this->load->view('sondagePseudo');
		} else {
			$pseudo = $this->input->post('login');
		
			
			if ($this->Model_sondage->pseudoExists($pseudo)) {
				$data['error'] = 'Le pseudo existe déjà. Veuillez choisir un autre pseudo.';
				$this->load->view('sondagePseudo', $data);
			} else {
				set_cookie('pseudo', $pseudo, '3600');
				$idsondage = $this->input->get('cle');
				redirect('sondage/sondageInvite?cle=' . $idsondage);
			}
		}
	}

	public function sondageInvite()
	{
		$this->load->model('Model_sondage');
		$this->form_validation->set_rules('checkboxes[]', 'Checkbox', 'required');



		$idsondage = $this->input->get('cle'); //get_cookie('idsondage'); //$this->uri->segment(4); // Récupère la valeur du paramètre 'id' de l'URL
		$pseudo = get_cookie('pseudo');

		$sondage = $this->Model_sondage->getSondage($idsondage);
		$datasondage = array(
			'titre' => $sondage['titre'],
			'localisation' => $sondage['localisation'],
			'description' => $sondage['description']
		);

		$jours_tableau = $this->Model_sondage->getjour($idsondage);
		for($i=0;$i<count($jours_tableau);$i++){
			$dataoption[$i] = array('jour' => $jours_tableau[$i], 'validation' => $this->Model_sondage->getvalidationjours($jours_tableau[$i]['id']));
			}

		$data['pseudo'] = array('pseudo' => $pseudo);
		$data['sondage'] = $datasondage;
		$data['option'] = $dataoption;




		if ($this->form_validation->run() === FALSE) {
			$this->load->view('sondageInvite', $data);
		} else {

			foreach ($dataoption as $date) {
				$checkboxValue = $this->input->post('checkboxes[' . $date['jour']['jour'] . ']');

				if ($checkboxValue === '1') {
					$idjour = $this->Model_sondage->getidjour($idsondage, $date['jour']['jour']);

					$this->Model_sondage->createInvite($idsondage, $pseudo, $idjour[0]);
				}
			}

			redirect('/accueil');
		}
	}
}