package us.mitfs.samples.auditserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import us.muit.fs.samples.auditserver.controllers.HealthController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;


@SpringBootTest(classes = us.muit.fs.samples.auditserver.AuditserverApplication.class)
class AuditserverApplicationTests {

	@Autowired
	private HealthController controller;

	@Test
	void contextLoads() {
		assertNotNull(controller,"El controlador no se ha cargado");
	}

}







