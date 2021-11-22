package com.example.coding.queue;

public class PetrolPumpProblem {

    public static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int startingPoint(PetrolPump arr[], int n) {
        int start = 0;
        int end = 1;

        int currentPetrol = arr[start].petrol - arr[start].distance;

        while (end != start || currentPetrol < 0 ) {
            while (currentPetrol < 0 && start != end) {
                currentPetrol = currentPetrol - (arr[start].petrol - arr[start].distance);
                start = (start + 1) % n;

                if (start == 0) {
                    return -1;
                }
            }

            currentPetrol = currentPetrol + (arr[end].petrol - arr[end].distance);
            end = (end +1)%n;
        }

        return start;
    }

    public static void main(String[] args) {
        PetrolPump[] arr = {new PetrolPump(4,6), new PetrolPump(6,5) ,
                new PetrolPump(7,3), new PetrolPump(4,5)};

        int startingPoint = startingPoint(arr, 4);

        System.out.println("startingPoint=" + startingPoint);
    }
}
