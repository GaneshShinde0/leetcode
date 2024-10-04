class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long res =0;
        int len = skill.length;
        int temp=skill[0]+skill[len-1];
        for(int i=0;i<skill.length/2;i++){
            if(temp!=skill[i]+skill[len-i-1]) return -1;
            res+=skill[i]*skill[len-i-1];
        }
        return res;
    }

    public long dividePlayersOptimized(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        int[] skillFrequency = new int[1001];

        // Calculate total skill and skill frequency
        for (int playerSkill : skill) {
            totalSkill += playerSkill;
            skillFrequency[playerSkill]++;
        }

        // Check if total skill can be evenly distributed among teams
        if (totalSkill % (n / 2) != 0) {
            return -1;
        }

        int targetTeamSkill = totalSkill / (n / 2);
        long totalChemistry = 0;

        // Calculate total chemistry while verifying valid team formations
        for (int playerSkill : skill) {
            int partnerSkill = targetTeamSkill - playerSkill;

            // Check if a valid partner exists
            if (skillFrequency[partnerSkill] == 0) {
                return -1;
            }

            totalChemistry += (long) playerSkill * (long) partnerSkill;
            skillFrequency[partnerSkill]--;
        }

        // Return half of totalChemistry as each pair is counted twice
        return totalChemistry / 2;
    }
}
