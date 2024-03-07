package br.com.ero.servidorpublicobdwebmvc.controller;


import br.com.ero.servidorpublicobdwebmvc.entity.ServidorPublico;
import br.com.ero.servidorpublicobdwebmvc.service.ServidorPublicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ServidorPubicoController {

    @Autowired
    private ServidorPublicoService servidorPublicoService;

    @GetMapping("/listarServidores")
    public String listarServidores(Model model)
    {
        model.addAttribute("servidorespublicos",servidorPublicoService.listAll());
        return "servidorespublicos";
    }
    @GetMapping("/listarServidor/{matricula}")
    public String listarServidor(@PathVariable long matricula, Model model){
        model.addAttribute("servidorpublico",servidorPublicoService.listByMatricula(matricula).get());
        return "servidorpublico";

    }

    @GetMapping("/excluirServidor/{matricula}")
    public String excluirServidor(@PathVariable long matricula){
        servidorPublicoService.delete(matricula);
        return "redirect:/listarServidores";

    }

    @GetMapping("/formularioEditarServidor/{matricula}")
    public String formEditarServidor(@PathVariable long matricula, Model model){
        Optional<ServidorPublico> servidorEncontrado = servidorPublicoService.listByMatricula(matricula);
        model.addAttribute("servidorPublico", servidorEncontrado);
        return "editarservidorpublico";

    }

    @PostMapping("/editarServidor/{matricula}")
    public String editarServidor( @ModelAttribute ServidorPublico servidor){
        servidorPublicoService.update(servidor);
        return "redirect:/listarServidores";

    }

    @GetMapping("/formularioNovoServidor")
    public String formNovoServidor(Model model){
        model.addAttribute("servidorPublico", new ServidorPublico());
        return "novoservidorpublico";

    }

    @PostMapping("/cadastrarServidor")
    public String cadastrarServidor(@ModelAttribute ServidorPublico novoservidor){
        Optional<ServidorPublico> servidorEncontrado = servidorPublicoService.listByMatricula(novoservidor.getMatricula());
        if (!servidorEncontrado.isPresent()){
            servidorPublicoService.save(novoservidor);
        } else {
            return "redirect:/mensagem";
        }
        return "redirect:/listarServidores";

    }


    @GetMapping("/mensagem")
    public String mensagem (Model model){
        model.addAttribute("erroMatriculaExistente", true);
        return "erro/mensagem";
    }

}
