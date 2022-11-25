package by.tms.lesson35patterns.task2builder;

public class MainBuilder {

    public static void main(String[] args) {

        Plane plane = Plane.builder()
                .number(123)
                .numberSeats(2500)
                .wheel(new Wheel.Builder()
                        .rubberType("Rubber Type #6")
                        .mark("Mark #7")
                        .diameter(20)
                        .build()
                )
                .engine(new Engine.Builder()
                        .power(1000.0)
                        .mark("Sumsung")
                        .build())
                .hull(new Hull.Builder()
                        .gradeSteel("Stail procat #4")
                        .steelStrength(20000.0)
                        .build())
                .build();

        System.out.println(plane);
    }
}
