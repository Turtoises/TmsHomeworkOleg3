import by.tms.lesson33sql.service.ServiceCreateServices;
import by.tms.lesson33sql.utils.Constants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestServiceCreateServices {

    ServiceCreateServices serviceCreateServices = new ServiceCreateServices(Constants.DATABASE_PROPERTIES_FILE_PATH);

    @ParameterizedTest
    @CsvSource(value = {
            "Krupki,true",
            "Minsk,false"
    })
    public void testAddCity(String name, boolean result) {

        assertTrue(serviceCreateServices.serviceCityImpl.add(name) == result);

    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testAddCity2(String name) {

        assertTrue(serviceCreateServices.serviceCityImpl.add(name) == false);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "100,false"
    })
    public void testDeleteCity(Integer index, boolean result) {

        assertTrue(serviceCreateServices.serviceCityImpl.delete(index) == result);
    }

    @Test
    public void testDeleteCity2() {
        int index = serviceCreateServices.serviceCityImpl.getIDCity("Krupki");

        assertTrue(serviceCreateServices.serviceCityImpl.delete(index) == true);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Pupkin,Aleksei,Minsk,true",
            "Pupkin,Aleksei,mmm,false",
            ",Aleksei,Minsk,false"
    })
    public void testAddStudent(String name, String surname, String city, boolean result) {

        assertTrue(serviceCreateServices.serviceStudentImpl.add(name,surname,city) == result);

    }


}


