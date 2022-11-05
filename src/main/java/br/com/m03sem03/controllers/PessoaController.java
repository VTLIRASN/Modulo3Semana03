package br.com.m03sem03.controllers;

import br.com.m03sem03.model.PessoaModel;
import br.com.m03sem03.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

   @Autowired
   private  PessoaRepository pessoaRepository;

   @PostMapping(value = "/cadastrar" , produces = "application/json")
   public ResponseEntity<PessoaModel> cadastrar(@RequestBody PessoaModel pessoaModel){

       PessoaModel pessoa = pessoaRepository.save(pessoaModel);
       return new ResponseEntity<PessoaModel>(pessoa, HttpStatus.CREATED);

   }

    @PutMapping(value = "/atualizar" , produces = "application/json")
    public ResponseEntity<PessoaModel> atualizar(@RequestBody PessoaModel pessoaModel){

       PessoaModel pessoa = pessoaRepository.save(pessoaModel);
       return new ResponseEntity<PessoaModel>(pessoa, HttpStatus.OK);


    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idPessoa){
        pessoaRepository.deleteById(idPessoa);
        return new ResponseEntity<String>("Contato Deletado com Sucesso!" , HttpStatus.OK);
    }

    @GetMapping(value = "/{idPessoa}")
    public ResponseEntity<PessoaModel> getPessoById(@PathVariable(value = "idPessoa") Long idPessoa){
       PessoaModel pessoaModel = pessoaRepository.findById(idPessoa).get();
       return new ResponseEntity<PessoaModel>(pessoaModel , HttpStatus.OK);
    }

}


//{
//        "id" : "1",
//        "nome" : "Victor",
//        "email" : "VTLIRA@OUTLOOK.COM",
//        "estado" : "Santa Catarina" ,
//        "cidade" : " Florianopolis " ,
//        "logradouro" : "Servidao Nova Esperanca",
//        "cep" : "88063037"
//
//        }
