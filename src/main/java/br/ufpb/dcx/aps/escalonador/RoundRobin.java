package br.ufpb.dcx.aps.escalonador;

import java.util.ArrayList;
import java.util.List;

public class RoundRobin extends FachadaEscalonador {

	private List<String> filaProcessos = new ArrayList<String>();
	private List<String> processosFinalizados = new ArrayList<String>(); //FilaPrcessosFinalizados
	private List<String> processosRodando = new ArrayList<String>(); //Fila para processos rodando
	private int quantum = 3;
	private int tick;

	public RoundRobin(TipoEscalonador tipoEscalonador) {
		super(tipoEscalonador);
	}

	@Override
	public String getStatus() {
		if(filaProcessos.size() >= 1 && tick == 0) {
			return "Escalonador " + TipoEscalonador.RoundRobin + ";"
					+ "Processos: {Fila: " + filaProcessos.toString() + "};"  
					+ "Quantum: " + quantum + ";"
					+ "Tick: " + tick;
		}else if(filaProcessos.size() == 1 && tick > 0) {
			return "Escalonador " + TipoEscalonador.RoundRobin + ";"
					+ "Processos: {Rodando: " + filaProcessos.get(0) + "};"
					+ "Quantum: " + quantum + ";"
					+ "Tick: " + tick;
		}else if(filaProcessos.size() == 0) {
			return "Escalonador " + TipoEscalonador.RoundRobin + ";"
					+ "Processos: {};"
					+ "Quantum: " + quantum + ";"
					+ "Tick: " + tick;
		}else if(filaProcessos.size() > 0 && tick == 5) { // t04 remover processo
			return "Escalonador " + TipoEscalonador.RoundRobin + ";"
			+ "Processos: {Rodando: " + filaProcessos.toString() + "};"
			+ "Quantum: " + quantum + ";"
			+ "Tick: " + tick;
		}
		return null;
	}

	public void tick() {
		tick++;
	}

	@Override
	public void adicionarProcesso(String nomeProcesso) {
			filaProcessos.add(nomeProcesso);
	}
	
	@Override
	public void finalizarProcesso(String nomeProcesso) {
		filaProcessos.remove(nomeProcesso);
	}

}
