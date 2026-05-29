package pe.edu.utp.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.utp.backend.entity.Pago;
import pe.edu.utp.backend.repository.PagoRepository;
import pe.edu.utp.backend.service.PagoService;



@Service
public class PagoServiceimpl implements PagoService {

     @Autowired
     private PagoRepository repository;

     @Override
     public List<Pago> getall() {
        return repository.findAll();
     }

     @Override
     public Pago guardarpago(Pago Pago) {
        return repository.save(Pago);
     }

     @Override
     public Optional<Pago> getId(Long id) {
        return repository.findById(id);
     }

   

   

}