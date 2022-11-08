package by.tms.lesson36Pattern2.task1adapter;

public final class ServiceWork {

    private ServiceWork() {
    }

    //этим методом мог быть метод записи данных работника в БД
    public static void printInfo(Worker worker) {
        System.out.println(worker.getFirstName() + "\n"
                + worker.getLastName() + "\n"
                + worker.getAppointment() + "\n"
                + worker.getSolar() + "\n"
                + worker.getHourWeek());
    }

}
