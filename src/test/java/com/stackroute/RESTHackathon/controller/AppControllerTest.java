package com.stackroute.RESTHackathon.controller;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import com.stackroute.RESTHackathon.App;
import com.stackroute.RESTHackathon.domain.AppDomain;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppControllerTest  extends TestCase {
   
    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    AppDomain appDomain;    
   
    @Before
    public void setUp() throws Exception {
    	appDomain = new AppDomain(1,"abc@gmail.com","yeh naam hai");
    }
    
   private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
    
   @After
    public void tearDown() throws Exception {
    }
    
   @Test
    public void addrestaurant() throws Exception { 
       HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AppDomain> entity = new HttpEntity<AppDomain>(appDomain, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user"),
                HttpMethod.POST, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Added successfully",actual);
    }
    
   @Test
    public void getAllUsers() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user"),
                HttpMethod.GET, entity, String.class);
        assertNotNull(response);
    }
    
   @Test
    public void testGetUser() throws Exception {
    }
    
   @Test
    public void updateUser() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AppDomain> entity = new HttpEntity<AppDomain>(appDomain, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/3"),
                HttpMethod.PUT, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Updated successfully",actual);
    }
    
   @Test
    public void deleteUser() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AppDomain> entity = new HttpEntity<AppDomain>(appDomain, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/user/1"),
                HttpMethod.DELETE, entity, String.class);
        assertNotNull(response);
        String actual = response.getBody();
        System.out.println(actual);
        assertEquals("Deleted successfully",actual);
    }
    
}