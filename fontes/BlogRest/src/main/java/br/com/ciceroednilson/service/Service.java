package br.com.ciceroednilson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ciceroednilson.model.ResultadoModel;
import br.com.ciceroednilson.model.UsuarioModel;
import br.com.ciceroednilson.repository.UsuarioRepository;

/**
 * CLASSE RESPONSÁVEL POR DISPONIBILIZAR OS NOSSO MÉTODOS VIA HTTP COMO SERVIÇO REST
 * @author cicero
 *
 */
@RestController
@RequestMapping("/service")
public class Service {

	/*CRIANDO O OBJETO DE PERSISTENCIA DO USUÁRIO*/
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	/**
	 * ESSE MÉTODO CADASTRA UM NOVO USUÁRIO COMO MOSTRA O EXEMPLO ABAIXO.
	 * 
	 * EXEMPLO:
	 * 
	 * 	URL: http://localhost:8090/service/usuario
	 * 
	 *  REQUEST JSON:
	 *  			{
	 *  				"login":"cicero",
	 *  				"senha":"123456",
	 *  				"ativo":0
	 *  			}
	 *  
	 *  
	 *  RESPONSE JSON:
	 *  			{
	 *  				"codigo": 1,
	 *  				"mensagem": "Registro cadastrado com sucesso!"
	 *  			}
	 *  
	 *  
	 * 
	 * */
	@RequestMapping(value="/usuario", 
			method = RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResultadoModel cadastrar(@RequestBody UsuarioModel usuario){
		
		return this.usuarioRepository.cadastrar(usuario);
	}
	
	
	/**
	 * ATUALIZA UM USUÁRIO COMO MOSTRA O EXEMPLO ABAIXO.
	 * 
	 * EXEMPLO: 
	 * 	 
	 * 	 URL: http://localhost:8090/service/usuario
	 * 	 
	 *   REQUEST JSON:   
	 *				{
	 *					"codigo": 1,
	 *					"login": "cicero",
	 *					"senha": "1234",
	 *					"ativo": 1
	 *				}
	 *      
	 *      
	 *   RESPONSE JSON:
	 *				{
	 *					"codigo": 1,
	 *					"mensagem": "Registro atualizado com sucesso!"
	 *				}
	 *         
	 *         
	 *         
	 *         
	 * 
	 * @param usuario
	 * @return
	 */
	@RequestMapping(value="/usuario", 
			method = RequestMethod.PUT, 
			consumes=MediaType.APPLICATION_JSON_VALUE, 
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResultadoModel atualizar(@RequestBody UsuarioModel usuario){
		
		return this.usuarioRepository.atualizarUsuario(usuario);
	}
	
	
	/**
	 * CONSULTA TODOS OS USUÁRIOS CADASTRADOS COMO MOSTRA O EXEMPLO ABAIXO
	 * 
	 * EXEMPLO:
	 * 	 URL:http://localhost:8090/service/usuario
	 * 
	 *   RESPONSE JSON:
	 *				[
	 *					{
	 *					  "codigo": 16,
	 *					  "login": "cicero1",
	 *					  "senha": "1234561",
	 *					  "ativo": 0
	 *					  },
	 *					  {
	 *					  "codigo": 14,
	 *					  "login": "cicero2",
	 *					  "senha": "123456",
	 *					  "ativo": 1
	 *					  }
	 *				]   	
	 *   
	 *   
	 * 
	 * @return
	 */
	@RequestMapping(value="/usuario", 
			method = RequestMethod.GET,  
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UsuarioModel> consultar(){
		
		return this.usuarioRepository.usuarios();
	
	}
	
	/**
	 * SELECIONA UM USUÁRIO PELO CÓDIGO COMO MOSTRA O EXEMPLO ABAIXO
	 * 
	 * EXEMPLO:
	 *   
	 *   URL REQUEST:http://localhost:8090/service/usuario/15
	 *   
	 *   
	 *   RESPONSE JSON:
	 *   		{
	 *   			"codigo": 1,
	 *   			"login": "cicero",
	 *   			"senha": "1234561",
	 *   			"ativo": 0
	 *   		}
	 *   		
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/usuario/{codigo}", 
			method = RequestMethod.GET,  
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UsuarioModel selecionar(@PathVariable("codigo") Integer codigo){
	
		return this.usuarioRepository.usuario(codigo);
	}
	
	/**
	 * EXCLUI UM USUÁRIO PELO CÓDIGO COMO MOSTRA O EXEMPLO ABAIXO;
	 * 
	 * EXEMPLO:
	 * 	
	 * 	URL REQUEST:http://localhost:8090/service/usuario/16
	 * 
	 * 	RESPONSE JSON:
	 * 				{
	 * 					"codigo": 1,
	 * 					"mensagem": "Registro excluido com sucesso!"
	 * 				}
	 * 
	 * @param codigo
	 * @return
	 */
	@RequestMapping(value="/usuario/{codigo}", 
			method = RequestMethod.DELETE,  
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResultadoModel delete(@PathVariable("codigo") Integer codigo){
	
		return this.usuarioRepository.excluirUsuario(codigo);
	}
}
