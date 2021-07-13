package exemplorest003;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/list")
	public Iterable<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/find/{id}")
    public Optional<Usuario> findUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findById(id);
    }
	
	@PostMapping("/add")
	public String addUsuario(@RequestParam String nome, @RequestParam String email) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuarioRepository.save(usuario);
		return "Inserido com sucesso";
	}
	
    @DeleteMapping("/delete/{id}")
	public void deleteUsuario(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}
    
    @PutMapping("/update")
	public String updateUsuario(@RequestParam Long id, @RequestParam String nome, @RequestParam String email) {
    	Usuario usuario;
    	usuario = new Usuario();
    	usuario.setId(id);
    	usuario.setNome(nome);
    	usuario.setEmail(email);
    	usuarioRepository.save(usuario);
		return "Alterado com sucesso";
	}
	
	
	
	

}
