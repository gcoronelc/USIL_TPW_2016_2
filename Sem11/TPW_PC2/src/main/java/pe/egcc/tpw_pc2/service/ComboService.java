package pe.egcc.tpw_pc2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.egcc.tpw_pc2.dao.ComboDao;
import pe.egcc.tpw_pc2.model.Combo;

@Service
public class ComboService {

  @Autowired
  private ComboDao comboDao;
  
  
  public List<Combo> getDepartamentos(){
    return comboDao.getDepartamentos();
  }
}
