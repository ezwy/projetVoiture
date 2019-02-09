package Control;

import DAO.DAOVoiture;
import Entities.Voiture;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ying Enzweiler
 */
public class ServiceVoiture2 {
    public ServiceVoiture2(){
        
    }
    public ArrayList<Voiture> getAll(){
        DAOVoiture dvoiture = new DAOVoiture();
        ArrayList<Voiture> voitures = (ArrayList<Voiture>) dvoiture.getAll();
        return voitures;
    }
    public boolean delete(String id){
        DAOVoiture dvoiture = new DAOVoiture();
        boolean b = dvoiture.delete(id);
        return b;
    }
}
