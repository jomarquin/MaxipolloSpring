package co.com.maxipollo.service.test.reservacion;

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

import co.com.maxipollo.dto.Reservacion;
import co.com.maxipollo.exception.MPDaoException;
import co.com.maxipollo.service.ReservacionService;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class ReservacionServiceObtenerTodosTest {

	@Autowired
	ReservacionService reservacionService;
	
	@Test
	@Rollback(false)
	public void test() {
		PropertyConfigurator.configure("log4j.properties");
		try {

			List<Reservacion> reservaciones = reservacionService.obtener();
				for(Reservacion reservacion : reservaciones){
					System.out.println("idReservacion: "+ reservacion.getIdReservacion());
					System.out.println("Fecha de Reservacion: "+ reservacion.getFechaReservacion());
					System.out.println("Mesa: "+ reservacion.getNroMesa());
					System.out.println("Cedula cliente: "+ reservacion.getCedulaCliente());
					System.out.println("=====================================");
				}		
		} catch (MPDaoException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
