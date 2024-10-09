class Solution {
    public int canCompleteCircuitInitialSolution(int[] gas, int[] cost) {
        // Calculate the total amount of gas and cost to check feasibility
        int gasSum = 0, costSum = 0;
        
        // Sum up all the gas and cost values
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        
        // If the total cost exceeds the total gas, it's impossible to complete the circuit
        if (costSum > gasSum) return -1;
        
        // Initialize variables to keep track of starting index, current cost, and current gas
        int startIndex = 0;
        int currentCost = 0, currentGas = 0;
        
        // Iterate through the gas stations twice to simulate a circular array
        for (int i = 0; i < gas.length * 2; i++) {
            // If at any point the cost exceeds the available gas, reset the start index
            if (currentCost > currentGas) {
                startIndex = i % gas.length;  // Update the start index to the next station
                currentCost = 0;  // Reset the current cost
                currentGas = 0;   // Reset the current gas
            }
            
            // Add gas and cost of the current station
            currentCost += cost[i % gas.length];
            currentGas += gas[i % gas.length];
        }
        
        // Return the valid start index modulo gas.length to ensure it's within bounds
        return startIndex % gas.length;
    }

    public int canCompleteCircuitOptimized(int[] gas, int[] cost) {
        // Calculate the total amount of gas and cost to check feasibility
        int gasSum = 0, costSum = 0;
        
        // Sum up all the gas and cost values
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        
        // If the total cost exceeds the total gas, it's impossible to complete the circuit
        if (costSum > gasSum) return -1;
        
        // Initialize variables to keep track of starting index, current cost, and current gas
        int startIndex = 0;
        int currentCost = 0, currentGas = 0;
        
        // Iterate through the gas stations
        for (int i = 0; i < gas.length; i++) {
            // If at any point the cost exceeds the available gas, reset the start index
            if (currentCost > currentGas) {
                startIndex = i % gas.length;  // Update the start index to the next station
                currentCost = 0;  // Reset the current cost
                currentGas = 0;   // Reset the current gas
            }
            
            // Add gas and cost of the current station
            currentCost += cost[i % gas.length];
            currentGas += gas[i % gas.length];
        }
        
        // Return the valid start index modulo gas.length to ensure it's within bounds
        return startIndex % gas.length;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int fuel, total, start;
        fuel = total = start = 0;

        for (int i = 0; i < gas.length; i++) {
            fuel += gas [i] - cost[i];

            if (fuel < 0) {
                start = i + 1;
                total += fuel;
                fuel = 0;
            }
        }

        return (fuel + total) < 0? -1 : start;
    }
}
