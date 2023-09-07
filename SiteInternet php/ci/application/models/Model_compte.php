<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Model_compte extends CI_Model {
    public function __construct(){
		$this->load->database();
        if (!isset($this->session)) {
            $this->load->library('session');
        }
	}

    public function createCompte($data){
        $this->db->insert('SAEUser', $data);
    }

    public function getemail() {
       if  ( $this->session->userdata('user_email')) {
            return $this->session->userdata('user_email');
       } else {
        return false ;
       }      
    }

    public function getUsername() {
        if  ( $this->session->userdata('username')) {
             return $this->session->userdata('username');
        } else {
         return false ;
        }
     }
}