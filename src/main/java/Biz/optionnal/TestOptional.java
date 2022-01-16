package Biz.optionnal;

import java.util.Optional;

public class TestOptional {

    public static void main(String[] args) {
        User user = new User();
        Car car = new Car();
        car.setCarName("red car");
        Insurance insurance = new Insurance();
        insurance.setInsuranceName("speed protected");
        car.setInsurance(insurance);
        user.setCar(car);
        user.setUserName("张三");

        User optional = Optional.ofNullable(user).get();
        System.out.println(optional);

        User user1 = new User();
        User user2 = Optional.ofNullable(user1).orElse(orElseGetUser());
        User user3 = Optional.ofNullable(user1).orElseGet(()->orElseGetUser());

        User userOfNull = null;
//        User user4 = Optional.ofNullable(userOfNull).orElseThrow(() -> new ArrayIndexOutOfBoundsException());

        Optional.ofNullable(user1).ifPresent(u-> System.out.println(u.getUserName()+ " if present"));
        String userName = Optional.ofNullable(user1).map(x->x.getUserName() + "Get by map").get();
        System.out.println(userName);
    }

    public static User orElseGetUser() {
        User user = new User();
        user.setUserName("lisi");
        System.out.println(user.getUserName());
        return user;
    }
}
