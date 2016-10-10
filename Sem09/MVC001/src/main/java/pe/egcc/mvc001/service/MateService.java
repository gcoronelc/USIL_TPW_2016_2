package pe.egcc.mvc001.service;

import org.springframework.stereotype.Service;

@Service
public class MateService {
	
	public int sumar(int n1, int n2){
	  int r;
	  r = (n1 + n2);
	  return r;
	}
	
}
