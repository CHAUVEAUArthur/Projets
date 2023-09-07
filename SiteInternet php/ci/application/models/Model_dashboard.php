<?php if (!defined('BASEPATH'))
    exit('No direct script access allowed');

class Model_dashboard extends CI_Model
{
    public function __construct()
    {
        $this->load->database();
    }
    public function getName() {
        if  ( $this->session->userdata('name')) {
             return $this->session->userdata('name');
        } else {
         return false ;
        }
     }
    
   
}