package Rique.servicex.pagamento.services;

import Rique.servicex.pagamento.domain.PagamentoBoleto;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class BoletoServiceTest {

    @Test
    void testPreencherPagamentoComBoleto() {
        // Dados de entrada
        BoletoService boletoService = new BoletoService();
        PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
        Date instanteDoPedido = new Date();

        // Chamada ao método a ser testado
        boletoService.preencherPagamentoComBoleto(pagamentoBoleto, instanteDoPedido);

        // Verificação dos resultados
        assertNotNull(pagamentoBoleto.getDataVencimento());

        // Verifica se a data de vencimento está correta (7 dias após o instante do pedido)
        Calendar cal = Calendar.getInstance();
        cal.setTime(instanteDoPedido);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        Date dataVencimentoEsperada = cal.getTime();
        assertEquals(dataVencimentoEsperada, pagamentoBoleto.getDataVencimento());
    }
}