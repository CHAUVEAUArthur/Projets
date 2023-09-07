<?php if (!defined('BASEPATH'))
    exit('No direct script access allowed');

class Model_sondage extends CI_Model
{
    public function __construct()
    {
        $this->load->database();
    }

    public function generateID(){
        $ID = hash_hmac('sha256',uniqid(),'secret_key');
        return $ID;
    }

    public function createurl($controleur,$idsondage){
        $parametre1 = 'cle';
        $url = site_url('sondage/'.$controleur.'?'.$parametre1.'='.$idsondage);
        return $url;
    }
   

    public function geturl($idsondage){
        $this->db->select('url');
        $this->db->where('id', $idsondage);
        return $this->db->get('SAESondage');
    }

    public function createSondage($titre, $description, $localisation, $owner)  
    {
       $id = $this->generateID() ;
        $data = array( 'id' => $id ,'titre' => $titre, 'description' => $description, 'localisation' => $localisation, 'owner' => $owner, 'urlinvite' => $this-> createurl('sondagePseudo',$id), 'urledit' =>$this-> createurl('sondageEdit',$id));
        $this->db->insert('SAESondage', $data);
        return $id; //renvoie le dernier id générer
    }

    public function createjour($sondage, $jour)
    {
        $id = $this->generateID();
        $this->db->where('sondage',$sondage);
        $data = array( 'id' =>  $id ,'sondage' => $sondage ,'jour' => $jour);
        $this->db->insert('SAEOption', $data);
        return $id ; //renvoie le dernier id générer
    }

    public function pseudoExists($pseudo)
{
    $query = $this->db->get_where('SAEInvite', array('pseudo' => $pseudo));
    return $query->num_rows() > 0;
}


    public function editSondage($id, $titre, $description, $localisation, $owner)
    {
        $sql = "UPDATE SAESondage SET titre = ?, description = ?, localisation = ?, owner = ? WHERE id = ?";
        $this->db->query($sql, array($titre, $description, $localisation, $owner, $id));
    }

    public function deleteSondage($id)
    {
        $this->db->where('id', $id);
        $this->db->delete('SAESondage');
        return $this->db->affected_rows() > 0; // afected_row renvoie un booléean true si la table a etait changé
    }
    public function deletejour($id)
    {
        $this->db->where('sondage', $id);
        $this->db->delete('SAEOption');
        return $this->db->affected_rows() > 0; // afected_row renvoie un booléean true si la table a etait changé
    }
    public function deleteinvite($idsondage)
    {
        $idsjour= $this->idjour($idsondage);
        foreach($idsjour as $id){
        $this->db->where('jours', $id);
        $this->db->delete('SAEInvite');
        }
        return $this->db->affected_rows() > 0; // afected_row renvoie un booléean true si la table a etait changé
    }



    public function getSondage($id)
{
    $this->db->where('id', $id);
    $query = $this->db->get('SAESondage');
    
    if ($query->num_rows() > 0) {
        $a= $query->row_array(); // Retourne un tableau contenant les données du sondage
        array_shift($a); // Supprime le premier élément du tableau
        array_pop($a); // Supprime le dernier élément du tableau
    
        return $a;
    } else {
        return array(); // Retourne un tableau vide si aucun sondage n'a été trouvé
    }
}

    public function getSondageId($email)
        {
            $this->db->select('id');
            $this->db->where('owner', $email);
            $query = $this->db->get('SAESondage');

            if ($query->num_rows() > 0) {
                // Il y a des sondages associés à l'email
                $result = $query->result();
                $ids = array();
                foreach ($result as $row) {
                    $ids[] = $row->id;
                }
                return $ids;
            } else {
                // Aucun sondage associé à l'email
                return array();


            
        }
    }

    public function getjour($idsondage) {
        $this->db->where('sondage', $idsondage);
        $query = $this->db->get('SAEOption');
    
        if ($query->num_rows() > 0) {
            return $query->result_array(); 
        } else {
            return array(); 
        }
    }
    
    

    public function idjour($idsondage){
        $this->db->select('id');
        $this->db->where('sondage', $idsondage);
        $query = $this->db->get('SAEOption');
        $result = $query->result();
        $id = array();
            foreach ($result as $row) {
                $id[] = $row->id;
            }
            return $id;


    }

    public function getidjour($sondage,$date){
        $this->db->select('id');
        $this->db->where('sondage', $sondage);
        $this->db->where('jour', $date);
        $query = $this->db->get('SAEOption');

        
            
            $result = $query->result();
            $id = array();
            foreach ($result as $row) {
                $id[] = $row->id;
            }
            return $id;


    }

    public function createInvite($sondage,$pseudo,$idjour){
        ;
        
        $data = array( 'pseudo' => $pseudo, 'jours' =>$idjour ,'validation'=> 1);
        $this->db->insert('SAEInvite', $data);
        
         //renvoie le dernier id générer

    }

    public function getvalidationjours($idjour){
        $this->db->select(' COUNT(*) as total');
        $this->db->from('SAEInvite');
        $this->db->where('jours' ,$idjour);
        $this->db->where('validation',true);
        $query = $this->db->get();
        $result = $query->row()->total;
    
        return $result;
        

    }


}