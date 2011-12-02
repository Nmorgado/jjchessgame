package control;

import java.util.List;

import model.Peca;
import model.Posicao;
import model.Tabuleiro;
import exception.IsNotYourTurnException;

public class ValidationManager {

	/**
	 * Valida se � a vez do jogador
	 * 
	 * @throws IsNotYourTurnException
	 *             Caso n�o for a vez
	 */
	public Peca validTurn(Tabuleiro tabuleiro, int linha, int coluna)
			throws IsNotYourTurnException {
		Peca peca = tabuleiro.getPeca(linha, coluna);
		if (peca != null && !peca.getCor().equals(tabuleiro.getJogadorVez())) {
			throw new IsNotYourTurnException();
		}
		return peca;
	}

	/**
	 * Valida a captura<br>
	 * Caso a posi��o destino tiver uma pe�a que for a mesma cor da pe�a
	 * selecionada, considera-se que se est� selecionando outra pe�a
	 * 
	 * @param tabuleiro
	 * @param pecaSelecionada
	 * @param alvo
	 * @return true caso a pe�a foi capturada, false caso foi selecionada outra
	 *         pe�a
	 * @throws Exception caso o lance foi imposs�vel
	 */
	public boolean validCapture(Tabuleiro tabuleiro, Peca pecaSelecionada,
			Peca alvo) throws Exception {
		if (alvo.getCor() == pecaSelecionada.getCor()) {
			if (pecaSelecionada != alvo) {
				// JOptionPane.showMessageDialog(null,"Voc� deve jogar com a pe�a que tocou primeiro!");
			}
			return false;
		} else {
			List<Posicao> lista = pecaSelecionada.getPosicoesAtacadas(tabuleiro
					.getPecas());
			for (Posicao p : lista) {
				if (p.getX() == alvo.getX() && p.getY() == alvo.getY()) {
					pecaSelecionada.capturar(alvo);
					return true;
				}
			}
			throw new IllegalArgumentException(
					"Lance Imposs�vel - Voc� Tentou capturar uma pe�a\n "
							+ "que est� fora do alcance de "
							+ pecaSelecionada.toString());
		}
	}

	public boolean validMovement(Tabuleiro tabuleiro, Peca pecaSelecionada,
			int linha, int coluna) {
		List<Posicao> lista = pecaSelecionada.getPosicoesAtacadas(tabuleiro
				.getPecas());
		for (Posicao p : lista) {
			if (p.getX() == linha && p.getY() == coluna) {
				pecaSelecionada.movimentar(linha, coluna);
				return true;
			}
		}
		throw new IllegalArgumentException("Lance Imposs�vel!");
	}
}
