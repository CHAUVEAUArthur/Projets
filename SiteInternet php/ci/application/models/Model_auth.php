<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Model_auth extends CI_Model {
    public function __construct(){
		$this->load->database();
	}
    public function auth($email,$password){
        $this->db->where('email', $email);
        $user = $this->db->get('SAEUser')->row_array();

        if ($user && password_verify($password, $user['password'])) {
            return array(
                'email'=>$user['email'],
                'nom' =>$user['nom'],
                'prénom'=>$user['prénom']
            );
        }

        return false;
    }
}