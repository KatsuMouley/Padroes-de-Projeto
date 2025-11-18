import com.usina.context.UsinaNuclear;

public class Main {
    public static void main(String[] args) {
        UsinaNuclear usina = new UsinaNuclear();

        // 1. Ligando a usina
        usina.ligar();
        usina.atualizarSensores(250, 1000, false);

        // 2. Simulando Aumento para Alerta Amarelo
        // REGRA: NORMAL → AMARELO (temp > 300)
        usina.atualizarSensores(310, 1100, false);
        
        // 3. Simulando Aumento para Alerta Vermelho
        // REGRA: AMARELO → VERMELHO (temp > 400)
        usina.atualizarSensores(410, 1500, false);

        // 4. Simulando Falha de Resfriamento -> Emergência
        // REGRA: VERMELHO → EMERGENCIA (falha resfriamento)
        usina.atualizarSensores(450, 1800, true);

        // 5. Tentando ações bloqueadas em Emergência
        usina.ligar();
        usina.entrarManutencao();

        // 6. Desligamento de Emergência
        usina.desligar();
        
        System.out.println("\n=== SIMULAÇÃO MODO MANUTENÇÃO ===");
        
        // 7. Ligando novamente
        usina.ligar();
        usina.atualizarSensores(280, 1000, false);
        
        // 8. Entrando em manutenção a partir do estado Normal
        usina.entrarManutencao();
        
        // 9. Ações são sobrescritas
        usina.atualizarSensores(350, 1200, false); // Sensor será ignorado
        usina.desligar(); // Ação será bloqueada

        // 10. Saindo da manutenção
        usina.sairManutencao();
        
        // 11. A usina volta ao estado normal e reage aos sensores
        usina.atualizarSensores(350, 1200, false); // Agora ela reage!
    }
}