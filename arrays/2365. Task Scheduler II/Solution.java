class Solution {
    public long taskSchedulerIIInitialSolution(int[] tasks, int space) {
        long days = 0;
        // We will use this hashmap to map task and its last completed day.
        Map<Integer, Long> hm = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            // We are getting the time when the task was last completed.
            long lastCompleted = hm.getOrDefault(tasks[i], days);

            // If number of days since last completed and today (i) are greater than space
            // then just continue.
            // Other wise we will have to wait for i- lastCompleted + space

            // Example: For Day 1, Last Completed will be 0
            // Task 1 was completed on day 0, Hence It can be completed again on 5th day, as
            // space is 3..
            // Lets walk through that example step by step
            // lastCompleted(0)!=2 && (2-0)<=3
            // days + = 3-(2-0)=1... but space should be increased by 2 so changed code to
            // days += space+1 - (i-lastCompleted);
            if ((lastCompleted != days) && ((days - lastCompleted) <= space)) {
                days += space + 1 - (days - lastCompleted);
            }
            // As we got the last time when task was completed, We will the tasks date as
            // todays date..
            hm.put(tasks[i], days);
            days++;
            // System.out.println("Task:"+i+", Day:"+days);
        }
        return days;
    }

    public long taskSchedulerII(int[] tasks, int space) {
        long days = 0;
        Map<Integer, Long> hm = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            long lastCompleted = hm.getOrDefault(tasks[i], days);
            if ((lastCompleted != days) && ((days - lastCompleted) <= space)) {
                days += space + 1 - (days - lastCompleted);
            }
            hm.put(tasks[i], days);
            days++;
        }
        return days;
    }

    public long taskSchedulerIIAlternateLogic(int[] tasks, int space) {
        long currentDay = 0;
        Map<Integer, Long> lastCompletionMap = new HashMap<>();
        
        for (int task : tasks) {
            // Get the last completed day of the current task or -1 if not seen before
            long lastCompletedDay = lastCompletionMap.getOrDefault(task, -1L);
            
            // If the task has been completed before and within 'space' days, adjust the current day
            if (lastCompletedDay != -1 && currentDay - lastCompletedDay <= space) {
                currentDay = lastCompletedDay + space + 1;
            }
            
            // Update the last completed day for the current task
            lastCompletionMap.put(task, currentDay);
            
            // Move to the next day
            currentDay++;
        }
        
        return currentDay;
    }

}
