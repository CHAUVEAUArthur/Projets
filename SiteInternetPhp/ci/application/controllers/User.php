<?php
defined('BASEPATH') or exit('No direct script access allowed');

class User extends CI_Controller
{

	public function __construct()
	{
		parent::__construct();
		$this->load->helper('html');
		$this->load->library('form_validation');
	}

	public function inscription()
	{

		$this->load->model('model_compte');
		$this->form_validation->set_rules('login', 'Login', 'required');
		$this->form_validation->set_rules('nom', 'Nom', 'required');
		$this->form_validation->set_rules('prénom', 'Prénom', 'required');
		$this->form_validation->set_rules('email', 'Adresse email', 'valid_email');
		$this->form_validation->set_rules('password', 'current password', 'min_length[5]|required');
		$this->form_validation->set_rules('cpassword', 'confirm password', 'required|matches[password]');


		if ($this->form_validation->run() === FALSE) {
			$this->load->view('inscription');

		} else {

			$data = array(
				'login' => $this->input->post('login'),
				'nom' => $this->input->post('nom'),
				'prénom' => $this->input->post('prénom'),
				'email' => $this->input->post('email'),
				'password' => password_hash($this->input->post('password'), PASSWORD_DEFAULT)
			);
			$this->model_compte->createCompte($data);
			redirect('/accueil');
		}
	}

	public function auth()
	{
		$this->load->model('model_auth');
		$this->form_validation->set_rules('email', 'Adresse email', 'valid_email');
		$this->form_validation->set_rules('password', 'current password', 'min_length[5]|required');

		if ($this->form_validation->run() === FALSE) {
			$this->load->view('auth');
		} else {
			$data = array(
				$email = $this->input->post('email'),
				$password = $this->input->post('password'),
			);
			$user = $this->model_auth->auth($email, $password);

			if ($user) {
				$this->session->set_userdata('user_email', $user['email']);
				
				$this->session->set_userdata('name', $user['nom']);

				redirect('/accueil');
			} else {
				// Afficher un message d'erreur si les informations d'identification sont incorrectes
				$data['error'] = 'Email ou mot de passe incorrect';
				$this->load->view('auth', $data);
			}
		}
	}

	public function deconnexion()
	{
		$this->session->unset_userdata('user_email');
		$this->session->unset_userdata('name');
		redirect('/accueil');
	}
}