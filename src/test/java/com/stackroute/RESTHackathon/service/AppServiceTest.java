package com.stackroute.RESTHackathon.service;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.RESTHackathon.domain.AppDomain;
import com.stackroute.RESTHackathon.repository.AppRepository;

import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class AppServiceTest {
    
       
       private AppServiceDaoImpl appServiceImpl;
        @Mock
        private AppRepository appRepository;
        @Mock
        private AppDomain appDomain;
        @Before
        public void setupMock() {
            MockitoAnnotations.initMocks(this);
            appServiceImpl=new AppServiceDaoImpl();
            appServiceImpl.setAppRepository(appRepository);
        }
        @Test
        public void TestgetById() throws Exception {
            // Arrange
            when(appRepository.findById(2)).thenReturn(appDomain);
            // Act
            AppDomain retrievedUser = appServiceImpl.getById(2);
            // Assert
            assertThat(retrievedUser, is(equalTo(appDomain)));
       }
        
        @Test
        public void TestUpdate() throws Exception {
            // Arrange
            when(appRepository.save(appDomain)).thenReturn(appDomain);
            // Act
            appServiceImpl.update(1,appDomain);
            // Assert
            assertThat(appRepository.findById(1), is(appRepository.findById(1)));
        }
        @Test
        public void TestDelete() throws Exception {
            // Arrange
            doNothing().when(appRepository).delete(1);
            AppRepository my = Mockito.mock(AppRepository.class);
            // Act
           appServiceImpl.delete(1);
            // Assert
            verify(appRepository, times(1)).delete(1);
        }
    }