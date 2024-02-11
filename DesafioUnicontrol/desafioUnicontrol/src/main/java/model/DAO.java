package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** módulo de conexão **/

	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbpessoas?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "meubanco";

	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD CREATE **/

	public void insertPessoas(JavaBeans pessoa) {
		String create = "insert into pessoas (nome,profissao,idade) values (?,?,?)";

		try {
			// abrir a conexao
			Connection con = conectar();
			// preparando a query para enviar ao banco de dados
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, pessoa.getNome());
			pst.setString(2, pessoa.getProfissao());
			pst.setString(3, pessoa.getIdade());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/** CRUD READ **/

	public ArrayList<JavaBeans> listarPessoas() {

		ArrayList<JavaBeans> pessoas = new ArrayList<>();

		String read = "select * from pessoas order by nome";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String profissao = rs.getString(3);
				String idade = rs.getString(4);

				pessoas.add(new JavaBeans(id, nome, profissao, idade));
			}

			con.close();

			return pessoas;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/** CRUD UPDATE **/

	public void selecionarPessoa(JavaBeans pessoa) {

		String read2 = "select * from pessoas where id = ?"; // pode dar merda aqui !!!!

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, pessoa.getIdcon());
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				pessoa.setIdcon(rs.getString(1));
				pessoa.setNome(rs.getString(2));
				pessoa.setProfissao(rs.getString(3));
				pessoa.setIdade(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public void alterarContanto(JavaBeans pessoa) {
		String create = "update pessoas set nome=?, profissao=?, idade=? where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, pessoa.getNome());
			pst.setString(2, pessoa.getProfissao());
			pst.setString(3, pessoa.getIdade());
			pst.setString(4, pessoa.getIdcon());
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	/** CRUD DELETE **/
	
	public void deleterPessoas(JavaBeans pessoa) {
		
		String delete = "delete from pessoas where id=?";
		
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, pessoa.getIdcon());
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
