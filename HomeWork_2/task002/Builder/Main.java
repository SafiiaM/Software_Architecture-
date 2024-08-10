package Builder;


public class Main {
    public static void main(String[] args) {
        //настраиваем билдер
        ParameterBuilder ParameterBuilder = new ParameterBuilder();
        ParameterBuilder.setName("BMW");
        ParameterBuilder.setPower(170);
        ParameterBuilder.getResult();

        ParameterBuilder.setWeight(1550);
        ParameterBuilder.getResult();

        ParameterBuilder.setSpeed(220);
        ParameterBuilder.getResult();
    }
}
