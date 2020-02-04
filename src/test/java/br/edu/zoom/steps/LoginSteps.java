package br.edu.zoom.steps;

import br.edu.zoom.action.EscreverAction;
import br.edu.zoom.action.MouseAction;
import br.edu.zoom.action.ValidacaoAction;
import br.edu.zoom.page.HomePage;
import io.cucumber.java8.Pt;

public class LoginSteps implements Pt {
	MouseAction mouse = new MouseAction();
	EscreverAction escrever = new EscreverAction();
	ValidacaoAction valida = new ValidacaoAction();

	public LoginSteps() {

		Quando("clico no botão entrar", () -> {
			mouse.clicar(HomePage.botaoEntrar);
			// Thread.sleep(2000);

		});
		
		Quando("preencho o modal com endereço de email {string}", (String email) -> {
			mouse.clicar(HomePage.campoEmail);
			escrever.escrever(HomePage.campoEmail, email);

		});

		Quando("clico na seta a direita do email", () -> {
			mouse.clicar(HomePage.confirmaEmail);

		});

		Quando("preencho o modal com um nome {string}", (String nome) -> {
			escrever.escrever(HomePage.campoNome, nome);

		});

		Quando("clico no botão de confirmação", () -> {
			mouse.clicar(HomePage.botaoConfirmaNome);
		});

		Quando("clico no avatar do usuário", () -> {
			mouse.clicar(HomePage.avatar);
		});

		Então("é exibido o avatar do menu do usuário validando o login no site {string}.", (String z) -> {
			valida.validacaoAvatar(z, HomePage.validacao);

		});

	}
}