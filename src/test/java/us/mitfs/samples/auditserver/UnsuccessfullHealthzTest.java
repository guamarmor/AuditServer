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



@SpringBootTest(classes = us.muit.fs.samples.auditserver.AuditserverApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT, properties = { "app.healthzGithubRepo=fakerepo" })
class UnsuccessfulHealthzTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void healthz() throws Exception {
		String endpoint = "http://localhost:" + port + "/readyz";
		Map<String, Object> endpointResponse = this.restTemplate.getForObject(endpoint, Map.class);
		assertThat(endpointResponse).containsKeys("healthy", "error");
		assertThat(endpointResponse.get("healthy")).isEqualTo(false);
	}
}

