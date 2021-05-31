package leetCode_other._1603_设计停车系统;

class ParkingSystem {
    private int[] carContainer;
    public ParkingSystem(int big, int medium, int small) {
        carContainer = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return carContainer[carType - 1]-- > 0 ;
    }

}
