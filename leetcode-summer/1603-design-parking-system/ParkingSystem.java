class ParkingSystem {
    private int[] spaces;

    public ParkingSystem(int big, int medium, int small) {
        spaces = new int[4];

        spaces[1] = big;
        spaces[2] = medium;
        spaces[3] = small;
    }

    public boolean addCar(int carType) {
        if (spaces[carType] == 0) {
            return false;
        }

        spaces[carType]--;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */