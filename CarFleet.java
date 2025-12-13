import java.util.Arrays;
class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double [][] cars = new double[n][2]; //n ->  number of cars, 2 -> no of attributes per car (2D)

        for(int i=0; i<n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];  //time
        }

        Arrays.sort(cars, (a,b) -> Double.compare(b[0], a[0])); //sort cars based on the current positions of the given cars (b.position - a.position)

        int count = 0; //calculate wt time a fleet will arrive
        double prevTime = 0; //slowest time seen for a car to reach to the end
        for (double [] car : cars) {
            if(car[1] > prevTime) {
                count++;
                prevTime = car[1];
            }
        }
        return count;
    }
}