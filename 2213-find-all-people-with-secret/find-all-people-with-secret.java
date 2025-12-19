class Solution {
    public List<Integer> findAllPeopleHashMapDoesNotWork(int n, int[][] meetings, int firstPerson) {
        Set<Integer> set = new HashSet<>();
        // HashMap has one issue it will consider pairs which do not have any mutual friends with who know secret. 
        TreeMap<Integer,Set<Integer>> timeToPerson = new TreeMap<>();
        for(int[] meet:meetings){
            Set<Integer> temp= timeToPerson.computeIfAbsent(meet[2],s->new HashSet<Integer>());
            temp.add(meet[0]);
            temp.add(meet[1]);
        }
        set.add(0);
        set.add(firstPerson);
        System.out.println(timeToPerson);
        for(Map.Entry<Integer, Set<Integer>> e:timeToPerson.entrySet()){
            Set<Integer> innerSet = e.getValue();
            if(set.stream().anyMatch(innerSet::contains)){
                set.addAll(innerSet);
            }
        }
        return new ArrayList<>(set);
    }
    public List<Integer> findAllPeopleBFSGivesTLE(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] meeting: meetings){
            int x = meeting[0], y=meeting[1], t=meeting[2];
            graph.computeIfAbsent(x,k->new ArrayList<>()).add(new int[]{t,y});
            graph.computeIfAbsent(y,k->new ArrayList<>()).add(new int[]{t,x});
        }
        // Earliest Time at which person learned the secret
        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0]=0;
        earliest[firstPerson]=0;

        // Queue For BFS. It will store (person, time of knowing the secret);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        q.offer(new int[]{0, firstPerson});

        while(!q.isEmpty()){
            int[] personTime = q.poll();
            int person = personTime[1], time = personTime[0];
            for(int[] nextPersonTime: graph.getOrDefault(person, new ArrayList<>())){
                int t = nextPersonTime[0], nextPerson = nextPersonTime[1];
                if(t>=time && earliest[nextPerson]>t){
                    earliest[nextPerson]= t;
                    q.offer(new int[]{t, nextPerson});
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(earliest[i]!=Integer.MAX_VALUE){
                ans.add(i);
            }
        }
        return ans;
    }

    public List<Integer> findAllPeopleStackTLE(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] meeting: meetings){
            int x = meeting[0], y=meeting[1], t=meeting[2];
            graph.computeIfAbsent(x,k->new ArrayList<>()).add(new int[]{t,y});
            graph.computeIfAbsent(y,k->new ArrayList<>()).add(new int[]{t,x});
        }
        // Earliest Time at which person learned the secret
        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0]=0;
        earliest[firstPerson]=0;

        // Stack For DFS. It will store (person, time of knowing the secret);
        Stack<int[]> stk = new Stack<>();
        stk.push(new int[]{0,0});
        stk.push(new int[]{0, firstPerson});

        while(!stk.isEmpty()){
            int[] personTime = stk.pop();
            int person = personTime[1], time = personTime[0];
            for(int[] nextPersonTime: graph.getOrDefault(person, new ArrayList<>())){
                int t = nextPersonTime[0], nextPerson = nextPersonTime[1];
                if(t>=time && earliest[nextPerson]>t){
                    earliest[nextPerson]= t;
                    stk.push(new int[]{t, nextPerson});
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(earliest[i]!=Integer.MAX_VALUE){
                ans.add(i);
            }
        }
        return ans;
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] meeting: meetings){
            int x = meeting[0], y=meeting[1], t=meeting[2];
            graph.computeIfAbsent(x,k->new ArrayList<>()).add(new int[]{t,y});
            graph.computeIfAbsent(y,k->new ArrayList<>()).add(new int[]{t,x});
        }
        // Earliest Time at which person learned the secret
        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);

        // PriorityQueue For BFS. It will store (person, time of knowing the secret);
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.offer(new int[] { 0, 0 });
        q.offer(new int[] { 0, firstPerson });

        while(!q.isEmpty()){
            int[] personTime = q.poll();
            int person = personTime[1], time = personTime[0];
            if(earliest[person]!=Integer.MAX_VALUE) continue;
            earliest[person] = time;
            for(int[] nextPersonTime: graph.getOrDefault(person, new ArrayList<>())){
                int t = nextPersonTime[0], nextPerson = nextPersonTime[1];
                if(t>=time && earliest[nextPerson]==Integer.MAX_VALUE){
                    q.offer(new int[]{t, nextPerson});
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(earliest[i]!=Integer.MAX_VALUE){
                ans.add(i);
            }
        }
        return ans;
    }
}