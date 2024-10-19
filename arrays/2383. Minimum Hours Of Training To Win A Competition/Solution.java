class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n = energy.length;
        int hoursToTrain = 0;
        for(int i=0;i<n;i++){
            // System.out.println("Initial Energy:"+initialEnergy+", Initial Experience:"+initialExperience+" Energy:"+energy[i]+" Experience:"+experience[i]);
            // if(initialEnergy<=energy[i]){
            //     initialEnergy+=1;
            //     hoursToTrain++;
            // }
            // if(initialExperience<=experience[i]){
            //     initialExperience+=1;
            //     hoursToTrain++;
            // }
            if(initialEnergy<=energy[i]){
                hoursToTrain+=energy[i]-initialEnergy+1;
                initialEnergy = energy[i]+1;
            }
            initialEnergy-=energy[i];
            if(initialExperience<=experience[i]){
                hoursToTrain+=experience[i]-initialExperience+1;
                initialExperience = experience[i]+1;

            }
            initialExperience+=experience[i];
            // System.out.println("Initial Energy:"+initialEnergy+", Initial Experience:"+initialExperience+" Energy:"+energy[i]+" Experience:"+experience[i]+" HoursToTRain:"+hoursToTrain);

        }
        return hoursToTrain;
    }
}
