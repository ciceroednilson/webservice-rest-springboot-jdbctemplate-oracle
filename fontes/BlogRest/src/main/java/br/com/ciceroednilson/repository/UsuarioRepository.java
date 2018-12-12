package br.com.ciceroednilson.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.ciceroednilson.model.ResultadoModel;
import br.com.ciceroednilson.model.UsuarioModel;

/**
 * CLASSE RESPONSÁVEL POR PERSISTIR AS INFORMAÇÕES DE USUÁRIO NO BANCO DE DADOS
 * @author cicero
 *
 */
@Repository
public class UsuarioRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/***
	 * ESSE MÉTODO CADASTRA UM NOVO USUÁRIO NO BANCO DE DADOS	
	 * @param usuario
	 * @return
	 */
	public ResultadoModel cadastrar(UsuarioModel usuario){
		
		try {
			
			jdbcTemplate.update(QuerysRepository.INSERIR_USUARIO, usuario.getLogin(),usuario.getSenha(),usuario.getAtivo());
			
		} catch (Exception e) {
			
			return new ResultadoModel(0,"Erro ao cadastrar o registro! detalhe:" + e.getMessage());	
		}
		
		return new ResultadoModel(1,"Registro cadastrado com sucesso!");
	}
	
	/**
	 * ESSE MÉTODO RETORNAR TODOS OS USUÁRIOS CADASTRADOS
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<UsuarioModel> usuarios(){
				
		return jdbcTemplate.query(QuerysRepository.CONSULTAR_USUARIOS, new BeanPropertyRowMapper(UsuarioModel.class));
		
	}
	
	/**
	 * ESSE MÉTODO RETORNA UM USUÁRIO CADASTRADO PELO CÓDIGO
	 * @param codigo
	 * @return
	 */
	public UsuarioModel usuario(int codigo){
		
		return jdbcTemplate.queryForObject(QuerysRepository.SELECIONAR_USUARIO, new BeanPropertyRowMapper<UsuarioModel>(UsuarioModel.class),codigo);
		
	}

	/**
	 * ATUALIZA AS INFORMAÇÕES DO USUÁRIO
	 * @param usuario
	 * @return
	 */
	public ResultadoModel atualizarUsuario(UsuarioModel usuario){
		
		try {
			
			jdbcTemplate.update(QuerysRepository.ATUALIZAR_USUARIO, 
					usuario.getLogin(), 
					usuario.getSenha(), 
					usuario.getAtivo(), 
					usuario.getCodigo());
			
		} catch (Exception e) {
			
			return new ResultadoModel(0,"Erro ao atualizar o registro! detalhe:" + e.getMessage());	
		}
		
		return new ResultadoModel(1,"Registro atualizado com sucesso!");
	}
	
	/**
	 * EXCLUI UM USUÁRIO DA BASE PELO CÓDIGO INFORMADO
	 * @param codigo
	 * @return
	 */
	public ResultadoModel excluirUsuario(int codigo){
		
		try {
			
			jdbcTemplate.update(QuerysRepository.EXCLUIR_USUARIO, codigo);
			
		} catch (Exception e) {
			
			return new ResultadoModel(0,"Erro ao excluir o registro! detalhe:" + e.getMessage());	
		}
		
		return new ResultadoModel(1,"Registro excluido com sucesso!");
	}
	
	
	
}

