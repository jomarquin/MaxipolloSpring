package co.com.maxipollo.service.test.pedido;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.maxipollo.dto.Pedido;
import co.com.maxipollo.exception.MPDaoException;
import co.com.maxipollo.service.PedidoService;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class PedidoServiceObtenerTodosTest {

	@Autowired
	PedidoService pedidoService;
	
	@Test
	@Rollback(false)
	public void test() {
		PropertyConfigurator.configure("log4j.properties");
		try {

			List<Pedido> pedidos = pedidoService.obtener();
				for(Pedido pedido : pedidos){
					System.out.println("idPedido: "+ pedido.getIdPedido());
					System.out.println("Fecha de Pedido: "+ pedido.getFechaPedido());
					System.out.println("Cedula Cliente: "+ pedido.getCedulaPedido());
					System.out.println("Valor del pedido: "+ pedido.getValorPedido());
					System.out.println("=====================================");
				}		
		} catch (MPDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
