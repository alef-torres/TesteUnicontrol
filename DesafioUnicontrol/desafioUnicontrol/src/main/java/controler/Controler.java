package controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans pessoa = new JavaBeans();

	public Controler() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			pesquisa(request, response);
		} else if (action.equals("/insert")) {
			novaPessoa(request, response);
		} else if (action.equals("/select")) {
			listarPessoas(request, response);
		} else if (action.equals("/update")) {
			editarPessoa(request, response);
		} else if (action.equals("/delete")) {
			deletarPessoa(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	protected void pesquisa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<JavaBeans> listaDePessoas = dao.listarPessoas();

		request.setAttribute("pessoas", listaDePessoas);
		RequestDispatcher rd = request.getRequestDispatcher("pesquisa.jsp");
		rd.forward(request, response);
	}

	protected void novaPessoa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// enviando para as variaveis JavaBeans

		pessoa.setNome(request.getParameter("name"));
		pessoa.setProfissao(request.getParameter("profissao"));
		pessoa.setIdade(request.getParameter("idade"));

		// invocar o metodo insertPessoa passando o objeto pessoa

		dao.insertPessoas(pessoa);

		// retornando para a pagina index
		response.sendRedirect("index.html");
	}

	protected void listarPessoas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");

		pessoa.setIdcon(idcon);

		dao.selecionarPessoa(pessoa);

		request.setAttribute("idcon", pessoa.getIdcon());
		request.setAttribute("nome", pessoa.getNome());
		request.setAttribute("profissao", pessoa.getProfissao());
		request.setAttribute("idade", pessoa.getIdade());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	protected void editarPessoa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		pessoa.setIdcon(request.getParameter("idcon"));
		pessoa.setNome(request.getParameter("nome"));
		pessoa.setProfissao(request.getParameter("profissao"));
		pessoa.setIdade(request.getParameter("idade"));

		dao.alterarContanto(pessoa);

		response.sendRedirect("main");

	}

	protected void deletarPessoa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idcon = request.getParameter("idcon");
		System.out.println(idcon);

		pessoa.setIdcon(idcon);

		dao.deleterPessoas(pessoa);

		response.sendRedirect("main");

	}

}
