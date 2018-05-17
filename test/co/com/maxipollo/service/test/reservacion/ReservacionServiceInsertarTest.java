package co.com.maxipollo.service.test.reservacion;

import static org.junit.Assert.*;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.com.maxipollo.exception.MPDaoException;
import co.com.maxipollo.exception.MPServiceException;
import co.com.maxipollo.service.ReservacionService;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class ReservacionServiceInsertarTest {

	@Autowired
	ReservacionService reservacionService;
	
	@Test
	@Rollback(false)
	public void testGuardaReservacion() {
		PropertyConfigurator.configure("log4j.properties");
		try {
			reservacionService.guardaReservacion(2, "4", "71086742");
		} catch (MPDaoException | MPServiceException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
