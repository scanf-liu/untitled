package z_JVM_test;

public class FieldHasNoPolymorphic {

    static class Father {
        public int money1 = 1;

        public Father() {
            money1 = 2;
            //this.showMeTheMoney();
            showMeTheMoney();
        }

        public void showMoneySp() {
            System.out.println("sp I am Father, i have $" + money1);
        }

        public void showMeTheMoney() {
            System.out.println("I am Father, i have $" + money1);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            money = 4;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Son,  i have $" + money);
        }
    }

    public static void main(String[] args) {
        Father gay = new Son();
        System.out.println("This gay has $" + gay.money1);
        gay.showMeTheMoney();
    }
}

