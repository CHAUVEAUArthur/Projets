<?php
defined('BASEPATH') or exit('No direct script access allowed');
class Dashboard extends CI_Controller
{

    public function __construct()
    {
        parent::__construct();
        $this->load->model('Model_dashboard');
        $this->load->model('Model_sondage');
    }

    public function index()
    {
        // echo "<pre>";
        // var_dump($this->session->userdata());
        // echo "</pre>";
        // die();
        $tableau_idsondage = $this->Model_sondage->getSondageId($this->session->userdata('user_email'));
        if(!empty($tableau_idsondage)){
        for($i=0;$i<count($tableau_idsondage);$i++) {
            $sondage[$i] = $this->Model_sondage->getSondage($tableau_idsondage[$i]);
        }
        
       
        $data['ids'] = $sondage; // Créez un tableau pour stocker les données que vous souhaitez transmettre à la vue
        
    }else{
        $sondage[] = array('titre'=>'','localisation'=>'','description' => '','urlinvite'=>'','urledit'=> '');
        $data['ids'] = $sondage;
    }
    $name = $this->Model_dashboard->getName();
    $data['user'] = array('name' => $name);
    $this->load->view('dashboard', $data);
        }


}