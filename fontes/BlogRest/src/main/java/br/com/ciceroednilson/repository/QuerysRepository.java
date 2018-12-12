package br.com.ciceroednilson.repository;

public class QuerysRepository {

	/*INSERIR UM NOVO USUÁRIO*/
	public static final String INSERIR_USUARIO = "INSERT INTO cicero.tb_usuario(ds_login,ds_senha,fl_ativo) VALUES(?,?,?)";
	
	/*CONSULTAR TODOS USUÁRIOS*/
	public static final String CONSULTAR_USUARIOS = "SELECT id_usuario codigo, ds_login login, ds_senha senha, fl_ativo ativo FROM cicero.tb_usuario";
	
	/*SELECIONAR UM USUÁRIO PELO CÓDIGO*/
	public static final String SELECIONAR_USUARIO = "SELECT id_usuario codigo, ds_login login, ds_senha senha, fl_ativo ativo FROM cicero.tb_usuario WHERE id_usuario = :id_usuario";
	
	/*EXCLUIR UM USUÁRIO PELO CÓDIGO*/
	public static final String EXCLUIR_USUARIO =" DELETE cicero.tb_usuario WHERE id_usuario = :id_usuario";
	
	/*ATUALIZAR INFORMAÇÕES DO USUÁRIO PELO CÓDIGO*/
	public static final String ATUALIZAR_USUARIO = "UPDATE cicero.tb_usuario SET ds_login = ?,ds_senha=?, fl_ativo=? WHERE id_usuario=? ";
	
	
}
