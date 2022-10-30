package by.tms.lesson33sql;

import by.tms.lesson33sql.service.ServiceCreateServices;
import by.tms.lesson33sql.utils.Constants;

public class MainSQL {

    public static void main(String[] args) {

        ServiceCreateServices serviceCreateServices = new ServiceCreateServices(Constants.DATABASE_PROPERTIES_FILE_PATH);

        serviceCreateServices.serviceStudentImpl.add("Ivan", "Ivanov", "Grodno");

        serviceCreateServices.serviceCityImpl.add("Baranki");

    }
}
