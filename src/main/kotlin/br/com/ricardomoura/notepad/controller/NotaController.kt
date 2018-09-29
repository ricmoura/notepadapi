package br.com.ricardomoura.notepad.controller

import br.com.ricardomoura.notepad.model.Nota
import br.com.ricardomoura.notepad.service.NotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.xml.ws.Service

@RestController //controler do tipo rest
@RequestMapping ("/nota")
class NotaController{

    @Autowired
    lateinit var notaService: NotaService

    @GetMapping ("/check")
    fun checkHealth(): String{
        return "OK"
    }

    @GetMapping
    fun buscatTodos() : List<Nota>{
        return notaService.buscarTodos()
    }

    @PostMapping
    fun salvar(@RequestBody nota: Nota): Nota{
        return notaService.salvar(nota)
    }

    @GetMapping("/{id}")
    fun buscarPor(@PathVariable("id") id: String) : Nota{
        return notaService.buscarPor(id)
    }

    @GetMapping("/titulo/{titulo}")
    fun buscarPorTitulo(@PathVariable("titulo") titulo: String) : List<Nota>{
        return notaService.buscarPorTitulo(titulo)
    }

}